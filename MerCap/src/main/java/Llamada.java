import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Llamada {
    public LocalDate fecha;
    public final DayOfWeek dia;
    public LocalTime hora;
    public int duracion;

    protected Llamada(LocalDate fecha,DayOfWeek dia, LocalTime hora, int duracion) {
        this.fecha = fecha;
        this.dia = dia;
        this.hora = hora;
        this.duracion = duracion;
    }

    public float costo() {
        return 0;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}