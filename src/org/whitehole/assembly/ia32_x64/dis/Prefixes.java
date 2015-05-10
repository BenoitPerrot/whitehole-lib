// Copyright (c) 2004-2013, Benoit PERROT.
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
package org.whitehole.assembly.ia32_x64.dis;

import java.io.IOException;
import java.io.InputStream;

import org.whitehole.assembly.ia32_x64.dom.Modifier;

class Prefixes {

	//
	// Legacy

	// Group 1

	private boolean _lock;

	public void setLOCK(boolean b) {
		_lock = b;
	}

	public boolean getLOCK() {
		return _lock;
	}

	private boolean _repne;

	public void setREPNE(boolean b) {
		_repne = b;
	}

	public boolean getREPNE() {
		return _repne;
	}

	private boolean _rep;

	public void setREP(boolean b) {
		_rep = b;
	}

	public boolean getREP() {
		return _rep;
	}

	// Group 2

	public enum SegmentOverride {
		NONE, CS, SS, DS, ES, FS, GS
	};

	private SegmentOverride _segmentOverride;

	public void setSegmentOverride(SegmentOverride o) {
		_segmentOverride = o;
	}

	public SegmentOverride getSegmentOverride() {
		return _segmentOverride;
	}

	public enum BranchHint {
		NONE, BRANCH_NOT_TAKEN, BRANCH_TAKEN
	};

	private BranchHint _branchHint;

	public void setBranchHint(BranchHint h) {
		_branchHint = h;
	}

	public BranchHint getBranchHint() {
		return _branchHint;
	}

	// Group 3

	private boolean _switchOperandSize;

	public void setSwitchOperandSize(boolean b) {
		_switchOperandSize = b;
	}

	public boolean getSwitchOperandSize() {
		return _switchOperandSize;
	}

	// Group 4

	private boolean _switchAddressSize;

	public void setSwitchAddressSize(boolean b) {
		_switchAddressSize = b;
	}

	public boolean getSwitchAddressSize() {
		return _switchAddressSize;
	}

	//
	// REX

	private boolean _REXW = false;

	private void setREXW(boolean REXW) {
		_REXW = REXW;
	}

	public boolean getREXW() {
		return _REXW;
	}

	private boolean _REXR = false;

	private void setREXR(boolean REXR) {
		_REXR = REXR;
	}

	public boolean getREXR() {
		return _REXR;
	}

	private boolean _REXX = false;

	private void setREXX(boolean REXX) {
		_REXX = REXX;
	}

	public boolean getREXX() {
		return _REXX;
	}

	private boolean _REXB = false;

	private void setREXB(boolean REXB) {
		_REXB = REXB;
	}

	public boolean getREXB() {
		return _REXB;
	}

	//
	// VEX

	private boolean _hasImplied0F = false;

	public boolean hasImplied0F() {
		return _hasImplied0F;
	}

	private boolean _hasImplied0F38 = false;

	public boolean hasImplied0F38() {
		return _hasImplied0F38;
	}

	private boolean _hasImplied0F3A = false;

	public boolean hasImplied0F3A() {
		return _hasImplied0F3A;
	}

	private byte _VEXvvvv = 0;

	public byte getVEXvvvv() {
		return _VEXvvvv;
	}

	private boolean _VEXL = false;

	public boolean getVEXL() {
		return _VEXL;
	}

	private boolean _has66 = false;

	public boolean has66() {
		return _has66;
	}

	private boolean _hasF2 = false;

	public boolean hasF2() {
		return _hasF2;
	}

	private boolean _hasF3 = false;

	public boolean hasF3() {
		return _hasF3;
	}

	//
	// Reader

	public static Prefixes read(InputStream i, Disassembler.WorkingMode workingMode) throws IOException {
		final Prefixes p = new Prefixes();

		// Identify legacy prefixes
		boolean isPrefix = true;
		while (isPrefix && 1 <= i.available()) {
			i.mark(1);
			final int c = i.read();
			switch (c) {
			// Group 1
				case 0xF0:
					p.setLOCK(true);
					break;
				case 0xF2:
					p.setREPNE(true);
					p._hasF2 = true;
					break;
				case 0xF3:
					p.setREP(true);
					p._hasF3 = true;
					break;
				// Group 2
				case 0x2E:
					p.setBranchHint(BranchHint.BRANCH_NOT_TAKEN);
					p.setSegmentOverride(SegmentOverride.CS);
					break;
				case 0x36:
					p.setSegmentOverride(SegmentOverride.SS);
					break;
				case 0x3E:
					p.setBranchHint(BranchHint.BRANCH_TAKEN);
					p.setSegmentOverride(SegmentOverride.DS);
					break;
				case 0x26:
					p.setSegmentOverride(SegmentOverride.ES);
					break;
				case 0x64:
					p.setSegmentOverride(SegmentOverride.FS);
					break;
				case 0x65:
					p.setSegmentOverride(SegmentOverride.GS);
					break;
				// Group 3
				case 0x66:
					p.setSwitchOperandSize(true);
					p._has66 = true;
					break;
				// Group 4
				case 0x67:
					p.setSwitchAddressSize(true);
					break;
				default:
					isPrefix = false;
					i.reset();
					break;
			}
		}
		if (workingMode == Disassembler.WorkingMode._64BIT) {
			// Consider REX and VEX prefixes
			i.mark(2);
			final int b0 = i.read();
			if (b0 == 0xC5) {
				final int b1 = i.read();
				if (0 <= b1) {
					p.setREXR((b1 & 0x080) != 0x080); // b1.7 is REX.R in 1's
														// complement (inverted)
														// form
					p._VEXvvvv = (byte) ~(b1 & 0x078); // [b1.6:b1.3]
					p._VEXL = (b1 & 0x4) == 0x04;
					final byte pp = (byte) (b1 & 0x3); // [b2.1:b2.0]
					if (pp == 3)
						p._hasF3 = true;
					else if (pp == 2)
						p._hasF2 = true;
					else if (pp == 1)
						p._has66 = true;
					// FIXME: LOCK, 66, F2, F3 as well as subsequent REX must
					// #UD
				}
			}
			else if (b0 == 0xC4) {
				final int b1 = i.read();
				final int b2 = i.read();
				if (0 <= b1 && 0 <= b2) {
					p.setREXR((b1 & 0x080) != 0x080); // b1.7 is REX.R in 1's
														// complement (inverted)
														// form
					p.setREXX((b1 & 0x040) != 0x040); // b1.6 is REX.X in 1's
														// complement (inverted)
														// form
					p.setREXB((b1 & 0x020) != 0x020); // b1.5 is REX.B in 1's
														// complement (inverted)
														// form
					final byte mmmmm = (byte) (b1 & 0x1F); // [b1.4:b1.0]
					if (mmmmm == 1)
						p._hasImplied0F = true;
					else if (mmmmm == 2)
						p._hasImplied0F38 = true;
					else if (mmmmm == 3)
						p._hasImplied0F3A = true;
					// FIXME: else #UD
					// p._VEXW = ((b1 & 0x080) == 0x080); // b2.7
					p._VEXvvvv = (byte) ~(b2 & 0x078); // [b2.6:b2.3]
					p._VEXL = (b2 & 0x4) == 0x04;
					final byte pp = (byte) (b2 & 0x3); // [b2.1:b2.0]
					if (pp == 3)
						p._hasF3 = true;
					else if (pp == 2)
						p._hasF2 = true;
					else if (pp == 1)
						p._has66 = true;
					// FIXME: LOCK, 66, F2, F3 as well as subsequent REX must
					// #UD
				}
			}
			else if ((b0 & 0xF0) == 0x40) {
				p.setREXW((b0 & 0x08) == 0x08);
				p.setREXR((b0 & 0x04) == 0x04);
				p.setREXX((b0 & 0x02) == 0x02);
				p.setREXB((b0 & 0x01) == 0x01);
			}
			else
				i.reset();
		}
		return p;
	}

	//
	// Converters

	public Modifier toModifier() {
		return new Modifier(_lock, _rep, _repne);
	}
}
