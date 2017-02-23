// Generated, do not edit by hand
package org.whitehole.infra.types;

import java.math.BigInteger;

public class UInt128 extends ByteArray16 {

	public static final UInt128 ZERO = new UInt128();
	public static final UInt128 ONE = new UInt128((byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1);
	public UInt128(byte b15, byte b14, byte b13, byte b12, byte b11, byte b10, byte b9, byte b8, byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		super(b15, b14, b13, b12, b11, b10, b9, b8, b7, b6, b5, b4, b3, b2, b1, b0);
	}

	public UInt128() {
	}

	public UInt128(ByteArray16 i) {
		super(i);
	}

	public UInt128(ByteArray1 b) {
		super(b);
	}

	public UInt128(ByteArray2 b) {
		super(b);
	}

	public UInt128(ByteArray4 b) {
		super(b);
	}

	public UInt128(ByteArray8 b) {
		super(b);
	}

	public BigInteger toBigInteger() {
		return new BigInteger(new byte[] { 0, getByte15(), getByte14(), getByte13(), getByte12(), getByte11(), getByte10(), getByte9(), getByte8(), getByte7(), getByte6(), getByte5(), getByte4(), getByte3(), getByte2(), getByte1(), getByte0() });
	}

}
