// Generated, do not edit by hand
package org.whitehole.infra.types;

import java.math.BigInteger;

public class UInt64 extends ByteArray8 {

	public static final UInt64 ZERO = new UInt64();
	public static final UInt64 ONE = new UInt64((byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1);
	public UInt64(byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		super(b7, b6, b5, b4, b3, b2, b1, b0);
	}

	public UInt64() {
	}

	public UInt64(ByteArray8 i) {
		super(i);
	}

	public UInt64(ByteArray1 b) {
		super(b);
	}

	public UInt64(ByteArray2 b) {
		super(b);
	}

	public UInt64(ByteArray4 b) {
		super(b);
	}

	public BigInteger toBigInteger() {
		return new BigInteger(new byte[] { 0, getByte7(), getByte6(), getByte5(), getByte4(), getByte3(), getByte2(), getByte1(), getByte0() });
	}

}
