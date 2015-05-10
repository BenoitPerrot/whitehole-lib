// Generated, do not edit by hand
package org.whitehole.infra.types;

public class ByteArray16 {

	public ByteArray16(byte b15, byte b14, byte b13, byte b12, byte b11, byte b10, byte b9, byte b8, byte b7, byte b6, byte b5, byte b4, byte b3, byte b2, byte b1, byte b0) {
		_b0 = b0;
		_b1 = b1;
		_b2 = b2;
		_b3 = b3;
		_b4 = b4;
		_b5 = b5;
		_b6 = b6;
		_b7 = b7;
		_b8 = b8;
		_b9 = b9;
		_b10 = b10;
		_b11 = b11;
		_b12 = b12;
		_b13 = b13;
		_b14 = b14;
		_b15 = b15;
	}

	public ByteArray16() {
		_b0 = 0;
		_b1 = 0;
		_b2 = 0;
		_b3 = 0;
		_b4 = 0;
		_b5 = 0;
		_b6 = 0;
		_b7 = 0;
		_b8 = 0;
		_b9 = 0;
		_b10 = 0;
		_b11 = 0;
		_b12 = 0;
		_b13 = 0;
		_b14 = 0;
		_b15 = 0;
	}

	public ByteArray16(ByteArray1 a) {
		_b15 = 0;
		_b14 = 0;
		_b13 = 0;
		_b12 = 0;
		_b11 = 0;
		_b10 = 0;
		_b9 = 0;
		_b8 = 0;
		_b7 = 0;
		_b6 = 0;
		_b5 = 0;
		_b4 = 0;
		_b3 = 0;
		_b2 = 0;
		_b1 = 0;
		_b0 = a._b0;
	}

	public ByteArray16(ByteArray2 a) {
		_b15 = 0;
		_b14 = 0;
		_b13 = 0;
		_b12 = 0;
		_b11 = 0;
		_b10 = 0;
		_b9 = 0;
		_b8 = 0;
		_b7 = 0;
		_b6 = 0;
		_b5 = 0;
		_b4 = 0;
		_b3 = 0;
		_b2 = 0;
		_b1 = a._b1;
		_b0 = a._b0;
	}

	public ByteArray16(ByteArray4 a) {
		_b15 = 0;
		_b14 = 0;
		_b13 = 0;
		_b12 = 0;
		_b11 = 0;
		_b10 = 0;
		_b9 = 0;
		_b8 = 0;
		_b7 = 0;
		_b6 = 0;
		_b5 = 0;
		_b4 = 0;
		_b3 = a._b3;
		_b2 = a._b2;
		_b1 = a._b1;
		_b0 = a._b0;
	}

	public ByteArray16(ByteArray8 a) {
		_b15 = 0;
		_b14 = 0;
		_b13 = 0;
		_b12 = 0;
		_b11 = 0;
		_b10 = 0;
		_b9 = 0;
		_b8 = 0;
		_b7 = a._b7;
		_b6 = a._b6;
		_b5 = a._b5;
		_b4 = a._b4;
		_b3 = a._b3;
		_b2 = a._b2;
		_b1 = a._b1;
		_b0 = a._b0;
	}

	public ByteArray16(ByteArray16 a) {
		_b15 = a._b15;
		_b14 = a._b14;
		_b13 = a._b13;
		_b12 = a._b12;
		_b11 = a._b11;
		_b10 = a._b10;
		_b9 = a._b9;
		_b8 = a._b8;
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

	public byte getByte8() {
		return _b8;
	}

	public byte getByte9() {
		return _b9;
	}

	public byte getByte10() {
		return _b10;
	}

	public byte getByte11() {
		return _b11;
	}

	public byte getByte12() {
		return _b12;
	}

	public byte getByte13() {
		return _b13;
	}

	public byte getByte14() {
		return _b14;
	}

	public byte getByte15() {
		return _b15;
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
		if (64 <= b && b < 72) {
			return (_b8 & (0x01 << (b - 64))) != 0;
		}
		if (72 <= b && b < 80) {
			return (_b9 & (0x01 << (b - 72))) != 0;
		}
		if (80 <= b && b < 88) {
			return (_b10 & (0x01 << (b - 80))) != 0;
		}
		if (88 <= b && b < 96) {
			return (_b11 & (0x01 << (b - 88))) != 0;
		}
		if (96 <= b && b < 104) {
			return (_b12 & (0x01 << (b - 96))) != 0;
		}
		if (104 <= b && b < 112) {
			return (_b13 & (0x01 << (b - 104))) != 0;
		}
		if (112 <= b && b < 120) {
			return (_b14 & (0x01 << (b - 112))) != 0;
		}
		if (120 <= b && b < 128) {
			return (_b15 & (0x01 << (b - 120))) != 0;
		}
		throw new IllegalArgumentException();
	}

	public byte[] toByteArray(Endianness e) {
		if (e == Endianness.BIG) {
			return new byte[] { _b15, _b14, _b13, _b12, _b11, _b10, _b9, _b8, _b7, _b6, _b5, _b4, _b3, _b2, _b1, _b0 };
		}
		else {
			return new byte[] { _b0, _b1, _b2, _b3, _b4, _b5, _b6, _b7, _b8, _b9, _b10, _b11, _b12, _b13, _b14, _b15 };
		}
	}

	public String toHexString() {
		return toHexString(false);
	}

	public String toHexString(boolean printLeadingZero) {
		String s = "";
		if (getByte15() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte15(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte14() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte14(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte13() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte13(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte12() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte12(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte11() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte11(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte10() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte10(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte9() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte9(), printLeadingZero);
			printLeadingZero = true;
		}
		if (getByte8() != 0 || printLeadingZero) {
			s += ByteArray1.toHexString(getByte8(), printLeadingZero);
			printLeadingZero = true;
		}
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

	public boolean equals(ByteArray16 rhs) {
		return _b0 == rhs._b0 && _b1 == rhs._b1 && _b2 == rhs._b2 && _b3 == rhs._b3 && _b4 == rhs._b4 && _b5 == rhs._b5 && _b6 == rhs._b6 && _b7 == rhs._b7 && _b8 == rhs._b8 && _b9 == rhs._b9
				&& _b10 == rhs._b10 && _b11 == rhs._b11 && _b12 == rhs._b12 && _b13 == rhs._b13 && _b14 == rhs._b14 && _b15 == rhs._b15;
	}

	final byte _b15;
	final byte _b14;
	final byte _b13;
	final byte _b12;
	final byte _b11;
	final byte _b10;
	final byte _b9;
	final byte _b8;
	final byte _b7;
	final byte _b6;
	final byte _b5;
	final byte _b4;
	final byte _b3;
	final byte _b2;
	final byte _b1;
	final byte _b0;
}
