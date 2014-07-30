package org.whitehole.infra.graph;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.TreeMap;

import org.junit.Test;
import org.whitehole.infra.json.stream.JsonGenerator;

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
