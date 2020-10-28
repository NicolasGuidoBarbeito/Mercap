import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaNacional extends Llamada {

    Localidad localidad;

    protected LlamadaNacional(LocalDate fecha, DayOfWeek dia, LocalTime hora, int duracion) {
        super(fecha, dia, hora, duracion);
    }

    public float costo(){
        return duracion * localidad.getCostoAsociado();
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}