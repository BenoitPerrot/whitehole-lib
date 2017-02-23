// Copyright (c) 2015, Benoit PERROT.
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.StringAsciiz;
import org.whitehole.infra.types.UInt32;

public class ImportDirectoryTable implements Iterable<ImportDirectoryTableEntry> {

	static private boolean isNull(ImportDirectoryTableEntry e) {
		return e.getImportLookupTableRVA().equals(UInt32.ZERO) && e.getTimeStamp().equals(UInt32.ZERO) && e.getForwarderChain().equals(UInt32.ZERO)
				&& e.getNameRVA().equals(UInt32.ZERO) && e.getImportAddressTableRVA().equals(UInt32.ZERO);
	}

	public static ImportDirectoryTable read(LargeByteBuffer buffer, long offset, boolean isPE32x, long rvaToOffset) {

		//
		// Read all entries of the table

		final ArrayList<ImportDirectoryTableEntry> entries = new ArrayList<ImportDirectoryTableEntry>();
		{
			ImportDirectoryTableEntry e;
			while (!isNull(e = ImportDirectoryTableEntry.read(buffer, offset))) { // FIXME: offset < buffer.length
				entries.add(e);
				offset += ImportDirectoryTableEntry.byteSize;
			}
		}

		//
		// Read lookup tables pointed to by entries

		final HashMap<ImportDirectoryTableEntry, ImportLookupTable> lookupTables = new HashMap<ImportDirectoryTableEntry, ImportLookupTable>();
		for (final ImportDirectoryTableEntry e : entries) {
			// Retrieve DLL name
			final String name = StringAsciiz.read(buffer, rvaToOffset + e.getNameRVA().toLong());

			// Retrieve imported symbols
			final ImportLookupTable lt = ImportLookupTable.read(buffer, rvaToOffset + e.getImportLookupTableRVA().toLong(), isPE32x, name);
			for (final Entry<Long, ImportLookupTableEntry> ole : lt.entrySet()) {
				// final long addr = base + e.getImportAddressTableRVA().toBigInteger().longValue() + ole.getKey();
				final ImportLookupTableEntry le = ole.getValue();
				if (le instanceof ImportLookupTableEntry.HintNameEntry) {
					final ImportLookupTableEntry.HintNameEntry hne = (ImportLookupTableEntry.HintNameEntry) le;
					hne.setHintName(HintName.read(buffer, rvaToOffset + hne.getRVA()));
				}
				// addressToILTE.put(addr, le);
			}
			lookupTables.put(e, lt);
		}

		return new ImportDirectoryTable(entries, lookupTables);
	}

	private final ArrayList<ImportDirectoryTableEntry> _entries;
	private final HashMap<ImportDirectoryTableEntry, ImportLookupTable> _lookupTables;

	public ImportDirectoryTable(ArrayList<ImportDirectoryTableEntry> entries, HashMap<ImportDirectoryTableEntry, ImportLookupTable> lookupTables) {
		_entries = entries;
		_lookupTables = lookupTables;
	}

	public ImportLookupTable getLookupTable(ImportDirectoryTableEntry e) {
		return _lookupTables.get(e);
	}

	public Iterator<ImportDirectoryTableEntry> iterator() {
		return _entries.iterator();
	}

}
