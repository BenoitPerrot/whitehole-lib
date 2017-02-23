// Generated, do not edit by hand
package org.whitehole.infra.types;

public class ByteArray8 {

	public ByteArray8(byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		_b0 = b0;
		_b1 = b1;
		_b2 = b2;
		_b3 = b3;
		_b4 = b4;
		_b5 = b5;
		_b6 = b6;
		_b7 = b7;
	}

	public ByteArray8() {
		_b0 = 0;
		_b1 = 0;
		_b2 = 0;
		_b3 = 0;
		_b4 = 0;
		_b5 = 0;
		_b6 = 0;
		_b7 = 0;
	}

	public ByteArray8(ByteArray1 a) {
		_b7 = 0;
		_b6 = 0;
		_b5 = 0;
		_b4 = 0;
		_b3 = 0;
		_b2 = 0;
		_b1 = 0;
		_b0 = a._b0;
	}

	public ByteArray8(ByteArray2 a) {
		_b7 = 0;
		_b6 = 0;
		_b5 = 0;
		_b4 = 0;
		_b3 = 0;
		_b2 = 0;
		_b1 = a._b1;
		_b0 = a._b0;
	}

	public ByteArray8(ByteArray4 a) {
		_b7 = 0;
		_b6 = 0;
		_b5 = 0;
		_b4 = 0;
		_b3 = a._b3;
		_b2 = a._b2;
		_b1 = a._b1;
		_b0 = a._b0;
	}

	public ByteArray8(ByteArray8 a) {
		_b7 = a._b7;
		_b6 = a._b6;
		_b5 = a._b5;
		_b4 = a._b4;
		_b3 = a._b3;
		_b2 = a._b2;
		_b1 = a._b1;
		_b0 = a._b0;
	}

	public byte getByte0() {
		return _b0;
	}

	public byte getByte1() {
		return _b1;
	}

	public byte getByte2() {
		return _b2;
	}

	public byte getByte3() {
		return _b3;
	}

	public byte getByte4() {
		return _b4;
	}

	public byte getByte5() {
		return _b5;
	}

	public byte getByte6() {
		return _b6;
	}

	public byte getByte7() {
		return _b7;
	}

	public boolean testBit(int b) {
		if (0 <= b && b < 8) {
			return (_b0 & (0x01 << (b - 0))) != 0;
		}
		if (8 <= b && b < 16) {
			return (_b1 & (0x01 << (b - 8))) != 0;
		}
		if (16 <= b && b < 24) {
			return (_b2 & (0x01 << (b - 16))) != 0;
		}
		if (24 <= b && b < 32) {
			return (_b3 & (0x01 << (b - 24))) != 0;
		}
		if (32 <= b && b < 40) {
			return (_b4 & (0x01 << (b - 32))) != 0;
		}
		if (40 <= b && b < 48) {
			return (_b5 & (0x01 << (b - 40))) != 0;
		}
		if (48 <= b && b < 56) {
			return (_b6 & (0x01 << (b - 48))) != 0;
		}
		if (56 <= b && b < 64) {
			return (_b7 & (0x01 << (b - 56))) != 0;
		}
		throw new IllegalArgumentException();
	}

	public byte[] toByteArray(Endianness e) {
		if (e == Endianness.BIG) {
			return new byte[] { _b7, _b6, _b5, _b4, _b3, _b2, _b1, _b0 };
		}
		else {
			return new byte[] { _b0, _b1, _b2, _b3, _b4, _b5, _b6, _b7 };
		}
	}

	public String toHexString() {
		return toHexString(false);
	}

	public String toHexString(boolean printLeadingZero) {
		String s = "";
		if (getByte7() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte7(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte6() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte6(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte5() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte5(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte4() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte4(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte3() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte3(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte2() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte2(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte1() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte1(), printLeadingZero);
			printLeadingZero = true;
		}
		return s + ByteArray1.toHexString(getByte0(), printLeadingZero);
	}

	public boolean equals(ByteArray8 rhs) {
		return _b0 == rhs._b0 && _b1 == rhs._b1 && _b2 == rhs._b2 && _b3 == rhs._b3 && _b4 == rhs._b4 && _b5 == rhs._b5 && _b6 == rhs._b6 && _b7 == rhs._b7;
	}

	final byte _b7;
	final byte _b6;
	final byte _b5;
	final byte _b4;
	final byte _b3;
	final byte _b2;
	final byte _b1;
	final byte _b0;
}
