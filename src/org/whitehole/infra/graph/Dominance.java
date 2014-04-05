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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class Dominance {

	private final Graph.Default _dominanceGraph;
	private final HashMap<Integer, Integer> _immediateDominators;
	private final HashMap<Integer, HashSet<Integer>> _dominanceFrontier;

	public Dominance(Graph g, int source) {
		_dominanceGraph = makeDominanceGraph(g, source);
		_immediateDominators = computeImmediateDominators(_dominanceGraph, source);
		_dominanceFrontier = computeDominanceFrontier(g, _immediateDominators);
	}

	public Iterable<Integer> getStrictDominators(int v) {
		return _dominanceGraph.getPredecessors(v);
	}

	public Iterable<Integer> getDominators(final int v) {
		return new Iterable<Integer>() {

			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {

					private Iterator<Integer> _strictDominators = null;

					public boolean hasNext() {
						return _strictDominators == null || _strictDominators.hasNext();
					}

					public Integer next() {
						if (_strictDominators == null) {
							_strictDominators = getStrictDominators(v).iterator();
							return v;
						}
						else
							return _strictDominators.next();
					}

					public void remove() {
						throw new AssertionError(); // Should not be there
					}
				};
			}
		};
	}

	public int getImmediateDominator(int v) {
		return _immediateDominators.get(v);
	}

	public HashSet<Integer> getDominanceFrontier(int v) {
		return _dominanceFrontier.get(v);
	}

	public ArrayList<Integer> getDominanceTreeSuccessors(int v) {
		final ArrayList<Integer> dts = new ArrayList<Integer>();
		for (Entry<Integer, Integer> e : _immediateDominators.entrySet())
			if (e.getKey() != v && e.getValue() == v)
				dts.add(e.getKey());
		return dts;
	}

	public HashSet<Integer> getIteratedDominanceFrontier(int n) {
	    final HashSet<Integer> iteratedDominanceFrontier = getDominanceFrontier(n);

		final ArrayDeque<Integer> s = new ArrayDeque<Integer>();
		s.addAll(iteratedDominanceFrontier);

		while (0 < s.size()) {
	    	final Integer e = s.pop();
	    	HashSet<Integer> idfE = getDominanceFrontier(e);
	    	for (Integer i : idfE)
	    		if (!iteratedDominanceFrontier.contains(i)) {
					s.push(i);
	    			iteratedDominanceFrontier.add(i);
	    		}
	    }
	    return iteratedDominanceFrontier;
	}

	// Helpers <<
	private static HashSet<Integer> newHashSet(int e) {
		final HashSet<Integer> s = new HashSet<Integer>();
		s.add(e);
		return s;
	}

	private static HashSet<Integer> newHashSet(Iterable<Integer> i) {
		final HashSet<Integer> s = new HashSet<Integer>();
		for (int e : i)
			s.add(e);
		return s;
	}

	private static Integer pop(HashSet<Integer> x) {
		final int i = x.iterator().next();
		x.remove(i);
		return i;
	}
	// >>

	public static Graph.Default makeDominanceGraph(Graph g, int source) {
		final Graph.Default dominanceGraph = new Graph.Default();

		// Initiate
		final HashMap<Integer, HashSet<Integer>> dominators = new HashMap<Integer, HashSet<Integer>>();
		for (int v : g.getVertices()) {
			if (v == source)
				dominators.put(v, newHashSet(v));
			else
				dominators.put(v, newHashSet(g.getVertices()));

			dominanceGraph.makeVertex(); // Assume dense input graph
		}

		// Iterate
		final HashSet<Integer> changed = newHashSet(g.getVertices());
		while (0 < changed.size()) {
			final int v = pop(changed);
			final HashSet<Integer> domV;
			if (0 < g.getPredecessorCount(v)) {
				final Iterator<Integer> i = g.getPredecessors(v).iterator();
				domV = new HashSet<Integer>(dominators.get(i.next()));
				while (i.hasNext())
					domV.retainAll(dominators.get(i.next()));
				domV.add(v);
			}
			else
				domV = newHashSet(v);
			if (!domV.equals(dominators.get(v))) {
				dominators.put(v, domV);
				for (int s : g.getSuccessors(v))
					changed.add(s);
			}
		}

		// Build resulting graph
		for (int n : dominanceGraph.getVertices())
			for (int d : dominators.get(n))
				if (d != n)
					dominanceGraph.makeEdge(d, n);

		return dominanceGraph;
	}

	public static HashMap<Integer, Integer> computeImmediateDominators(Graph dominangeGraph, int source) {
		final HashMap<Integer, Integer> immediateDominators = new HashMap<Integer, Integer>();
		immediateDominators.put(source, source);

		for (final int v : dominangeGraph.getVertices()) {
			final HashSet<Integer> preds = newHashSet(dominangeGraph.getPredecessors(v));
			for (final int d : preds)
				if (d != v) {
					final HashSet<Integer> s = newHashSet(dominangeGraph.getSuccessors(d));
					s.retainAll(preds);
					if (s.size() == 0) {
						immediateDominators.put(v, d);
						break; // assert(n not in immediateDominators)
					}
				}
		}

		return immediateDominators;
	}

	public static HashMap<Integer, HashSet<Integer>> computeDominanceFrontier(Graph g, HashMap<Integer, Integer> immediateDominators) {
		final HashMap<Integer, HashSet<Integer>> dominanceFrontier = new HashMap<Integer, HashSet<Integer>>();
		for (final int n : g.getVertices())
			dominanceFrontier.put(n, new HashSet<Integer>());

		for (final int n : g.getVertices())
			if (1 < g.getPredecessorCount(n))
				for (final int p : g.getPredecessors(n)) {
					int r = p;
					while (r != immediateDominators.get(n)) {
						if (n != r)
							dominanceFrontier.get(r).add(n);
						r = immediateDominators.get(r);
					}
				}

		return dominanceFrontier;
	}
}
