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

import java.io.IOException;
import java.nio.ByteBuffer;

import org.whitehole.assembly.ia32_x64.dis.Disassembler;
import org.whitehole.infra.io.ByteBufferAsInputStream;

public class InstructionBuffer {

	private final Disassembler _d;
	private final ByteBufferAsInputStream _i;
	private final Builder _b;

	public InstructionBuffer(Disassembler d, ByteBuffer b) {
		_d = d;
		_i = new ByteBufferAsInputStream(b);
		_b = new Builder();
	}

	public long capacity() {
		return _i.capacity();
	}

	public InstructionBuffer position(long offset) {
		_i.position(offset);
		return this;
	}

	public long position() {
		return _i.position();
	}

	public boolean hasRemaining() {
		return 0 < _i.available();
	}

	public Instruction get() throws IOException {
		_d.disassemble(_i, _b);
		return _b.get();
	}
}
