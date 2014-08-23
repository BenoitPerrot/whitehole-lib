// Generated, do not edit by hand
package org.whitehole.binary.pe;
import org.whitehole.infra.types.ByteArray2;
import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;

public class Characteristics {
    public Characteristics(ByteArray2 code) {
        _code = code;
    }
    
    public Characteristics() {
        this(new ByteArray2());
    }
    
    public static Characteristics read(LargeByteBuffer buffer, long offset) {
        return new Characteristics(LittleEndianReader.readByteArray2(buffer, offset));
    }
    
    public boolean getRelocsStripped() {
        return _code.testBit(0);
    }
    
    public boolean getExecutableImage() {
        return _code.testBit(1);
    }
    
    public boolean getLineNumsStripped() {
        return _code.testBit(2);
    }
    
    public boolean getLocalSymsStripped() {
        return _code.testBit(3);
    }
    
    public boolean getAggressiveWsTrim() {
        return _code.testBit(4);
    }
    
    public boolean getLargeAddressAware() {
        return _code.testBit(5);
    }
    
    public boolean getReserved() {
        return _code.testBit(6);
    }
    
    public boolean getBytesReversedLo() {
        return _code.testBit(7);
    }
    
    public boolean get32bitMachine() {
        return _code.testBit(8);
    }
    
    public boolean getDebugStripped() {
        return _code.testBit(9);
    }
    
    public boolean getRemovableRunFromSwap() {
        return _code.testBit(10);
    }
    
    public boolean getNetRunFromSwap() {
        return _code.testBit(11);
    }
    
    public boolean getSystem() {
        return _code.testBit(12);
    }
    
    public boolean getDll() {
        return _code.testBit(13);
    }
    
    public boolean getUpSystemOnly() {
        return _code.testBit(14);
    }
    
    public boolean getBytesReversedHi() {
        return _code.testBit(15);
    }
    
    public String toHexString(boolean printLeadingZero) {
        return _code.toHexString(printLeadingZero);
    }
    
    static public final int byteSize = 2;
    private final ByteArray2 _code;
}
