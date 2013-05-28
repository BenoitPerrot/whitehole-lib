// Copyright (c) 2004-2013, Benoit PERROT.
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

// Build a Java class representing a flag set in a binary scheme.
// Said class is immutable.
//

define('org/whitehole/binary/generateStructure', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	return function(ns, schema, name) {
		var cw, typeData = {}, i, k, f, t, offset, byteSize,
			s = schema.structures[name],
			aliases = schema.aliases || {};
		
		function unaliasType(t) {
			return aliases[t] || t;
		}

		for (i = 1; i <= 16; i *= 2) {
			typeData['ByteArray' + i] = {
				    i : 'org.whitehole.infra.types.ByteArray' + i,
				    bs : i
			};
			typeData['Int' + (i * 8)] = {
			    i : 'org.whitehole.infra.types.Int' + (i * 8),
			    bs : i
			};
			typeData['UInt' + (i * 8)] = {
			    i : 'org.whitehole.infra.types.UInt' + (i * 8),
			    bs : i
			};
		}

		cw = new IO.CodeWriter();

		cw.openDocument().openNamespace(ns);

		cw.openClass('public', name, s.base);

		// Constructors
		//

		// Reader
		cw.addImport('org.whitehole.infra.io.LargeByteBuffer');

		offset = 0;
		byteSize = {
		    imm : 0,
		    sum : []
		};

		cw.openFunction('public static ' + name, 'read', 'LargeByteBuffer buffer, long offset');
		cw.addStatement('final ' + name + ' x = new ' + name + '()');
		
		if (s.base && schema.structures[s.base] && (!schema.structures[s.base].fields || schema.structures[s.base].fields.length)) {
			throw "FIXME: Not implemented yet";
			// cw.addStatement(s.base + '.read(buffer, offset, x)');
			// cw.addStatement('offset += ' + s.base + '.byteSize');
		}
		
		for (k in s.fields)
			if (s.fields.hasOwnProperty(k)) {
				f = s.fields[k];
				if (f.keep !== false) {
					t = unaliasType(f.type);

					offset = 'offset';
					if (f.offset)
						offset += ' + ' + f.offset;

					if (f.count) {
						t = 'ArrayList<' + t + '>';
						byteSize = undefined;
					}
					else {
						if (typeData.hasOwnProperty(t)) {
							cw.addImport('org.whitehole.infra.types.LittleEndianReader');

							if (byteSize !== undefined)
								byteSize.imm += typeData[t].bs;

							cw.addStatement('x.' + IO.CodeWriter.makeMethodName('set', f.name) + '(LittleEndianReader.read' + t + '(buffer, ' + offset + '))');
						}
						else {
							if (byteSize !== undefined)
								byteSize.sum.push(t + '.byteSize');

							cw.addStatement('x.' + IO.CodeWriter.makeMethodName('set', f.name) + '(' + t + '.read(buffer, ' + offset + '))');
						}
					}
				}
			}
		cw.addStatement('return x');
		cw.closeFunction();

		// Accessors
		//

		for (k in s.fields)
			if (s.fields.hasOwnProperty(k)) {
				f = s.fields[k];
				if (f.keep !== false) {
					t = unaliasType(f.type);

					cw.openFunction('public ' + t, IO.CodeWriter.makeMethodName('get', f.name));
					cw.addStatement('return ' + IO.CodeWriter.makeMemberName(f.name));
					cw.closeFunction();

					cw.openFunction('public ' + name, IO.CodeWriter.makeMethodName('set', f.name), t + ' x');
					cw.addStatement(IO.CodeWriter.makeMemberName(f.name) + ' = x');
					cw.addStatement('return this');
					cw.closeFunction();
				}
			}

		if (byteSize !== undefined)
			cw.addStatement('public static final int byteSize = ' + byteSize.imm + (byteSize.sum.length ? ' + ' + byteSize.sum.join(' + ') : ''));

		// Attributes
		//

		for (k in s.fields)
			if (s.fields.hasOwnProperty(k)) {
				f = s.fields[k];
				if (f.keep !== false) {
					t = unaliasType(f.type);

					if (f.count) {
						t = 'ArrayList<' + t + '>';
						cw.addImport('java.util.ArrayList');
					}
					else if (typeData.hasOwnProperty(t))
						cw.addImport(typeData[t].i);

					cw.addStatement('private ' + t + ' ' + IO.CodeWriter.makeMemberName(f.name));
				}
			}

		cw.closeClass();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	};
});
