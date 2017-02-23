// Generated, do not edit by hand
package org.whitehole.infra.types;

public class ByteArray1 {

	public ByteArray1(byte b0) {
		_b0 = b0;
	}

	public ByteArray1() {
		_b0 = 0;
	}

	public ByteArray1(ByteArray1 a) {
		_b0 = a._b0;
	}

	public byte getByte0() {
		return _b0;
	}

	public boolean testBit(int b) {
		if (0 <= b && b < 8) {
			return (_b0 & (0x01 << (b - 0))) != 0;
		}
		throw new IllegalArgumentException();
	}

	public byte[] toByteArray(Endianness e) {
		if (e == Endianness.BIG) {
			return new byte[] { _b0 };
		}
		else {
			return new byte[] { _b0 };
		}
	}

	public String toHexString() {
		return toHexString(false);
	}

	public String toHexString(boolean printLeadingZero) {
		return toHexString(getByte0(), false);
	}

	static String toHexString(byte b, boolean printLeadingZero) {
		int i = b & 0xff;
		if (printLeadingZero && i <= 0xf) {
			return "0" + Integer.toHexString(i);
		}
		else {
			return Integer.toHexString(i);
		}
	}

	public boolean equals(ByteArray1 rhs) {
		return _b0 == rhs._b0;
	}

	final byte _b0;
}
