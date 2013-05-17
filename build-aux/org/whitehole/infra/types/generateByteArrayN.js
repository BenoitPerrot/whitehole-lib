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

// Build Java classes for fixed-size arrays of bytes
//

define('org/whitehole/infra/types/generateByteArrayN',
    [
        'org/whitehole/infra/IO'
    ],
    function (IO) {
        'use strict';

        function generate(n) {
            var cw, className = 'ByteArray' + n, i, j, l;

            cw = new IO.CodeWriter();

            cw.openDocument()
                .openNamespace('org.whitehole.infra.types');

            cw.openClass(className, 'public');
            
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
            cw.addStatement('set(' + l.join(', ') + ')');
            cw.closeFunction();

            // All zero
            cw.openFunction('public', className);
            l = [];
            for (i = 0; i < n; ++i)
            	l.push('(byte) 0');
            cw.addStatement('set(' + l.join(', ') + ')');
            cw.closeFunction();

            // Compose
            for (i = 1; i <= n; i *= 2) {
            	cw.openFunction('public', className, 'ByteArray' + i + ' b');
            	l = [];
            	for (j = n - 1; i <= j; --j)
            		l.push('(byte) 0');
            	for (j = i - 1; 0 <= j; --j)
            		l.push('b.getByte' + j + '()');
            	cw.addStatement('set(' + l.join(', ') + ')');
            	cw.closeFunction();
            }

            // Generate accessors
            //
            for (i = 0; i < n; ++i) {
            	cw.openFunction('public byte', 'getByte' + i);
            	cw.addStatement('return _b' + i);
            	cw.closeFunction();
            }
            
            cw.openFunction('public boolean', 'testBit', 'int b');
            for (i = 0; i < n; ++i) {
            	cw.openIf(i * 8 + ' <= b && b < ' + (i + 1) * 8);
            	cw.addStatement('return (getByte' + i + '() & (0x01 << (b - ' + (i * 8) + '))) != 0');
            	cw.closeIf();
            }
            cw.addStatement('throw new IllegalArgumentException()');
            cw.closeFunction();
            
            // Generate convertors
            // 
            
            // To built-in frozen byte array
            cw.openFunction('public byte[]', 'toByteArray');
            l = [];
            for (i = n - 1; 0 <= i; --i)
            	l.push('_b' + i);
            cw.addStatement('return new byte[] { ' + l.join(', ') + ' }');
            cw.closeFunction();

            // To hexadecimal string
            cw.openFunction('public String', 'toHexString');
            cw.addStatement('return toHexString(false)');
            cw.closeFunction();

            cw.openFunction('public String', 'toHexString', 'boolean printLeadingZero');
            if (n === 1) {
            	cw.addStatement('return toHexString(getByte0(), false)');
            	cw.closeFunction();
            	
            	cw.openFunction('static String', 'toHexString', 'byte b, boolean printLeadingZero');
            	cw.addStatement('int i = b & 0xff');
            	cw.openIf('printLeadingZero && i <= 0xf');
            	cw.addStatement('return "0" + Integer.toHexString(i)');
            	cw.openElse();
            	cw.addStatement('return Integer.toHexString(i)');
            	cw.closeIf();
            }
            else {
            	cw.addStatement('String s = ""');
            	for (i = n - 1; 0 < i; --i) {
            		cw.openIf('getByte' + i + '() != 0 || printLeadingZero');
            		cw.addStatement('s += ByteArray1.toHexString(getByte' + i + '(), printLeadingZero)');
            		cw.addStatement('printLeadingZero = true');
            		cw.closeIf();
            	}
            	cw.addStatement('return s + ByteArray1.toHexString(getByte0(), printLeadingZero)');
            }
            cw.closeFunction();
            
            // Generate comparators
            //
            cw.openFunction('public boolean', 'equals', className + ' rhs');
            l = [];
            for (i = 0; i < n; ++i)
            	l.push('getByte' + i + '() == rhs.getByte' + i + '()');
            cw.addStatement('return ' + l.join(' && '));
            cw.closeFunction();
            
            // Internal setter
            l = [];
            for (i = n - 1; 0 <= i; --i)
            	l.push('byte b' + i);
            cw.openFunction('protected void', 'set', l.join(', '));
            for (i = n - 1; 0 <= i; --i)
            	cw.addStatement('_b' + i + ' = b' + i);
            cw.closeFunction();
            
            // Generate attributes
            //
            for (i = n - 1; 0 <= i; --i)
            	cw.addStatement('private byte _b' + i);

            // Epilogue
            //
            cw.closeClass();

            cw.closeNamespace().closeDocument();

            return cw.toString();
        }
        
        return function (destPath) {
        	var i;
        	
        	for (i = 1; i <= 8; i *= 2)
                IO.writeFile(destPath + '/ByteArray' + i + '.java',
                		generate(i));
        };
    });
