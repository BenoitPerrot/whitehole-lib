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

// Build a Java enumeration for ia32/x64 register names
//

define('org/whitehole/assembly/ia32_x64/dom/generateRegisterName', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	// Add an enum member for each register name in maps
	//
	function generateEnumMembers(cw, registerMaps) {
		var gprs, w, k;

		function addAsEnumMember(n) {
			cw.addEnumMember(n);
		}

		gprs = registerMaps.generalPurpose;
		for (w in gprs)
			if (gprs.hasOwnProperty(w))
				gprs[w].forEach(addAsEnumMember);

		for (k in registerMaps)
			if (registerMaps.hasOwnProperty(k) && k !== 'generalPurpose')
				registerMaps[k].forEach(addAsEnumMember);

		cw.addEnumMember('FLAGS');
		cw.addEnumMember('RIP');

		cw.closeEnumMembers();
	}

	function generateConstructor(cw, kind, registers) {
		var i;

		cw.openFunction('public static RegisterName', kind, 'int i');

		cw.openSwitch('i');

		for (i = 0; i < registers.length; ++i) {
			cw.openCase(i);
			cw.addStatement('return ' + registers[i]);
			cw.closeCase(i);
		}

		cw.openDefault();
		cw.addStatement('throw new IllegalArgumentException()');
		cw.closeDefault();

		cw.closeSwitch();

		cw.closeFunction();
	}

	// Generate code accordingly
	//
	function generateCode(registerMaps) {
		var cw, gprs;

		cw = new IO.CodeWriter();

		cw.openDocument().openNamespace('org.whitehole.assembly.ia32_x64.dom');

		cw.addImport('org.whitehole.infra.types.BinaryWidth');

		cw.openEnum('public', 'RegisterName');

		//
		generateEnumMembers(cw, registerMaps);

		//
		cw.openFunction("public static RegisterName", "GPR", "BinaryWidth w, int i");
		{
			cw.openSwitch("w");
			{
				// cw.open_case("UNKNOWN");
				// cw.add_statement("break");
				// cw.close_case();
				cw.openCase("_8BIT");
				cw.addStatement("return GPR8(i)");
				cw.closeCase();
				cw.openCase("_16BIT");
				cw.addStatement("return GPR16(i)");
				cw.closeCase();
				cw.openCase("_32BIT");
				cw.addStatement("return GPR32(i)");
				cw.closeCase();
				cw.openCase("_64BIT");
				cw.addStatement("return GPR64(i)");
				cw.closeCase();
				cw.openDefault();
				cw.addStatement("break");
				cw.closeDefault();
			}
			cw.closeSwitch();
			cw.addStatement("throw new IllegalArgumentException()");
		}
		cw.closeFunction();

		gprs = registerMaps.generalPurpose;
		generateConstructor(cw, 'GPR8', gprs['8bit']);
		generateConstructor(cw, 'GPR16', gprs['16bit']);
		generateConstructor(cw, 'GPR32', gprs['32bit']);
		generateConstructor(cw, 'GPR64', gprs['64bit']);

		generateConstructor(cw, 'Segment', registerMaps.segment);
		generateConstructor(cw, 'Control', registerMaps.control);
		generateConstructor(cw, 'Debug', registerMaps.debug);
		generateConstructor(cw, 'MMX', registerMaps.mmx);
		generateConstructor(cw, 'ST', registerMaps.x87);
		generateConstructor(cw, 'XMM', registerMaps.xmm);
		generateConstructor(cw, 'YMM', registerMaps.ymm);

		cw.closeEnum();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	}

	return function(registerMapsPath, destPath) {
		IO.writeFile(destPath, generateCode(IO.readJSONFile(registerMapsPath)));
	};
});
