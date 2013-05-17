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

define('org/whitehole/infra/types/generateSIntN',
    [
        'org/whitehole/infra/IO'
    ],
    function (IO) {
        'use strict';

        function generate(isSigned, n) {
            var cw, className = (isSigned ? '' : 'U') + 'Int' + (n * 8), i, j, first, s, l;

            cw = new IO.CodeWriter();

            cw.openDocument()
                .openNamespace('org.whitehole.infra.types');

            cw.openClass(className, 'public', 'ByteArray' + n);
            
            // Generate constructors
            //

            // Component per component
            l = [];
            for (i = n - 1; 0 <= i; --i)
            	l.push('byte b' + i);
            cw.openFunction('public', className, l.join(', '));
            l = [];
            for (i = n - 1; 0 <= i; --i)
            	l.push('b' + i)
            cw.addStatement('set(' + l.join(', ') + ')');
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
	            	if (2 < n) { // do not conflict with previously defined Int16 constructor
	            		l = ['byte sign'];
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
	            	l = ['(byte) 0'];
	            	for (j = i - 1; 0 <= j; --j)
	            		l.push('i.getByte' + j + '()');
	            	cw.addStatement('this(' + l.join(', ') + ')');
	            	cw.closeFunction();
	
	            	// From signed integers
	            	cw.openFunction('public', className, 'Int' + (i * 8) + ' i');
	            	l = ['(byte) (i.getByte' + (i - 1) + '() < 0 ? 0xff : 0)'];
	            	for (j = i - 1; 0 <= j; --j)
	            		l.push('i.getByte' + j + '()');
	            	cw.addStatement('this(' + l.join(', ') + ')');
	            	cw.closeFunction();
	            }
	            
	            // To BigInteger
	            cw.addImport('java.math.BigInteger');
	            cw.openFunction('public BigInteger', 'toBigInteger');
	            cw.addStatement('return new BigInteger(toByteArray())');
	            cw.closeFunction();
            }
            else {
            	// From signed or unsigned integers (i.e. ByteArray)
            	for (i = 1; i < n; i *= 2) {
            		cw.openFunction('public', className, 'ByteArray' + i + ' b');
            		cw.addStatement('super(b)');
            		cw.closeFunction();
            	}

            	// From BigInteger
            	cw.openFunction('public', className, 'BigInteger i');
                cw.addStatement('final byte[] a = i.toByteArray()');
                cw.openSwitch('a.length');
                //
            	cw.openCase(n + 1);
                cw.addStatement('if (a[0] != 0) throw new IllegalArgumentException()'); // Accept non-sign extension 
                cw.closeCase();
                //
                for (i = n; 0 < i; --i) {
                	cw.openCase(i);
                	l = [];
                	for (j = i; j < n; ++j)
                		l.push('(byte) 0');
                	for (j = 0; j < i; ++j)
                		l.push('a[' + j + ']');
                	cw.addStatement('set(' + l.join(', ') + ')');
                	cw.addStatement('break');
                	cw.closeCase();
                }
                cw.openDefault();
            	cw.addStatement('throw new IllegalArgumentException()');
                cw.closeDefault();
                //
                cw.closeSwitch();
            	cw.closeFunction();
            	
            	// To BigInteger, preventing sign extension
            	cw.addImport('java.math.BigInteger');
            	cw.openFunction('public BigInteger', 'toBigInteger');
            	l = ['0'];
            	for (i = n - 1; 0 <= i; --i)
            		l.push('getByte' + i + '()');
            	cw.addStatement('return new BigInteger(new byte[] { ' + l.join(', ') +' })');
            	cw.closeFunction();
            }

            // Epilogue
            //
            cw.closeClass();

            cw.closeNamespace().closeDocument();

            return cw.toString();
        }
        
        return function (destPath) {
        	var i;
        	
        	for (i = 1; i <= 8; i *= 2) {
                IO.writeFile(destPath + '/UInt' + (i * 8) + '.java',
                		generate(false, i));
        	    IO.writeFile(destPath + '/Int' + (i * 8) + '.java',
                		generate(true, i));
        	}
        };
    });
