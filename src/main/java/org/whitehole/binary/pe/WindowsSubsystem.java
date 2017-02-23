// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.ByteArray2;
import org.whitehole.infra.types.LittleEndianReader;

public class WindowsSubsystem {

	public enum Valid {
		UNKNOWN(0x0),
		NATIVE(0x1),
		WINDOWS_GUI(0x2),
		WINDOWS_CUI(0x3),
		POSIX_CUI(0x7),
		WINDOWS_CE_GUI(0x9),
		EFI_APPLICATION(0xa),
		EFI_BOOT_SERVICE_DRIVER(0xb),
		EFI_RUNTIME_DRIVER(0xc),
		EFI_ROM(0xd),
		XBOX(0xe);

		private Valid(int c) {
			code = c;
		}

		public final int code;

	}
	public WindowsSubsystem(ByteArray2 c) {
		code = c;
	}

	public WindowsSubsystem(Valid v) {
		this(new ByteArray2((byte) ((v.code >> 0) & 0x0ff), (byte) ((v.code >> 8) & 0x0ff)));
	}

	public WindowsSubsystem() {
		this(new ByteArray2());
	}

	public static WindowsSubsystem read(LargeByteBuffer buffer, long offset) {
		return new WindowsSubsystem(LittleEndianReader.readByteArray2(buffer, offset));
	}

	public Valid toValid() {
		switch (((code.getByte1() << 8) | code.getByte0()) & 0x0ffff) {
			case 0x0: return Valid.UNKNOWN;
			case 0x1: return Valid.NATIVE;
			case 0x2: return Valid.WINDOWS_GUI;
			case 0x3: return Valid.WINDOWS_CUI;
			case 0x7: return Valid.POSIX_CUI;
			case 0x9: return Valid.WINDOWS_CE_GUI;
			case 0xa: return Valid.EFI_APPLICATION;
			case 0xb: return Valid.EFI_BOOT_SERVICE_DRIVER;
			case 0xc: return Valid.EFI_RUNTIME_DRIVER;
			case 0xd: return Valid.EFI_ROM;
			case 0xe: return Valid.XBOX;
			default: {
				return null;
			}
		}
	}

	static public final int byteSize = 2;
	public final ByteArray2 code;
}
