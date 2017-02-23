// Copyright (c) 2004-2015, Benoit PERROT.
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
package org.whitehole.infra.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferAsInputStream extends InputStream {

	final ByteBuffer _buffer;

	public ByteBufferAsInputStream(ByteBuffer buffer) {
		_buffer = buffer.duplicate();
	}

	@Override
	public int available() {
		return _buffer.remaining();
	}

	@Override
	public long skip(long n) {
		final long p = _buffer.position() + n;
		_buffer.position((int) p);
		return n;
	}

	@Override
	public synchronized int read() throws IOException {
		if (!_buffer.hasRemaining())
			return -1;
		return _buffer.get() & 0xff;
	}

	@Override
	public synchronized int read(byte[] bytes, int offset, int len) throws IOException {
		if (!_buffer.hasRemaining())
			return -1;
		len = Math.min(len, _buffer.remaining());
		_buffer.get(bytes, offset, len);
		return len;
	}

	@Override
	public void mark(int readLimit) {
		_buffer.mark();
	}

	@Override
	public void reset() {
		_buffer.reset();
	}

	public long capacity() {
		return _buffer.capacity();
	}

	public long position() {
		return _buffer.position();
	}

	public void position(long offset) {
		_buffer.position((int) offset);
	}
}
