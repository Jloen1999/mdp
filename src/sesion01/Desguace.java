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
     * @Description La operaci??n de a??adir un veh??culo debe comprobar si el veh??culo existe o no por el bastidor.
     * En el caso que exista, no se debe a??adir.
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
     * @Description La operaci??n que permita buscar un veh??culo por su bastidor. Se debe controlar los posibles errores.
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
     * @description La operaci??n de a??adir una pieza a un veh??culo por bastidor en desguace (coche, moto, cami??n).
     * Si existe dicha pieza (por el ID) se debe incrementar el n??mero de dicha pieza al veh??culo
     * (se implementa esta operabilidad en Desguace). En el caso de no existir, se a??ade tal y como est?? implementado en Veh??culo
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
     * @description Operaci??n que devuelva cuantos veh??culos, con piezas, tienen un n??mero de piezas par
     * (no que el n??mero de stock de la pieza es par)
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
     * @description La operaci??n que permita obtener el valor del atributo derivado de la clase veh??culo como String
     * situado en una posici??n del array del veh??culo. Se debe controlar los posibles errores, en cuyo se devolver?? null.
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
