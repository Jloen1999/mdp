package test.es.unex.cum.mdp.sesion1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import sesion0.Persona;
import sesion01.Pieza;
import sesion01.Vehiculo;

public class TestVehiculoV4 {
	// Tamaño de piezas de vehiculo 5
	private Vehiculo v1, v2, v3;
	private Persona p;

	@Before
	public void setUp() throws Exception {
		v1 = new Vehiculo();
		p = new Persona("Luis", "4", 4);
		v2 = new Vehiculo("Renault", "Laguna", p);
		v3 = new Vehiculo(v2);
	}

	@After
	public void tearDown() throws Exception {
		v1 = null;
		v2 = null;
		v3 = null;
		p = null;
	}

	@Test
	public void testVehiculo() {
		assertNotNull(v1);
		assertNotNull(v2);
		assertNotNull(v3);
		Assertions.assertEquals(v2, v3);
	}

	@Test
	public void testGetMarca() {
		String Marca = v2.getMarca();
		assertEquals("Renault", Marca);
	}

	@Test
	public void testSetMarca() {
		v2.setMarca("Seat");
		assertEquals("Seat", v2.getMarca());
	}

	@Test
	public void testGetModelo() {
		String modelo = v2.getModelo();
		assertEquals("Laguna", modelo);
	}

	@Test
	public void testSetModelo() {
		v2.setModelo("Leon");
		assertEquals("Leon", v2.getModelo());
	}

	@Test
	public void testGetPropietario() {

		assertEquals(p.toString(), v2.getPropietario().toString());
	}

	@Test
	public void testSetPropietario() {
		Persona p2 = new Persona("Pepe", "5", 5);
		v2.setPropietario(p2);
		assertEquals(p2.toString(), v2.getPropietario().toString());
	}

	@Test
	public void testGetAddPieza() {
		Pieza p1 = new Pieza("1", "Freno", 2);
		Pieza p2 = new Pieza("2", "Faro", 5);
		Pieza p3 = new Pieza("3", "Cambio", 1);
		Pieza p4 = new Pieza("4", "Bujia", 1);
		Pieza p5 = new Pieza("4", "Bujia", 1);
		Pieza p6 = new Pieza("3", "Cambio", 1);
		Pieza p7 = new Pieza("7", "Cambio", 1);
		Pieza p8 = new Pieza("8", "Cambio", 1);
		assertTrue(v2.addPiezaV(p1));
		assertTrue(v2.addPiezaV(p2));
		assertTrue(v2.addPiezaV(p3));
		assertTrue(v2.addPiezaV(p4));
		assertFalse(v2.addPiezaV(p5));
		assertFalse(v2.addPiezaV(p6));
		assertTrue(v2.addPiezaV(p7));
		assertTrue(v2.addPiezaV(p8));

	}

	@Test
	public void testGetPieza() {
		Pieza p1 = new Pieza("1", "Freno", 2);
		Pieza p2 = new Pieza("2", "Faro", 5);
		Pieza p3 = new Pieza("3", "Cambio", 1);
		v2.addPiezaV(p1);
		v2.addPiezaV(p2);
		v2.addPiezaV(p3);

		assertNotNull(v2.getPiezaV(0));
		assertEquals(p1, v2.getPiezaV(0));
		assertNull(v2.getPiezaV(10));
		assertNull(v2.getPiezaV(-5));
		assertEquals(3, v2.getCont()); //El contador debería ser 2, no 3 porque el array empieza en 0 y no 1
	}

}
