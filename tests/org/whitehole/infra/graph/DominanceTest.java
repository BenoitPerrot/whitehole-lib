// Copyright (c) 2013-2015, Benoit PERROT.
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

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.TreeMap;

import org.junit.Test;
import org.whitehole.infra.json.JsonGenerator;

public class DominanceTest {

	private static void write(JsonGenerator j, Graph g, TreeMap<Integer, String> m) throws IOException {
		j.writeStartObject();

		j.writeStartArray("vertices");
		for (int v : g.getVertices()) {
			j.writeStartObject();
			j.write("label", m.get(v));
			j.writeEnd();
		}
		j.writeEnd();

		j.writeStartArray("edges");
		for (int v0 : g.getVertices())
			for (int v1 : g.getSuccessors(v0)) {
				j.writeStartObject();
				j.write("l", BigDecimal.valueOf(v0));
				j.write("r", BigDecimal.valueOf(v1));
				j.writeEnd();
			}
		j.writeEnd();

		j.writeEnd();
	}

	private static void write(JsonGenerator j, Graph g, Dominance d) throws IOException {
		j.writeStartObject();

		j.writeStartArray("dominators");
		for (int v : g.getVertices()) {
			j.writeStartArray();
			for (int u : d.getDominators(v))
				j.write(BigDecimal.valueOf(u));
			j.writeEnd();
		}
		j.writeEnd();

		j.writeEnd();
	}

	@SuppressWarnings("serial")
	@Test
	public void test() {

		final Graph.Default g = new Graph.Default();
		final int vA = g.makeVertex();
		final int vForInit = g.makeVertex();
		final int vForTest = g.makeVertex();
		final int vB = g.makeVertex();
		final int vC = g.makeVertex();
		final int vD = g.makeVertex();
		final int vForInc = g.makeVertex();
		final int vE = g.makeVertex();
		g.makeEdge(vA, vForInit);
		g.makeEdge(vForInit, vForTest);
		g.makeEdge(vForTest, vB);
		g.makeEdge(vB, vC);
		g.makeEdge(vC, vD);
		g.makeEdge(vD, vForInc);
		g.makeEdge(vForInc, vForTest);
		g.makeEdge(vForTest, vE);

		final TreeMap<Integer, String> labels = new TreeMap<Integer, String>() {

			{
				put(vA, "A: goto E");
				put(vForInit, "i := 1");
				put(vForTest, "i <= 10");
				put(vB, "B: goto A");
				put(vC, "C: goto E");
				put(vD, "D: goto B");
				put(vForInc, "i := i + 1");
				put(vE, "E: goto A");
			}
		};

		{
			final Dominance d = new Dominance(g, vA);
			try {
				final StringWriter w = new StringWriter();
				write(new JsonGenerator.Writer(w), g, labels);
				write(new JsonGenerator.Writer(w), g, d);
				w.close();
				System.out.println(w.toString());
			}
			catch (IOException e) {
				fail(e.getLocalizedMessage());
			}
		}

		{
			final Graph rg = g.reverse();
			final Dominance d = new Dominance(rg, vA);
			try {
				final StringWriter w = new StringWriter();
				write(new JsonGenerator.Writer(w), g, labels);
				write(new JsonGenerator.Writer(w), g, d);
				w.close();
				System.out.println(w.toString());
			}
			catch (IOException e) {
				fail(e.getLocalizedMessage());
			}
		}
	}

}
