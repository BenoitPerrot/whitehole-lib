// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.UInt8;

public class OptionalHeaderStandardFields {

	public static OptionalHeaderStandardFields read(LargeByteBuffer buffer, long offset) {
		return read(buffer, offset, new OptionalHeaderStandardFields());
	}

	public static OptionalHeaderStandardFields read(LargeByteBuffer buffer, long offset, OptionalHeaderStandardFields x) {
		x.setMagic(MagicNumber.read(buffer, offset));
		x.setMajorLinkerVersion(LittleEndianReader.readUInt8(buffer, offset + 2));
		x.setMinorLinkerVersion(LittleEndianReader.readUInt8(buffer, offset + 3));
		x.setSizeOfCode(LittleEndianReader.readUInt32(buffer, offset + 4));
		x.setSizeOfInitializedData(LittleEndianReader.readUInt32(buffer, offset + 8));
		x.setSizeOfUninitializedData(LittleEndianReader.readUInt32(buffer, offset + 12));
		x.setAddressOfEntryPoint(LittleEndianReader.readUInt32(buffer, offset + 16));
		x.setBaseOfCode(LittleEndianReader.readUInt32(buffer, offset + 20));
		return x;
	}

	public MagicNumber getMagic() {
		return _magic;
	}

	public OptionalHeaderStandardFields setMagic(MagicNumber x) {
		_magic = x;
		return this;
	}

	public UInt8 getMajorLinkerVersion() {
		return _majorLinkerVersion;
	}

	public OptionalHeaderStandardFields setMajorLinkerVersion(UInt8 x) {
		_majorLinkerVersion = x;
		return this;
	}

	public UInt8 getMinorLinkerVersion() {
		return _minorLinkerVersion;
	}

	public OptionalHeaderStandardFields setMinorLinkerVersion(UInt8 x) {
		_minorLinkerVersion = x;
		return this;
	}

	public UInt32 getSizeOfCode() {
		return _sizeOfCode;
	}

	public OptionalHeaderStandardFields setSizeOfCode(UInt32 x) {
		_sizeOfCode = x;
		return this;
	}

	public UInt32 getSizeOfInitializedData() {
		return _sizeOfInitializedData;
	}

	public OptionalHeaderStandardFields setSizeOfInitializedData(UInt32 x) {
		_sizeOfInitializedData = x;
		return this;
	}

	public UInt32 getSizeOfUninitializedData() {
		return _sizeOfUninitializedData;
	}

	public OptionalHeaderStandardFields setSizeOfUninitializedData(UInt32 x) {
		_sizeOfUninitializedData = x;
		return this;
	}

	public UInt32 getAddressOfEntryPoint() {
		return _addressOfEntryPoint;
	}

	public OptionalHeaderStandardFields setAddressOfEntryPoint(UInt32 x) {
		_addressOfEntryPoint = x;
		return this;
	}

	public UInt32 getBaseOfCode() {
		return _baseOfCode;
	}

	public OptionalHeaderStandardFields setBaseOfCode(UInt32 x) {
		_baseOfCode = x;
		return this;
	}

	public static final int byteSize = 22 + MagicNumber.byteSize;
	private MagicNumber _magic;
	private UInt8 _majorLinkerVersion;
	private UInt8 _minorLinkerVersion;
	private UInt32 _sizeOfCode;
	private UInt32 _sizeOfInitializedData;
	private UInt32 _sizeOfUninitializedData;
	private UInt32 _addressOfEntryPoint;
	private UInt32 _baseOfCode;
}
