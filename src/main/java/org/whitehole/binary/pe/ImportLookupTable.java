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
