/**
 * Clase que representa una herramienta ninja individual con su respectivo peso.
 */
public class Herramienta {
    private String nombre;
    private double peso;

    /**
     * Constructor de Herramienta.
     * @param nombre Nombre de la herramienta.
     * @param peso Peso en kilogramos.
     */
    public Herramienta(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * Obtiene el nombre de la herramienta.
     * @return Nombre de la herramienta.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el peso de la herramienta.
     * @return Peso en kilogramos.
     */
    public double getPeso() {
        return peso;
    }
}
