/**
 * Clase que representa a un ninja voluntario que actuara como lider de grupo.
 */
public class NinjaVoluntario {
    private String nombre;
    private int edad;
    private String clan;
    private String rango;
    private int nivelHabilidad;

    /**
     * Constructor de la clase NinjaVoluntario.
     * @param nombre Nombre del ninja.
     * @param edad Edad del ninja.
     * @param clan Clan de procedencia.
     * @param rango Rango del ninja (genin, chunin, jonin).
     * @param nivelHabilidad Nivel de habilidad (4-6).
     */
    public NinjaVoluntario(String nombre, int edad, String clan, String rango, int nivelHabilidad) {
        this.nombre = nombre;
        this.edad = edad;
        this.clan = clan;
        this.rango = rango;
        this.nivelHabilidad = nivelHabilidad;
    }

    /**
     * Obtiene el nombre del ninja.
     * @return Nombre del ninja.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la edad del ninja.
     * @return Edad del ninja.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el clan del ninja.
     * @return Clan del ninja.
     */
    public String getClan() {
        return clan;
    }

    /**
     * Obtiene el rango del ninja.
     * @return Rango del ninja.
     */
    public String getRango() {
        return rango;
    }

    /**
     * Obtiene el nivel de habilidad del ninja.
     * @return Nivel de habilidad (4-6).
     */
    public int getNivelHabilidad() {
        return nivelHabilidad;
    }

    /**
     * Determina la capacidad maxima de aspirantes que puede liderar el ninja segun su rango.
     * @return 1 para genin, 2 para chunin, 3 para jonin.
     */
    public int getCapacidadAspirantes() {
        if (rango == null) return 1;
        String r = rango.trim().toLowerCase();
        if (r.equals("jonin")) {
            return 3;
        } else if (r.equals("chunin")) {
            return 2;
        } else {
            return 1;
        }
    }
}
