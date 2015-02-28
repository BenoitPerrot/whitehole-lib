// Copyright (c) 2004-2015, Benoit PERROT.
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     * Redistributions of source code must retain the above copyright
//       notice, this list of conditions and the following disclaimer.
//
//     * Redistributions in binary form must reproduce the above
//       copyright notice, this list of conditions and the following
//       disclaimer in the documentation and/or other materials provided
//       with the distribution.
//
//     * Neither the name of the White Hole Project nor the names of its
//       contributors may be used to endorse or promote products derived
//       from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

// Build a Java enumeration for ia32/x64 mnemonics
//

define('org/whitehole/assembly/ia32_x64/dis/generateInstructionDecoder', [ 'org/whitehole/infra/IO' ], function (IO) {
	'use strict';

	function generateAltsDecoder(cw, alts, hasModRM) {
		var e, i, x, alt, ifOpened, woTest;
		
		alts.forEach(function (alt, e) {
			if (alt != null) {
				
				if (! (alt instanceof Array))
					alt = [alt];
				
				if (0 < alt.length) {

					var h = (0xf < e ? '0x' : '0x0') + e.toString(16);

					cw.openCase(h);

					//
					ifOpened = false;

					// Find entries without any test, if any
					woTest = null;
					alt.forEach(function (x) {
						if (x.hasOwnProperty('m')) {
							if (x.prefix === undefined /*&& x.precond === undefined*/ && x.mod === undefined && x.rm === undefined) {
								// FIXME: assert(woTest === null);
								woTest = x;
							}
						}
						else if (! (x instanceof Array)) {
							// FIXME: assert(woTest === null);
							woTest = x;
						}
					});

					// Generate decoder for instructions with a prefix
					alt.forEach(function (x) {
						if (x != woTest)
							if (x.hasOwnProperty('m')) {
								ifOpened = generateSingleDecoder(cw, x, ifOpened, hasModRM);
							}
					});
					
					// Generate decoder for instructions without any prefix 
					if (woTest != null)
						ifOpened = generateSingleDecoder(cw, woTest, ifOpened, hasModRM);

					if (ifOpened)
						cw.closeIf();

					cw.addStatement('break');
					cw.closeCase();
				}
			}
		});
	}
	
	function generateSingleDecoder(cw, i, ifOpened, hasModRM) {
		// Dispatch to appropriate generator
		if (i.hasOwnProperty('m'))
			return generatePreconditionedInstDecoder(cw, i, ifOpened, hasModRM);
		else
			return generateGoToSub(cw, i, ifOpened, hasModRM);
	}
	
	function generateGoToSub(cw, name, ifOpened, hasModRM) {
		// Branch to sub map
        if (0 <= name.indexOf("group")) {
            if (!hasModRM)
                cw.addStatement("final ModRM mrm = ModRM.read(i)");
            cw.addStatement(name + "(m, p, mrm, i, l)");
        }
        else
        	cw.addStatement(name + "(m, p, i, l)");
        
        return ifOpened;
    }

	function generatePreconditionedInstDecoder(cw, i, ifOpened, hasModRM) {

		var s, test = [], overrides = {};
		
		// Translate precondition if any
		if (i.hasOwnProperty('precond')) {
			if (i.precond === 'i64')
				test.push('!m.is64BIT()');
			else if (i.precond === 'o64')
				test.push('m.is64BIT()');
			else if (i.precond === 'd64')
				overrides.defaultOperandSizeTo64bit = true;
			else if (i.precond === 'f64')
				overrides.forceOperandSize64Tobit = true;
		}

		// Translate prefixes if any
		if (i.hasOwnProperty('prefix')) {
			if (0 <= i.prefix.indexOf('66'))
				test.push('p.has66()');
			if (0 <= i.prefix.indexOf('F2'))
				test.push('p.hasF2()');
			if (0 <= i.prefix.indexOf('F3'))
				test.push('p.hasF3()');
		}

		// Translate Mod if any
		if (i.hasOwnProperty('mod')) {
			if (i.mod === 'mem')
				test.push('mrm.mod() != 3');
			else
				test.push('mrm.mod() == ' + i.mod);
		}

	    // Translate R/M if any
		if (i.hasOwnProperty('rm'))
			test.push('mrm.rm() == ' + i.rm);

		//
	    if (0 < test.length) {
	    	s = test.join(' && ');
	    	if (ifOpened)
	    		cw.openElseIf(s);
	    	else
	    		cw.openIf(s);
	    	ifOpened = true;
	    }
	    else if (ifOpened)
	    	cw.openElse();

	    // Generate instruction creation
	    generateInstDecoder(cw, i, hasModRM, overrides);

	    return ifOpened;
	}
	
	function generateInstDecoder(cw, i, hasModRM, overrides) {
		
		// Consider operands
		var operandDecoders = [];
	    var needModRM = false;

	    ((i.o === undefined) ? [] : (i.o instanceof Array) ? i.o : [ i.o ]).forEach(function (o) {
	    	
	    	var u = unpackOperand(o);

	    	var args = [];
	    	if (u.needMode) {
	    		if (overrides.defaultOperandSizeTo64bit)
	    			args.push('Mode.d64(m)');
	    		else if (overrides.forceOperandSize64Tobit)
	    			args.push('Mode.f64(m)');
	    		else
	    			args.push('m');
	    	}
	    	if (u.needPrefixes)
	    		args.push('p');
	    	if (u.needModRM) {
	    		args.push('mrm');
	    		needModRM = true;
	    	}
	    	if (u.needInput)
	    		args.push('i');
	    	
			var a = o;
	    	if (u.t) {
	    		a = a.substring(0, 1);
	    		args.push(u.t);
	    	}
	    	
	    	args.push('l');

	    	operandDecoders.push("OperandDecoder." + a + "(" + args.join(', ') + ")");
	    });

	    // Commit
	    if (needModRM && !hasModRM)
	    	cw.addStatement("final ModRM mrm = ModRM.read(i)");

	    cw.addStatement("l.startInstruction(p.toModifier(), Mnemonic." + i.m + ")");
	    operandDecoders.forEach(function (d) {
	    	cw.addStatement(d);
	    });
	    cw.addStatement("l.endInstruction()");
	}
	
	function unpackOperand(o) {

		var u = {};
		
		//
		// Alternatives
		
		if (0 < o.indexOf('_')) {
			if (0 <= ['Rd_Mb', 'Rd_Mw', 'Ry_Mb', 'Ry_Mw', 'Udq_Md', 'Ux_Md', 'Ux_Mq', 'Ux_Mw'].indexOf(o)) {
				u.needMode = true;
				u.needPrefixes = true;
				u.needModRM = true;
				u.needInput = true;
			}
		}

		//
		// Complete forms
		
		else if (0 <= ['AL', 'CL', 'AX', 'DX', 'CS', 'DS', 'ES', 'FS', 'GS', 'SS',
		               'ST0', 'ST1', 'ST2', 'ST3', 'ST4', 'ST5', 'ST6', 'ST7'].indexOf(o))
			; // Explicit form, nothing to do
		else if (0 <= ['rAX', 'rDX', 'eAX', 'eBX', 'eCX', 'eDX', 'eBP', 'eSP', 'eSI', 'eDI'].indexOf(o)) {
			u.needMode = true;
		}
		else if (0 <= ['rAXr8', 'rCXr9', 'rDXr10', 'rBXr11', 'rSPr12', 'rBPr13', 'rSIr14', 'rDIr15',
		               'ALr8b', 'CLr9b', 'DLr10b', 'BLr11b', 'AHr12b', 'CHr13b', 'DHr14b', 'BHr15b'].indexOf(o)) {
			u.needMode = true;
			u.needPrefixes = true;
		}
		else if (o === '_1') {
		}

		//
		// Abbreviations
		
		else if ('A' <= o.charAt(0) && o.charAt(0) <= 'Z') {

			if (o.charAt(0) === 'A' || o.charAt(0) === 'O') {
				u.needMode = true;
				u.needInput = true;
			}

			else if (o.charAt(0) === 'B' || o.charAt(0) === 'H') {
				u.needPrefixes = true;
				u.t = unpackOperandType(o.substring(1));
			}

			else if (o.charAt(0) === 'C' || o.charAt(0) === 'D') {
				u.needMode = true;
				u.needPrefixes = true;
				u.needModRM = true;
			}
			
			else if (o.charAt(0) === 'E' || o.charAt(0) === 'M' || o.charAt(0) === 'Q' || o.charAt(0) === 'W') {
				u.needMode = true;
				u.needPrefixes = true;
				u.needModRM = true;
				u.needInput = true;
				u.t = unpackOperandType(o.substring(1));
			}
			
			else if (o.charAt(0) === 'F')
				u.needMode = true;
			
			else if (o.charAt(0) === 'G') {
				u.needMode = true;
				u.needPrefixes = true;
				u.needModRM = true;
				u.t = unpackOperandType(o.substring(1));
			}
			
			else if (o.charAt(0) === 'I' || o.charAt(0) === 'J' || o.charAt(0) === 'L') {
				u.needInput = true;
				u.t = unpackOperandType(o.substring(1));
			}

			else if (o.charAt(0) === 'N' || o.charAt(0) === 'S') {
				u.needModRM = true;
			}
			
			else if (o.charAt(0) === 'P') {
				u.needModRM = true;
				u.t = unpackOperandType(o.substring(1));
			}
			
			else if (o.charAt(0) === 'R') {
				u.needModRM = true;
				u.t = unpackOperandType(o.substring(1));
			}
			
			else if (o.charAt(0) === 'X' || o.charAt(0) === 'Y')
				u.t = unpackOperandType(o.substring(1));

			else if (o.charAt(0) === 'U' || o.charAt(0) === 'V') {
				u.needModRM = true;
				u.t = unpackOperandType(o.substring(1));
			}

			else
				throw "Unknown operand abbreviation: " + o;

		}
		else
			throw "Unknown operand form: " + o;
		
		return u;
	}
	
	function unpackOperandType(t) {
		
		var r = {
				''  : 'OperandType.BYTE',
				'a' : 'OperandDecoder.a(m.getOperandSize())',
				'b' : 'OperandType.BYTE',
				// 'c': Byte or word, depending on operand-size attribute
				'd' : 'OperandType.DOUBLEWORD',
				'dq': 'OperandType.DOUBLE_QUADWORD',
				'p' : 'OperandDecoder.p(m.getOperandSize())',
				'pd': 'OperandDecoder.pd(m.getOperandSize())',
				'pi': 'OperandType.QUADWORD', // FIXME: Quadword MMX register
				'ps': 'OperandDecoder.ps(m.getOperandSize())',
				'q' : 'OperandType.QUADWORD',
				'qq': 'OperandType.QUAD_QUADWORD',
				's' : 'OperandDecoder.s(m.getOperandSize())',
				'sd': 'OperandType.SCALAR_DOUBLE_128BIT',
				'ss': 'OperandType.SCALAR_SINGLE_128BIT',
				// 'si': Doubleword integer register
				't' : 'OperandType.PACKED_BCD',
				'v' : 'OperandDecoder.v(m.getOperandSize())',
				'w' : 'OperandType.WORD',
				'x' : 'OperandDecoder.x(m.getOperandSize())',
				'y' : 'OperandDecoder.y(m.getOperandSize())',
				'z' : 'OperandDecoder.z(m.getOperandSize())'
		} [t];
		
		if (r === undefined)
			throw "Unknown operand type code: " + t;
		
		return r;
	}
	
	function generateMapDecoder(cw, name, alts) {
        cw.openFunction('static void', name, 'Mode m, Prefixes p, InputStream i, Disassembler.Listener l', 'throws IOException');

        cw.addStatement("final int c = i.read()");
        cw.openSwitch("c");
        generateAltsDecoder(cw, alts, false);
        cw.openDefault();
	    cw.addStatement('l.reportInvalid()'); // TODO: detail
        cw.addStatement("break");
        cw.closeDefault();
        
        cw.closeSwitch();
		
		cw.closeFunction();
	}
	
	function generateGroupDecoder(cw, name, alts) {
        cw.openFunction('static void', name, 'Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener l', 'throws IOException');

        cw.openSwitch("mrm.reg()");
        generateAltsDecoder(cw, alts, true);
        cw.openDefault();
	    cw.addStatement('l.reportInvalid()'); // TODO: detail
        cw.closeDefault();
        cw.closeSwitch();

        cw.closeFunction();
    }
	
	function generateX87Decoder(cw, name, alt) {
		cw.openFunction('static void', name, 'Mode m, Prefixes p, InputStream i, Disassembler.Listener l', 'throws IOException');

		cw.addStatement('final int c = i.read()');
		cw.addStatement('final ModRM mrm = new ModRM((byte) c)');
		cw.openIf('c <= 0xbf');

		cw.openSwitch('mrm.reg()');
		alt.reg.forEach(function (e, i) {
			if (e !== null) {
				// FIXME: assert e.hasOwnProperty('m')
				cw.openCase('0x' + i.toString(16));
				generateSingleDecoder(cw, e, false, true);
				cw.addStatement('break');
				cw.closeCase();
			}
		});
	    cw.openDefault();
	    cw.addStatement('l.reportInvalid()'); // TODO: detail
	    cw.addStatement('break');
	    cw.closeDefault();
	    cw.closeSwitch();

	    cw.openElse();

	    cw.openSwitch('c');
	    alt.no.forEach(function (e, i) {
			if (e !== null) {
				// assert e.hasOwnProperty('m')
	    		cw.openCase('0x' + (0xc0 + i).toString(16));
	    		generateSingleDecoder(cw, e, false, true);
	    		cw.addStatement('break');
	    		cw.closeCase();
	    	}
	    });
	    cw.openDefault();
	    cw.addStatement('l.reportInvalid()'); // TODO: detail
	    cw.addStatement('break');
	    cw.closeDefault();
	    cw.closeSwitch();

	    cw.closeIf();

	    cw.closeFunction();
	}
	
	function generate(om) {
		var n, cw = new IO.CodeWriter();

		cw.openDocument().openNamespace('org.whitehole.assembly.ia32_x64.dis');

        cw.addImport('java.io.IOException');
        cw.addImport('java.io.InputStream');
        cw.addImport('org.whitehole.assembly.ia32_x64.dom.OperandType');
        cw.addImport('org.whitehole.assembly.ia32_x64.dom.Mnemonic');
		
		cw.openClass('', 'InstructionDecoder');
		
        for (n in om.maps)
        	if (om.maps.hasOwnProperty(n))
        		generateMapDecoder(cw, n, om.maps[n]);

        for (n in om.x87_maps)
        	generateX87Decoder(cw, n, om.x87_maps[n]);
        
        for (n in om.groups)
        	if (om.groups.hasOwnProperty(n))
        		generateGroupDecoder(cw, n, om.groups[n]);

		cw.closeClass();
		
		cw.closeNamespace().closeDocument();

		return cw.toString();
	}

	return function(opcodeMapsPath, destPath) {
		print('Generating ' + destPath);
		IO.writeFile(destPath, generate(IO.readJSONFile(opcodeMapsPath)));
	};
});
