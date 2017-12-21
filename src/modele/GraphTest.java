package modele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Graph: avant tout");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Graph: après tout");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Graph: avant un test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Graph: après un test");
	}

	@Test
	public void testContains() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoesntExist() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdgeVertexDirections() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVertexByDir() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVertex() {
		fail("Not yet implemented");
	}

}
