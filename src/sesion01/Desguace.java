/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 */

package sesion01;

import java.util.Arrays;
import java.util.Objects;

public class Desguace {
    private String nombre;
    private Vehiculo[] vehiculos;
    private int cont = 0;

    public Desguace(String nombre, int tam) {
        this.nombre = nombre;
        this.vehiculos = new Vehiculo[tam];
    }

    public Desguace() {
        nombre = "";
        vehiculos = new Vehiculo[3];
        cont = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public Vehiculo[] getVehiculos() {
        return vehiculos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desguace desguace = (Desguace) o;
        return cont == desguace.cont && Objects.equals(nombre, desguace.nombre) && Arrays.equals(vehiculos, desguace.vehiculos);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nombre, cont);
        result = 31 * result + Arrays.hashCode(vehiculos);
        return result;
    }

    @Override
    public String toString() {
        return "Desguace{" +
                "nombre='" + nombre + '\'' +
                ", vehiculos=" + Arrays.toString(vehiculos) +
                ", cont=" + cont +
                '}';
    }

    /**
     * @param b (Integer)
     * @return enc (booleano)
     * @Function verifyBastidor
     * @Description Comprueba si existe o no el bastidor introducido
     * @version 1.0
     */
    public boolean existBastidor(Integer b) {
        boolean enc = false;
        cont = 0;
            while (cont < vehiculos.length && !enc && vehiculos[cont] != null) {
                if (vehiculos[cont].getBastidor().equals(b)) {
                    enc = true;
                }
                cont++;
            }

        return enc;
    }


    /**
     * @param v
     * @return booleano
     * @Function addVehiculo
     * @Description La operación de añadir un vehículo debe comprobar si el vehículo existe o no por el bastidor.
     * En el caso que exista, no se debe añadir.
     * @version 1.0
     * @see boolean verifyBastidor(Integer b)
     */
    public boolean addVehiculo(Vehiculo v) {
        if (!existBastidor(v.getBastidor()) && vehiculos[cont] != null) {
            if (vehiculos[cont].getClass().equals(Camion.class)) {
                Camion ca = (Camion) vehiculos[cont];
                vehiculos[cont] = ca;
            } else if (vehiculos[cont].getClass().equals(Coche.class)) {
                Coche co = (Coche) vehiculos[cont];
                vehiculos[cont] = co;
            } else {
                Moto m = (Moto) vehiculos[cont];
                vehiculos[cont] = m;
            }
            return true;
        }
        return !existBastidor(v.getBastidor());
    }

    /**
     * @param bastidor
     * @return vehiculos[con] (Vehiculo)
     * @Function getVehiculoBastidor
     * @Description La operación que permita buscar un vehículo por su bastidor. Se debe controlar los posibles errores.
     * @see boolean verifyBastidor
     */
    public Vehiculo getVehiculoBastidor(Integer bastidor) {
        if (!existBastidor(bastidor) || vehiculos.length == 0) {
            return null;
        }
        return vehiculos[cont];
    }

    /**
     * @param p        (Pieza)
     * @param bastidor (Integer)
     * @return add (booleano)
     * @function addPiezaVehiculo
     * @description La operación de añadir una pieza a un vehículo por bastidor en desguace (coche, moto, camión).
     * Si existe dicha pieza (por el ID) se debe incrementar el número de dicha pieza al vehículo
     * (se implementa esta operabilidad en Desguace). En el caso de no existir, se añade tal y como está implementado en Vehículo
     * @see Vehiculo addPiezaVehiculo
     * @see boolean verifyID
     */
    public boolean addPiezaVehiculo(Pieza p, Integer bastidor) {
        Vehiculo v = getVehiculoBastidor(bastidor);
        boolean add = false;
        if (v != null) {
            if (v.existID(p.getId())) {
                p.setStock(p.getStock() + 1);
            } else {
                v.addPiezaV(p);
            }
            add = true;
        }
        return add;

    }

    /**
     * @return nVehiculos (int)
     * @function cuantasPiezas
     * @description Operación que devuelva cuantos vehículos, con piezas, tienen un número de piezas par
     * (no que el número de stock de la pieza es par)
     */
    public int cuantasPiezasPar() {
        int nVehiculos = 0;
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPiezas().length % 2 == 0) {
                nVehiculos++;
            }
        }
        return nVehiculos;
    }

    /**
     * @param pos (int)
     * @return vAtributo (String)
     * @function getInfoDerivada
     * @description La operación que permita obtener el valor del atributo derivado de la clase vehículo como String
     * situado en una posición del array del vehículo. Se debe controlar los posibles errores, en cuyo se devolverá null.
     */
    public String getInfoDerivada(int pos) {
        String vAtributo = "";
        if (vehiculos[pos].getClass().equals(Coche.class)) {
            Coche co = (Coche) vehiculos[pos];
            vAtributo = co.getColor();
        } else if (vehiculos[pos].getClass().equals(Camion.class)) {
            Camion ca = (Camion) vehiculos[pos];
            vAtributo = ca.getTonelaje().toString();
        } else {
            Moto m = (Moto) vehiculos[pos];
            vAtributo = m.getPotencia().toString();
        }
        return vAtributo;
    }
}
