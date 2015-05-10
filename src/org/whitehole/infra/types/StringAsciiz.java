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
package org.whitehole.infra.types;

import org.whitehole.infra.io.LargeByteBuffer;

public class StringAsciiz {

	static public String read(LargeByteBuffer buffer, long offset) {
		final StringBuilder sb = new StringBuilder();
		// Search for null termination
		while (buffer.get(offset) != 0) {
			sb.append((char) buffer.get(offset));
			++offset;
		}

		return sb.toString();
	}

	static public String readLittleEndian(ByteArray8 x) {
		StringBuilder sb = new StringBuilder();
		if (x.getByte0() != 0) {
			sb.append((char) x.getByte0());
			if (x.getByte1() != 0) {
				sb.append((char) x.getByte1());
				if (x.getByte2() != 0) {
					sb.append((char) x.getByte2());
					if (x.getByte3() != 0) {
						sb.append((char) x.getByte3());
						if (x.getByte4() != 0) {
							sb.append((char) x.getByte4());
							if (x.getByte5() != 0) {
								sb.append((char) x.getByte5());
								if (x.getByte6() != 0) {
									sb.append((char) x.getByte6());
									if (x.getByte7() != 0)
										sb.append((char) x.getByte7());
								}
							}
						}
					}
				}
			}
		}
		return sb.toString();
	}

	static public int byteSize(String s) {
		// Consider that s is an ASCII string, and add one for the terminating zero
		return 1 + s.length();
	}
}
