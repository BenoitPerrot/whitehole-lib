// Copyright (c) 2014-2015, Benoit PERROT.
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
import java.math.BigInteger;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.StringAsciiz;

public class Image {

	private final PEHeader _h;

	private final ImportDirectoryTable _idt;

	private final ExportDirectoryTable _edt;
	private final ExportAddressNameOrdinalTable _et;

	private Image(PEHeader h, ImportDirectoryTable idt, ExportDirectoryTable edt, ExportAddressNameOrdinalTable et) {
		_h = h;

		_idt = idt;

		_edt = edt;
		_et = et;
	}

	public static class DataDirectoryLocations {

		private final long _rvaToOffset;
		private final long _tableOffset;

		private DataDirectoryLocations(long tableRVA, long rvaToOffset) {
			_rvaToOffset = rvaToOffset;
			_tableOffset = tableRVA + rvaToOffset;
		}

		public long getRVAToOffset() {
			return _rvaToOffset;
		}

		public long getTableOffset() {
			return _tableOffset;
		}

		public static DataDirectoryLocations tryLocate(PEHeader h, DataDirectory d) {
			if (d != null) {
				final long tableRVA = d.getVirtualAddress().toBigInteger().longValue();
				final SectionHeader sh = h.findSectionHeaderByRVA(tableRVA);
				if (sh != null) {
					final long rvaToOffset = computeRVAToOffset(sh);
					return new DataDirectoryLocations(tableRVA, rvaToOffset);
				}
			}
			return null;
		}
	}

	public static Image load(LargeByteBuffer b, long offset) throws IOException {
		final PEHeader h = new PEHeader(b, offset);

		// Load export directory table
		// String name = null;
		ExportDirectoryTable edt = null;
		ExportAddressNameOrdinalTable et = null;
		{
			final DataDirectoryLocations l = DataDirectoryLocations.tryLocate(h, h.getOptionalHeader().getExportTable());
			if (l != null) {
				// Load table
				edt = ExportDirectoryTable.read(b, l.getTableOffset());

				// Retrieve DLL name
				// name = StringAsciiz.read(b, l.getRVAToOffset() + edt.getNameRva().toLong());
				et = ExportAddressNameOrdinalTable.read(b, l.getRVAToOffset(), edt);
			}
		}

		// Load import directory table
		ImportDirectoryTable idt = null;
		{
			final DataDirectoryLocations l = DataDirectoryLocations.tryLocate(h, h.getOptionalHeader().getImportTable());
			if (l != null)
				idt = ImportDirectoryTable.read(b, l.getTableOffset(), h.isPE32x(), l.getRVAToOffset());
		}

		return new Image(h, idt, edt, et);
	}

	public PEHeader getHeader() {
		return _h;
	}

	public boolean isPE32x() {
		return _h.isPE32x();
	}

	public MachineType getMachineType() {
		return _h.getCOFFHeader().getMachine();
	}

	public BigInteger getImageBase() {
		return _h.getImageBase();
	}

	public BigInteger getAddressOfEntryPoint() {
		return _h.getAddressOfEntryPoint();
	}

	public SectionHeader findSectionHeaderByRVA(long offset) {
		return _h.findSectionHeaderByRVA(offset);
	}

	public String getSectionName(SectionHeader sh) {
		return StringAsciiz.readLittleEndian(sh.getName());
	}

	public SectionHeader findSectionHeaderByName(String name) {
		return _h.findSectionHeaderByName(name);
	}

	public Iterable<SectionHeader> getSectionHeaders() {
		return _h.getSectionHeaders();
	}

	public ImportDirectoryTable getImportDirectoryTable() {
		return _idt;
	}

	public ExportDirectoryTable getExportDirectoryTable() {
		return _edt;
	}

	public ExportAddressNameOrdinalTable getExportAddressNameOrdinalTable() {
		return _et;
	}

	public static long computeRVAToOffset(SectionHeader sh) {
		return sh.getPointerToRawData().toLong() - sh.getVirtualAddress().toLong();
	}

}
