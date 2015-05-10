// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.UInt64;

public class SectionHeader {

	public static SectionHeader read(LargeByteBuffer buffer, long offset) {
		return read(buffer, offset, new SectionHeader());
	}

	public static SectionHeader read(LargeByteBuffer buffer, long offset, SectionHeader x) {
		x.setName(LittleEndianReader.readUInt64(buffer, offset));
		x.setVirtualSize(LittleEndianReader.readUInt32(buffer, offset + 8));
		x.setVirtualAddress(LittleEndianReader.readUInt32(buffer, offset + 12));
		x.setSizeOfRawData(LittleEndianReader.readUInt32(buffer, offset + 16));
		x.setPointerToRawData(LittleEndianReader.readUInt32(buffer, offset + 20));
		x.setPointerToRelocations(LittleEndianReader.readUInt32(buffer, offset + 24));
		x.setPointerToLineNumbers(LittleEndianReader.readUInt32(buffer, offset + 28));
		x.setNumberOfRelocations(LittleEndianReader.readUInt16(buffer, offset + 32));
		x.setNumberOfLineNumbers(LittleEndianReader.readUInt16(buffer, offset + 34));
		x.setCharacteristics(SectionFlags.read(buffer, offset + 36));
		return x;
	}

	public UInt64 getName() {
		return _name;
	}

	public SectionHeader setName(UInt64 x) {
		_name = x;
		return this;
	}

	public UInt32 getVirtualSize() {
		return _virtualSize;
	}

	public SectionHeader setVirtualSize(UInt32 x) {
		_virtualSize = x;
		return this;
	}

	public UInt32 getVirtualAddress() {
		return _virtualAddress;
	}

	public SectionHeader setVirtualAddress(UInt32 x) {
		_virtualAddress = x;
		return this;
	}

	public UInt32 getSizeOfRawData() {
		return _sizeOfRawData;
	}

	public SectionHeader setSizeOfRawData(UInt32 x) {
		_sizeOfRawData = x;
		return this;
	}

	public UInt32 getPointerToRawData() {
		return _pointerToRawData;
	}

	public SectionHeader setPointerToRawData(UInt32 x) {
		_pointerToRawData = x;
		return this;
	}

	public UInt32 getPointerToRelocations() {
		return _pointerToRelocations;
	}

	public SectionHeader setPointerToRelocations(UInt32 x) {
		_pointerToRelocations = x;
		return this;
	}

	public UInt32 getPointerToLineNumbers() {
		return _pointerToLineNumbers;
	}

	public SectionHeader setPointerToLineNumbers(UInt32 x) {
		_pointerToLineNumbers = x;
		return this;
	}

	public UInt16 getNumberOfRelocations() {
		return _numberOfRelocations;
	}

	public SectionHeader setNumberOfRelocations(UInt16 x) {
		_numberOfRelocations = x;
		return this;
	}

	public UInt16 getNumberOfLineNumbers() {
		return _numberOfLineNumbers;
	}

	public SectionHeader setNumberOfLineNumbers(UInt16 x) {
		_numberOfLineNumbers = x;
		return this;
	}

	public SectionFlags getCharacteristics() {
		return _characteristics;
	}

	public SectionHeader setCharacteristics(SectionFlags x) {
		_characteristics = x;
		return this;
	}

	public static final int byteSize = 36 + SectionFlags.byteSize;
	private UInt64 _name;
	private UInt32 _virtualSize;
	private UInt32 _virtualAddress;
	private UInt32 _sizeOfRawData;
	private UInt32 _pointerToRawData;
	private UInt32 _pointerToRelocations;
	private UInt32 _pointerToLineNumbers;
	private UInt16 _numberOfRelocations;
	private UInt16 _numberOfLineNumbers;
	private SectionFlags _characteristics;
}
