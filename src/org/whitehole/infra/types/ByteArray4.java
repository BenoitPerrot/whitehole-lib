// Generated, do not edit by hand
package org.whitehole.infra.types;

public class ByteArray4 {
    public ByteArray4(byte b3, byte b2, byte b1, byte b0) {
        _b0 = b0;
        _b1 = b1;
        _b2 = b2;
        _b3 = b3;
    }
    
    public ByteArray4() {
        _b0 = 0;
        _b1 = 0;
        _b2 = 0;
        _b3 = 0;
    }
    
    public ByteArray4(ByteArray1 a) {
        _b3 = 0;
        _b2 = 0;
        _b1 = 0;
        _b0 = a._b0;
    }
    
    public ByteArray4(ByteArray2 a) {
        _b3 = 0;
        _b2 = 0;
        _b1 = a._b1;
        _b0 = a._b0;
    }
    
    public ByteArray4(ByteArray4 a) {
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
        throw new IllegalArgumentException();
    }
    
    public byte[] toByteArray(Endianness e) {
        if (e == Endianness.BIG) {
            return new byte[] { _b3, _b2, _b1, _b0 };
        }
        else {
            return new byte[] { _b0, _b1, _b2, _b3 };
        }
    }
    
    public String toHexString() {
        return toHexString(false);
    }
    
    public String toHexString(boolean printLeadingZero) {
        String s = "";
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
    
    public boolean equals(ByteArray4 rhs) {
        return _b0 == rhs._b0 && _b1 == rhs._b1 && _b2 == rhs._b2 && _b3 == rhs._b3;
    }
    
    final byte _b3;
    final byte _b2;
    final byte _b1;
    final byte _b0;
}
