package sesion01;

import sesion0.Persona;

import java.util.Objects;

public class Camion extends Vehiculo{
    private Integer tonelaje;

    public Camion(Integer tonelaje) {
        this.tonelaje = tonelaje;
    }

    public Camion(Vehiculo v, Integer tonelaje) {
        super(v);
        this.tonelaje = tonelaje;
    }

    public Camion(String marca, String modelo, Persona propietario, Integer tonelaje) {
        super(marca, modelo, propietario);
        this.tonelaje = tonelaje;
    }

    public Integer getTonelaje() {
        return tonelaje;
    }

    public void setTonelaje(Integer tonelaje) {
        this.tonelaje = tonelaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Camion camion = (Camion) o;
        return Objects.equals(tonelaje, camion.tonelaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tonelaje);
    }

    @Override
    public String toString(){
        return Thread.currentThread().getStackTrace()[1].getClassName()+"[marca="+getMarca()+", modelo="+getModelo()+", bastidor="+getBastidor()+", tonelaje="+getTonelaje()+"]";
    }
}
