package test.es.unex.cum.mdp.sesion1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sesion01.Pieza;

public class TestPiezaV5 {

	private Pieza p1, p2, p3;

	@BeforeEach
	public void setUp() throws Exception {
		p1 = new Pieza();
		p2 = new Pieza("1", "Freno", 2);
		p3 = new Pieza(p2);
	}

	@AfterEach
	public void tearDown() throws Exception {
		p1 = null;
		p2 = null;
		p3 = null;
	}

	@Test
	public void testPieza() {
		assertNotNull(p1);
		assertNotNull(p2);
		assertNotNull(p3);
		assertEquals(p2, p3);
	}

	@Test
	public void testGetNombre() {
		String nombre = p2.getNombre();
		assertEquals("Freno", nombre);
	}

	@Test
	public void testSetNombre() {
		p2.setNombre("Freno");
		assertEquals("Freno", p2.getNombre());
	}

	@Test
	public void testGetId() {
		String Id = p2.getId();
		assertEquals("1", Id);
	}

	@Test
	public void testSetId() {
		p2.setId("1234");
		assertEquals("1234", p2.getId());
	}

	@Test
	public void testGetStock() {
		int Stock = p2.getStock();
		assertEquals(2, Stock);
	}

	@Test
	public void testSetStock() {
		p2.setStock(35);
		assertEquals(35, p2.getStock());
	}

	@Test
	public void testToString() {
		assertEquals(p2.toString(), "Pieza [id=1, nombre=Freno, stock=2]");
	}

	@Test
	public void testEquals() {
		assertEquals(p2, p3);
		assertNotEquals(p1, p3);

	}

}
