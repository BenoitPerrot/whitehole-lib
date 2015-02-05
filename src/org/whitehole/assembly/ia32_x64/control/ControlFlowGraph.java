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

import org.whitehole.assembly.ia32_x64.control.Trace.BranchReason;
import org.whitehole.infra.graph.Graph;

public class ControlFlowGraph {

	private final Graph _g;
	private final HashMap<Graph.Edge, BranchReason> _branchingReasons;
	private final int _entryVertex;
	private final HashMap<Integer, BasicBlock> _vertexToBasicBlock;
	private final HashMap<BasicBlock, Integer> _basicBlockToVertex;

	public ControlFlowGraph(Graph g, HashMap<Graph.Edge, BranchReason> branchingReasons, int entryVertex, HashMap<Integer, BasicBlock> vertexToBasicBlock,
			HashMap<BasicBlock, Integer> basicBlockToVertex) {
		_g = g;
		_branchingReasons = branchingReasons;
		_entryVertex = entryVertex;
		_vertexToBasicBlock = vertexToBasicBlock;
		_basicBlockToVertex = basicBlockToVertex;
	}

	public int getEntryVertex() {
		return _entryVertex;
	}

	public BasicBlock getBasicBlock(int v) {
		return _vertexToBasicBlock.get(v);
	}

	public Iterable<BasicBlock> getBasicBlocks() {
		return _basicBlockToVertex.keySet();
	}

	public boolean hasOutcomingBlocks(BasicBlock bb) {
		return 0 < _g.getSuccessorCount(_basicBlockToVertex.get(bb));
	}

	public class MotivatedBlock {

		private final BasicBlock _bb;
		private final Trace.BranchReason _r;

		public MotivatedBlock(BasicBlock bb, Trace.BranchReason r) {
			_bb = bb;
			_r = r;
		}

		public BasicBlock getBlock() {
			return _bb;
		}

		public Trace.BranchReason getReason() {
			return _r;
		}
	}

	public Iterable<MotivatedBlock> getDestinationBlocks(BasicBlock bb) {
		final int v = _basicBlockToVertex.get(bb);
		return new Iterable<MotivatedBlock>() {

			public Iterator<MotivatedBlock> iterator() {
				return new Iterator<MotivatedBlock>() {

					final Iterator<Graph.Edge> _outEdges = _g.getOutEdges(v).iterator();

					@Override
					public boolean hasNext() {
						return _outEdges.hasNext();
					}

					@Override
					public MotivatedBlock next() {
						final Graph.Edge e = _outEdges.next();
						return new MotivatedBlock(_vertexToBasicBlock.get(e.getSecond()), _branchingReasons.get(e));
					}

					@Override
					public void remove() {
					}
				};
			}
		};
	}
}
