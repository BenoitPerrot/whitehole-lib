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

import java.util.ArrayList;
import java.util.TreeMap;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.StringAsciiz;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.UInt32;

public class ExportAddressNameOrdinalTable {

	private final ArrayList<UInt32> _eat;
	private final TreeMap<String, Integer> _est;

	public ArrayList<UInt32> getExportAddressTable() {
		return _eat;
	}

	public TreeMap<String, Integer> getExportSymbolTable() {
		return _est;
	}

	public ExportAddressNameOrdinalTable(ArrayList<UInt32> eat, TreeMap<String, Integer> est) {
		_eat = eat;
		_est = est;
	}

	private static ArrayList<UInt32> readExportAddressTable(LargeByteBuffer buffer, long rvaToOffset, ExportDirectoryTable et) {
		final ArrayList<UInt32> l = new ArrayList<UInt32>();

		long offset = rvaToOffset + et.getExportAddressTableRva().toLong();
		final long entryCount = et.getAddressTableEntries().toLong();

		for (long i = 0; i < entryCount; ++i) {
			final UInt32 x = LittleEndianReader.readUInt32(buffer, offset);
			offset += 4;

			l.add(x); // FIXME: if x is within the export section, it is a forwarderRVA, else it is an exportRVA
		}

		return l;
	}

	private static ArrayList<String> readExportNamePointerTable(LargeByteBuffer buffer, long rvaToOffset, long namePointerTableRVA, long entryCount) {
		final ArrayList<String> names = new ArrayList<String>();

		long namePointerTableOffset = rvaToOffset + namePointerTableRVA;
		for (long i = 0; i < entryCount; ++i) {
			final UInt32 x = LittleEndianReader.readUInt32(buffer, namePointerTableOffset);
			namePointerTableOffset += 4;
			names.add(StringAsciiz.read(buffer, rvaToOffset + x.toLong()));
		}

		return names;
	}

	private static ArrayList<Integer> readExportOrdinalTable(LargeByteBuffer buffer, long rvaToOffset, long ordinalTableRVA, long entryCount) {
		final ArrayList<Integer> ordinals = new ArrayList<Integer>();

		long ordinalTableOffset = rvaToOffset + ordinalTableRVA;
		for (long i = 0; i < entryCount; ++i) {
			final UInt16 x = LittleEndianReader.readUInt16(buffer, ordinalTableOffset);
			ordinalTableOffset += 2;
			ordinals.add((int) x.toInt());
		}

		return ordinals;
	}

	private static TreeMap<String, Integer> readExportSymbolTable(LargeByteBuffer buffer, long rvaToOffset, ExportDirectoryTable et) {

		final long entryCount = et.getNumberOfNamePointers().toLong();

		final ArrayList<String> names = readExportNamePointerTable(buffer, rvaToOffset, et.getNamePointerRva().toLong(), entryCount);
		final ArrayList<Integer> ordinals = readExportOrdinalTable(buffer, rvaToOffset, et.getOrdinalTableRva().toLong(), entryCount);
		assert (names.size() == ordinals.size());

		final TreeMap<String, Integer> symbols = new TreeMap<String, Integer>();

		for (int i = 0; i < names.size(); ++i)
			symbols.put(names.get(i), ordinals.get(i));

		return symbols;
	}

	public static ExportAddressNameOrdinalTable read(LargeByteBuffer b, long rvaToOffset, ExportDirectoryTable et) {
		return new ExportAddressNameOrdinalTable(readExportAddressTable(b, rvaToOffset, et), readExportSymbolTable(b, rvaToOffset, et));
	}
}