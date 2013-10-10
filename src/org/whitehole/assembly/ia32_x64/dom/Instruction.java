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

public class Instruction {

	public interface Visitor {

		public void visit(Instruction o);
	}

	private final Modifier _x;
	private final Mnemonic _m;
	private final Operand[] _operands;

	public Instruction(Modifier x, Mnemonic m, Operand[] operands) {
		_x = x;
		_m = m;
		_operands = operands;
	}

	public Modifier getModifier() {
		return _x;
	}

	public Mnemonic getMnemonic() {
		return _m;
	}

	public Operand[] getOperands() {
		return _operands;
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public boolean isBranch() {
		return isConditionalBranch() || isUnconditionalBranch();
	}

	public boolean isConditionalBranch() {
		switch (_m) {
			case JA:
			case JAE:
			case JB:
			case JBE:
			case JG:
			case JGE:
			case JL:
			case JLE:
			case JNO:
			case JNP:
			case JNS:
			case JNZ:
			case JO:
			case JP:
			case JRCXZ:
			case JS:
			case JZ:
				return true;
			default:
				return false;
		}
	}

	public boolean isUnconditionalBranch() {
		return _m == Mnemonic.JMP || _m == Mnemonic.RET || _m == Mnemonic.CALL;
	}
}
