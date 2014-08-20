// Generated, do not edit by hand
package org.whitehole.infra.types;
import java.math.BigInteger;

public class Int32 extends ByteArray4 {
    public static final Int32 ZERO = new Int32();
    public static final Int32 ONE = new Int32((byte) 0, (byte) 0, (byte) 0, (byte) 1);
    public Int32(byte b3, byte b2, byte b1, byte b0) {
        super(b3, b2, b1, b0);
    }
    
    public Int32() {
    }
    
    public Int32(ByteArray4 i) {
        super(i);
    }
    
    private Int32(byte sign, byte b0) {
        super(sign, sign, sign, b0);
    }
    
    public Int32(UInt8 i) {
        this((byte) 0, i.getByte0());
    }
    
    public Int32(Int8 i) {
        this((byte) (i.getByte0() < 0 ? 0xff : 0), i.getByte0());
    }
    
    private Int32(byte sign, byte b1, byte b0) {
        super(sign, sign, b1, b0);
    }
    
    public Int32(UInt16 i) {
        this((byte) 0, i.getByte1(), i.getByte0());
    }
    
    public Int32(Int16 i) {
        this((byte) (i.getByte1() < 0 ? 0xff : 0), i.getByte1(), i.getByte0());
    }
    
    public BigInteger toBigInteger() {
        return new BigInteger(toByteArray(Endianness.BIG));
    }
    
    public long toLong() {
        return toBigInteger().longValue();
    }
    
    public long toInt() {
        return toBigInteger().intValue();
    }
    
}
