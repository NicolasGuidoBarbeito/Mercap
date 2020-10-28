import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada {

    public Pais pais;

    protected LlamadaInternacional(LocalDate fecha, DayOfWeek dia, LocalTime hora, int duracion) {
        super(fecha,dia, hora, duracion);
    }

    public float costo(){
        return duracion * pais.getCostoAsociado();
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}