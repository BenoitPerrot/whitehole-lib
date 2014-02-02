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

import java.util.Iterator;
import java.util.Map.Entry;

import org.whitehole.assembly.ia32_x64.dom.Instruction;

public class BasicBlock {

	private final Trace _t;
	private final long _entryPoint;
	private final long _afterExitPoint;

	public BasicBlock(Trace t, long entryPoint, long afterExitPoint) {
		_t = t;
		_entryPoint = entryPoint;
		_afterExitPoint = afterExitPoint;
	}

	public long getEntryPoint() {
		return _entryPoint;
	}

	public long getExitPoint() {
		return _afterExitPoint;
	}

	public Iterable<Entry<Long, Instruction>> getIterator() {
		return new Iterable<Entry<Long, Instruction>>() {

			public Iterator<Entry<Long, Instruction>> iterator() {
				return new Iterator<Entry<Long, Instruction>>() {

					Entry<Long, Instruction> _next = _t.getOffsetInstructionAt(_entryPoint);

					@Override
					public boolean hasNext() {
						if (_next != null)
							if (_next.getKey() < _afterExitPoint)
								return _next.getValue() != null;
						return false;
					}

					@Override
					public Entry<Long, Instruction> next() {
						final Entry<Long, Instruction> current = _next;
						_next = _t.getOffsetInstructionAfter(current.getKey());
						return current;
					}

					@Override
					public void remove() {
					}

				};
			};
		};
	}
}
