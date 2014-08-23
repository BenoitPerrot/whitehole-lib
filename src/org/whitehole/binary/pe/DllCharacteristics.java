// Generated, do not edit by hand
package org.whitehole.binary.pe;
import org.whitehole.infra.types.ByteArray2;
import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;

public class DllCharacteristics {
    public DllCharacteristics(ByteArray2 code) {
        _code = code;
    }
    
    public DllCharacteristics() {
        this(new ByteArray2());
    }
    
    public static DllCharacteristics read(LargeByteBuffer buffer, long offset) {
        return new DllCharacteristics(LittleEndianReader.readByteArray2(buffer, offset));
    }
    
    public boolean getReserved1() {
        return _code.testBit(0);
    }
    
    public boolean getReserved2() {
        return _code.testBit(1);
    }
    
    public boolean getReserved3() {
        return _code.testBit(2);
    }
    
    public boolean getReserved4() {
        return _code.testBit(3);
    }
    
    public boolean getDynamicBase() {
        return _code.testBit(6);
    }
    
    public boolean getForceIntegrity() {
        return _code.testBit(7);
    }
    
    public boolean getNxCompat() {
        return _code.testBit(8);
    }
    
    public boolean getNoIsolation() {
        return _code.testBit(9);
    }
    
    public boolean getNoSeh() {
        return _code.testBit(10);
    }
    
    public boolean getNoBind() {
        return _code.testBit(11);
    }
    
    public boolean getReserved5() {
        return _code.testBit(12);
    }
    
    public boolean getWdmDriver() {
        return _code.testBit(13);
    }
    
    public boolean getTerminalServerAware() {
        return _code.testBit(15);
    }
    
    public String toHexString(boolean printLeadingZero) {
        return _code.toHexString(printLeadingZero);
    }
    
    static public final int byteSize = 2;
    private final ByteArray2 _code;
}
