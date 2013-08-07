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

// Build a Java class for reading signed or unsigned fixed-size integers
// when stored least significant byte first. 

define('org/whitehole/infra/types/generateLittleEndianReader', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	function generate() {
		var cw, l, i, j;

		cw = new IO.CodeWriter();

		cw.openDocument().openNamespace('org.whitehole.infra.types');

		cw.openClass('public', 'LittleEndianReader');

		cw.addImport('org.whitehole.infra.io.LargeByteBuffer');
		for (i = 1; i <= 16; i *= 2) {
			l = [];
			for (j = i - 1; 0 <= j; --j)
				l.push('buffer.get(offset + ' + j + ')');

			// Read ByteArrays
			cw.openFunction('public static ByteArray' + i, 'readByteArray' + i, 'LargeByteBuffer buffer, long offset');
			cw.addStatement('return new ByteArray' + i + '(' + l.join(', ') + ')');
			cw.closeFunction();

			// Read unsigned integers
			cw.openFunction('public static UInt' + (i * 8), 'readUInt' + (i * 8), 'LargeByteBuffer buffer, long offset');
			cw.addStatement('return new UInt' + (i * 8) + '(' + l.join(', ') + ')');
			cw.closeFunction();

			// Read signed integers
			cw.openFunction('public static Int' + (i * 8), 'readInt' + (i * 8), 'LargeByteBuffer buffer, long offset');
			cw.addStatement('return new Int' + (i * 8) + '(' + l.join(', ') + ')');
			cw.closeFunction();
		}
		
		cw.addImport('java.io.InputStream');
		cw.addImport('java.io.IOException');
		for (i = 1; i <= 16; i *= 2) {
			l = [];
			for (j = i - 1; 0 <= j; --j)
				l.push('buffer[' + j + ']');

			// Read unsigned integers
			cw.openFunction('public static UInt' + (i * 8), 'readUInt' + (i * 8), 'InputStream i', 'throws IOException');
			cw.addStatement('final byte[] buffer = new byte[' + i + ']');
			cw.addStatement('i.read(buffer)');
			cw.addStatement('return new UInt' + (i * 8) + '(' + l.join(', ') + ')');
			cw.closeFunction();

			// Read signed integers
			cw.openFunction('public static Int' + (i * 8), 'readInt' + (i * 8), 'InputStream i', 'throws IOException');
			cw.addStatement('final byte[] buffer = new byte[' + i + ']');
			cw.addStatement('i.read(buffer)');
			cw.addStatement('return new Int' + (i * 8) + '(' + l.join(', ') + ')');
			cw.closeFunction();
		}

		cw.closeClass();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	}

	return function(destPath) {
		IO.writeFile(destPath, generate());
	};
});
