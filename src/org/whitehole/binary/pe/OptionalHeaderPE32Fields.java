// Generated, do not edit by hand
package org.whitehole.binary.pe;
import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt16;

public class OptionalHeaderPE32Fields extends WindowsSpecificPEFields {
    public static OptionalHeaderPE32Fields read(LargeByteBuffer buffer, long offset) {
        return read(buffer, offset, new OptionalHeaderPE32Fields());
    }
    
    public static OptionalHeaderPE32Fields read(LargeByteBuffer buffer, long offset, OptionalHeaderPE32Fields x) {
        x.setBaseOfData(LittleEndianReader.readUInt32(buffer, offset));
        x.setImageBase(LittleEndianReader.readUInt32(buffer, offset + 4));
        x.setSectionAlignment(LittleEndianReader.readUInt32(buffer, offset + 8));
        x.setFileAlignment(LittleEndianReader.readUInt32(buffer, offset + 12));
        x.setMajorOperatingSystemVersion(LittleEndianReader.readUInt16(buffer, offset + 16));
        x.setMinorOperatingSystemVersion(LittleEndianReader.readUInt16(buffer, offset + 18));
        x.setMajorImageVersion(LittleEndianReader.readUInt16(buffer, offset + 20));
        x.setMinorImageVersion(LittleEndianReader.readUInt16(buffer, offset + 22));
        x.setMajorSubsystemVersion(LittleEndianReader.readUInt16(buffer, offset + 24));
        x.setMinorSubsystemVersion(LittleEndianReader.readUInt16(buffer, offset + 26));
        x.setWin32VersionValue(LittleEndianReader.readUInt32(buffer, offset + 28));
        x.setSizeOfImage(LittleEndianReader.readUInt32(buffer, offset + 32));
        x.setSizeOfHeaders(LittleEndianReader.readUInt32(buffer, offset + 36));
        x.setChecksum(LittleEndianReader.readUInt32(buffer, offset + 40));
        x.setSubsystem(WindowsSubsystem.read(buffer, offset + 44));
        x.setDllCharacteristics(DllCharacteristics.read(buffer, offset + 46));
        x.setSizeOfStackReserve(LittleEndianReader.readUInt32(buffer, offset + 48));
        x.setSizeOfStackCommit(LittleEndianReader.readUInt32(buffer, offset + 52));
        x.setSizeOfHeapReserve(LittleEndianReader.readUInt32(buffer, offset + 56));
        x.setSizeOfHeapCommit(LittleEndianReader.readUInt32(buffer, offset + 60));
        x.setLoaderFlags(LittleEndianReader.readUInt32(buffer, offset + 64));
        x.setNumberOfRvaAndSize(LittleEndianReader.readUInt32(buffer, offset + 68));
        return x;
    }
    
    public UInt32 getBaseOfData() {
        return _baseOfData;
    }
    
    public OptionalHeaderPE32Fields setBaseOfData(UInt32 x) {
        _baseOfData = x;
        return this;
    }
    
    public UInt32 getImageBase() {
        return _imageBase;
    }
    
    public OptionalHeaderPE32Fields setImageBase(UInt32 x) {
        _imageBase = x;
        return this;
    }
    
    public UInt32 getSectionAlignment() {
        return _sectionAlignment;
    }
    
    public OptionalHeaderPE32Fields setSectionAlignment(UInt32 x) {
        _sectionAlignment = x;
        return this;
    }
    
    public UInt32 getFileAlignment() {
        return _fileAlignment;
    }
    
    public OptionalHeaderPE32Fields setFileAlignment(UInt32 x) {
        _fileAlignment = x;
        return this;
    }
    
    public UInt16 getMajorOperatingSystemVersion() {
        return _majorOperatingSystemVersion;
    }
    
    public OptionalHeaderPE32Fields setMajorOperatingSystemVersion(UInt16 x) {
        _majorOperatingSystemVersion = x;
        return this;
    }
    
    public UInt16 getMinorOperatingSystemVersion() {
        return _minorOperatingSystemVersion;
    }
    
    public OptionalHeaderPE32Fields setMinorOperatingSystemVersion(UInt16 x) {
        _minorOperatingSystemVersion = x;
        return this;
    }
    
    public UInt16 getMajorImageVersion() {
        return _majorImageVersion;
    }
    
    public OptionalHeaderPE32Fields setMajorImageVersion(UInt16 x) {
        _majorImageVersion = x;
        return this;
    }
    
    public UInt16 getMinorImageVersion() {
        return _minorImageVersion;
    }
    
    public OptionalHeaderPE32Fields setMinorImageVersion(UInt16 x) {
        _minorImageVersion = x;
        return this;
    }
    
    public UInt16 getMajorSubsystemVersion() {
        return _majorSubsystemVersion;
    }
    
    public OptionalHeaderPE32Fields setMajorSubsystemVersion(UInt16 x) {
        _majorSubsystemVersion = x;
        return this;
    }
    
    public UInt16 getMinorSubsystemVersion() {
        return _minorSubsystemVersion;
    }
    
    public OptionalHeaderPE32Fields setMinorSubsystemVersion(UInt16 x) {
        _minorSubsystemVersion = x;
        return this;
    }
    
    public UInt32 getWin32VersionValue() {
        return _win32VersionValue;
    }
    
    public OptionalHeaderPE32Fields setWin32VersionValue(UInt32 x) {
        _win32VersionValue = x;
        return this;
    }
    
    public UInt32 getSizeOfImage() {
        return _sizeOfImage;
    }
    
    public OptionalHeaderPE32Fields setSizeOfImage(UInt32 x) {
        _sizeOfImage = x;
        return this;
    }
    
    public UInt32 getSizeOfHeaders() {
        return _sizeOfHeaders;
    }
    
    public OptionalHeaderPE32Fields setSizeOfHeaders(UInt32 x) {
        _sizeOfHeaders = x;
        return this;
    }
    
    public UInt32 getChecksum() {
        return _checksum;
    }
    
    public OptionalHeaderPE32Fields setChecksum(UInt32 x) {
        _checksum = x;
        return this;
    }
    
    public WindowsSubsystem getSubsystem() {
        return _subsystem;
    }
    
    public OptionalHeaderPE32Fields setSubsystem(WindowsSubsystem x) {
        _subsystem = x;
        return this;
    }
    
    public DllCharacteristics getDllCharacteristics() {
        return _dllCharacteristics;
    }
    
    public OptionalHeaderPE32Fields setDllCharacteristics(DllCharacteristics x) {
        _dllCharacteristics = x;
        return this;
    }
    
    public UInt32 getSizeOfStackReserve() {
        return _sizeOfStackReserve;
    }
    
    public OptionalHeaderPE32Fields setSizeOfStackReserve(UInt32 x) {
        _sizeOfStackReserve = x;
        return this;
    }
    
    public UInt32 getSizeOfStackCommit() {
        return _sizeOfStackCommit;
    }
    
    public OptionalHeaderPE32Fields setSizeOfStackCommit(UInt32 x) {
        _sizeOfStackCommit = x;
        return this;
    }
    
    public UInt32 getSizeOfHeapReserve() {
        return _sizeOfHeapReserve;
    }
    
    public OptionalHeaderPE32Fields setSizeOfHeapReserve(UInt32 x) {
        _sizeOfHeapReserve = x;
        return this;
    }
    
    public UInt32 getSizeOfHeapCommit() {
        return _sizeOfHeapCommit;
    }
    
    public OptionalHeaderPE32Fields setSizeOfHeapCommit(UInt32 x) {
        _sizeOfHeapCommit = x;
        return this;
    }
    
    public UInt32 getLoaderFlags() {
        return _loaderFlags;
    }
    
    public OptionalHeaderPE32Fields setLoaderFlags(UInt32 x) {
        _loaderFlags = x;
        return this;
    }
    
    public UInt32 getNumberOfRvaAndSize() {
        return _numberOfRvaAndSize;
    }
    
    public OptionalHeaderPE32Fields setNumberOfRvaAndSize(UInt32 x) {
        _numberOfRvaAndSize = x;
        return this;
    }
    
    public static final int byteSize = 68 + WindowsSubsystem.byteSize + DllCharacteristics.byteSize;
    private UInt32 _baseOfData;
    private UInt32 _imageBase;
    private UInt32 _sectionAlignment;
    private UInt32 _fileAlignment;
    private UInt16 _majorOperatingSystemVersion;
    private UInt16 _minorOperatingSystemVersion;
    private UInt16 _majorImageVersion;
    private UInt16 _minorImageVersion;
    private UInt16 _majorSubsystemVersion;
    private UInt16 _minorSubsystemVersion;
    private UInt32 _win32VersionValue;
    private UInt32 _sizeOfImage;
    private UInt32 _sizeOfHeaders;
    private UInt32 _checksum;
    private WindowsSubsystem _subsystem;
    private DllCharacteristics _dllCharacteristics;
    private UInt32 _sizeOfStackReserve;
    private UInt32 _sizeOfStackCommit;
    private UInt32 _sizeOfHeapReserve;
    private UInt32 _sizeOfHeapCommit;
    private UInt32 _loaderFlags;
    private UInt32 _numberOfRvaAndSize;
}
