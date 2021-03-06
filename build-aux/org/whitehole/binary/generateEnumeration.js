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

// Build a Java class representing an enumerated type in a binary scheme.
// Said class is immutable.
//

define('org/whitehole/binary/generateEnumeration', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	function generateValidEnumeration(cw, e) {
		var m;

		cw.openEnum('public', 'Valid');
		for (m in e.members)
			if (e.members.hasOwnProperty(m)) {
				// Ensure m is a valid member name
				if (m[0].match(/[a-zA-Z_]/))
					cw.addEnumMember(m, e.members[m].v);
				else
					cw.addEnumMember('_' + m, e.members[m].v);
			}
		cw.closeEnumMembers();

		cw.openFunction('private', 'Valid', 'int c');
		cw.addStatement('code = c');
		cw.closeFunction();

		cw.addStatement('public final int code');

		cw.closeEnum();
	}

	function generateModel(cw, name, e) {
		var underlyingType = 'ByteArray' + e.byteWidth, l, i, m, masking;

		cw.addImport('org.whitehole.infra.types.' + underlyingType);

		// Constructors
		//

		// Primitive
		cw.openFunction('public', name, underlyingType + ' c');
		cw.addStatement('code = c');
		cw.closeFunction();

		// Enumeration
		cw.openFunction('public', name, 'Valid v');
		l = [];
		for (i = 0; i < e.byteWidth; ++i)
			l.push('(byte) ((v.code >> ' + (i * 8) + ') & 0x0ff)');
		cw.addStatement('this(new ' + underlyingType + '(' + l.join(', ') + '))');
		cw.closeFunction();

		// Default
		cw.openFunction('public', name);
		cw.addStatement('this(new ' + underlyingType + '())');
		cw.closeFunction();

		// Reader
		cw.addImport('org.whitehole.infra.io.LargeByteBuffer');
		cw.addImport('org.whitehole.infra.types.LittleEndianReader');

		cw.openFunction('public static ' + name, 'read', 'LargeByteBuffer buffer, long offset');
		cw.addStatement('return new ' + name + '(LittleEndianReader.read' + underlyingType + "(buffer, offset))");
		cw.closeFunction();

		// Converter
		//
		cw.openFunction('public Valid', 'toValid');
		l = [];
		masking = ' & 0x0ff';
		for (i = e.byteWidth - 1; 0 < i; --i) {
			l.push('(code.getByte' + i + '() << ' + (i * 8) + ')');
			masking += 'ff';
		}
		l.push('code.getByte0()');
		cw.openSwitch('(' + l.join(' | ') + ')' + masking);
		for (m in e.members)
			if (e.members.hasOwnProperty(m)) {
				cw.addStatement('case ' + e.members[m].v + ': return Valid.' + (m[0].match(/[a-zA-Z_]/) ? '' : '_') + m);
			}
		cw.openDefault().addStatement('return null').closeDefault();
		cw.closeSwitch();
		cw.closeFunction();

		cw.addStatement('static public final int byteSize = ' + e.byteWidth);

		// Attributes
		//
		cw.addStatement('public final ' + underlyingType + ' code');
	}

	return function(ns, name, e) {
		var cw;

		cw = new IO.CodeWriter();

		cw.openDocument().openNamespace(ns);

		cw.openClass('public', name);
		generateValidEnumeration(cw, e);
		generateModel(cw, name, e);
		cw.closeClass();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	};
});
