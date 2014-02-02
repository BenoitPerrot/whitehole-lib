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
package org.whitehole.infra.graph;

import java.util.ArrayList;
import java.util.Iterator;

public interface Graph {

	public int getVertexCount();

	public Iterable<Integer> getVertices();

	public int getSuccessorCount(int v);

	public Iterable<Integer> getSuccessors(int v);

	public int getPredecessorCount(int v);

	public Iterable<Integer> getPredecessors(int v);

	public final class Default implements Graph {

		private final ArrayList<ArrayList<Integer>> _successorsOf = new ArrayList<ArrayList<Integer>>();
		private final ArrayList<ArrayList<Integer>> _predecessorsOf = new ArrayList<ArrayList<Integer>>();

		public int getVertexCount() {
			return _successorsOf.size();
		}

		public Iterable<Integer> getVertices() {
			return new Iterable<Integer>() {

				public Iterator<Integer> iterator() {
					return new Iterator<Integer>() {

						int _v = -1;

						public boolean hasNext() {
							return _v + 1 < getVertexCount();
						}

						public Integer next() {
							return ++_v;
						}

						public void remove() {
							throw new AssertionError();
						}
					};
				}
			};
		}

		public int getSuccessorCount(int v) {
			return _successorsOf.get(v).size();
		}

		public Iterable<Integer> getSuccessors(int v) {
			return _successorsOf.get(v);
		}

		public int getPredecessorCount(int v) {
			return _predecessorsOf.get(v).size();
		}

		public Iterable<Integer> getPredecessors(int v) {
			return _predecessorsOf.get(v);
		}

		public int makeVertex() {
			_successorsOf.add(new ArrayList<Integer>());
			_predecessorsOf.add(new ArrayList<Integer>());
			assert _successorsOf.size() == _predecessorsOf.size();
			return getVertexCount() - 1;
		}

		public void makeEdge(int v0, int v1) {
			_successorsOf.get(v0).add(v1);
			_predecessorsOf.get(v1).add(v0);
		}

		public Reverse reverse() {
			return new Reverse(this);
		}
	}

	public final class Reverse implements Graph {

		final private Graph _g;

		public Reverse(Graph g) {
			_g = g;
		}

		public int getVertexCount() {
			return _g.getVertexCount();
		}

		public Iterable<Integer> getVertices() {
			return _g.getVertices();
		}

		public int getSuccessorCount(int v) {
			return _g.getPredecessorCount(v);
		}

		public Iterable<Integer> getSuccessors(int v) {
			return _g.getPredecessors(v);
		}

		public int getPredecessorCount(int v) {
			return _g.getSuccessorCount(v);
		}

		public Iterable<Integer> getPredecessors(int v) {
			return _g.getSuccessors(v);
		}
	}
}
