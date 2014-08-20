// Generated, do not edit by hand
package org.whitehole.binary.pe;
import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.StringAsciiz;

public class HintName {
    public static HintName read(LargeByteBuffer buffer, long offset) {
        return read(buffer, offset, new HintName());
    }
    
    public static HintName read(LargeByteBuffer buffer, long offset, HintName x) {
        x.setHint(LittleEndianReader.readUInt16(buffer, offset));
        x.setName(StringAsciiz.read(buffer, offset + 2));
        return x;
    }
    
    public UInt16 getHint() {
        return _hint;
    }
    
    public HintName setHint(UInt16 x) {
        _hint = x;
        return this;
    }
    
    public String getName() {
        return _name;
    }
    
    public HintName setName(String x) {
        _name = x;
        return this;
    }
    
    public int byteSize() {
        return 2 + StringAsciiz.byteSize(_name);
    }
    
    private UInt16 _hint;
    private String _name;
}
