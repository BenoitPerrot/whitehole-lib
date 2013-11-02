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

	static public int byteSize(String s) {
		// Consider that s is an ASCII string, and add one for the terminating zero
		return 1 + s.length();
	}
}
