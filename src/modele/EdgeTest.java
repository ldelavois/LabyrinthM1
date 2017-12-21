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
		Graph g = new Graph();
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		Edge e = g.addEdge(v1, v2);
		
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
		fail("Not yet implemented");
	}

	@Test
	public void testSource() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testTarget() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
