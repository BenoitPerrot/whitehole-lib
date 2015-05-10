// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.ByteArray2;
import org.whitehole.infra.types.LittleEndianReader;

public class MagicNumber {

	public enum Valid {
		PE32(0x10b),
		PE32x(0x20b);

		private Valid(int c) {
			code = c;
		}

		public final int code;

	}

	public MagicNumber(ByteArray2 c) {
		code = c;
	}

	public MagicNumber(Valid v) {
		this(new ByteArray2((byte) ((v.code >> 0) & 0x0ff), (byte) ((v.code >> 8) & 0x0ff)));
	}

	public MagicNumber() {
		this(new ByteArray2());
	}

	public static MagicNumber read(LargeByteBuffer buffer, long offset) {
		return new MagicNumber(LittleEndianReader.readByteArray2(buffer, offset));
	}

	public Valid toValid() {
		switch (((code.getByte1() << 8) | code.getByte0()) & 0x0ffff) {
			case 0x10b:
				return Valid.PE32;
			case 0x20b:
				return Valid.PE32x;
			default: {
				return null;
			}
		}
	}

	static public final int byteSize = 2;
	public final ByteArray2 code;
}
