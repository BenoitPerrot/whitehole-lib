// Generated, do not edit by hand
package org.whitehole.infra.types;
import java.math.BigInteger;

public class Int16 extends ByteArray2 {
    public static final Int16 ZERO = new Int16();
    public static final Int16 ONE = new Int16((byte) 0, (byte) 1);
    public Int16(byte b1, byte b0) {
        super(b1, b0);
    }
    
    public Int16() {
    }
    
    public Int16(ByteArray2 i) {
        super(i);
    }
    
    public Int16(UInt8 i) {
        this((byte) 0, i.getByte0());
    }
    
    public Int16(Int8 i) {
        this((byte) (i.getByte0() < 0 ? 0xff : 0), i.getByte0());
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
