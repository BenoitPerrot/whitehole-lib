// Generated, do not edit by hand
package org.whitehole.infra.types;

import java.math.BigInteger;

public class UInt32 extends ByteArray4 {

	public static final UInt32 ZERO = new UInt32();
	public static final UInt32 ONE = new UInt32((byte) 0, (byte) 0, (byte) 0, (byte) 1);
	public UInt32(byte b3, byte b2, byte b1, byte b0) {
		super(b3, b2, b1, b0);
	}

	public UInt32() {
	}

	public UInt32(ByteArray4 i) {
		super(i);
	}

	public UInt32(ByteArray1 b) {
		super(b);
	}

	public UInt32(ByteArray2 b) {
		super(b);
	}

	public BigInteger toBigInteger() {
		return new BigInteger(new byte[] { 0, getByte3(), getByte2(), getByte1(), getByte0() });
	}

	public long toLong() {
		return toBigInteger().longValue();
	}

}
