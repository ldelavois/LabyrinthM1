package modele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EdgeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Edge: avant tout");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Edge: après tout");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Edge: avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Edge: après un test");
	}

	@Test
	public void testCompareTo() {
		Graph g = new Graph();
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		Vertex v3 = new Vertex(14, 15, 5);
		Vertex v4 = new Vertex(14, 14, 7);
		Edge a = g.addEdge(v1, v2);
		Edge e1 = g.getEdge(v1, v2);
		g.addEdge(v3, v4);
		Edge e2 = g.getEdge(v3, v4);
		
		assertTrue("e1 == e1 ok", e1.compareTo(e1) == 0);
		assertTrue("e1 > e2 ok", e1.compareTo(e2) < 0);
		assertTrue("e2 < e1 ok", e2.compareTo(e1) < 0);
	}

	@Test
	public void testSource() {
		Graph g = new Graph();
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		Edge e1 = g.addEdge(v1, v2);
		
		assertSame("Source ok", e1.source(), v1);
	}

	@Test
	public void testTarget() {
		Graph g = new Graph();
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		Edge e1 = g.addEdge(v1, v2);
		
		assertSame("Target ok", e1.target(), v2);
	}

	@Test
	public void testToString() {
		Graph g = new Graph();
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		Edge e1 = g.addEdge(v1, v2);
		
		assertTrue("toString ok","((20)<->(19))".compareTo(e1.toString()) == 0);
	}

}
