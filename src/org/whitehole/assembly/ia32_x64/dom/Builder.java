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
package org.whitehole.assembly.ia32_x64.dom;

import java.util.LinkedList;

import org.whitehole.assembly.ia32_x64.dis.Disassembler;
import org.whitehole.infra.types.Int8;
import org.whitehole.infra.types.UInt16;
import org.whitehole.infra.types.UInt32;
import org.whitehole.infra.types.UInt64;

public class Builder implements Disassembler.Listener {

	private Modifier _x;
	private Mnemonic _m;
	private LinkedList<Operand> _operands = new LinkedList<Operand>();
	private Instruction _inst;

	public Instruction get() {
		return _inst;
	}

	public void startInstruction(Modifier x, Mnemonic m) {
		_x = x;
		_m = m;
	}

	public void appendRegister(RegisterName n, OperandType t) {
		_operands.add(new Register(n, t));
	}

	public void appendImmediate(Int8 i, OperandType t) {
		_operands.add(new Immediate(i.toBigInteger(), t));
	}

	public void appendImmediate(UInt16 i, OperandType t) {
		_operands.add(new Immediate(i.toBigInteger(), t));
	}

	public void appendImmediate(UInt32 i, OperandType t) {
		_operands.add(new Immediate(i.toBigInteger(), t));
	}

	public void appendImmediate(UInt64 i, OperandType t) {
		_operands.add(new Immediate(i.toBigInteger(), t));
	}

	public void appendSIBAddress(RegisterName base, RegisterName index, int scale, OperandType t) {
		_operands.add(new SIBAddress(base, index, scale, t));
	}

	public void appendSIBDAddress(RegisterName base, RegisterName index, int scale, Int8 displacement, OperandType t) {
		_operands.add(new SIBDAddress(base, index, scale, displacement.toBigInteger(), t));
	}

	public void appendSIBDAddress(RegisterName base, RegisterName index, int scale, UInt16 displacement, OperandType t) {
		_operands.add(new SIBDAddress(base, index, scale, displacement.toBigInteger(), t));
	}

	public void appendSIBDAddress(RegisterName base, RegisterName index, int scale, UInt32 displacement, OperandType t) {
		_operands.add(new SIBDAddress(base, index, scale, displacement.toBigInteger(), t));
	}

	public void appendAbsoluteAddress(UInt16 offset, OperandType t) {
		_operands.add(new AbsoluteAddress(offset.toBigInteger(), t));
	}

	public void appendAbsoluteAddress(UInt32 offset, OperandType t) {
		_operands.add(new AbsoluteAddress(offset.toBigInteger(), t));
	}

	public void appendSegmentOffset(UInt16 segmentSelector, UInt16 offset) {
		_operands.add(new SegmentOffset(segmentSelector, offset.toBigInteger()));
	}

	public void appendSegmentOffset(UInt16 segmentSelector, UInt32 offset) {
		_operands.add(new SegmentOffset(segmentSelector, offset.toBigInteger()));
	}

	public void appendSegmentOffset(UInt16 segmentSelector, UInt64 offset) {
		_operands.add(new SegmentOffset(segmentSelector, offset.toBigInteger()));
	}

	public void appendDSRSiAddress(OperandType t) {
		_operands.add(new DSRSiAddress(t));
	}

	public void appendESRDiAddress(OperandType t) {
		_operands.add(new ESRDiAddress(t));
	}

	public void endInstruction() {
		commit(_m);
	}

	public void reportInvalid() {
		commit(Mnemonic.INVALID);
	}

	private void commit(Mnemonic m) {
		final Operand[] a = new Operand[_operands.size()];
		_inst = new Instruction(_x, m, _operands.toArray(a));
		// Clear
		_m = Mnemonic.INVALID;
		_operands.clear();
	}
}
