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

import org.whitehole.assembly.ia32_x64.dom.OperandType;
import org.whitehole.assembly.ia32_x64.dom.RegisterName;
import org.whitehole.infra.types.BinaryWidth;
import org.whitehole.infra.types.LittleEndianReader;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.UInt64;

class OperandDecoder {

	// Operand types

	static OperandType a(BinaryWidth w) {
		return w == BinaryWidth._16BIT ? OperandType.TWO_ONE_WORD : OperandType.TWO_DOUBLEWORD;
	}

	static OperandType p(BinaryWidth w) {
		return w == BinaryWidth._16BIT ? OperandType.POINTER_32BIT : w == BinaryWidth._32BIT ? OperandType.POINTER_48BIT : OperandType.POINTER_80BIT;
	}

	static OperandType pd(BinaryWidth w) {
		return w == BinaryWidth._128BIT ? OperandType.PACKED_DOUBLE_128BIT : OperandType.PACKED_DOUBLE_256BIT; // FIXME: wrong test
	}

	static OperandType ps(BinaryWidth w) {
		return w == BinaryWidth._128BIT ? OperandType.PACKED_SINGLE_128BIT : OperandType.PACKED_SINGLE_256BIT; // FIXME: wrong test
	}

	static OperandType s(BinaryWidth w) {
		return w == BinaryWidth._16BIT ? OperandType.PSEUDO_DESCRIPTOR_6BYTE : OperandType.PSEUDO_DESCRIPTOR_10BYTE;
	}

	static OperandType v(BinaryWidth w) {
		switch (w) {
		case _16BIT:
			return OperandType.WORD;
		case _32BIT:
			return OperandType.DOUBLEWORD;
		case _64BIT:
			return OperandType.QUADWORD;
		default:
			return null; // Should not be there
		}
	}

	static OperandType x(BinaryWidth w) {
		if (w == BinaryWidth._64BIT) // FIXME: check: 128/256 instead?
			return OperandType.DOUBLE_QUADWORD;
		else
			return OperandType.QUAD_QUADWORD;
	}
	
	static OperandType y(BinaryWidth w) {
		if (w == BinaryWidth._64BIT)
			return OperandType.QUADWORD;
		else
			return OperandType.DOUBLEWORD;
	}

	static OperandType z(BinaryWidth w) {
		switch (w) {
		case _16BIT:
			return OperandType.WORD;
		case _32BIT:
		case _64BIT:
			return OperandType.DOUBLEWORD;
		default:
			return null; // Should not be there
		}
	}

	// ------------------------------------------------------------------------

	// TODO: have an immediate union composing a large integer and a width
	static void appendImmediate(Disassembler.Listener b, OperandType t, InputStream i) throws IOException {
		final BinaryWidth w = OperandType.toBinaryWidth(t);
		switch (w) {
		case _8BIT: {
			b.appendImmediate(LittleEndianReader.readInt8(i), t);
			break;
		}

		case _16BIT: {
			b.appendImmediate(LittleEndianReader.readUInt16(i), t);
			break;
		}

		case _32BIT: {
			b.appendImmediate(LittleEndianReader.readUInt32(i), t);
			break;
		}

		case _64BIT: {
			b.appendImmediate(LittleEndianReader.readUInt64(i), t);
			break;
		}

		case _128BIT:
			break;
		}
	}

	static void appendSIBDAddress(Mode m, Prefixes p, ModRM mrm, Disassembler.Listener b, OperandType t, InputStream i) throws IOException {
		RegisterName base = null;
		RegisterName index = null;
		BinaryWidth displacementWidth = null;

		int scale = 0;

		switch (m.getAddressSize()) {
		case _16BIT: { // 16 bit addressing forms with the ModR/M byte

			assert (mrm.mod() != 3);

			if (mrm.mod() == 1)
				displacementWidth = BinaryWidth._8BIT;
			else if (mrm.mod() == 2)
				displacementWidth = BinaryWidth._16BIT;

			switch (mrm.rm()) {
			case 0:
				base = RegisterName.BX;
				index = RegisterName.SI;
				break;
			case 1:
				base = RegisterName.BX;
				index = RegisterName.DI;
				break;
			case 2:
				base = RegisterName.BP;
				index = RegisterName.SI;
				break;
			case 3:
				base = RegisterName.BP;
				index = RegisterName.DI;
				break;
			case 4:
				base = RegisterName.SI;
				break;
			case 5:
				base = RegisterName.DI;
				break;
			case 6: // disp16
				if (mrm.mod() == 0)
					displacementWidth = BinaryWidth._16BIT;
				else
					base = RegisterName.BP;
				break;
			case 7:
				base = RegisterName.BX;
				break;
			}

			break;
		}

		case _32BIT:
		case _64BIT: {
			assert (mrm.mod() != 3);

			if (mrm.mod() == 0 && mrm.rm() == 5)
				displacementWidth = BinaryWidth._32BIT;
			else {
				if (mrm.mod() == 1)
					displacementWidth = BinaryWidth._8BIT;
				else if (mrm.mod() == 2)
					displacementWidth = BinaryWidth._32BIT;

				//
				if (mrm.rm() == 4) { // SIB follows
					final ScaleIndexBase sib = new ScaleIndexBase(LittleEndianReader.readUInt8(i));

					// Scaled index
					if (sib.getIndex() != 4) {
						scale = (1 << sib.getScale()) & ~1;

						final int Xxxx = sib.getIndex() | (p.getREXX() ? 0x08 : 0x0);
						index = RegisterName.GPR32(Xxxx);
					}

					// Base
					if (sib.getBase() == 5) {
						if (mrm.mod() == 0)
							displacementWidth = BinaryWidth._32BIT;
						else
							base = m.is32BIT() ? RegisterName.EBP : RegisterName.RBP;
					} else {
						final int Bbbb = sib.getBase() | (p.getREXB() ? 0x08 : 0x0);
						base = m.is32BIT() ? RegisterName.GPR32(Bbbb) : RegisterName.GPR64(Bbbb);
					}
				} else { // No SIB byte
					final int Bbbb = mrm.rm() | (p.getREXB() ? 0x08 : 0x0);
					base = m.is32BIT() ? RegisterName.GPR32(Bbbb) : RegisterName.GPR64(Bbbb);
				}
			}

			break;
		}

		default:
			assert (false); // Should not be there
			break;
		}

		// FIXME: when in 64bit, sign-extend displacement

		// Consider displacement if any, then commit
		if (displacementWidth == null)
			b.appendSIBAddress(base, index, scale, t);
		else
			switch (displacementWidth) {
			case _8BIT: {
				b.appendSIBDAddress(base, index, scale, LittleEndianReader.readInt8(i), t);
				break;
			}

			case _16BIT: {
				b.appendSIBDAddress(base, index, scale, LittleEndianReader.readUInt16(i), t);
				break;
			}

			case _32BIT: {
				b.appendSIBDAddress(base, index, scale, LittleEndianReader.readUInt32(i), t);
				break;
			}

			default:
				assert (false);
				break;
			}
	}

	// Addressing modes

	static void Ap(Mode m, InputStream i, Disassembler.Listener b) throws IOException {
		switch (m.getOperandSize()) {
		case _16BIT: {
			final UInt16 offset = LittleEndianReader.readUInt16(i);
			final UInt16 segment = LittleEndianReader.readUInt16(i);
			b.appendSegmentOffset(segment, offset);
			break;
		}

		case _32BIT: {
			final UInt32 offset = LittleEndianReader.readUInt32(i);
			final UInt16 segment = LittleEndianReader.readUInt16(i);
			b.appendSegmentOffset(segment, offset);
			break;
		}

		case _64BIT: {
			final UInt64 offset = LittleEndianReader.readUInt64(i);
			final UInt16 segment = LittleEndianReader.readUInt16(i);
			b.appendSegmentOffset(segment, offset);
			break;
		}

		default:
			throw new AssertionError(); // Should not be there
		}
	}

	static void B(Prefixes p, OperandType t, Disassembler.Listener b) {
		// FIXME: The VEX.vvvv field of the VEX prefix selects a general purpose register
	}

	static void Cd(Mode m, Prefixes p, ModRM mrm, Disassembler.Listener b) {
		if (m.is64BIT())
			b.appendRegister(RegisterName.Control((p.getREXR() ? 0x08 : 0) | mrm.reg()), OperandType.QUADWORD);
		else
			b.appendRegister(RegisterName.Control(mrm.reg()), OperandType.DOUBLEWORD);
	}

	static void Dd(Mode m, Prefixes p, ModRM mrm, Disassembler.Listener b) {
		if (m.is64BIT())
			b.appendRegister(RegisterName.Debug((p.getREXR() ? 0x08 : 0) | mrm.reg()), OperandType.QUADWORD);
		else
			b.appendRegister(RegisterName.Debug(mrm.reg()), OperandType.DOUBLEWORD);
	}

	static void E(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3) {
			BinaryWidth w = null;
			switch (t) {
			case BYTE:
				w = BinaryWidth._8BIT;
				break;
			case WORD:
				w = BinaryWidth._16BIT;
				break;
			case DOUBLEWORD:
				w = BinaryWidth._32BIT;
				break;
			case QUADWORD:
				w = BinaryWidth._64BIT;
				break;
			case DOUBLE_QUADWORD:
				w = BinaryWidth._128BIT;
				break;
			case POINTER_32BIT:
				w = BinaryWidth._16BIT;
				break;
			case POINTER_48BIT:
				w = BinaryWidth._32BIT;
				break;
			case POINTER_80BIT:
				w = BinaryWidth._64BIT;
				break;
			default:
				assert (false);
			}
			b.appendRegister(RegisterName.GPR(w, (p.getREXB() ? 0x08 : 0) | mrm.rm()), t);
		} else
			appendSIBDAddress(m, p, mrm, b, t, i);
	}

	static void Fv(Mode m, Disassembler.Listener b) {
		b.appendRegister(RegisterName.FLAGS, v(m.getOperandSize()));
	}

	static void G(Mode m, Prefixes p, ModRM mrm, OperandType t, Disassembler.Listener b) {
		b.appendRegister(RegisterName.GPR(OperandType.toBinaryWidth(t), (p.getREXR() ? 0x08 : 0) | mrm.reg()), t);
	}

	static void H(Prefixes p, OperandType t, Disassembler.Listener b) {
		final boolean isLegacySSE = true;
		if (!isLegacySSE) {
			// The VEX.vvvv field of the VEX prefix selects a 128-bit XMM register or a
			// 256-bit YMM register, determined by operand type.
		}
		// For legacy SSE encodings this operand does not exist, changing the instruction to destructive form.
	}

	static void I(InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		appendImmediate(b, t, i);
	}

	static void J(InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		// Same implementation as I, only use differs
		appendImmediate(b, t, i);
	}

	static void L(InputStream i, OperandType t, Disassembler.Listener b) {
		// The upper 4 bits of the 8-bit immediate selects a 128-bit XMM register or
		// a
		// 256-bit YMM register, determined by operand type. (the MSB is ignored in
		// 32-bit mode)
	}
	
	//
	// FIXME: check operand reader below this point
	//

	static void M(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3) // ModR/M byte may refer only to memory
			b.reportInvalid(); // TODO: be more specific
		else
			appendSIBDAddress(m, p, mrm, b, t, i);
	}

	static void Nq(ModRM mrm, Disassembler.Listener b) {
		b.appendRegister(RegisterName.MMX(mrm.rm()), OperandType.QUADWORD); // FIXME:
																			// PACKED_QUADWORD
																			// says
																			// the
																			// doc
	}

	static void Ob(Mode m, InputStream i, Disassembler.Listener b) throws IOException {
		O(m, i, OperandType.BYTE, b);
	}

	static void Ov(Mode m, InputStream i, Disassembler.Listener b) throws IOException {
		O(m, i, v(m.getOperandSize()), b);
	}

	static void O(Mode m, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		switch (m.getAddressSize()) {

		case _16BIT: {
			b.appendAbsoluteAddress(LittleEndianReader.readUInt16(i), t);
			break;
		}

		case _32BIT: {
			b.appendAbsoluteAddress(LittleEndianReader.readUInt32(i), t);
			break;
		}

		// case _64BIT: { doc says "word or double word", does not speak about
		// "quad word"
		// b.appendAbsoluteAddress(new LittleEndianReader(i).readUInt64());
		// break;
		// }

		default:
			throw new AssertionError();
		}
	}
	
	static void P(ModRM mrm, OperandType t, Disassembler.Listener b) {
		b.appendRegister(RegisterName.MMX(mrm.reg()), t);
	}

	static void Q(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3)
			b.appendRegister(RegisterName.MMX(mrm.rm()), t);
		else
			appendSIBDAddress(m, p, mrm, b, t, i);
	}

	static void R(ModRM mrm, OperandType t, Disassembler.Listener b) {
		if (mrm.mod() == 3)
			b.appendRegister(RegisterName.GPR32(mrm.rm()), t);
		else
			b.reportInvalid(); // TODO: be more specific
	}

	static void Rd(ModRM mrm, Disassembler.Listener b) {
		R(mrm, OperandType.DOUBLEWORD, b);
	}

	private static void Rd_M(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3)
			b.appendRegister(RegisterName.GPR32(mrm.rm()), OperandType.DOUBLEWORD); // Rd
		else
			appendSIBDAddress(m, p, mrm, b, t, i);
	}

	static void Rd_Mb(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Rd_M(m, p, mrm, i, OperandType.BYTE, b);
	}

	static void Rd_Mw(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Rd_M(m, p, mrm, i, OperandType.WORD, b);
	}
	
	private static void Ry_M(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3)
			b.appendRegister(RegisterName.GPR32(mrm.rm()), y(m.getOperandSize()));
		else
			appendSIBDAddress(m, p, mrm, b, t, i);
	}
	
	static void Ry_Mb(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Ry_M(m, p, mrm, i, OperandType.BYTE, b);
	}

	static void Ry_Mw(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Ry_M(m, p, mrm, i, OperandType.WORD, b);
	}

	static void Sw(ModRM mrm, Disassembler.Listener b) {
		b.appendRegister(RegisterName.Segment(mrm.reg()), OperandType.WORD);
	}

	static void U(ModRM mrm, OperandType t, Disassembler.Listener b) {
		b.appendRegister(RegisterName.XMM(mrm.rm()), t);
	}

	private static void Udq_M(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3)
			b.appendRegister(RegisterName.XMM(mrm.rm()), OperandType.DOUBLE_QUADWORD); // Udq
		else
			appendSIBDAddress(m, p, mrm, b, t, i); // M
	}

	static void Udq_Mq(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Udq_M(m, p, mrm, i, OperandType.QUADWORD, b);
	}

	static void Udq_Md(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Udq_M(m, p, mrm, i, OperandType.DOUBLEWORD, b);
	}

	private static void Ux_M(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3)
			b.appendRegister(RegisterName.XMM(mrm.rm()), x(m.getOperandSize()));
		else
			appendSIBDAddress(m, p, mrm, b, t, i); // M
	}
	
	static void Ux_Md(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Ux_M(m, p, mrm, i, OperandType.DOUBLEWORD, b);
	}

	static void Ux_Mq(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Ux_M(m, p, mrm, i, OperandType.QUADWORD, b);
	}

	static void Ux_Mw(Mode m, Prefixes p, ModRM mrm, InputStream i, Disassembler.Listener b) throws IOException {
		Ux_M(m, p, mrm, i, OperandType.WORD, b);
	}

	static void V(ModRM mrm, OperandType t, Disassembler.Listener b) {
		b.appendRegister(RegisterName.XMM(mrm.reg()), t);
		// FIXME: or YMM, following operand type
	}

	static void W(Mode m, Prefixes p, ModRM mrm, InputStream i, OperandType t, Disassembler.Listener b) throws IOException {
		if (mrm.mod() == 3) {
			b.appendRegister(RegisterName.XMM(mrm.rm()), t);
			// FIXME: or YMM, following operand type
		} else
			appendSIBDAddress(m, p, mrm, b, t, i);
	}

	static void X(OperandType t, Disassembler.Listener b) {
		// Xb = PrintingJsonEmitter (BinaryWidth._8BIT)
		// Xv = PrintingJsonEmitter
		// Xz = PrintingJsonEmitter (m.getOperandSize() == BinaryWidth._16BIT ?
		// BinaryWidth._16BIT :
		// BinaryWidth._32BIT) // (32 and 64 operand_size)
		b.appendDSRSiAddress(t);
	}

	static void Y(OperandType t, Disassembler.Listener b) {
		// Yb = Y (BinaryWidth._8BIT)
		// Yv = Y
		// Yz = Y (m.getOperandSize() == BinaryWidth._16BIT ?
		// BinaryWidth._16BIT :
		// BinaryWidth._32BIT) // (32 and 64 operand_size)
		b.appendESRDiAddress(t);
	}

	//
	// Immediate

	static void _1(Disassembler.Listener b) {
		b.appendImmediate(new UInt32((byte) 0, (byte) 0, (byte) 0, (byte) 1), OperandType.DOUBLEWORD);
	}

	//
	// Register codes (II-B:A.2.3)

	//

	static void AL(Disassembler.Listener b) {
		b.appendRegister(RegisterName.AL, OperandType.BYTE);
	}

	static void CL(Disassembler.Listener b) {
		b.appendRegister(RegisterName.CL, OperandType.BYTE);
	}

	static void AX(Disassembler.Listener b) {
		b.appendRegister(RegisterName.AX, OperandType.WORD);
	}

	static void DX(Disassembler.Listener b) {
		b.appendRegister(RegisterName.DX, OperandType.WORD);
	}

	static void CS(Disassembler.Listener b) {
		b.appendRegister(RegisterName.CS, OperandType.WORD);
	}

	static void DS(Disassembler.Listener b) {
		b.appendRegister(RegisterName.DS, OperandType.WORD);
	}

	static void ES(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ES, OperandType.WORD);
	}

	static void FS(Disassembler.Listener b) {
		b.appendRegister(RegisterName.FS, OperandType.WORD);
	}

	static void GS(Disassembler.Listener b) {
		b.appendRegister(RegisterName.GS, OperandType.WORD);
	}

	static void SS(Disassembler.Listener b) {
		b.appendRegister(RegisterName.SS, OperandType.WORD);
	}

	static void ST0(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST0, OperandType.EXTENDED_FLOAT);
	}

	static void ST1(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST1, OperandType.EXTENDED_FLOAT);
	}

	static void ST2(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST2, OperandType.EXTENDED_FLOAT);
	}

	static void ST3(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST3, OperandType.EXTENDED_FLOAT);
	}

	static void ST4(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST4, OperandType.EXTENDED_FLOAT);
	}

	static void ST5(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST5, OperandType.EXTENDED_FLOAT);
	}

	static void ST6(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST6, OperandType.EXTENDED_FLOAT);
	}

	static void ST7(Disassembler.Listener b) {
		b.appendRegister(RegisterName.ST7, OperandType.EXTENDED_FLOAT);
	}

	//

	static void ALr8b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R8B : RegisterName.AL, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void CLr9b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R9B : RegisterName.CL, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void DLr10b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R10B : RegisterName.DL, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void BLr11b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R11B : RegisterName.BL, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void AHr12b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R12B : RegisterName.AH, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void CHr13b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R13B : RegisterName.CH, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void DHr14b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R14B : RegisterName.DH, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void BHr15b(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(p.getREXB() ? RegisterName.R15B : RegisterName.BH, OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	//

	static void rAXr8(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rAXr8(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rAXr8(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R8W : RegisterName.AX;
		case _32BIT:
			return p.getREXB() ? RegisterName.R8D : RegisterName.EAX;
		case _64BIT:
			return p.getREXB() ? RegisterName.R8 : RegisterName.RAX;
		default:
			throw new AssertionError();
		}
	}

	static void rCXr9(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rCXr9(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rCXr9(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R9W : RegisterName.CX;
		case _32BIT:
			return p.getREXB() ? RegisterName.R9D : RegisterName.ECX;
		case _64BIT:
			return p.getREXB() ? RegisterName.R9 : RegisterName.RCX;
		default:
			throw new AssertionError();
		}
	}
	
	static void rDX(Mode m, Disassembler.Listener b) {
		// FIXME: b.appendRegister(rDXr10(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static void rDXr10(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rDXr10(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rDXr10(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R10W : RegisterName.DX;
		case _32BIT:
			return p.getREXB() ? RegisterName.R10D : RegisterName.EDX;
		case _64BIT:
			return p.getREXB() ? RegisterName.R10 : RegisterName.RDX;
		default:
			throw new AssertionError();
		}
	}

	static void rBXr11(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rBXr11(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rBXr11(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R11W : RegisterName.BX;
		case _32BIT:
			return p.getREXB() ? RegisterName.R11D : RegisterName.EBX;
		case _64BIT:
			return p.getREXB() ? RegisterName.R11 : RegisterName.RBX;
		default:
			throw new AssertionError();
		}
	}

	static void rSPr12(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rSPr12(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rSPr12(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R12W : RegisterName.SP;
		case _32BIT:
			return p.getREXB() ? RegisterName.R12D : RegisterName.ESP;
		case _64BIT:
			return p.getREXB() ? RegisterName.R12 : RegisterName.RSP;
		default:
			throw new AssertionError();
		}
	}

	static void rBPr13(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rBPr13(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rBPr13(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R13W : RegisterName.BP;
		case _32BIT:
			return p.getREXB() ? RegisterName.R13D : RegisterName.EBP;
		case _64BIT:
			return p.getREXB() ? RegisterName.R13 : RegisterName.RBP;
		default:
			throw new AssertionError();
		}
	}

	static void rSIr14(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rSIr14(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rSIr14(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R14W : RegisterName.SI;
		case _32BIT:
			return p.getREXB() ? RegisterName.R14D : RegisterName.ESI;
		case _64BIT:
			return p.getREXB() ? RegisterName.R14 : RegisterName.RSI;
		default:
			throw new AssertionError();
		}
	}

	static void rDIr15(Mode m, Prefixes p, Disassembler.Listener b) {
		b.appendRegister(rDIr15(m, p), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rDIr15(Mode m, Prefixes p) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return p.getREXB() ? RegisterName.R15W : RegisterName.DI;
		case _32BIT:
			return p.getREXB() ? RegisterName.R15D : RegisterName.EDI;
		case _64BIT:
			return p.getREXB() ? RegisterName.R15 : RegisterName.RDI;
		default:
			throw new AssertionError();
		}
	}

	//

	static void rAX(Mode m, Disassembler.Listener b) {
		b.appendRegister(rAX(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName rAX(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.AX;
		case _32BIT:
			return RegisterName.EAX;
		case _64BIT:
			return RegisterName.RAX;
		default:
			throw new AssertionError();
		}
	}

	static void eAX(Mode m, Disassembler.Listener b) {
		b.appendRegister(eAX(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eAX(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.AX;
		case _32BIT:
			return RegisterName.EAX;
		default:
			throw new AssertionError();
		}
	}

	static void eCX(Mode m, Disassembler.Listener b) {
		b.appendRegister(eCX(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eCX(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.CX;
		case _32BIT:
			return RegisterName.ECX;
		default:
			throw new AssertionError();
		}
	}

	static void eDX(Mode m, Disassembler.Listener b) {
		b.appendRegister(eDX(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eDX(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.DX;
		case _32BIT:
			return RegisterName.EDX;
		default:
			throw new AssertionError();
		}
	}

	static void eBX(Mode m, Disassembler.Listener b) {
		b.appendRegister(eBX(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eBX(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.BX;
		case _32BIT:
			return RegisterName.EBX;
		default:
			throw new AssertionError();
		}
	}

	static void eSP(Mode m, Disassembler.Listener b) {
		b.appendRegister(eSP(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eSP(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.SP;
		case _32BIT:
			return RegisterName.ESP;
		default:
			throw new AssertionError();
		}
	}

	static void eBP(Mode m, Disassembler.Listener b) {
		b.appendRegister(eBP(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eBP(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.BP;
		case _32BIT:
			return RegisterName.EBP;
		default:
			throw new AssertionError();
		}
	}

	static void eSI(Mode m, Disassembler.Listener b) {
		b.appendRegister(eSI(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eSI(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.SI;
		case _32BIT:
			return RegisterName.ESI;
		default:
			throw new AssertionError();
		}
	}

	static void eDI(Mode m, Disassembler.Listener b) {
		b.appendRegister(eDI(m), OperandType.fromBinaryWidth(m.getOperandSize()));
	}

	static RegisterName eDI(Mode m) {
		switch (m.getOperandSize()) {
		case _16BIT:
			return RegisterName.DI;
		case _32BIT:
			return RegisterName.EDI;
		default:
			throw new AssertionError();
		}
	}

}
