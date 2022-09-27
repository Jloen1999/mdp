package sesion01;

import sesion0.Persona;

import java.util.Arrays;
import java.util.Objects;

public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected Persona propietario;
    protected Pieza[] piezas;
    protected int cont;
    protected Integer bastidor;


    public Vehiculo(){
        marca = "";
        modelo = "";
        propietario = new Persona();
        piezas = new Pieza[3];
        cont = 0;
    }

    public Vehiculo(Vehiculo v){
        this.marca = v.marca;
        this.modelo = v.modelo;
        this.propietario = v.propietario;
        this.piezas = new Pieza[3];
    }

    public Vehiculo(String marca, String modelo, Persona propietario){
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = new Persona();
        this.piezas = new Pieza[3];
    }

    public Integer getBastidor() {
        return bastidor;
    }

    public void setBastidor(Integer bastidor) {
        this.bastidor = bastidor;
    }


    public void setCont(int cont){
        this.cont=cont;
    }
    public int getCont(){
        return cont;
    }

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

    public boolean verifyID(String id){
        boolean enc=false;
        int i=0;
        while(i < piezas.length && !enc){
            if(piezas[i].getId().equals(id)){
               enc=true;
            }
            i++;
        }
        return enc;
    }
    public boolean addPiezaV(Pieza pz)
    {
        while(cont < piezas.length && piezas[cont] != null){
            cont++;
        }

        if(cont != piezas.length){
            if(!verifyID(pz.getId())){
                piezas[cont] = pz;
                return true;
            }
        }
        return false;
    }

    public Pieza getPiezaV(int index){
        return piezas[index];
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

}
