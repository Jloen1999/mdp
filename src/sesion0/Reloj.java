package sesion0;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/*
Cada alumno deberá implementar una clase Reloj compuesta por los siguientes atributos: int horas; int minutos; int segundos.
Además debe tener los siguientes métodos (CUIDADO: deben llamarse tal y como aparecen a continuación):

• Reloj()
• Reloj(int hora, int minutos, int segundos)
• int getHoras()
• void setHoras(int hora)
• int getMinutos()
• void setMinutos(int minutos)
• int getSegundos()
• void setSegundos(int segundos)
• boolean equals(Reloj obj)
• String toString() deberá devolver la información en el siguiente formato:
◦
"Reloj [horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos + "]";
• void incrementarSegundos(): Incrementa en uno los segundos
• void incrementarMinutos() : Incrementa en uno los minutos
• void incrementarHoras(): : Incrementa en uno las horas
• void decrementarSegundos(): Decrementa en uno los segundos
• void decrementarMinutos(): Decrementa en uno los minutos
• void decrementarHoras(): Decrementa en uno las horas
• long getTiempo(): Devuelve en número entero las horas, minutos y segundos.
• void setTiempo(long s): Asigna las horas, minutos y segundos en base a un número long
• void anadirTiempo(Reloj r): Añade al reloj actual, la información de otro reloj
• void restarTiempo(Reloj r): Resta al reloj actual, la información de otro reloj
*/
public class Reloj {
    private int horas;
    private int minutos;
    private int segundos;

    public Reloj(){
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public Reloj(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void setHoras(int horas)
    {
        this.horas = horas;
    }
    public int getHoras()
    {
        return horas;
    }

    public void setMinutos(int minutos)
    {
        this.minutos = minutos;
    }
    public int getMinutos()
    {
        return minutos;
    }
    public void setSegundos(int segundos)
    {
        this.segundos = segundos;
    }
    public int getSegundos()
    {
        return segundos;
    }

    @Override
    public String toString()
    {
        return "Reloj [horas=" + horas + ", minutos=" + minutos + ", segundos=" + segundos + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reloj reloj = (Reloj) o;
        return horas == reloj.horas && minutos == reloj.minutos && segundos == reloj.segundos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horas, minutos, segundos);
    }

    public void incrementarSegundos() {
        if(segundos == 59){
            setSegundos(0);
            incrementarMinutos();
        }else{
            setSegundos(++segundos);
        }
    }

    public void decrementarSegundos() {
        if (minutos != 0 || horas != 0) {
            if (segundos == 0) {
                setSegundos(59);
                decrementarMinutos();
            } else {
                setSegundos(--segundos);
            }
        }
    }
    public void incrementarMinutos() {
        if(minutos == 59){
            setMinutos(0);
            incrementarHoras();
        }else{
            setMinutos(++minutos);
        }
    }

    public void decrementarMinutos() {
        if(minutos == 0){
            setMinutos(59);
            decrementarHoras();
        }else{
            setMinutos(--minutos);
        }
    } public void incrementarHoras() {
        if(horas == 23){
            setHoras(0);
        }else{
            setHoras(++horas);
        }
    }

    public void decrementarHoras() {
        if(horas != 0){
            setHoras(--horas);
        }
    }

    public long getTiempo() {
        return (getHoras()*3600L+getMinutos()* 60L +getSegundos());
    }

    public void setTiempo(long s) {
        Date date = new Date(s *1000);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String time = sdf.format(date);
        setHoras(Integer.parseInt(time.substring(0,2)));
        setMinutos(Integer.parseInt(time.substring(3,5)));
        setSegundos(Integer.parseInt(time.substring(6,8)));
    }

    public void restarTiempo(Reloj r) {
        setHoras(horas-r.getHoras());
        setMinutos(minutos-r.getMinutos());
        setSegundos(segundos-r.getSegundos());
        setTiempo(getHoras()*3600L+getMinutos()*60L+getSegundos());
    }

    public void anadirTiempo(Reloj r) {
        setHoras(horas+r.getHoras());
        setMinutos(minutos+r.getMinutos());
        setSegundos(segundos+r.getSegundos());
        setTiempo(getHoras()*3600L+getMinutos()*60L+getSegundos());
    }
}
