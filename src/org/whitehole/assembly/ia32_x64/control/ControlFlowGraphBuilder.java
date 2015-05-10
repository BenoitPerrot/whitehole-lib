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
import java.util.HashMap;
import java.util.TreeMap;

import org.whitehole.assembly.ia32_x64.control.Trace.BranchReason;
import org.whitehole.assembly.ia32_x64.control.Trace.MotivatedPoint;
import org.whitehole.assembly.ia32_x64.dom.InstructionBuffer;
import org.whitehole.infra.graph.Graph;

public class ControlFlowGraphBuilder {

	public static ControlFlowGraph build(InstructionBuffer is, long offset) throws IOException {

		// A basic block is generally described as a sequence of instructions comprised between
		// an entry point and the immediately following exit point, where a final instruction jumps
		// to some other basic block.
		//
		// A basic block is better described as the minimal sequence of instructions
		// comprised between two consecutive points where the flow is split or joined.
		// In particular, a basic block may be delimited by two consecutive entry points (i.e.
		// may be not terminated by a jumping instruction).
		//
		// The following code leverages these statements, by creating, for each entry point,
		// one basic block, ending at the next closest entry or exit point.

		// Explore control flow
		final Trace t = new TraceBuilder().build(is, offset);

		// FIXME: iterating over t while modifying it; it works because t.entryPoints is implemented by a TreeSet

		// Deduce basic blocks
		final TreeMap<Long, BasicBlock> basicBlocks;
		{
			basicBlocks = new TreeMap<Long, BasicBlock>();

			for (Long p : t.entryPoints()) {

				final Long higherExitPoint = t.higherExitPoint(p);
				if (higherExitPoint != null) {

					final Long higherEntryPoint = t.higherEntryPoint(p);

					final long exitPoint = (higherEntryPoint == null) ? higherExitPoint : Math.min(higherEntryPoint, higherExitPoint);

					if (!t.isExitPoint(exitPoint))
						t.addExitPoint(exitPoint, exitPoint, Trace.BranchReason.ALWAYS);

					basicBlocks.put(p, new BasicBlock(t, p, exitPoint));
				}
				else
					; // FIXME: should not be there?
			}
		}

		// Connect basic blocks
		{
			final org.whitehole.infra.graph.Graph.Default g = new org.whitehole.infra.graph.Graph.Default();
			final HashMap<Integer, BasicBlock> vertexToBasicBlock = new HashMap<Integer, BasicBlock>();
			final HashMap<BasicBlock, Integer> basicBlockToVertex = new HashMap<BasicBlock, Integer>();

			for (final BasicBlock bb : basicBlocks.values()) {
				final int v = g.makeVertex();
				vertexToBasicBlock.put(v, bb);
				basicBlockToVertex.put(bb, v);
			}

			final HashMap<Graph.Edge, BranchReason> branchingReasons = new HashMap<>();

			for (final BasicBlock bb : basicBlocks.values()) {
				final int v = basicBlockToVertex.get(bb);

				for (MotivatedPoint x : t.getDestinationsAt(bb.getExitPoint()))
					if (x.getPoint() != null) { // Consider sound destinations only
						final Graph.Edge e = g.makeEdge(v, basicBlockToVertex.get(basicBlocks.get(x.getPoint())));
						branchingReasons.put(e, x.getReason());
					}
			}

			return new ControlFlowGraph(g, branchingReasons, basicBlockToVertex.get(basicBlocks.get(offset)), vertexToBasicBlock, basicBlockToVertex);
		}
	}
}
