package org.whitehole.binary.pe;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map.Entry;

import org.whitehole.infra.json.JsonGenerator;
import org.whitehole.infra.types.UInt32;

// Should be generated
// <<
public class Json {

	public static JsonGenerator write(JsonGenerator g, String name, Characteristics c) {
		g.writeStartArray(name);
		if (c.getRelocsStripped())
			g.write("RELOCS_STRIPPED");
		if (c.getExecutableImage())
			g.write("EXECUTABLE_IMAGE");
		if (c.getLineNumsStripped())
			g.write("LINE_NUMS_STRIPPED");
		if (c.getLocalSymsStripped())
			g.write("LOCAL_SYMS_STRIPPED");
		if (c.getAggressiveWsTrim())
			g.write("AGGRESSIVE_WS_TRIM");
		if (c.getLargeAddressAware())
			g.write("LARGE_ADDRESS_AWARE");
		if (c.getReserved())
			g.write("RESERVED");
		if (c.getBytesReversedLo())
			g.write("BYTES_RESERVED_LO");
		if (c.get32bitMachine())
			g.write("32BIT_MACHINE");
		if (c.getDebugStripped())
			g.write("DEBUG_STRIPPED");
		if (c.getRemovableRunFromSwap())
			g.write("REMOVABLE_RUN_FROM_SWAP");
		if (c.getNetRunFromSwap())
			g.write("NET_RUN_FROM_SWAP");
		if (c.getSystem())
			g.write("SYSTEM");
		if (c.getDll())
			g.write("DLL");
		if (c.getUpSystemOnly())
			g.write("UP_SYSTEM_ONLY");
		if (c.getBytesReversedHi())
			g.write("BYTES_RESERVED_HI");
		return g.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, COFFHeader h) {
		final MachineType mt = h.getMachine();
		final MachineType.Valid v = mt.toValid();
		g.writeStartObject(name)
				.write("machineType", v == null ? "0x" + mt.code.toHexString() : v.toString())
				.write("numberOfSections", h.getNumberOfSections().toBigInteger())
				.write("timeDateStamp", new Date(h.getTimeDateStamp().toLong() * 1000).toString())
				// "0x" + h.getTimeDateStamp().toHexString())
				.write("pointerToSymbolTable", "0x" + h.getPointerToSymbolTable().toHexString())
				.write("numberOfSymbols", h.getNumberOfSymbols().toBigInteger())
				.write("sizeOfOptionalHeader", h.getSizeOfOptionalHeader().toBigInteger());
		write(g, "characteristics", h.getCharacteristics());
		return g.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, OptionalHeaderStandardFields f) {
		final MagicNumber m = f.getMagic();
		final MagicNumber.Valid mv = m.toValid();
		return g.writeStartObject(name)
				.write("magic", mv == null ? "0x" + m.code.toHexString() : mv.toString())
				.write("majorLinkerVersion", f.getMajorLinkerVersion().toBigInteger())
				.write("minorLinkerVersion", f.getMinorLinkerVersion().toBigInteger())
				.write("sizeOfCode", f.getSizeOfCode().toBigInteger())
				.write("sizeOfInitializedData", f.getSizeOfInitializedData().toBigInteger())
				.write("sizeOfUninitializedData", f.getSizeOfUninitializedData().toBigInteger())
				.write("addressOfEntryPoint", "0x" + f.getAddressOfEntryPoint().toHexString(true))
				.write("baseOfCode", "0x" + f.getBaseOfCode().toHexString(true))
				.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, DllCharacteristics c) {
		g.writeStartArray(name);
		if (c.getReserved1())
			g.write("RESERVED1");
		if (c.getReserved2())
			g.write("RESERVED2");
		if (c.getReserved3())
			g.write("RESERVED3");
		if (c.getReserved4())
			g.write("RESERVED4");
		if (c.getDynamicBase())
			g.write("DYNAMIC_BASE");
		if (c.getForceIntegrity())
			g.write("FORCE_INTEGRITY");
		if (c.getNxCompat())
			g.write("NX_COMPAT");
		if (c.getNoIsolation())
			g.write("NO_ISOLATION");
		if (c.getNoSeh())
			g.write("NO_SEH");
		if (c.getNoBind())
			g.write("NO_BIND");
		if (c.getReserved5())
			g.write("RESERVED5");
		if (c.getWdmDriver())
			g.write("WDM_DRIVER");
		if (c.getTerminalServerAware())
			g.write("TERMINAL_SERVER_AWARE");
		return g.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, OptionalHeaderPE32Fields f) {
		final WindowsSubsystem ws = f.getSubsystem();
		final WindowsSubsystem.Valid wsv = ws.toValid();
		g.writeStartObject(name)
				.write("baseOfData", "0x" + f.getBaseOfData().toHexString(true))
				.write("imageBase", "0x" + f.getImageBase().toHexString(true))
				.write("sectionAlignment", f.getSectionAlignment().toBigInteger())
				.write("fileAlignment", f.getFileAlignment().toBigInteger())
				.write("majorOperatingSystemVersion", f.getMajorOperatingSystemVersion().toBigInteger())
				.write("minorOperatingSystemVersion", f.getMinorOperatingSystemVersion().toBigInteger())
				.write("majorImageVersion", f.getMajorImageVersion().toBigInteger())
				.write("minorImageVersion", f.getMinorImageVersion().toBigInteger())
				.write("majorSubsystemVersion", f.getMajorSubsystemVersion().toBigInteger())
				.write("minorSubsystemVersion", f.getMinorSubsystemVersion().toBigInteger())
				.write("win32VersionValue", f.getWin32VersionValue().toBigInteger())
				.write("sizeOfImage", f.getSizeOfImage().toBigInteger())
				.write("sizeOfHeaders", f.getSizeOfHeaders().toBigInteger())
				.write("checksum", "0x" + f.getChecksum().toHexString(true))
				.write("subsystem", ws == null ? "0x" + ws.code.toHexString() : wsv.toString());
		write(g, "dllCharacteristics", f.getDllCharacteristics());
		g.write("sizeOfStackReserve", f.getSizeOfStackReserve().toBigInteger())
				.write("sizeOfStackCommit", f.getSizeOfStackCommit().toBigInteger())
				.write("sizeOfHeapReserve", f.getSizeOfHeapReserve().toBigInteger())
				.write("sizeOfHeapCommit", f.getSizeOfHeapCommit().toBigInteger())
				.write("loaderFlags", "0x" + f.getLoaderFlags().toHexString(true))
				.write("numberOfRvaAndSize", f.getNumberOfRvaAndSize().toBigInteger());
		return g.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, OptionalHeaderPE32xFields f) {
		final WindowsSubsystem ws = f.getSubsystem();
		final WindowsSubsystem.Valid wsv = ws.toValid();
		g.writeStartObject(name)
				.write("imageBase", "0x" + f.getImageBase().toHexString(true))
				.write("sectionAlignment", f.getSectionAlignment().toBigInteger())
				.write("fileAlignment", f.getFileAlignment().toBigInteger())
				.write("majorOperatingSystemVersion", f.getMajorOperatingSystemVersion().toBigInteger())
				.write("minorOperatingSystemVersion", f.getMinorOperatingSystemVersion().toBigInteger())
				.write("majorImageVersion", f.getMajorImageVersion().toBigInteger())
				.write("minorImageVersion", f.getMinorImageVersion().toBigInteger())
				.write("majorSubsystemVersion", f.getMajorSubsystemVersion().toBigInteger())
				.write("minorSubsystemVersion", f.getMinorSubsystemVersion().toBigInteger())
				.write("win32VersionValue", f.getWin32VersionValue().toBigInteger())
				.write("sizeOfImage", f.getSizeOfImage().toBigInteger())
				.write("sizeOfHeaders", f.getSizeOfHeaders().toBigInteger())
				.write("checksum", "0x" + f.getChecksum().toHexString(true))
				.write("subsystem", ws == null ? "0x" + ws.code.toHexString() : wsv.toString());
		write(g, "dllCharacteristics", f.getDllCharacteristics());
		g.write("sizeOfStackReserve", f.getSizeOfStackReserve().toBigInteger())
				.write("sizeOfStackCommit", f.getSizeOfStackCommit().toBigInteger())
				.write("sizeOfHeapReserve", f.getSizeOfHeapReserve().toBigInteger())
				.write("sizeOfHeapCommit", f.getSizeOfHeapCommit().toBigInteger())
				.write("loaderFlags", "0x" + f.getLoaderFlags().toHexString(true))
				.write("numberOfRvaAndSize", f.getNumberOfRvaAndSize().toBigInteger());
		return g.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, DataDirectory d) {
		return g.writeStartObject(name)
				.write("virtualAddress", "0x" + d.getVirtualAddress().toHexString(true))
				.write("size", d.getSize().toBigInteger())
				.writeEnd();
	}

	private static JsonGenerator writeIfSound(JsonGenerator g, String name, DataDirectory d) {
		if (d != null)
			write(g, name, d);
		return g;
	}

	public static JsonGenerator write(JsonGenerator g, String name, OptionalHeader h) {
		g.writeStartObject(name);
		write(g, "standardFields", h.getStandardFields());
		switch (h.getStandardFields().getMagic().toValid()) {
			case PE32:
				write(g, "pe32Fields", (OptionalHeaderPE32Fields) h.getWindowsSpecificFields());
				break;
			case PE32x:
				write(g, "pe32xFields", (OptionalHeaderPE32xFields) h.getWindowsSpecificFields());
				break;
			default:
				break;
		}
		writeIfSound(g, "exportTable", h.getExportTable());
		writeIfSound(g, "importTable", h.getImportTable());
		writeIfSound(g, "resourceTable", h.getResourceTable());
		writeIfSound(g, "exceptionTable", h.getExceptionTable());
		writeIfSound(g, "certificateTable", h.getCertificateTable());
		writeIfSound(g, "baseRelocationTable", h.getBaseRelocationTable());
		writeIfSound(g, "debug", h.getDebug());
		writeIfSound(g, "architecture", h.getArchitecture());
		writeIfSound(g, "globalPtr", h.getGlobalPtr());
		writeIfSound(g, "tlsTable", h.getTLSTable());
		writeIfSound(g, "loadConfigTable", h.getLoadConfigTable());
		writeIfSound(g, "boundImport", h.getBoundImport());
		writeIfSound(g, "iat", h.getIAT());
		writeIfSound(g, "delayImportDescriptor", h.getDelayImportDescriptor());
		writeIfSound(g, "clrRuntimeHeader", h.getCLRRuntimeHeader());
		writeIfSound(g, "reserved", h.getReserved());
		g.writeEnd();
		return g;
	}

	public static JsonGenerator write(JsonGenerator g, SectionHeader h) {
		return g.writeStartObject()
				.write("virtualSize", h.getVirtualSize().toBigInteger())
				.write("virtualAddress", "0x" + h.getVirtualAddress().toHexString(true))
				.write("sizeOfRawData", h.getSizeOfRawData().toBigInteger())
				.write("pointerToRawData", "0x" + h.getPointerToRawData().toHexString(true))
				.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, PEHeader f) {
		g.writeStartObject(name);
		write(g, "coffHeader", f.getCOFFHeader());
		write(g, "optionalHeader", f.getOptionalHeader());
		g.writeStartArray("sectionHeaders");
		for (SectionHeader h : f.getSectionHeaders())
			write(g, h);
		g.writeEnd();
		return g.writeEnd();
	}

	//
	public static JsonGenerator write(JsonGenerator g, String name, ImportDirectoryTable t) {
		g.writeStartArray(name);
		for (final ImportDirectoryTableEntry e : t) {
			final ImportLookupTable lt = t.getLookupTable(e);
			g.writeStartObject();
			g.write("name", lt.getName());
			g.writeStartArray("lookupTable");
			for (final Entry<Long, ImportLookupTableEntry> ole : lt.entrySet()) {
				final ImportLookupTableEntry le = ole.getValue();
				if (le instanceof ImportLookupTableEntry.HintNameEntry) {
					final ImportLookupTableEntry.HintNameEntry hne = (ImportLookupTableEntry.HintNameEntry) le;
					g.writeStartObject();
					g.write("name", hne.getHintName().getName().toString());
					g.write("rva", Long.toHexString(hne.getRVA()));
					g.writeEnd();
				}
			}
			g.writeEnd();
			g.writeEnd();
		}
		return g.writeEnd();
	}

	//
	public static JsonGenerator write(JsonGenerator g, String name, ExportDirectoryTable t) {
		return g.writeStartObject(name)
				.write("exportFlags", "0x" + t.getExportFlags().toHexString(true))
				.write("timeDateStamp", new Date(t.getTimeDateStamp().toLong() * 1000).toString())
				.write("majorVersion", BigInteger.valueOf(t.getMajorVersion().toInt()))
				.write("minorVersion", BigInteger.valueOf(t.getMajorVersion().toInt()))
				.write("nameRva", "0x" + t.getNameRva().toHexString(true))
				.write("ordinalBase", "0x" + t.getOrdinalBase().toHexString(true))
				.write("addressTableEntries", "0x" + t.getAddressTableEntries().toHexString(true))
				.write("numberOfNamePointers", BigInteger.valueOf(t.getNumberOfNamePointers().toLong()))
				.write("exportAddressTableRva", "0x" + t.getExportAddressTableRva().toHexString(true))
				.write("namePointerRva", "0x" + t.getNamePointerRva().toHexString(true))
				.write("ordinalTableRva", "0x" + t.getOrdinalTableRva().toHexString(true))
				.writeEnd();
	}

	public static JsonGenerator write(JsonGenerator g, String name, ExportDirectoryTable edt, ExportAddressNameOrdinalTable et) {
		g.writeStartObject(name);
		write(g, "metadata", edt);
		g.writeStartArray("addresses");
		for (final UInt32 x : et.getExportAddressTable())
			g.write("0x" + x.toHexString(true));
		g.writeEnd();
		g.writeStartObject("symbols");
		for (final Entry<String, Integer> e : et.getExportSymbolTable().entrySet())
			g.write(e.getKey(), BigInteger.valueOf(e.getValue()));
		g.writeEnd();
		return g.writeEnd();
	}

	//
	public static JsonGenerator write(JsonGenerator g, String name, Image i) {
		if (name == null)
			g.writeStartObject();
		else
			g.writeStartObject(name);
		write(g, "header", i.getHeader());
		if (i.getImportDirectoryTable() != null)
			write(g, "importTable", i.getImportDirectoryTable());
		if (i.getExportAddressNameOrdinalTable() != null)
			write(g, "exportTable", i.getExportDirectoryTable(), i.getExportAddressNameOrdinalTable());
		return g.writeEnd();
	}
}
