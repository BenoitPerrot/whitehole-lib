// Generated, do not edit by hand
package org.whitehole.infra.types;

import java.math.BigInteger;

public class Int64 extends ByteArray8 {

	public static final Int64 ZERO = new Int64();
	public static final Int64 ONE = new Int64((byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 1);
	public Int64(byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		super(b7, b6, b5, b4, b3, b2, b1, b0);
	}

	public Int64() {
	}

	public Int64(ByteArray8 i) {
		super(i);
	}

	private Int64(byte sign, byte b0) {
		super(sign, sign, sign, sign, sign, sign, sign, b0);
	}

	public Int64(UInt8 i) {
		this((byte) 0, i.getByte0());
	}

	public Int64(Int8 i) {
		this((byte) (i.getByte0() < 0 ? 0xff : 0), i.getByte0());
	}

	private Int64(byte sign, byte b1, byte b0) {
		super(sign, sign, sign, sign, sign, sign, b1, b0);
	}

	public Int64(UInt16 i) {
		this((byte) 0, i.getByte1(), i.getByte0());
	}

	public Int64(Int16 i) {
		this((byte) (i.getByte1() < 0 ? 0xff : 0), i.getByte1(), i.getByte0());
	}

	private Int64(byte sign, byte b3, byte b2, byte b1, byte b0) {
		super(sign, sign, sign, sign, b3, b2, b1, b0);
	}

	public Int64(UInt32 i) {
		this((byte) 0, i.getByte3(), i.getByte2(), i.getByte1(), i.getByte0());
	}

	public Int64(Int32 i) {
		this((byte) (i.getByte3() < 0 ? 0xff : 0), i.getByte3(), i.getByte2(), i.getByte1(), i.getByte0());
	}

	public BigInteger toBigInteger() {
		return new BigInteger(toByteArray(Endianness.BIG));
	}

	public long toLong() {
		return toBigInteger().longValue();
	}

}
