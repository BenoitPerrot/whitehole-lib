package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.Int64;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.UInt64;

public class ImportLookupTableEntry {

	static public class OrdinalEntry extends ImportLookupTableEntry {

		private long _number;

		public OrdinalEntry(long number) {
			_number = number;
		}

		public long getNumber() {
			return _number;
		}

		public void setNumber(long number) {
			_number = number;
		}
	}

	static public class HintNameEntry extends ImportLookupTableEntry {

		private long _rva;
		private HintName _hn;

		public HintNameEntry(long rva) {
			_rva = rva;
		}

		public long getRVA() {
			return _rva;
		}

		public void setRVA(long rva) {
			_rva = rva;
		}

		public HintName getHintName() {
			return _hn;
		}

		public void setHintName(HintName hn) {
			_hn = hn;
		}
	}

	private static ImportLookupTableEntry create(boolean isOrdinal, long x) {
		return isOrdinal ? new ImportLookupTableEntry.OrdinalEntry(x) : new ImportLookupTableEntry.HintNameEntry(x);
	}

	public static ImportLookupTableEntry read(LargeByteBuffer buffer, long start, boolean isPE32x) {
		if (isPE32x) {
			final UInt64 x = LittleEndianReader.readUInt64(buffer, start);
			return x.equals(UInt64.ZERO) ? null : create((x.getByte7() & 0x80) == 0x80,
					new Int64((byte) (x.getByte7() & 0x7f), x.getByte6(), x.getByte5(), x.getByte4(), x.getByte3(), x.getByte2(), x.getByte1(), x.getByte0()).toLong());
		}
		else {
			final UInt32 x = LittleEndianReader.readUInt32(buffer, start);
			return x.equals(UInt32.ZERO) ? null : create((x.getByte3() & 0x80) == 0x80,
					new UInt32((byte) (x.getByte3() & 0x7f), x.getByte2(), x.getByte1(), x.getByte0()).toLong());
		}
	}
}
