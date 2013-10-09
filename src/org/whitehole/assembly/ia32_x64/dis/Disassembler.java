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

import org.whitehole.assembly.ia32_x64.dom.Mnemonic;
import org.whitehole.assembly.ia32_x64.dom.Modifier;
import org.whitehole.assembly.ia32_x64.dom.OperandType;
import org.whitehole.assembly.ia32_x64.dom.RegisterName;
import org.whitehole.infra.types.Int8;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.UInt64;

public class Disassembler {

	public interface Listener {

		public void startInstruction(Modifier x, Mnemonic m);

		public void appendRegister(RegisterName n, OperandType t);

		public void appendImmediate(Int8 i, OperandType t);
		public void appendImmediate(UInt16 i, OperandType t);
		public void appendImmediate(UInt32 i, OperandType t);
		public void appendImmediate(UInt64 i, OperandType t);

		public void appendSIBAddress(RegisterName base, RegisterName index, int scale, OperandType t);
		public void appendSIBDAddress(RegisterName base, RegisterName index, int scale, Int8 displacement, OperandType t);
		public void appendSIBDAddress(RegisterName base, RegisterName index, int scale, UInt16 displacement, OperandType t);
		public void appendSIBDAddress(RegisterName base, RegisterName index, int scale, UInt32 displacement, OperandType t);

		public void appendAbsoluteAddress(UInt16 offset, OperandType t);
		public void appendAbsoluteAddress(UInt32 offset, OperandType t);
		// public void appendAbsoluteAddress(UInt64 offset, OperandType t);

		public void appendSegmentOffset(UInt16 segmentSelector, UInt16 offset);
		public void appendSegmentOffset(UInt16 segmentSelector, UInt32 offset);
		public void appendSegmentOffset(UInt16 segmentSelector, UInt64 offset);

		public void appendDSRSiAddress(OperandType t);
		public void appendESRDiAddress(OperandType t);

		public void endInstruction();

		public void reportInvalid();
	}

	public enum WorkingMode {
		_16BIT, _32BIT, _64BIT
	}

	public Disassembler(WorkingMode workingMode) {
		setWorkingMode(workingMode);
	}

	public void disassemble(InputStream i, Listener l) throws IOException {

		// Implement I.3.6
		final Prefixes p = Prefixes.read(i, getWorkingMode());
		final Mode m = new Mode(getWorkingMode(), p.getSwitchOperandSize(), p.getSwitchAddressSize(), p.getREXW());

		// Consider AVX-implied leading byes
		if (p.hasImplied0F())
			InstructionDecoder.two_byte(m, p, i, l);
		else if (p.hasImplied0F38())
			InstructionDecoder.three_byte_0x38(m, p, i, l);
		else if (p.hasImplied0F3A())
			InstructionDecoder.three_byte_0x3a(m, p, i, l);
		else
			// FIXME: 2.2.1.7 Default 64-Bit Operand Size
			InstructionDecoder.one_byte(m, p, i, l);
	}

	public void setWorkingMode(WorkingMode workingMode) {
		_workingMode = workingMode;
	}

	public WorkingMode getWorkingMode() {
		return _workingMode;
	}

	private WorkingMode _workingMode;
}
