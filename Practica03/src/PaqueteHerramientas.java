import java.util.ArrayList;
import java.util.List;

/**
 * Producto final del patron Builder que representa un conjunto de herramientas ninja.
 */
public class PaqueteHerramientas {
    private List<Herramienta> herramientas;
    private double pesoTotal;

    /**
     * Constructor de PaqueteHerramientas.
     */
    public PaqueteHerramientas() {
        this.herramientas = new ArrayList<>();
        this.pesoTotal = 0.0;
    }

    /**
     * Agrega una herramienta al paquete y suma su peso al total.
     * @param h Herramienta a agregar.
     */
    public void agregarHerramienta(Herramienta h) {
        herramientas.add(h);
        pesoTotal += h.getPeso();
    }

    /**
     * Obtiene el peso total acumulado del paquete.
     * @return Peso total en kilogramos.
     */
    public double getPesoTotal() {
        return Math.round(pesoTotal * 100.0) / 100.0;
    }

    /**
     * Genera un desglose formateado de los componentes del paquete.
     * @return Descripcion textual de los elementos del paquete.
     */
    public String getDescripcion() {
        if (herramientas.isEmpty()) {
            return "Paquete Vacio";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < herramientas.size(); i++) {
            sb.append(herramientas.get(i).getNombre());
            if (i < herramientas.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
