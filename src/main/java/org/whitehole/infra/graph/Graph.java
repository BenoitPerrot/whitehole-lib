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
package org.whitehole.infra.graph;

import java.util.ArrayList;
import java.util.Iterator;

public interface Graph {

	public interface Edge {

		public int getFirst();

		public int getSecond();
	}

	public int getVertexCount();

	public Iterable<Integer> getVertices();

	public int getSuccessorCount(int v);

	public Iterable<Integer> getSuccessors(int v);

	public Iterable<Edge> getOutEdges(int v);

	public int getPredecessorCount(int v);

	public Iterable<Integer> getPredecessors(int v);

	public Iterable<Edge> getInEdges(int v);

	public final class Default implements Graph {

		private static class Edge implements Graph.Edge {

			final int first;
			final int second;

			final Edge nextOut;
			final Edge nextIn;

			public Edge(int first, int second, Edge nextOut, Edge nextIn) {
				this.first = first;
				this.second = second;
				this.nextOut = nextOut;
				this.nextIn = nextIn;
			}

			public int getFirst() {
				return first;
			}

			public int getSecond() {
				return second;
			}
		}

		private final ArrayList<Edge> _vertexToFirstOutEdge = new ArrayList<>();
		private final ArrayList<Integer> _vertexToOutEdgeCount = new ArrayList<>();

		private final ArrayList<Edge> _vertexToFirstInEdge = new ArrayList<>();
		private final ArrayList<Integer> _vertexToInEdgeCount = new ArrayList<>();

		private final ArrayList<Edge> _edges = new ArrayList<>();

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

		public int getVertexCount() {
			return _vertexToOutEdgeCount.size(); // Arbitrarily
		}

		public int getSuccessorCount(int v) {
			return _vertexToOutEdgeCount.get(v);
		}

		public Iterable<Integer> getSuccessors(int v) {
			return new Iterable<Integer>() {

				public Iterator<Integer> iterator() {
					return new Iterator<Integer>() {

						Edge _e = _vertexToFirstOutEdge.get(v);

						public boolean hasNext() {
							return _e != null;
						}

						public Integer next() {
							final Integer i = _e.second;
							_e = _e.nextOut;
							return i;
						}

						public void remove() {
							throw new AssertionError();
						}
					};
				}
			};
		}

		public Iterable<Graph.Edge> getOutEdges(int v) {
			return new Iterable<Graph.Edge>() {

				public Iterator<Graph.Edge> iterator() {
					return new Iterator<Graph.Edge>() {

						Edge _e = _vertexToFirstOutEdge.get(v);

						public boolean hasNext() {
							return _e != null;
						}

						public Graph.Edge next() {
							Edge current = _e;
							_e = _e.nextOut;
							return current;
						}

						public void remove() {
							throw new AssertionError();
						}
					};
				}
			};
		}

		public int getPredecessorCount(int v) {
			return _vertexToInEdgeCount.get(v);
		}

		public Iterable<Integer> getPredecessors(int v) {
			return new Iterable<Integer>() {

				public Iterator<Integer> iterator() {
					return new Iterator<Integer>() {

						Edge _e = _vertexToFirstInEdge.get(v);

						public boolean hasNext() {
							return _e != null;
						}

						public Integer next() {
							final Integer i = _e.first;
							_e = _e.nextIn;
							return i;
						}

						public void remove() {
							throw new AssertionError();
						}
					};
				}
			};
		}

		public Iterable<Graph.Edge> getInEdges(int v) {
			return new Iterable<Graph.Edge>() {

				public Iterator<Graph.Edge> iterator() {
					return new Iterator<Graph.Edge>() {

						Edge _e = _vertexToFirstInEdge.get(v);

						public boolean hasNext() {
							return _e != null;
						}

						public Graph.Edge next() {
							Edge current = _e;
							_e = _e.nextIn;
							return current;
						}

						public void remove() {
							throw new AssertionError();
						}
					};
				}
			};
		}

		public int makeVertex() {
			_vertexToFirstOutEdge.add(null);
			_vertexToOutEdgeCount.add(0);
			//
			_vertexToFirstInEdge.add(null);
			_vertexToInEdgeCount.add(0);

			return getVertexCount() - 1;
		}

		public Edge makeEdge(int v0, int v1) {
			final Edge e = new Edge(v0, v1, _vertexToFirstOutEdge.get(v0), _vertexToFirstInEdge.get(v1));
			_edges.add(e);
			//
			_vertexToFirstOutEdge.set(v0, e);
			_vertexToOutEdgeCount.set(v0, 1 + _vertexToOutEdgeCount.get(v0));
			//
			_vertexToFirstInEdge.set(v1, e);
			_vertexToInEdgeCount.set(v1, 1 + _vertexToInEdgeCount.get(v1));

			return e;
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

		public Iterable<Edge> getOutEdges(int v) {
			return _g.getInEdges(v);
		}

		public int getPredecessorCount(int v) {
			return _g.getSuccessorCount(v);
		}

		public Iterable<Integer> getPredecessors(int v) {
			return _g.getSuccessors(v);
		}

		public Iterable<Edge> getInEdges(int v) {
			return _g.getOutEdges(v);
		}
	}
}
