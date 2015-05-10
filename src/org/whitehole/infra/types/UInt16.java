// Generated, do not edit by hand
package org.whitehole.infra.types;

import java.math.BigInteger;

public class UInt16 extends ByteArray2 {

	public static final UInt16 ZERO = new UInt16();
	public static final UInt16 ONE = new UInt16((byte) 0, (byte) 1);

	public UInt16(byte b1, byte b0) {
		super(b1, b0);
	}

	public UInt16() {
	}

	public UInt16(ByteArray2 i) {
		super(i);
	}

	public UInt16(ByteArray1 b) {
		super(b);
	}

	public BigInteger toBigInteger() {
		return new BigInteger(new byte[] { 0, getByte1(), getByte0() });
	}

	public long toLong() {
		return toBigInteger().longValue();
	}

	public long toInt() {
		return toBigInteger().intValue();
	}

}
