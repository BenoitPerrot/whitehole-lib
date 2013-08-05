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

// Build a Java enumeration for ia32/x64 mnemonics
//

define('org/whitehole/assembly/ia32_x64/generateHTML', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	// Extract mnemonics from opcode maps
	//
	function generate(om) {
		
		function instToHTML(inst) {
			var s = inst.m;
			if (inst.hasOwnProperty('o')) {
				s += ' ';
				if (inst.o instanceof Array) {
					var first = true;
					inst.o.forEach(function (e) {
						if (!first)
							s += ',';
						s += e;
						first = false;
					});
				}
				else
					s += inst.o;
			}
			return s;
		}
		
		function instAltToHTML(alt) {
			var s = '<table style="table-layout:auto;">';
			for (var a = 0; a < alt.length; ++a) {
				s += '<tr>';
				
				var inst = alt[a];

				s += '<td>';
				if (inst.hasOwnProperty('prefix'))
					s += inst.prefix;
				else
					s += '&nbsp;';
				s += '</td>';
				
				s += '<td>' + instToHTML(inst) + '</td>';
				
				s += '</tr>';
			}
			s += '</table>';

			return s;
		}
		
		function entryToHTML(e) {
			if (e !== null) {
				if (e.hasOwnProperty('m'))
					return instToHTML(e);

				else if (e instanceof Array)
					return instAltToHTML(e);

				else // Assume sub-table
					return e.replace(/_/g, ' ');
			}
			return ''; // Invalid opcode
		}
		
		var s = '', i, j, a, e, firstTable, firstRow;
		
		s += '<html>';
		
		s += '<head>'+
		'<style>' +
		'* { font-family: "Courier New";  font-size: 10pt; }' + 
		'table { table-layout: fixed; border: 1px solid black; border-collapse: collapse; width: 100%; }' +
		'td { border: 1px solid black; text-align: center; }'+
		'td.h { font-weight: bold; border: 3px solid black; }'+
		'</style>'+
		'</head>'
		;
		
		s += '<body>';
		for (m in om.maps)
			if (om.maps.hasOwnProperty(m)) {
				a = om.maps[m];
				
				s += '<h1>' + m + '</h1>';
				
				if (a.length != 256)
					s += 'WARNING: 256 entries expected, ' + a.length + ' found';

				[0, 8, 128, 136].forEach(function (k) {
					var i, j, x;
					s += '<table>';

					s += '<tr><td class="h" style="width:2em;">&nbsp;</td>';
					for (j = 0; j < 8; ++j)
						s += '<td class="h">' + ((k < 128 ? 0 : 8) + j).toString(16) + '</td>';
					s += '</tr>';
					
					for (i = 0; i < 8; ++i) {
						s += '<tr><td class="h">' + ((k < 128 ? 0 : 8) + i).toString(16) + '</td>';
						
						for (j = 0; j < 8; ++j) {
							s += '<td>';
							
							x = k + i * 16 + j;
							
							if (x < a.length)
								s += entryToHTML(a[x]);
							
							s += '</td>';
						}
						s += '</tr>';
					}
					s += '</table><br>';
				});
			}
			
		
		s += '</body></html>' 
		return s;
	}

	return function(opcodeMapsPath, destPath) {
		IO.writeFile(destPath, generate(IO.readJSONFile(opcodeMapsPath)));
	};
});
