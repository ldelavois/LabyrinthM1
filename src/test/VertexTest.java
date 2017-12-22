package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import modele.Directions;
import modele.Vertex;

public class VertexTest {
	private static Vertex v1, v2,v3;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		v1 = new Vertex(10, 10, 20);
		v2 = new Vertex(11, 10, 19);
		v3 = new Vertex(15, 10, 20);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		v1 = null;
		v2 = null;
		v3 = null;
	}

	@Before
	public void setUp() throws Exception {
		v1 = new Vertex(10, 10, 20);
		v2 = new Vertex(11, 10, 19);
		v3 = new Vertex(15, 10, 20);
	}

	@After
	public void tearDown() throws Exception {
		v1 = null;
		v2 = null;
		v3 = null;
	}

	@Test
	public void testGetX() {
		assertEquals("X ok", v1.getX(), 10);
	}

	@Test
	public void testGetY() {
		Vertex v1 = new Vertex(11, 10, 20);
		assertEquals("Y ok", v1.getY(),10);
	}

	@Test
	public void testAreNeighbors() {		
		assertTrue("Are Neighboors ok", v1.areNeighbors(v2) == true);
	}

	@Test
	public void testCompareTo() {		
		assertTrue("e1 == e1 ok", v1.compareTo(v1) == 0);
		assertTrue("e1 > e2 ok", v1.compareTo(v2) < 0);
		assertTrue("e2 < e1 ok", v2.compareTo(v1) > 0);
	}

	@Test
	public void testToString() {
		assertTrue("toString ok", "(20)".compareTo(v1.toString()) == 0);
	}

	@Test
	public void testEqualsObject() {
		assertTrue("Equals true ok", v1.equals(v1) == true);
		assertTrue("Equals false ok", v1.equals(v2) == false);
	}

	@Test
	public void testInBorders() {	
		assertFalse("inborders out ok", v3.inBorders(Directions.EAST));
		assertTrue("inborders in ok", v2.inBorders(Directions.EAST));
	}

	@Test
	public void testGetNbr() {
		assertEquals("Get Nbr ok", v1.getNbr(),20);
	}

	@Test
	public void testSetNbr() {
		v1.setNbr(2);
		assertEquals("Get Nbr ok", v1.getNbr(), 2);
	}

}
