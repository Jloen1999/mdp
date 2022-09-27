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

    public boolean verifyBastidor(Integer b) {
        boolean enc = false;
        int i = 0;
        while (i < vehiculos.length && !enc) {
            if (Objects.equals(b, vehiculos[i].getBastidor())) {
                enc = true;
            }
            i++;
        }
        return enc;
    }


    /**
     * Function: addVehiculo
     * Description: La operación de añadir un vehículo debe comprobar si el vehículo existe o no por el bastidor.
     * En el caso que exista, no se debe añadir. public boolean  addVehiculo(Vehiculo v);
     *
     * @param v
     * @return booleano
     */
    public boolean addVehiculo(Vehiculo v) {
        while (cont < vehiculos.length && vehiculos[cont] != null) {
            cont++;
        }

        if (cont != vehiculos.length) {
            if (!verifyBastidor(v.getBastidor())) {
                if (vehiculos[cont].getClass().equals(Camion.class)) {
                    Vehiculo ca = (Camion) vehiculos[cont];
                    vehiculos[cont] = ca;
                } else if (vehiculos[cont].getClass().equals(Coche.class)) {
                    Vehiculo co = (Coche) vehiculos[cont];
                    vehiculos[cont] = co;
                } else {
                    Vehiculo m = (Moto) vehiculos[cont];
                    vehiculos[cont] = m;
                }
            }

            return true;
        }
        return false;
    }


    /**
     * Function: getVehiculoBastidor
     * Description: La operación que permita buscar un vehículo por su bastidor. Se debe controlar
     * los posibles errores. public Vehiculo getVehiculoBastidor(Integer bastidor);
     * @param bastidor
     * @return
     */
    public Vehiculo getVehiculoBastidor(Integer bastidor){
       if(vehiculos.length==0){
           return null;
       }
       while(cont<vehiculos.length && !verifyBastidor(bastidor)){
           if(!verifyBastidor(bastidor)){
               return null;
           }
           cont++;
       }
       return vehiculos[cont];
    }
}
