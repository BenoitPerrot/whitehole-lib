// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.UInt64;

public class OptionalHeaderPE32xFields extends WindowsSpecificPEFields {

	public static OptionalHeaderPE32xFields read(LargeByteBuffer buffer, long offset) {
		return read(buffer, offset, new OptionalHeaderPE32xFields());
	}

	public static OptionalHeaderPE32xFields read(LargeByteBuffer buffer, long offset, OptionalHeaderPE32xFields x) {
		x.setImageBase(LittleEndianReader.readUInt64(buffer, offset));
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
		x.setSizeOfStackReserve(LittleEndianReader.readUInt64(buffer, offset + 48));
		x.setSizeOfStackCommit(LittleEndianReader.readUInt64(buffer, offset + 56));
		x.setSizeOfHeapReserve(LittleEndianReader.readUInt64(buffer, offset + 64));
		x.setSizeOfHeapCommit(LittleEndianReader.readUInt64(buffer, offset + 72));
		x.setLoaderFlags(LittleEndianReader.readUInt32(buffer, offset + 80));
		x.setNumberOfRvaAndSize(LittleEndianReader.readUInt32(buffer, offset + 84));
		return x;
	}

	public UInt64 getImageBase() {
		return _imageBase;
	}

	public OptionalHeaderPE32xFields setImageBase(UInt64 x) {
		_imageBase = x;
		return this;
	}

	public UInt32 getSectionAlignment() {
		return _sectionAlignment;
	}

	public OptionalHeaderPE32xFields setSectionAlignment(UInt32 x) {
		_sectionAlignment = x;
		return this;
	}

	public UInt32 getFileAlignment() {
		return _fileAlignment;
	}

	public OptionalHeaderPE32xFields setFileAlignment(UInt32 x) {
		_fileAlignment = x;
		return this;
	}

	public UInt16 getMajorOperatingSystemVersion() {
		return _majorOperatingSystemVersion;
	}

	public OptionalHeaderPE32xFields setMajorOperatingSystemVersion(UInt16 x) {
		_majorOperatingSystemVersion = x;
		return this;
	}

	public UInt16 getMinorOperatingSystemVersion() {
		return _minorOperatingSystemVersion;
	}

	public OptionalHeaderPE32xFields setMinorOperatingSystemVersion(UInt16 x) {
		_minorOperatingSystemVersion = x;
		return this;
	}

	public UInt16 getMajorImageVersion() {
		return _majorImageVersion;
	}

	public OptionalHeaderPE32xFields setMajorImageVersion(UInt16 x) {
		_majorImageVersion = x;
		return this;
	}

	public UInt16 getMinorImageVersion() {
		return _minorImageVersion;
	}

	public OptionalHeaderPE32xFields setMinorImageVersion(UInt16 x) {
		_minorImageVersion = x;
		return this;
	}

	public UInt16 getMajorSubsystemVersion() {
		return _majorSubsystemVersion;
	}

	public OptionalHeaderPE32xFields setMajorSubsystemVersion(UInt16 x) {
		_majorSubsystemVersion = x;
		return this;
	}

	public UInt16 getMinorSubsystemVersion() {
		return _minorSubsystemVersion;
	}

	public OptionalHeaderPE32xFields setMinorSubsystemVersion(UInt16 x) {
		_minorSubsystemVersion = x;
		return this;
	}

	public UInt32 getWin32VersionValue() {
		return _win32VersionValue;
	}

	public OptionalHeaderPE32xFields setWin32VersionValue(UInt32 x) {
		_win32VersionValue = x;
		return this;
	}

	public UInt32 getSizeOfImage() {
		return _sizeOfImage;
	}

	public OptionalHeaderPE32xFields setSizeOfImage(UInt32 x) {
		_sizeOfImage = x;
		return this;
	}

	public UInt32 getSizeOfHeaders() {
		return _sizeOfHeaders;
	}

	public OptionalHeaderPE32xFields setSizeOfHeaders(UInt32 x) {
		_sizeOfHeaders = x;
		return this;
	}

	public UInt32 getChecksum() {
		return _checksum;
	}

	public OptionalHeaderPE32xFields setChecksum(UInt32 x) {
		_checksum = x;
		return this;
	}

	public WindowsSubsystem getSubsystem() {
		return _subsystem;
	}

	public OptionalHeaderPE32xFields setSubsystem(WindowsSubsystem x) {
		_subsystem = x;
		return this;
	}

	public DllCharacteristics getDllCharacteristics() {
		return _dllCharacteristics;
	}

	public OptionalHeaderPE32xFields setDllCharacteristics(DllCharacteristics x) {
		_dllCharacteristics = x;
		return this;
	}

	public UInt64 getSizeOfStackReserve() {
		return _sizeOfStackReserve;
	}

	public OptionalHeaderPE32xFields setSizeOfStackReserve(UInt64 x) {
		_sizeOfStackReserve = x;
		return this;
	}

	public UInt64 getSizeOfStackCommit() {
		return _sizeOfStackCommit;
	}

	public OptionalHeaderPE32xFields setSizeOfStackCommit(UInt64 x) {
		_sizeOfStackCommit = x;
		return this;
	}

	public UInt64 getSizeOfHeapReserve() {
		return _sizeOfHeapReserve;
	}

	public OptionalHeaderPE32xFields setSizeOfHeapReserve(UInt64 x) {
		_sizeOfHeapReserve = x;
		return this;
	}

	public UInt64 getSizeOfHeapCommit() {
		return _sizeOfHeapCommit;
	}

	public OptionalHeaderPE32xFields setSizeOfHeapCommit(UInt64 x) {
		_sizeOfHeapCommit = x;
		return this;
	}

	public UInt32 getLoaderFlags() {
		return _loaderFlags;
	}

	public OptionalHeaderPE32xFields setLoaderFlags(UInt32 x) {
		_loaderFlags = x;
		return this;
	}

	public UInt32 getNumberOfRvaAndSize() {
		return _numberOfRvaAndSize;
	}

	public OptionalHeaderPE32xFields setNumberOfRvaAndSize(UInt32 x) {
		_numberOfRvaAndSize = x;
		return this;
	}

	public static final int byteSize = 84 + WindowsSubsystem.byteSize + DllCharacteristics.byteSize;
	private UInt64 _imageBase;
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
	private UInt64 _sizeOfStackReserve;
	private UInt64 _sizeOfStackCommit;
	private UInt64 _sizeOfHeapReserve;
	private UInt64 _sizeOfHeapCommit;
	private UInt32 _loaderFlags;
	private UInt32 _numberOfRvaAndSize;
}
