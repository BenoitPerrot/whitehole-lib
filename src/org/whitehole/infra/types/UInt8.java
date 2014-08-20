// Generated, do not edit by hand
package org.whitehole.infra.types;
import java.math.BigInteger;

public class UInt8 extends ByteArray1 {
    public static final UInt8 ZERO = new UInt8();
    public static final UInt8 ONE = new UInt8((byte) 1);
    public UInt8(byte b0) {
        super(b0);
    }
    
    public UInt8() {
    }
    
    public UInt8(ByteArray1 i) {
        super(i);
    }
    
    public BigInteger toBigInteger() {
        return new BigInteger(new byte[] { 0, getByte0() });
    }
    
    public long toLong() {
        return toBigInteger().longValue();
    }
    
    public long toInt() {
        return toBigInteger().intValue();
    }
    
}
