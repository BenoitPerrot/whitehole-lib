// Copyright (c) 2004-2013, Benoit PERROT.
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are
// met:
//
//     * Redistributions of source code must retain the above copyright
//       notice, this list of conditions and the following disclaimer.
//
//     * Redistributions in binary form must reproduce the above
//       copyright notice, this list of conditions and the following
//       disclaimer in the documentation and/or other materials provided
//       with the distribution.
//
//     * Neither the name of the White Hole Project nor the names of its
//       contributors may be used to endorse or promote products derived
//       from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
package org.whitehole.binary.pe;

import java.io.IOException;
import java.util.ArrayList;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt32;

public class PEHeader {

	public PEHeader(LargeByteBuffer buffer, long offset) throws IOException {
		// Signature offset is at 0x3c
		long n = 0x3c;
		final UInt32 signatureOffset = LittleEndianReader.readUInt32(buffer, offset + n);
		// Check signature
		n = signatureOffset.toBigInteger().intValue();
		final UInt32 signature = LittleEndianReader.readUInt32(buffer, offset + n);
		n += 4;
		if (signature.getByte0() != 'P' || signature.getByte1() != 'E' || signature.getByte2() != 0 || signature.getByte3() != 0)
			throw new IOException(); // TODO: call buffer.get() directly
		// Read COFF header
		_coffHeader = COFFHeader.read(buffer, offset + n);
		n += COFFHeader.byteSize;
		// Read optional header (actually required for image files)
		if (_coffHeader.getSizeOfOptionalHeader().toBigInteger().intValue() == 0)
			throw new IOException();
		_optionalHeader = new OptionalHeader(buffer, offset + n);
		n += _optionalHeader.byteSize;
		// Read section table, if any
		_sectionHeaders = new ArrayList<SectionHeader>();
		for (int i = _coffHeader.getNumberOfSections().toBigInteger().intValue(); 0 < i; --i) {
			SectionHeader sh = SectionHeader.read(buffer, offset + n);
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
