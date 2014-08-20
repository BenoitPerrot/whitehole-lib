// Generated, do not edit by hand
package org.whitehole.binary.pe;
import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt32;

public class COFFHeader {
    public static COFFHeader read(LargeByteBuffer buffer, long offset) {
        return read(buffer, offset, new COFFHeader());
    }
    
    public static COFFHeader read(LargeByteBuffer buffer, long offset, COFFHeader x) {
        x.setMachine(MachineType.read(buffer, offset));
        x.setNumberOfSections(LittleEndianReader.readUInt16(buffer, offset + 2));
        x.setTimeDateStamp(LittleEndianReader.readUInt32(buffer, offset + 4));
        x.setPointerToSymbolTable(LittleEndianReader.readUInt32(buffer, offset + 8));
        x.setNumberOfSymbols(LittleEndianReader.readUInt32(buffer, offset + 12));
        x.setSizeOfOptionalHeader(LittleEndianReader.readUInt16(buffer, offset + 16));
        x.setCharacteristics(Characteristics.read(buffer, offset + 18));
        return x;
    }
    
    public MachineType getMachine() {
        return _machine;
    }
    
    public COFFHeader setMachine(MachineType x) {
        _machine = x;
        return this;
    }
    
    public UInt16 getNumberOfSections() {
        return _numberOfSections;
    }
    
    public COFFHeader setNumberOfSections(UInt16 x) {
        _numberOfSections = x;
        return this;
    }
    
    public UInt32 getTimeDateStamp() {
        return _timeDateStamp;
    }
    
    public COFFHeader setTimeDateStamp(UInt32 x) {
        _timeDateStamp = x;
        return this;
    }
    
    public UInt32 getPointerToSymbolTable() {
        return _pointerToSymbolTable;
    }
    
    public COFFHeader setPointerToSymbolTable(UInt32 x) {
        _pointerToSymbolTable = x;
        return this;
    }
    
    public UInt32 getNumberOfSymbols() {
        return _numberOfSymbols;
    }
    
    public COFFHeader setNumberOfSymbols(UInt32 x) {
        _numberOfSymbols = x;
        return this;
    }
    
    public UInt16 getSizeOfOptionalHeader() {
        return _sizeOfOptionalHeader;
    }
    
    public COFFHeader setSizeOfOptionalHeader(UInt16 x) {
        _sizeOfOptionalHeader = x;
        return this;
    }
    
    public Characteristics getCharacteristics() {
        return _characteristics;
    }
    
    public COFFHeader setCharacteristics(Characteristics x) {
        _characteristics = x;
        return this;
    }
    
    public static final int byteSize = 16 + MachineType.byteSize + Characteristics.byteSize;
    private MachineType _machine;
    private UInt16 _numberOfSections;
    private UInt32 _timeDateStamp;
    private UInt32 _pointerToSymbolTable;
    private UInt32 _numberOfSymbols;
    private UInt16 _sizeOfOptionalHeader;
    private Characteristics _characteristics;
}
