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

import org.whitehole.infra.types.BinaryWidth;

class Mode {

	public boolean is32BIT() {
		return _workingMode == Disassembler.WorkingMode._32BIT;
	}

	public boolean is64BIT() {
		return _workingMode == Disassembler.WorkingMode._64BIT;
	}

	private final BinaryWidth _operandSize;

	public BinaryWidth getOperandSize() {
		return _operandSize;
	}

	private final BinaryWidth _addressSize;

	public BinaryWidth getAddressSize() {
		return _addressSize;
	}

	private final Disassembler.WorkingMode _workingMode;

	public Mode(Disassembler.WorkingMode workingMode, boolean switchOperandSize, boolean switchAddressSize, boolean hasREXW) {
		_workingMode = workingMode;
		switch (workingMode) {
			case _16BIT:
				_operandSize = switchOperandSize ? BinaryWidth._32BIT : BinaryWidth._16BIT;
				_addressSize = switchAddressSize ? BinaryWidth._32BIT : BinaryWidth._16BIT;
				break;
			case _32BIT:
				_operandSize = switchOperandSize ? BinaryWidth._16BIT : BinaryWidth._32BIT;
				_addressSize = switchAddressSize ? BinaryWidth._16BIT : BinaryWidth._32BIT;
				break;
			case _64BIT:
				if (hasREXW) {
					// Ignore switchOperandSize
					_operandSize = BinaryWidth._64BIT;
					_addressSize = switchAddressSize ? BinaryWidth._32BIT : BinaryWidth._64BIT;
				}
				else {
					_operandSize = switchOperandSize ? BinaryWidth._16BIT : BinaryWidth._32BIT;
					_addressSize = switchAddressSize ? BinaryWidth._32BIT : BinaryWidth._64BIT;
				}
				break;
			default:
				throw new AssertionError(); // Cannot be there, all cases are covered by the "switch" statement
		}
	}

	//
	// Overrides

	private Mode(Disassembler.WorkingMode workingMode, BinaryWidth operandSize, BinaryWidth addressSize) {
		_workingMode = workingMode;
		_operandSize = operandSize;
		_addressSize = addressSize;
	}

	public static Mode d64(Mode original) {
		// On 64bit mode, default not to 32bit but to 64bit operand size
		if (original._workingMode == Disassembler.WorkingMode._64BIT && original._operandSize == BinaryWidth._32BIT)
			return new Mode(original._workingMode, BinaryWidth._64BIT, original._addressSize);
		else
			return original;
	}

	public static Mode f64(Mode original) {
		return new Mode(original._workingMode, BinaryWidth._64BIT, original._addressSize);
	}
}
