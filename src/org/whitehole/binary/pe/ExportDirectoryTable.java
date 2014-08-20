// Generated, do not edit by hand
package org.whitehole.binary.pe;
import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt16;

public class ExportDirectoryTable {
    public static ExportDirectoryTable read(LargeByteBuffer buffer, long offset) {
        return read(buffer, offset, new ExportDirectoryTable());
    }
    
    public static ExportDirectoryTable read(LargeByteBuffer buffer, long offset, ExportDirectoryTable x) {
        x.setExportFlags(LittleEndianReader.readUInt32(buffer, offset));
        x.setTimeDateStamp(LittleEndianReader.readUInt32(buffer, offset + 4));
        x.setMajorVersion(LittleEndianReader.readUInt16(buffer, offset + 8));
        x.setMinorVersion(LittleEndianReader.readUInt16(buffer, offset + 10));
        x.setNameRva(LittleEndianReader.readUInt32(buffer, offset + 12));
        x.setOrdinalBase(LittleEndianReader.readUInt32(buffer, offset + 16));
        x.setAddressTableEntries(LittleEndianReader.readUInt32(buffer, offset + 20));
        x.setNumberOfNamePointers(LittleEndianReader.readUInt32(buffer, offset + 24));
        x.setExportAddressTableRva(LittleEndianReader.readUInt32(buffer, offset + 28));
        x.setNamePointerRva(LittleEndianReader.readUInt32(buffer, offset + 32));
        x.setOrdinalTableRva(LittleEndianReader.readUInt32(buffer, offset + 36));
        return x;
    }
    
    public UInt32 getExportFlags() {
        return _exportFlags;
    }
    
    public ExportDirectoryTable setExportFlags(UInt32 x) {
        _exportFlags = x;
        return this;
    }
    
    public UInt32 getTimeDateStamp() {
        return _timeDateStamp;
    }
    
    public ExportDirectoryTable setTimeDateStamp(UInt32 x) {
        _timeDateStamp = x;
        return this;
    }
    
    public UInt16 getMajorVersion() {
        return _majorVersion;
    }
    
    public ExportDirectoryTable setMajorVersion(UInt16 x) {
        _majorVersion = x;
        return this;
    }
    
    public UInt16 getMinorVersion() {
        return _minorVersion;
    }
    
    public ExportDirectoryTable setMinorVersion(UInt16 x) {
        _minorVersion = x;
        return this;
    }
    
    public UInt32 getNameRva() {
        return _nameRva;
    }
    
    public ExportDirectoryTable setNameRva(UInt32 x) {
        _nameRva = x;
        return this;
    }
    
    public UInt32 getOrdinalBase() {
        return _ordinalBase;
    }
    
    public ExportDirectoryTable setOrdinalBase(UInt32 x) {
        _ordinalBase = x;
        return this;
    }
    
    public UInt32 getAddressTableEntries() {
        return _addressTableEntries;
    }
    
    public ExportDirectoryTable setAddressTableEntries(UInt32 x) {
        _addressTableEntries = x;
        return this;
    }
    
    public UInt32 getNumberOfNamePointers() {
        return _numberOfNamePointers;
    }
    
    public ExportDirectoryTable setNumberOfNamePointers(UInt32 x) {
        _numberOfNamePointers = x;
        return this;
    }
    
    public UInt32 getExportAddressTableRva() {
        return _exportAddressTableRva;
    }
    
    public ExportDirectoryTable setExportAddressTableRva(UInt32 x) {
        _exportAddressTableRva = x;
        return this;
    }
    
    public UInt32 getNamePointerRva() {
        return _namePointerRva;
    }
    
    public ExportDirectoryTable setNamePointerRva(UInt32 x) {
        _namePointerRva = x;
        return this;
    }
    
    public UInt32 getOrdinalTableRva() {
        return _ordinalTableRva;
    }
    
    public ExportDirectoryTable setOrdinalTableRva(UInt32 x) {
        _ordinalTableRva = x;
        return this;
    }
    
    public static final int byteSize = 40;
    private UInt32 _exportFlags;
    private UInt32 _timeDateStamp;
    private UInt16 _majorVersion;
    private UInt16 _minorVersion;
    private UInt32 _nameRva;
    private UInt32 _ordinalBase;
    private UInt32 _addressTableEntries;
    private UInt32 _numberOfNamePointers;
    private UInt32 _exportAddressTableRva;
    private UInt32 _namePointerRva;
    private UInt32 _ordinalTableRva;
}
