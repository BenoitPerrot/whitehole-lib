// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.ByteArray2;
import org.whitehole.infra.types.LittleEndianReader;

public class MachineType {

	public enum Valid {
		UNKNOWN(0x0),
		AM33(0x1d3),
		AMD64(0x8664),
		ARM(0x1c0),
		EBC(0xebc),
		I386(0x14c),
		IA64(0x200),
		M32R(0x9041),
		MIPS16(0x266),
		MIPSFPU(0x366),
		MIPSFPU16(0x466),
		POWERPC(0x1f0),
		POWERPCFP(0x1f1),
		R4000(0x166),
		SH3(0x1a2),
		SH3DSP(0x1a3),
		SH4(0x1a6),
		SH5(0x1a8),
		THUMB(0x1c2),
		WCEMIPSV2(0x169);

		private Valid(int c) {
			code = c;
		}

		public final int code;

	}

	public MachineType(ByteArray2 c) {
		code = c;
	}

	public MachineType(Valid v) {
		this(new ByteArray2((byte) ((v.code >> 0) & 0x0ff), (byte) ((v.code >> 8) & 0x0ff)));
	}

	public MachineType() {
		this(new ByteArray2());
	}

	public static MachineType read(LargeByteBuffer buffer, long offset) {
		return new MachineType(LittleEndianReader.readByteArray2(buffer, offset));
	}

	public Valid toValid() {
		switch (((code.getByte1() << 8) | code.getByte0()) & 0x0ffff) {
			case 0x0:
				return Valid.UNKNOWN;
			case 0x1d3:
				return Valid.AM33;
			case 0x8664:
				return Valid.AMD64;
			case 0x1c0:
				return Valid.ARM;
			case 0xebc:
				return Valid.EBC;
			case 0x14c:
				return Valid.I386;
			case 0x200:
				return Valid.IA64;
			case 0x9041:
				return Valid.M32R;
			case 0x266:
				return Valid.MIPS16;
			case 0x366:
				return Valid.MIPSFPU;
			case 0x466:
				return Valid.MIPSFPU16;
			case 0x1f0:
				return Valid.POWERPC;
			case 0x1f1:
				return Valid.POWERPCFP;
			case 0x166:
				return Valid.R4000;
			case 0x1a2:
				return Valid.SH3;
			case 0x1a3:
				return Valid.SH3DSP;
			case 0x1a6:
				return Valid.SH4;
			case 0x1a8:
				return Valid.SH5;
			case 0x1c2:
				return Valid.THUMB;
			case 0x169:
				return Valid.WCEMIPSV2;
			default: {
				return null;
			}
		}
	}

	static public final int byteSize = 2;
	public final ByteArray2 code;
}
