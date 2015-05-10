package org.whitehole.infra.types;

import org.whitehole.infra.io.LargeByteBuffer;

public class StringAsciiz {

	static public String read(LargeByteBuffer buffer, long offset) {
		final StringBuilder sb = new StringBuilder();
		// Search for null termination
		while (buffer.get(offset) != 0) {
			sb.append((char) buffer.get(offset));
			++offset;
		}

		return sb.toString();
	}

	static public String readLittleEndian(ByteArray8 x) {
		StringBuilder sb = new StringBuilder();
		if (x.getByte0() != 0) {
			sb.append((char) x.getByte0());
			if (x.getByte1() != 0) {
				sb.append((char) x.getByte1());
				if (x.getByte2() != 0) {
					sb.append((char) x.getByte2());
					if (x.getByte3() != 0) {
						sb.append((char) x.getByte3());
						if (x.getByte4() != 0) {
							sb.append((char) x.getByte4());
							if (x.getByte5() != 0) {
								sb.append((char) x.getByte5());
								if (x.getByte6() != 0) {
									sb.append((char) x.getByte6());
									if (x.getByte7() != 0)
										sb.append((char) x.getByte7());
								}
							}
						}
					}
				}
			}
		}
		return sb.toString();
	}

	static public int byteSize(String s) {
		// Consider that s is an ASCII string, and add one for the terminating zero
		return 1 + s.length();
	}
}
