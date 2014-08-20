// Generated, do not edit by hand
package org.whitehole.infra.types;
import java.math.BigInteger;

public class Int8 extends ByteArray1 {
    public static final Int8 ZERO = new Int8();
    public static final Int8 ONE = new Int8((byte) 1);
    public Int8(byte b0) {
        super(b0);
    }
    
    public Int8() {
    }
    
    public Int8(ByteArray1 i) {
        super(i);
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
