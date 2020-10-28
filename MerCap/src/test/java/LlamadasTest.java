import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LlamadasTest {

    LlamadaNacional llamadaNacional = new LlamadaNacional(LocalDate.of(2020, 10, 22), DayOfWeek.MONDAY, LocalTime.of(10,30), 200);
    LlamadaLocal llamadaLocal = new LlamadaLocal(LocalDate.of(2020, 10, 15), DayOfWeek.FRIDAY, LocalTime.of(12,20), 10);
    LlamadaInternacional llamadaInternacional = new LlamadaInternacional(LocalDate.of(2020, 10, 18),DayOfWeek.SUNDAY, LocalTime.of(15, 50), 60);

    Pais francia = new Pais(1.15f);

    Localidad donTorcuato = new Localidad(0.8f);

    List<Llamada> llamadas = new ArrayList<>();

    public void cargarLlamadasEnLista(){
        llamadaNacional.setLocalidad(donTorcuato);
        llamadaInternacional.setPais(francia);
        llamadas.add(llamadaLocal);
        llamadas.add(llamadaInternacional);
        llamadas.add(llamadaNacional);
    }

    @Test
    public void costoLlamadaNacional() {
        llamadaNacional.setLocalidad(donTorcuato);
        float costoFinal = llamadaNacional.costo();
        Assert.assertEquals(160.0f, costoFinal, 0.0);
    }

    @Test
    public void costoLlamadaInternacional() {
        llamadaInternacional.setPais(francia);
        float costoFinal = llamadaInternacional.costo();
        Assert.assertEquals(69.0f, costoFinal, 0.0);
    }

    @Test
    public void costoLlamadaLocalEnHoraCara() {
        float costoFinal = llamadaLocal.costo();
        Assert.assertEquals(2.0f, costoFinal, 0.0);
    }

    @Test
    public void costoLlamadaLocalEnHoraBarata() {
        llamadaLocal.setHora(LocalTime.of(21,28));
        float costoFinal = llamadaLocal.costo();
        Assert.assertEquals(1.0f, costoFinal, 0.0);
    }


    @Test
    public void montoFactura() {
        cargarLlamadasEnLista();
        Factura factura = new Factura(LocalDate.now(),5000, llamadas);
        float montoFinal = factura.importeTotal();
        Assert.assertEquals(5231.0f, montoFinal, 0.0);
    }
}
