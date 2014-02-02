// Copyright (c) 2004-2014, Benoit PERROT.
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
package org.whitehole.assembly.ia32_x64.control;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

import org.whitehole.assembly.ia32_x64.control.Trace.EntryReason;
import org.whitehole.assembly.ia32_x64.control.Trace.ExitReason;
import org.whitehole.assembly.ia32_x64.dom.Immediate;
import org.whitehole.assembly.ia32_x64.dom.Instruction;
import org.whitehole.assembly.ia32_x64.dom.InstructionBuffer;
import org.whitehole.assembly.ia32_x64.dom.Mnemonic;
import org.whitehole.assembly.ia32_x64.dom.Operand;

public class TraceBuilder {

	private final boolean _followCall;

	public TraceBuilder(boolean followCall) {
		_followCall = followCall;
	}

	private static Immediate getUniqueOperandAsImmediate(Instruction i) {
		if (i.getOperands().length == 1) {
			final Operand o0 = i.getOperands()[0];
			if (o0 instanceof Immediate)
				return (Immediate) o0;
		}
		return null;
	}

	private boolean isBranching(Instruction i) {
		return i.isBranch() && (i.getMnemonic() != Mnemonic.CALL || _followCall);
	}

	public Trace build(InstructionBuffer input, long entryPoint) throws IOException {
		final Trace t = new Trace();

		final LinkedList<Long> offsetsToExplore = new LinkedList<Long>();

		offsetsToExplore.add(entryPoint);
		t.addEntryPoint(null, entryPoint, EntryReason.START);

		final HashSet<Long> exploredOffsets = new HashSet<Long>();
		while (!offsetsToExplore.isEmpty()) {
			final long start = offsetsToExplore.remove();

			// Actual content of previously disassembled
			// instructions may have been invalid,
			// start could be off bounds
			if (0 <= start && start < input.capacity()) {
				input.position(start);

				while (!exploredOffsets.contains(input.position()) && input.hasRemaining()) {

					final long before = input.position();
					final Instruction i = input.get();
					final long after = input.position();

					t.addInstruction(before, after - before, i);
					exploredOffsets.add(before);

					if (isBranching(i)) {
						// If possible, compute destination as a delta to current position
						Long destination = null;
						if (i.getMnemonic() != Mnemonic.RET) {
							final Immediate imm = getUniqueOperandAsImmediate(i);
							if (imm != null) {
								// FIXME: interpret as a signed value,
								// i.e. sign extend it for 64 bit
								destination = after + imm.getSignedInteger().intValue();
							}
						}

						// Document reasons to jump
						final ExitReason reasonToExit;
						final EntryReason reasonToContinue;
						if (i.getMnemonic() == Mnemonic.CALL) {
							reasonToExit = ExitReason.TO_SUB;
							reasonToContinue = EntryReason.FROM_SUB;
						}
						else {
							reasonToExit = i.getMnemonic() == Mnemonic.RET ? ExitReason.END : i.isConditionalBranch() ? ExitReason.TEST_IS_TRUE : ExitReason.ALWAYS;
							reasonToContinue = i.isConditionalBranch() ? EntryReason.TEST_IS_FALSE : null;
						}

						// Report an exit point
						t.addExitPoint(after, destination, reasonToExit); // WAS: l.addBranch(after, destination, reasonToExit)

						// <<
						if (destination != null)
							offsetsToExplore.add(destination);
						// >>

						// If there is a reason to continue,
						if (reasonToContinue != null) {
							// Report a re-entry point
							t.addEntryPoint(after, after, reasonToContinue); // WAS: l.addBranch(after, after, reasonToContinue)

							// And do continue

							// <<
							offsetsToExplore.add(after);
							// >>
						}
						else
							break;
					}
				}
			}
		}

		return t;
	}
}
