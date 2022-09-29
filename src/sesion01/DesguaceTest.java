package sesion01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sesion0.Persona;

import static org.junit.jupiter.api.Assertions.*;

class DesguaceTest {
    private Desguace d;
    private Vehiculo v;
    @BeforeEach
    void setUp() {
        d = new Desguace("Martin", 2);
        v = new Vehiculo("Opel", "Zafira", new Persona("Jose", "Y2323", 21), 1);
    }

    @AfterEach
    void tearDown() {
        d = null;
        v = null;
    }

    @Test
    void getNombre() {
        assertEquals(d.getNombre(), "Martin");
    }

    @Test
    void existBastidor() {
        assertFalse(d.existBastidor(1));
    }

    @Test
    void addVehiculo() {
        assertTrue(d.addVehiculo(v));
    }

    @Test
    void getVehiculoBastidor() {
        d.addVehiculo(v);
        assertEquals(d.getVehiculoBastidor(1), new Vehiculo("Opel", "Zafira", new Persona("Jose", "Y2323", 21), 1));
    }

    @Test
    void addPiezaVehiculo() {
    }

    @Test
    void cuantasPiezasPar() {
    }

    @Test
    void getInfoDerivada() {
    }
}