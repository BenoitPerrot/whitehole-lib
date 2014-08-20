package org.whitehole.binary.pe;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.whitehole.infra.io.LargeByteBuffer;

public class ImportLookupTable {

	private final String _name;
	private final HashMap<Long, ImportLookupTableEntry> _entries;

	private ImportLookupTable(String name, HashMap<Long, ImportLookupTableEntry> entries) {
		_name = name;
		_entries = entries;
	}

	public Set<Entry<Long, ImportLookupTableEntry>> entrySet() {
		return _entries.entrySet();
	}

	public String getName() {
		return _name;
	}

	public static ImportLookupTable read(LargeByteBuffer buffer, long start, boolean isPE32x, String name) {

		final long width = isPE32x ? 8 : 4;

		final HashMap<Long, ImportLookupTableEntry> entries = new HashMap<Long, ImportLookupTableEntry>();
		long offset = 0;
		ImportLookupTableEntry e;
		while ((e = ImportLookupTableEntry.read(buffer, start + offset, isPE32x)) != null) { // FIXME: offset < buffer.length()
			entries.put(offset, e);
			offset += width;
		}
		return new ImportLookupTable(name, entries);
	}

}
