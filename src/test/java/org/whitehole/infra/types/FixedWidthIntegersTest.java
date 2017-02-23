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

import java.math.BigInteger;
import java.util.logging.Logger;

import org.junit.Test;

public class FixedWidthIntegersTest {

	private static byte[] readByteArray2(byte[] a, boolean isSigned) {
		if (!isSigned)
			if ((a[1] & 0x80) == 0x80)
				return new byte[] { 0, a[1], a[0] };
		return new byte[] { a[1], a[0] };
	}

	private static BigInteger readUInt16(byte[] a) {
		return new BigInteger(readByteArray2(a, false));
	}

	private static BigInteger readInt16(byte[] a) {
		return new BigInteger(readByteArray2(a, true));
	}

	private static void dump(BigInteger x) {
		Logger.getAnonymousLogger().info(Long.toString(x.longValue()));
		Logger.getAnonymousLogger().info("bitLength: " + Integer.toString(x.bitLength()));
		Logger.getAnonymousLogger().info("signum: " + Integer.toString(x.signum()));
	}

	@Test
	public void test() {
		final byte[] a = new byte[] { (byte) 0x42, (byte) 0x80, (byte) 0x42, (byte) 0x80 };
		dump(readUInt16(a));
		dump(readInt16(a));
	}

}
