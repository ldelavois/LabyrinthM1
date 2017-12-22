package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import modele.Edge;
import modele.Graph;
import modele.Vertex;

public class EdgeTest {
	private static Graph g;
	private static Vertex v1, v2, v3, v4;
	private static Edge e1, e2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		g = new Graph();
		v1 = new Vertex(10, 10, 20);
		v2 = new Vertex(11, 10, 19);
		v3 = new Vertex(14, 15, 5);
		v4 = new Vertex(14, 14, 7);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		e1 = g.addEdge(v1, v2);
		e2 = g.addEdge(v3, v4);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		g = null;
		v1 = null;
		v2 = null;
		v3 = null;
		v4 = null;
		e1 = null;
		e2 = null;
	}

	@Test
	public void testCompareTo() {		
		assertTrue("e1 == e1 ok", e1.compareTo(e1) == 0);
		assertTrue("e1 > e2 ok", e1.compareTo(e2) < 0);
		assertTrue("e2 < e1 ok", e2.compareTo(e1) > 0);
	}

	@Test
	public void testSource() {		
		assertSame("Source ok", e1.source(), v1);
	}

	@Test
	public void testTarget() {
		assertSame("Target ok", e1.target(), v2);
	}

	@Test
	public void testToString() {
		assertTrue("toString ok","((20)<->(19))".compareTo(e1.toString()) == 0);
	}

}
