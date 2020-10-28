import java.time.LocalDate;
import java.util.List;

public class Factura {

    public List<Llamada> llamadas;
    public LocalDate fecha;
    private float abonoBasico;
    public float montoTotal;

    public Factura(LocalDate fecha, int abonoBasico, List<Llamada> llamadas) {
        this.fecha = fecha;
        this.abonoBasico = abonoBasico;
        this.llamadas = llamadas;
    }

    public float importeTotal(){

        float costoLLamadas = 0;

        System.out.print("Fecha de Factura: ");
        System.out.println(fecha);
        System.out.print("\nDetalle de factura: \n");
        System.out.print("\nAbono básico: $");
        System.out.print(abonoBasico);
        System.out.print("\n\nCantidad de llamadas: ");
        System.out.print(llamadas.size());

        for(int i = 0; i < llamadas.size(); i++){
            Llamada llamada = llamadas.get(i);
            float costoLLamada = llamada.costo();
            System.out.print("\n\nDía: ");
            System.out.println(llamada.getFecha());
            System.out.print("     Llamada número ");
            System.out.print(i + 1);
            System.out.print("     Costo: $ ");
            System.out.print(costoLLamada);
            costoLLamadas += costoLLamada;
        }

        montoTotal = costoLLamadas + abonoBasico;
        System.out.print("\n\nCosto total de llamadas: $ ");
        System.out.print(costoLLamadas);
        System.out.print("\n\nMonto final: $ ");
        System.out.print(montoTotal);
        System.out.print("\n");
        return montoTotal;
    }

    public void setLlamadas(List<Llamada> llamadas) {
        this.llamadas = llamadas;
    }
}
