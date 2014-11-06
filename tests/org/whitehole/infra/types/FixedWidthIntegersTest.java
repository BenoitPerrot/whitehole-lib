package org.whitehole.infra.types;

import java.math.BigInteger;
import java.util.logging.Logger;

import org.junit.Test;


public class FixedWidthIntegersTest {

	private static byte[] readByteArray2(byte[] a, boolean isSigned) {
		if (!isSigned)
			if ((a[1] & 0x80) == 0x80)
				return new byte[] { 0, a[1], a[0] };
		return new byte[] { a[1], a[0] };
	}

	private static BigInteger readUInt16(byte[] a) {
		return new BigInteger(readByteArray2(a, false));
	}

	private static BigInteger readInt16(byte[] a) {
		return new BigInteger(readByteArray2(a, true));
	}

	private static void dump(BigInteger x) {
		Logger.getAnonymousLogger().info(Long.toString(x.longValue()));
		Logger.getAnonymousLogger().info("bitLength: " + Integer.toString(x.bitLength()));
		Logger.getAnonymousLogger().info("signum: " + Integer.toString(x.signum()));
	}

	@Test
	public void test() {
		final byte[] a = new byte[] { (byte) 0x42, (byte) 0x80, (byte) 0x42, (byte) 0x80 };
		dump(readUInt16(a));
		dump(readInt16(a));
	}

}
