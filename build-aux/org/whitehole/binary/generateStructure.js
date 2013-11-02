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
		var cw, builtinTypes = {}, i, n, s = schema.structures[name], aliases = schema.aliases || {};

		function unaliasType(t) {
			return aliases[t] || t;
		}

		for (i = 1; i <= 16; i *= 2) {
			n = 'ByteArray' + i;
			builtinTypes[n] = {
			    deps : [ 'org.whitehole.infra.types.ByteArray' + i, 'org.whitehole.infra.types.LittleEndianReader' ],
			    read : 'LittleEndianReader.read' + n,
			    byteSize : i
			};

			n = 'Int' + (i * 8);
			builtinTypes[n] = {
			    deps : [ 'org.whitehole.infra.types.Int' + (i * 8), 'org.whitehole.infra.types.LittleEndianReader' ],
			    read : 'LittleEndianReader.read' + n,
			    byteSize : i
			};

			n = 'UInt' + (i * 8);
			builtinTypes[n] = {
			    deps : [ 'org.whitehole.infra.types.UInt' + (i * 8), 'org.whitehole.infra.types.LittleEndianReader' ],
			    read : 'LittleEndianReader.read' + n,
			    byteSize : i
			};
		}
		builtinTypes['StringAsciiz'] = {
		    deps : [ 'org.whitehole.infra.types.StringAsciiz' ],
		    at : 'String'
		};

		cw = new IO.CodeWriter();

		// Prologue

		cw.openDocument().openNamespace(ns);

		cw.openClass('public', name, s.base);

		//
		// Reader

		(function generateReader(cw, name, s) {
			cw.addImport('org.whitehole.infra.io.LargeByteBuffer');

			cw.openFunction('public static ' + name, 'read', 'LargeByteBuffer buffer, long offset');
			cw.addStatement('return read(buffer, offset, new ' + name + '())');
			cw.closeFunction();

			cw.openFunction('public static ' + name, 'read', 'LargeByteBuffer buffer, long offset, ' + name + ' x');

			if (s.base && schema.structures[s.base] && (!schema.structures[s.base].fields || schema.structures[s.base].fields.length)) {
				cw.addStatement(s.base + '.read(buffer, offset, x)');
				cw.addStatement('offset += ' + s.base + '.byteSize');
			}

			s.fields.forEach(function(f) {
				var t, read, offset = 0;

				if (f.keep !== false) {
					t = unaliasType(f.type);

					offset = 'offset';
					if (f.offset)
						offset += ' + ' + f.offset;

					if (f.count) {
						t = 'ArrayList<' + t + '>';
					}
					else {
						read = t + '.read';

						if (builtinTypes.hasOwnProperty(t)) {
							if (builtinTypes[t].hasOwnProperty('read'))
								read = builtinTypes[t].read;
						}

						cw.addStatement('x.' + IO.CodeWriter.makeMethodName('set', f.name) + '(' + read + '(buffer, ' + offset + '))');
					}
				}
			});

			cw.addStatement('return x');
			cw.closeFunction();
		}(cw, name, s));

		//
		// Accessors

		s.fields.forEach(function generateAccessor(f) {
			var at;
			if (f.keep !== false) {
				at = unaliasType(f.type);

				if (builtinTypes.hasOwnProperty(at))
					if (builtinTypes[at].hasOwnProperty('at'))
						at = builtinTypes[at].at;

				cw.openFunction('public ' + at, IO.CodeWriter.makeMethodName('get', f.name));
				cw.addStatement('return ' + IO.CodeWriter.makeMemberName(f.name));
				cw.closeFunction();

				cw.openFunction('public ' + name, IO.CodeWriter.makeMethodName('set', f.name), at + ' x');
				cw.addStatement(IO.CodeWriter.makeMemberName(f.name) + ' = x');
				cw.addStatement('return this');
				cw.closeFunction();
			}
		});

		//
		// Byte size

		(function generateByteSize(s) {
			var byteSize = {
					imm : 0,
				    sum : [],
				    fun: []
			}, cst;

			s.fields.forEach(function(f) {
				var t;
				if (f.keep !== false) {
					t = unaliasType(f.type);

					if (f.count) {
						byteSize.fun.push('FIXME');
					}
					else {
						if (builtinTypes.hasOwnProperty(t)) {
							if (builtinTypes[t].hasOwnProperty('byteSize'))
								byteSize.imm += builtinTypes[t].byteSize;
							else
								byteSize.fun.push(t + '.byteSize(' + IO.CodeWriter.makeMemberName(f.name) + ')');
						}
						else
							byteSize.sum.push(t + '.byteSize');
					}
				}
			});

			cst = byteSize.imm;
			if (0 < byteSize.sum.length)
				cst += ' + ' + byteSize.sum.join(' + ');
			if (0 < byteSize.fun.length) {
				cw.openFunction('public int', 'byteSize', '');
				cw.addStatement('return ' + cst + ' + ' + byteSize.fun.join(' + '));
				cw.closeFunction();
			}
			else
				cw.addStatement('public static final int byteSize = ' + cst);
		}(s));

		//
		// Attributes
		
		s.fields.forEach(function generateAttribute(f) {
			var at;
			if (f.keep !== false) {
				at = unaliasType(f.type);

				if (f.count) {
					cw.addImport('java.util.ArrayList');
					at = 'ArrayList<' + at + '>';
				}
				else if (builtinTypes.hasOwnProperty(at)) {

					builtinTypes[at].deps.forEach(function(i) {
						cw.addImport(i);
					});

					if (builtinTypes[at].hasOwnProperty('at'))
						at = builtinTypes[at].at;
				}

				cw.addStatement('private ' + at + ' ' + IO.CodeWriter.makeMemberName(f.name));
			}
		});

		// Epilogue

		cw.closeClass();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	};
});
