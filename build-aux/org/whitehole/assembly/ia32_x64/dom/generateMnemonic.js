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

define('org/whitehole/assembly/ia32_x64/dom/generateMnemonic', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	function isArray(o) {
		return Object.prototype.toString.call(o) === '[object Array]';
	}

	// Extract mnemonics from opcode maps
	//
	function extractMnemonics(allMaps) {
		
		var mnemonics = {};

		function extract(maps) {
			var name, map, i, j, b;
			
			for (name in maps)
				if (maps.hasOwnProperty(name)) {
					map = maps[name];

					for (i = 0; i < map.length; ++i) {
						b = map[i];
						if (b !== null) {

							if (b.hasOwnProperty('m'))
								mnemonics[b.m] = true;

							else if (isArray(b))
								for (j = 0; j < b.length; ++j)
									mnemonics[b[j].m] = true;
						}
					}
				}
		}

		extract(allMaps.maps);
		extract(allMaps.groups);
		
		for (var k in allMaps.x87_maps)
			if (allMaps.x87_maps.hasOwnProperty(k))
				extract(allMaps.x87_maps[k]);

		return mnemonics;
	}

	// Generate code accordingly
	//
	function generateCode(mnemonics) {
		var m, cw;

		cw = new IO.CodeWriter();

		cw.openDocument().openNamespace('org.whitehole.assembly.ia32_x64.dom');

		cw.openEnum('public', 'Mnemonic');
		cw.addEnumMember('INVALID');
		for (m in mnemonics)
			if (mnemonics.hasOwnProperty(m))
				cw.addEnumMember(m);
		cw.closeEnum();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	}

	return function(opcodeMapsPath, destPath) {
		print('Generating ' + destPath);
		IO.writeFile(destPath, generateCode(extractMnemonics(IO.readJSONFile(opcodeMapsPath))));
	};
});
