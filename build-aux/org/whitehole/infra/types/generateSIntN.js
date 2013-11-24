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

// Build Java classes for fixed-sized signed and unsigned integers of common
// width
//

define('org/whitehole/infra/types/generateSIntN', [ 'org/whitehole/infra/IO' ], function(IO) {
	'use strict';

	function generate(isSigned, n) {
		var cw, className = (isSigned ? '' : 'U') + 'Int' + (n * 8), i, j, l;

		cw = new IO.CodeWriter();

		cw.openDocument().openNamespace('org.whitehole.infra.types');

		cw.openClass('public', className, 'ByteArray' + n);
		
		// Generate constants
		//
		cw.addStatement('public static final ' + className + ' ZERO = new ' + className + '()');
		l = [];
		for (i = n - 2; 0 <= i; --i)
			l.push('(byte) 0');
		l.push('(byte) 1');
		cw.addStatement('public static final ' + className + ' ONE = new ' + className + '(' + l.join(', ') + ')');

		// Generate constructors
		//

		// Component per component
		l = [];
		for (i = n - 1; 0 <= i; --i)
			l.push('byte b' + i);
		cw.openFunction('public', className, l.join(', '));
		l = [];
		for (i = n - 1; 0 <= i; --i)
			l.push('b' + i);
		cw.addStatement('super(' + l.join(', ') + ')');
		cw.closeFunction();

		// All zero
		cw.openFunction('public', className);
		cw.closeFunction();

		// Generate converters
		//
		cw.openFunction('public', className, 'ByteArray' + n + ' i');
		cw.addStatement('super(i)');
		cw.closeFunction();

		if (isSigned) {
			for (i = 1; i < n; i *= 2) {
				// Internal helper for sign extension
				if (2 < n) { // do not conflict with previously defined Int16
								// constructor
					l = [ 'byte sign' ];
					for (j = i - 1; 0 <= j; --j)
						l.push('byte b' + j);
					cw.openFunction('private', className, l.join(', '));
					l = [];
					for (j = n - 1; i <= j; --j)
						l.push('sign');
					for (j = i - 1; 0 <= j; --j)
						l.push('b' + j);
					cw.addStatement('super(' + l.join(', ') + ')');
					cw.closeFunction();
				}

				// From unsigned integers
				cw.openFunction('public', className, 'UInt' + (i * 8) + ' i');
				l = [ '(byte) 0' ];
				for (j = i - 1; 0 <= j; --j)
					l.push('i.getByte' + j + '()');
				cw.addStatement('this(' + l.join(', ') + ')');
				cw.closeFunction();

				// From signed integers
				cw.openFunction('public', className, 'Int' + (i * 8) + ' i');
				l = [ '(byte) (i.getByte' + (i - 1) + '() < 0 ? 0xff : 0)' ];
				for (j = i - 1; 0 <= j; --j)
					l.push('i.getByte' + j + '()');
				cw.addStatement('this(' + l.join(', ') + ')');
				cw.closeFunction();
			}

			// To BigInteger
			cw.addImport('java.math.BigInteger');
			cw.openFunction('public BigInteger', 'toBigInteger');
			cw.addStatement('return new BigInteger(toByteArray(Endianness.BIG))');
			cw.closeFunction();
		}
		else {
			// From signed or unsigned integers (i.e. ByteArray)
			for (i = 1; i < n; i *= 2) {
				cw.openFunction('public', className, 'ByteArray' + i + ' b');
				cw.addStatement('super(b)');
				cw.closeFunction();
			}

			// To BigInteger, preventing sign extension by prefixing with 0
			cw.addImport('java.math.BigInteger');
			cw.openFunction('public BigInteger', 'toBigInteger');
			l = [ '0' ];
			for (i = n - 1; 0 <= i; --i)
				l.push('getByte' + i + '()');
			cw.addStatement('return new BigInteger(new byte[] { ' + l.join(', ') + ' })');
			cw.closeFunction();
		}

		// To long
		if (n < 8 || (n === 8 && isSigned)) {
			cw.openFunction('public long', 'toLong');
			cw.addStatement('return toBigInteger().longValue()');
			cw.closeFunction();
		}

		// To int
		if (n < 4 || (n === 4 && isSigned)) {
			cw.openFunction('public long', 'toInt');
			cw.addStatement('return toBigInteger().intValue()');
			cw.closeFunction();
		}
		
		// Epilogue
		//
		cw.closeClass();

		cw.closeNamespace().closeDocument();

		return cw.toString();
	}

	return function(destPath) {
		var i;

		for (i = 1; i <= 16; i *= 2) {
			IO.writeFile(destPath + '/UInt' + (i * 8) + '.java', generate(false, i));
			IO.writeFile(destPath + '/Int' + (i * 8) + '.java', generate(true, i));
		}
	};
});
