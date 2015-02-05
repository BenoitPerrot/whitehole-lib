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

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import org.whitehole.assembly.ia32_x64.dom.Instruction;

class Trace {

	public enum BranchReason {
		END, TO_SUB, TEST_IS_TRUE, ALWAYS,
		START, FROM_SUB, TEST_IS_FALSE
	}

	private final TreeSet<Long> _entryPoints = new TreeSet<>();
	private final TreeSet<Long> _exitPoints = new TreeSet<>();

	public static class MotivatedPoint {

		private final Long _destination;
		private final BranchReason _r;

		public MotivatedPoint(Long destination, BranchReason r) {
			_destination = destination;
			_r = r;
		}

		public Long getPoint() {
			return _destination;
		}

		public BranchReason getReason() {
			return _r;
		}
	}

	private final TreeMap<Long, ArrayList<MotivatedPoint>> _branches = new TreeMap<>();

	private final TreeMap<Long, Instruction> _offsetToInstruction = new TreeMap<>();

	public Trace addInstruction(long offset, long size, Instruction i) {
		_offsetToInstruction.put(offset, i);
		// if (i.getMnemonic() == Mnemonic.CALL) {
		// _functionOffsets.add(offset + size + getUniqueOperandAsImmediate(i).getSignedInteger().intValue());
		// }
		return this;
	}

	private void addBranch(long exitPoint, Long entryPoint, BranchReason r) {
		ArrayList<MotivatedPoint> l = _branches.get(exitPoint);
		if (l == null) {
			l = new ArrayList<>();
			_branches.put(exitPoint, l);
		}
		l.add(new MotivatedPoint(entryPoint, r));
	}

	public Trace addEntryPoint(Long exitPoint, long entryPoint, BranchReason r) {
		// TODO: keep track of starting points (r is START, exitPoint is null)
		if (exitPoint != null) {
			addBranch(exitPoint, entryPoint, r);
			_exitPoints.add(exitPoint);
		}
		_entryPoints.add(entryPoint);
		return this;
	}

	public Trace addExitPoint(long exitPoint, Long entryPoint, BranchReason r) {
		addBranch(exitPoint, entryPoint, r);
		if (entryPoint != null)
			_entryPoints.add(entryPoint);
		_exitPoints.add(exitPoint);
		return this;
	}

	public ArrayList<MotivatedPoint> getDestinationsAt(long offset) {
		return _branches.get(offset);
	}

	public Entry<Long, Instruction> getOffsetInstructionAt(long offset) {
		final Entry<Long, Instruction> e = _offsetToInstruction.floorEntry(offset);
		return (e != null && e.getKey() == offset) ? e : null;
	}

	public Entry<Long, Instruction> getOffsetInstructionAfter(long offset) {
		return _offsetToInstruction.higherEntry(offset);
	}

	public Iterable<Long> entryPoints() {
		return _entryPoints;
	}

	public Long higherEntryPoint(long offset) {
		return _entryPoints.higher(offset);
	}

	public Iterable<Long> exitPoints() {
		return _entryPoints;
	}

	public Long higherExitPoint(long offset) {
		return _exitPoints.higher(offset);
	}

	public boolean isExitPoint(long point) {
		return _exitPoints.contains(point);
	}
}
