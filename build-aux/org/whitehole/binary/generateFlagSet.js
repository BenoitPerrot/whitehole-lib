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

define('org/whitehole/binary/generateFlagSet', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	return function(ns, name, fs) {
		var cw, underlyingType = 'ByteArray' + fs.byteWidth, bitWidth = 8 * fs.byteWidth, f, l, i, b, mask;

		cw = new IO.CodeWriter();

		cw.openDocument().openNamespace(ns);

		cw.addImport('org.whitehole.infra.types.' + underlyingType);

		cw.openClass('public', name);

		// Constructors
		//
		cw.openFunction('public', name, underlyingType + ' code');
		cw.addStatement('_code = code');
		cw.closeFunction();

		cw.openFunction('public', name);
		cw.addStatement('this(new ' + underlyingType + '())');
		cw.closeFunction();

		// Reader
		cw.addImport('org.whitehole.infra.io.LargeByteBuffer');
		cw.addImport('org.whitehole.infra.types.LittleEndianReader');

		cw.openFunction('public static ' + name, 'read', 'LargeByteBuffer buffer, long offset');
		cw.addStatement('return new ' + name + '(LittleEndianReader.read' + underlyingType + "(buffer, offset))");
		cw.closeFunction();

		// Accessors
		//
		for (f in fs.flags)
			if (fs.flags.hasOwnProperty(f)) {

				mask = '' + fs.flags[f].v;
				if (mask[0] === '0' && mask[1] === 'x')
					mask = parseInt(mask, 16);

				cw.openFunction('public boolean', IO.CodeWriter.makeMethodName('get', f));
				l = [];
				for (i = 0; i < bitWidth; ++i) {
					b = (mask >> i) & 0x1;
					if (b === 1)
						l.push('_code.testBit(' + i + ')');
				}
				cw.addStatement('return ' + l.join(' && '));
				cw.closeFunction();
			}

		cw.addStatement('static public final int byteSize = ' + fs.byteWidth);

		// Attributes
		//
		cw.addStatement('private final ' + underlyingType + ' _code');

		cw.closeClass();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	};
});
