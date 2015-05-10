// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt32;

public class ImportDirectoryTableEntry {

	public static ImportDirectoryTableEntry read(LargeByteBuffer buffer, long offset) {
		return read(buffer, offset, new ImportDirectoryTableEntry());
	}

	public static ImportDirectoryTableEntry read(LargeByteBuffer buffer, long offset, ImportDirectoryTableEntry x) {
		x.setImportLookupTableRVA(LittleEndianReader.readUInt32(buffer, offset));
		x.setTimeStamp(LittleEndianReader.readUInt32(buffer, offset + 4));
		x.setForwarderChain(LittleEndianReader.readUInt32(buffer, offset + 8));
		x.setNameRVA(LittleEndianReader.readUInt32(buffer, offset + 12));
		x.setImportAddressTableRVA(LittleEndianReader.readUInt32(buffer, offset + 16));
		return x;
	}

	public UInt32 getImportLookupTableRVA() {
		return _importLookupTableRVA;
	}

	public ImportDirectoryTableEntry setImportLookupTableRVA(UInt32 x) {
		_importLookupTableRVA = x;
		return this;
	}

	public UInt32 getTimeStamp() {
		return _timeStamp;
	}

	public ImportDirectoryTableEntry setTimeStamp(UInt32 x) {
		_timeStamp = x;
		return this;
	}

	public UInt32 getForwarderChain() {
		return _forwarderChain;
	}

	public ImportDirectoryTableEntry setForwarderChain(UInt32 x) {
		_forwarderChain = x;
		return this;
	}

	public UInt32 getNameRVA() {
		return _nameRVA;
	}

	public ImportDirectoryTableEntry setNameRVA(UInt32 x) {
		_nameRVA = x;
		return this;
	}

	public UInt32 getImportAddressTableRVA() {
		return _importAddressTableRVA;
	}

	public ImportDirectoryTableEntry setImportAddressTableRVA(UInt32 x) {
		_importAddressTableRVA = x;
		return this;
	}

	public static final int byteSize = 20;
	private UInt32 _importLookupTableRVA;
	private UInt32 _timeStamp;
	private UInt32 _forwarderChain;
	private UInt32 _nameRVA;
	private UInt32 _importAddressTableRVA;
}
