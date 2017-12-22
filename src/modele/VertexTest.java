package modele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VertexTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Vertex: avant tout");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Vertex: après tout");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Vertex: avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Vertex: après un test");
	}

	@Test
	public void testGetX() {
		Vertex v1 = new Vertex(11, 10, 19);
		
		assertEquals("X ok", v1.getX(), 11);
	}

	@Test
	public void testGetY() {
		Vertex v1 = new Vertex(11, 10, 20);
		assertEquals("Y ok", v1.getY(),10);
	}

	@Test
	public void testAreNeighbors() {
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		
		assertTrue("Are Neighboors ok", v1.areNeighbors(v2) == true);
	}

	@Test
	public void testCompareTo() {
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		
		assertTrue("e1 == e1 ok", v1.compareTo(v1) == 0);
		assertTrue("e1 > e2 ok", v1.compareTo(v2) < 0);
		assertTrue("e2 < e1 ok", v2.compareTo(v1) > 0);
	}

	@Test
	public void testToString() {
		Vertex v1 = new Vertex(10, 10, 20);
		
		assertTrue("toString ok", "(20)".compareTo(v1.toString()) == 0);
	}

	@Test
	public void testEqualsObject() {
		Vertex v1 = new Vertex(10, 10, 20);
		Vertex v2 = new Vertex(11, 10, 19);
		
		assertTrue("Equals ok", v1.equals(v1) == true);
		assertTrue("Equals ok", v1.equals(v2) == false);
	}

	@Test
	public void testInBorders() {
		Graph g = new Graph();
	}

	@Test
	public void testGetNbr() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNbr() {
		fail("Not yet implemented");
	}

}
