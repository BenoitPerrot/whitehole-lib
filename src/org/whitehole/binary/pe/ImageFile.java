// Generated, do not edit by hand
package org.whitehole.binary.pe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt32;

public class ImageFile {
	public ImageFile(ByteBuffer buffer, int offset) throws IOException {

		// Signature offset is at 0x3c
		int n = 0x3c;
		final UInt32 signatureOffset = LittleEndianReader.readUInt32(buffer,
				offset + n);

		// Check signature
		n = signatureOffset.toBigInteger().intValue();
		final UInt32 signature = LittleEndianReader.readUInt32(buffer, offset + n);

		n += 4;
		if (signature.getByte0() != 'P' || signature.getByte1() != 'E'
				|| signature.getByte2() != 0 || signature.getByte3() != 0)
			throw new IOException(); // TODO: call buffer.get() directly

		// Read COFF header
		_coffHeader = new COFFHeader(buffer, offset + n);
		n += COFFHeader.byteSize;

		// Read optional header (actually required for image files)
		if (_coffHeader.getOptionalHeaderSize().toBigInteger().intValue() == 0)
			throw new IOException();

		_optionalHeader = new OptionalHeader(buffer, offset + n);
		n += _optionalHeader.byteSize;

		// Read section table, if any
		_sectionHeaders = new ArrayList<SectionHeader>();
		for (int i = _coffHeader.getSectionCount().toBigInteger().intValue(); 0 < i; --i) {
			SectionHeader sh = new SectionHeader(buffer, offset + n);
			n += SectionHeader.byteSize;
			_sectionHeaders.add(sh);
		}
	}
	
	public COFFHeader getCOFFHeader() {
		return _coffHeader;
	}
	
	public OptionalHeader getOptionalHeader() {
		return _optionalHeader;
	}
	
	public ArrayList<SectionHeader> getSectionHeaders() {
		return _sectionHeaders;
	}

	private final COFFHeader _coffHeader;
	private final OptionalHeader _optionalHeader;
	private final ArrayList<SectionHeader> _sectionHeaders;
}
