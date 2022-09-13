package es.unex.cum.mdp.sesion0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

/**
 * The test class RelojTest.
 *
 * @author  Luis Arévalo 
 * @version 1.0
 */
public class TestReloj
{

    public TestReloj(){
        Reloj r= new Reloj();
        assertNotNull(r);
        Reloj r1= new Reloj(1,1,1);
        assertNotNull(r1);
    }

    @Test
    public void testToString(){
        Reloj r= new Reloj();
        assertEquals(r.toString(),"Reloj [horas=0, minutos=0, segundos=0]");
        Reloj r1= new Reloj(1,1,1);
        assertEquals(r1.toString(),"Reloj [horas=1, minutos=1, segundos=1]");
    }

    @Test
    public void testGetter() {
        Reloj r1= new Reloj(1,1,1);
        assertTrue(1==r1.getHoras());
        assertTrue(1==r1.getMinutos());
        assertTrue(1==r1.getSegundos());
    }

    @Test
    public void testSetter() {
        Reloj r1= new Reloj(1,1,1);
        r1.setHoras(2);
        r1.setMinutos(2);
        r1.setSegundos(2);
        assertTrue(2==r1.getHoras());
        assertTrue(2==r1.getMinutos());
        assertTrue(2==r1.getSegundos());
    }

    @Test
    public void testIncrementarSegundos() {
        Reloj r1= new Reloj(1,1,1);
        r1.incrementarSegundos();
        assertTrue(1==r1.getHoras());
        assertTrue(1==r1.getMinutos());
        assertTrue(2==r1.getSegundos());
        r1= new Reloj(1,1,59);
        r1.incrementarSegundos();
        assertTrue(1==r1.getHoras());
        assertTrue(2==r1.getMinutos());
        assertTrue(0==r1.getSegundos());
        r1= new Reloj(1,59,59);
        r1.incrementarSegundos();
        assertTrue(2==r1.getHoras());
        assertTrue(0==r1.getMinutos());
        assertTrue(0==r1.getSegundos());
    }

    @Test
    public void testDecrementarSegundos() {
        Reloj r1= new Reloj(1,1,1);
        r1.decrementarSegundos();
        assertTrue(1==r1.getHoras());
        assertTrue(1==r1.getMinutos());
        assertTrue(0==r1.getSegundos());
        r1= new Reloj(1,1,0);
        r1.decrementarSegundos();
        assertTrue(1==r1.getHoras());
        assertTrue(0==r1.getMinutos());
        assertTrue(59==r1.getSegundos());
        r1= new Reloj(1,0,0);
        r1.decrementarSegundos();
        assertTrue(0==r1.getHoras());
        assertTrue(59==r1.getMinutos());
        assertTrue(59==r1.getSegundos());
        r1= new Reloj(0,0,0);
        r1.decrementarSegundos();
        assertTrue(0==r1.getHoras());
        assertTrue(0==r1.getMinutos());
        assertTrue(0==r1.getSegundos());
    }

    @Test
    public void testGetTiempo() {
        Reloj r1= new Reloj(1,1,1);
        assertTrue(3661==r1.getTiempo());
        r1= new Reloj(10,59,59);
        assertTrue(39599==r1.getTiempo());

    }

    @Test
    public void testSetTiempo(){
        Reloj r1= new Reloj(0,0,0);
        r1.setTiempo(3661);
        assertEquals(r1.toString(),"Reloj [horas=1, minutos=1, segundos=1]");
        r1.setTiempo(39599);
        assertEquals(r1.toString(),"Reloj [horas=10, minutos=59, segundos=59]");
    }

    @Test
    public void testAnadirTiempo() {
        Reloj r1= new Reloj(1,1,1);
        Reloj r2= new Reloj(1,1,1);
        r1.anadirTiempo(r2);
        assertEquals(r1.toString(),"Reloj [horas=2, minutos=2, segundos=2]");      
        r1= new Reloj(2,0,2);
        r2= new Reloj(1,59,59);
        r1.anadirTiempo(r2);
        assertEquals(r1.toString(),"Reloj [horas=4, minutos=0, segundos=1]");
    }

    @Test
    public void testRestarTiempo() {
        Reloj r1= new Reloj(1,1,2);
        Reloj r2= new Reloj(1,1,1);
        r1.restarTiempo(r2);
        assertEquals(r1.toString(),"Reloj [horas=0, minutos=0, segundos=1]");
        r1= new Reloj(2,58,58);
        r2= new Reloj(1,59,59);
        r1.restarTiempo(r2);
        assertEquals(r1.toString(),"Reloj [horas=0, minutos=58, segundos=59]");
    }

    @Test
    public void testEquals() {
        Reloj r1= new Reloj(1,1,1);
        Reloj r2= new Reloj(1,1,1);
        assertTrue(r1.equals(r2));
        //assertEquals(r1,r2);
        r2= new Reloj(1,1,2);
        assertFalse(r1.equals(r2));
    }


}

