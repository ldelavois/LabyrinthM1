package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import modele.Directions;
import modele.Graph;
import modele.Vertex;

public class GraphTest {
	private static Graph g;
	private static Vertex v1, v2, v3, v4;
	
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
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		g = null;
		v1 = null;
		v2 = null;
		v3 = null;
		v4 = null;
	}

	@Test
	public void testContains() {
		Vertex v5 = new Vertex(5, 3, 9);
		assertTrue("contains  ok", g.contains(v1));
		assertFalse("not contains ok", g.contains(v5));
	}

	@Test
	public void testDoesntExist() {
		assertTrue("doesn't exist  ok", g.doesntExist(v3, Directions.SOUTH));
		assertFalse("exist ok", g.doesntExist(v2, Directions.WEST));
	}

	@Test
	public void testGetVertexByDir() {
		assertEquals("GetVertexByDir ok", g.getVertexByDir(v4, Directions.SOUTH), v3);
		assertNull("GetVertexByDir null ok", g.getVertexByDir(v4, Directions.WEST));
	}

	@Test
	public void testGetVertex() {
		assertEquals("GetVertex ok", g.getVertex(14, 14), v4);
		assertNull("GetVertex null ok", g.getVertex(15, 14));
	}

}
