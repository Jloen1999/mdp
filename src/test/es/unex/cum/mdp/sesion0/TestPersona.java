package test.es.unex.cum.mdp.sesion0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sesion0.Persona;

public class TestPersona {

	@Test
	public void testConstructorPorDefecto() {
		Persona p = new Persona();
		Assertions.assertNotNull(p);
	}

	@Test
	public void testConstructorParametrizado() {
		Persona p = new Persona("Paco","1234",35);
		Assertions.assertNotNull(p);
	}

	@Test
	public void testConstructorCopia() {
		Persona p1 = new Persona("Paco","1234",35);
		Persona p2 = new Persona(p1);
		Assertions.assertNotNull(p2);
	}

	@Test
	public void testGetNombre() {
		Persona p = new Persona("Paco","1234",35);
		String nombre = p.getNombre();
		Assertions.assertEquals("Paco",nombre);
	}

	@Test
	public void testSetNombre() {
		Persona p = new Persona();
		p.setNombre("Paco");
		Assertions.assertEquals("Paco",p.getNombre());
	}

	@Test
	public void testGetDni() {
		Persona p = new Persona("Paco","1234",35);
		String dni = p.getDni();
		Assertions.assertEquals("1234",dni);
	}

	@Test
	public void testSetDni() {
		Persona p = new Persona();
		p.setDni("1234");
		Assertions.assertEquals("1234",p.getDni());
	}

	@Test
	public void testGetEdad() {
		Persona p = new Persona("Paco","1234",35);
		int edad = p.getEdad();
		Assertions.assertEquals(35,edad);
	}

	@Test
	public void testSetEdad() {
		Persona p = new Persona();
		p.setEdad(35);
		Assertions.assertEquals(35,p.getEdad());
	}



}
