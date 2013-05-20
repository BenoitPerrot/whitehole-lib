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
package org.whitehole.infra.io;

import java.io.IOException;
import java.io.Writer;

public class IndentingWriter {

	class Indenter {

		String _space;

		public Indenter(String space) {
			_space = space;
		}

		int _depth = 0;

		public void indentMore() {
			++_depth;
		}

		public void indentLess() {
			assert 0 < _depth;
			--_depth;
		}

		public Writer write(Writer w) throws IOException {
			for (int i = 0; i < _depth; ++i)
				w.write(_space);
			return w;
		}
	}

	final Writer _w;
	final Indenter _indenter;

	public IndentingWriter(Writer writer, String space) {
		_w = writer;
		_indenter = new Indenter(space);
	}

	public IndentingWriter indentMore() {
		_indenter.indentMore();
		return this;
	}

	public IndentingWriter indentLess() {
		_indenter.indentLess();
		return this;
	}

	public IndentingWriter startLine() throws IOException {
		_indenter.write(_w);
		return this;
	}

	public IndentingWriter startLine(String s) throws IOException {
		return startLine().print(s);
	}

	public IndentingWriter print(String s) throws IOException {
		_w.write(s);
		return this;
	}

	public IndentingWriter endLine() throws IOException {
		_w.write("\n");
		return this;
	}

	public IndentingWriter endLine(String s) throws IOException {
		return print(s).endLine();
	}

	public IndentingWriter printLine() throws IOException {
		return printLine("");
	}

	public IndentingWriter printLine(String l) throws IOException {
		return startLine(l).endLine();
	}

	public void close() throws IOException {
		_w.close();
	}
}