import java.util.Objects;

/**
 * Clase que representa a un aspirante registrado en la Academia Ninja.
 */
public class Aspirante {
    private String nombre;
    private int edad;
    private String clan;
    private int nivelHabilidad;

    /**
     * Constructor de la clase Aspirante.
     * @param nombre Nombre del aspirante.
     * @param edad Edad del aspirante.
     * @param clan Clan de procedencia.
     * @param nivelHabilidad Nivel de habilidad (1-3).
     */
    public Aspirante(String nombre, int edad, String clan, int nivelHabilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.nivelHabilidad = nivelHabilidad;
    }

    /**
     * Obtiene el nombre del aspirante.
     * @return Nombre del aspirante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la edad del aspirante.
     * @return Edad del aspirante.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el clan del aspirante.
     * @return Clan de procedencia.
     */
    public String getClan() {
        return clan;
    }

    /**
     * Obtiene el nivel de habilidad del aspirante.
     * @return Nivel de habilidad (1-3).
     */
    public int getNivelHabilidad() {
        return nivelHabilidad;
    }
}
