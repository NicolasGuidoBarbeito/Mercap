import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada {

    protected LlamadaLocal(LocalDate fecha, DayOfWeek dia, LocalTime hora, int duracion) {
        super(fecha, dia, hora, duracion);
    }

    public float costo(){
        if(esDiaHabil(dia) && estaEnHoraMasCara(hora)){
            return 0.20f * duracion;
        }
        return 0.10f * duracion;
    }

    private boolean esDiaHabil(DayOfWeek dia) {
        return dia.getValue() <= 5;
    }

    private boolean estaEnHoraMasCara(LocalTime hora){
        LocalTime primeraHora = LocalTime.of(8,0);
        LocalTime segundaHora = LocalTime.of(20,0);
        return hora.isAfter(primeraHora) && hora.isBefore(segundaHora);
    }
}