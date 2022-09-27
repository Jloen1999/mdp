package sesion01;

import java.util.Objects;

public class Pieza {

    private String id;
    private String nombre;
    private int stock;

    public Pieza(){
        id = "";
        nombre = "";
        stock = 0;

    }
    public Pieza(String id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public Pieza(Pieza p){
        this.id = p.id;
        this.nombre = p.nombre;
        this.stock = p.stock;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pieza pieza = (Pieza) o;
        return stock == pieza.stock && Objects.equals(id, pieza.id) && Objects.equals(nombre, pieza.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, stock);
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", stock=" + stock +
                '}';
    }


}
