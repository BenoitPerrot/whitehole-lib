package org.whitehole.binary.pe;

import java.io.IOException;
import java.math.BigInteger;

import org.whitehole.infra.io.LargeByteBuffer;

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

	private static class DataDirectoryLocations {

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

	public SectionHeader findSectionHeaderByName(String name) {
		return _h.findSectionHeaderByName(name);
	}
	
	public Iterable<SectionHeader> getSectionHeaders() {
		return _h.getSectionHeaders();
	}

	public Iterable<ImportDirectoryTableEntry> getImportDirectoryTableEntries() {
		return _idt;
	}
	
	public ImportLookupTable getImportLookupTable(ImportDirectoryTableEntry e) {
		return _idt.getLookupTable(e);
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
