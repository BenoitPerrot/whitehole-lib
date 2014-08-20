// Generated, do not edit by hand
package org.whitehole.infra.types;

public class ByteArray2 {
    public ByteArray2(byte b1, byte b0) {
        _b0 = b0;
        _b1 = b1;
    }
    
    public ByteArray2() {
        _b0 = 0;
        _b1 = 0;
    }
    
    public ByteArray2(ByteArray1 a) {
        _b1 = 0;
        _b0 = a._b0;
    }
    
    public ByteArray2(ByteArray2 a) {
        _b1 = a._b1;
        _b0 = a._b0;
    }
    
    public byte getByte0() {
        return _b0;
    }
    
    public byte getByte1() {
        return _b1;
    }
    
    public boolean testBit(int b) {
        if (0 <= b && b < 8) {
            return (_b0 & (0x01 << (b - 0))) != 0;
        }
        if (8 <= b && b < 16) {
            return (_b1 & (0x01 << (b - 8))) != 0;
        }
        throw new IllegalArgumentException();
    }
    
    public byte[] toByteArray(Endianness e) {
        if (e == Endianness.BIG) {
            return new byte[] { _b1, _b0 };
        }
        else {
            return new byte[] { _b0, _b1 };
        }
    }
    
    public String toHexString() {
        return toHexString(false);
    }
    
    public String toHexString(boolean printLeadingZero) {
        String s = "";
        if (getByte1() != 0 || printLeadingZero) {
            s += ByteArray1.toHexString(getByte1(), printLeadingZero);
            printLeadingZero = true;
        }
        return s + ByteArray1.toHexString(getByte0(), printLeadingZero);
    }
    
    public boolean equals(ByteArray2 rhs) {
        return _b0 == rhs._b0 && _b1 == rhs._b1;
    }
    
    final byte _b1;
    final byte _b0;
}
