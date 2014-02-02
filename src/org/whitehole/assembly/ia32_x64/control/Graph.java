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

import java.util.HashMap;
import java.util.Iterator;

public class Graph {

	private final org.whitehole.infra.graph.Graph _g;
	private final HashMap<Integer, BasicBlock> _vertexToBasicBlock;
	private final HashMap<BasicBlock, Integer> _basicBlockToVertex;

	public Graph(org.whitehole.infra.graph.Graph g, HashMap<Integer, BasicBlock> vertexToBasicBlock,
			HashMap<BasicBlock, Integer> basicBlockToVertex) {
		_g = g;
		_vertexToBasicBlock = vertexToBasicBlock;
		_basicBlockToVertex = basicBlockToVertex;
	}

	public Iterable<BasicBlock> getBasicBlocks() {
		return _basicBlockToVertex.keySet();
	}

	public boolean hasOutcomingBlocks(BasicBlock bb) {
		return 0 < _g.getSuccessorCount(_basicBlockToVertex.get(bb));
	}

	public Iterable<BasicBlock> getOutcomingBlocks(BasicBlock bb) {
		final int v = _basicBlockToVertex.get(bb);
		return new Iterable<BasicBlock>() {
			public Iterator<BasicBlock> iterator() {
				return new Iterator<BasicBlock>() {

					final Iterator<Integer> _i = _g.getSuccessors(v).iterator();

					@Override
					public boolean hasNext() {
						return _i.hasNext();
					}

					@Override
					public BasicBlock next() {
						return _vertexToBasicBlock.get(_i.next());
					}

					@Override
					public void remove() {
					}
				};
			}
		};
	}
}
