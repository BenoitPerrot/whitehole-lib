// Generated, do not edit by hand
package org.whitehole.binary.pe;

import org.whitehole.infra.io.LargeByteBuffer;
import org.whitehole.infra.types.ByteArray4;
import org.whitehole.infra.types.LittleEndianReader;

public class SectionFlags {

	public SectionFlags(ByteArray4 code) {
		_code = code;
	}

	public SectionFlags() {
		this(new ByteArray4());
	}

	public static SectionFlags read(LargeByteBuffer buffer, long offset) {
		return new SectionFlags(LittleEndianReader.readByteArray4(buffer, offset));
	}

	public boolean getReserved1() {
		return _code.testBit(0);
	}

	public boolean getReserved2() {
		return _code.testBit(1);
	}

	public boolean getReserved3() {
		return _code.testBit(2);
	}

	public boolean getTypeNoPad() {
		return _code.testBit(3);
	}

	public boolean getReserved4() {
		return _code.testBit(4);
	}

	public boolean getCntCode() {
		return _code.testBit(5);
	}

	public boolean getCntInitializedData() {
		return _code.testBit(6);
	}

	public boolean getCntUninitializedData() {
		return _code.testBit(7);
	}

	public boolean getLnkOther() {
		return _code.testBit(8);
	}

	public boolean getLnkInfo() {
		return _code.testBit(9);
	}

	public boolean getReserved5() {
		return _code.testBit(10);
	}

	public boolean getLnkRemove() {
		return _code.testBit(11);
	}

	public boolean getLnkComdat() {
		return _code.testBit(12);
	}

	public boolean getGprel() {
		return _code.testBit(15);
	}

	public boolean getMemPurgeable() {
		return _code.testBit(17);
	}

	public boolean getMem16bit() {
		return _code.testBit(17);
	}

	public boolean getMemLocked() {
		return _code.testBit(18);
	}

	public boolean getMemPreload() {
		return _code.testBit(19);
	}

	public boolean getAlign1bytes() {
		return _code.testBit(20);
	}

	public boolean getAlign2bytes() {
		return _code.testBit(21);
	}

	public boolean getAlign4bytes() {
		return _code.testBit(20) && _code.testBit(21);
	}

	public boolean getAlign8bytes() {
		return _code.testBit(22);
	}

	public boolean getAlign16bytes() {
		return _code.testBit(20) && _code.testBit(22);
	}

	public boolean getAlign32bytes() {
		return _code.testBit(21) && _code.testBit(22);
	}

	public boolean getAlign64bytes() {
		return _code.testBit(20) && _code.testBit(21) && _code.testBit(22);
	}

	public boolean getAlign128bytes() {
		return _code.testBit(23);
	}

	public boolean getAlign256bytes() {
		return _code.testBit(20) && _code.testBit(23);
	}

	public boolean getAlign512bytes() {
		return _code.testBit(21) && _code.testBit(23);
	}

	public boolean getAlign1024bytes() {
		return _code.testBit(20) && _code.testBit(21) && _code.testBit(23);
	}

	public boolean getAlign2048bytes() {
		return _code.testBit(22) && _code.testBit(23);
	}

	public boolean getAlign4096bytes() {
		return _code.testBit(20) && _code.testBit(22) && _code.testBit(23);
	}

	public boolean getAlign8192bytes() {
		return _code.testBit(21) && _code.testBit(22) && _code.testBit(23);
	}

	public boolean getLnkNrelocOvfl() {
		return _code.testBit(24);
	}

	public boolean getMemDiscardable() {
		return _code.testBit(25);
	}

	public boolean getMemNotCached() {
		return _code.testBit(26);
	}

	public boolean getMemNotPaged() {
		return _code.testBit(27);
	}

	public boolean getMemShared() {
		return _code.testBit(28);
	}

	public boolean getMemExecute() {
		return _code.testBit(29);
	}

	public boolean getMemRead() {
		return _code.testBit(30);
	}

	public boolean getMemWrite() {
		return _code.testBit(31);
	}

	public String toHexString(boolean printLeadingZero) {
		return _code.toHexString(printLeadingZero);
	}

	static public final int byteSize = 4;
	private final ByteArray4 _code;
}
