// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt32;

public class DataDirectory {

	public static DataDirectory read(LargeByteBuffer buffer, long offset) {
		return read(buffer, offset, new DataDirectory());
	}

	public static DataDirectory read(LargeByteBuffer buffer, long offset, DataDirectory x) {
		x.setVirtualAddress(LittleEndianReader.readUInt32(buffer, offset));
		x.setSize(LittleEndianReader.readUInt32(buffer, offset + 4));
		return x;
	}

	public UInt32 getVirtualAddress() {
		return _virtualAddress;
	}

	public DataDirectory setVirtualAddress(UInt32 x) {
		_virtualAddress = x;
		return this;
	}

	public UInt32 getSize() {
		return _size;
	}

	public DataDirectory setSize(UInt32 x) {
		_size = x;
		return this;
	}

	public static final int byteSize = 8;
	private UInt32 _virtualAddress;
	private UInt32 _size;
}
