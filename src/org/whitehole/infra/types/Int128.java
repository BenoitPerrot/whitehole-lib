// Generated, do not edit by hand
package org.whitehole.infra.types;

import java.math.BigInteger;

public class Int128 extends ByteArray16 {

	public static final Int128 ZERO = new Int128();
	public static final Int128 ONE = new Int128((byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0,
			(byte) 1);

	public Int128(byte b15, byte b14, byte b13, byte b12, byte b11, byte b10, byte b9, byte b8, byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		super(b15, b14, b13, b12, b11, b10, b9, b8, b7, b6, b5, b4, b3, b2, b1, b0);
	}

	public Int128() {
	}

	public Int128(ByteArray16 i) {
		super(i);
	}

	private Int128(byte sign, byte b0) {
		super(sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, b0);
	}

	public Int128(UInt8 i) {
		this((byte) 0, i.getByte0());
	}

	public Int128(Int8 i) {
		this((byte) (i.getByte0() < 0 ? 0xff : 0), i.getByte0());
	}

	private Int128(byte sign, byte b1, byte b0) {
		super(sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, b1, b0);
	}

	public Int128(UInt16 i) {
		this((byte) 0, i.getByte1(), i.getByte0());
	}

	public Int128(Int16 i) {
		this((byte) (i.getByte1() < 0 ? 0xff : 0), i.getByte1(), i.getByte0());
	}

	private Int128(byte sign, byte b3, byte b2, byte b1, byte b0) {
		super(sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, sign, b3, b2, b1, b0);
	}

	public Int128(UInt32 i) {
		this((byte) 0, i.getByte3(), i.getByte2(), i.getByte1(), i.getByte0());
	}

	public Int128(Int32 i) {
		this((byte) (i.getByte3() < 0 ? 0xff : 0), i.getByte3(), i.getByte2(), i.getByte1(), i.getByte0());
	}

	private Int128(byte sign, byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		super(sign, sign, sign, sign, sign, sign, sign, sign, b7, b6, b5, b4, b3, b2, b1, b0);
	}

	public Int128(UInt64 i) {
		this((byte) 0, i.getByte7(), i.getByte6(), i.getByte5(), i.getByte4(), i.getByte3(), i.getByte2(), i.getByte1(), i.getByte0());
	}

	public Int128(Int64 i) {
		this((byte) (i.getByte7() < 0 ? 0xff : 0), i.getByte7(), i.getByte6(), i.getByte5(), i.getByte4(), i.getByte3(), i.getByte2(), i.getByte1(), i.getByte0());
	}

	public BigInteger toBigInteger() {
		return new BigInteger(toByteArray(Endianness.BIG));
	}

}
