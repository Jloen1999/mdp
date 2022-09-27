package sesion01;

import sesion0.Persona;

import java.util.Objects;

public class Coche extends Vehiculo{
    private String color;

    public Coche(String color) {
        this.color = color;
    }

    public Coche(Vehiculo v, String color) {
        super(v);
        this.color = color;
    }

    public Coche(String marca, String modelo, Persona propietario, String color) {
        super(marca, modelo, propietario);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Coche coche = (Coche) o;
        return Objects.equals(color, coche.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

    @Override
    public String toString(){
        return Thread.currentThread().getStackTrace()[1].getClassName()+"[marca="+getMarca()+", modelo="+getModelo()+", bastidor="+getBastidor()+", color="+getColor()+"]";
    }
}
