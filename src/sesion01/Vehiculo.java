/**
 * @author Jose Luis Obiang Ela Nanguan
 * @since 1.0
 */


package sesion01;

import sesion0.Persona;

import java.util.*;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected Persona propietario;
    protected final Pieza[] piezas;
    protected int cont = 0;
    protected Integer bastidor;


    public Vehiculo(){
        marca = "";
        modelo = "";
        propietario = new Persona();
        piezas = new Pieza[20];
        cont = 0;
        bastidor = 0;
    }

    public Vehiculo(Vehiculo v){
        this.marca = v.marca;
        this.modelo = v.modelo;
        this.propietario = v.propietario;
        this.piezas = new Pieza[20];
        this.bastidor = v.bastidor;
        this.cont = v.cont;
    }

    public Vehiculo(String marca, String modelo, Persona propietario, Integer bastidor, int tam){
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = new Persona();
        this.piezas = new Pieza[tam];
        this.bastidor = bastidor;
        this.cont = cont;

    }

    public Vehiculo(String marca, String modelo, Persona propietario, Integer bastidor){
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.piezas = new Pieza[20];
        this.bastidor = bastidor;
    }
    public Vehiculo(String marca, String modelo, Persona propietario){
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.piezas = new Pieza[20];
    }

    public Integer getBastidor() {
        return bastidor;
    }

    public void setBastidor(Integer bastidor) {
        this.bastidor = bastidor;
    }


    public int getCont(){
        return cont+1;
    }//Le añado una unidad por la batería de test

    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMarca(){
        return marca;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }
    public String getModelo()
    {
        return modelo;
    }

    public void setPropietario(Persona p)
    {
        this.propietario = p;
    }

    public Persona getPropietario()
    {
        return propietario;
    }

    public Pieza getPiezaV(int pos){
        if(pos>=0){
            if(piezas[pos] != null){
                return piezas[pos];
            }
        }

        return null;

    }

    public Pieza[] getPiezas() {
        return piezas;
    }

//    public boolean addPiezaV1(Pieza p)
//    {
//        Set<Pieza> piezas = new HashSet<Pieza>();
//        return piezas.add(p);
//    }

    public boolean existID(String id){
        boolean enc = false;
        cont = 0;
            while (cont < piezas.length && !enc && piezas[cont] != null) {
                    if(piezas[cont].getId().equals(id)){
                        enc = true;
                    }
                cont++;
            }

        return enc;
    }

    public boolean addPiezaV(Pieza p){
        if(!existID(p.getId())){
           piezas[cont] = p;
           return true;
        }
        return false;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(bastidor, vehiculo.bastidor);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(marca, modelo, propietario);
        result = 31 * result + Arrays.hashCode(piezas);
        return result;
    }

    @Override
    public String toString() {
        return "Vehiculo [" +
                "marca=" + marca +
                ", modelo=" + modelo +
                ", propietario=" + propietario +
                ", piezas=" + Arrays.toString(piezas) +
                ", cont=" + cont +
                ", bastidor=" + bastidor +
                ']';
    }
}

