import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un grupo formado por un lider ninja, aspirantes,
 * paquete de herramientas y un campo de entrenamiento.
 */
public class Grupo {
    private NinjaVoluntario lider;
    private List<Aspirante> aspirantes;
    private PaqueteHerramientas paquete;
    private CampoEntrenamiento campo;

    /**
     * Constructor del Grupo.
     * @param lider Ninja voluntario que lidera el grupo.
     */
    public Grupo(NinjaVoluntario lider) {
        this.lider = lider;
        this.aspirantes = new ArrayList<>();
    }

    /**
     * Agrega un aspirante al grupo si no se supera la capacidad del lider.
     * @param a Aspirante a agregar.
     * @return true si se agrego con exito, false si se alcanzo el limite.
     */
    public boolean agregarAspirante(Aspirante a) {
        if (aspirantes.size() < lider.getCapacidadAspirantes()) {
            aspirantes.add(a);
            return true;
        }
        return false;
    }

    /**
     * Calcula la suma total de los niveles de habilidad del grupo.
     * @return Suma del nivel del lider mas los niveles de los aspirantes.
     */
    public int getSumaNivelHabilidad() {
        int suma = lider.getNivelHabilidad();
        for (Aspirante a : aspirantes) {
            suma += a.getNivelHabilidad();
        }
        return suma;
    }

    /**
     * Asigna el paquete de herramientas al grupo.
     * @param p Paquete de herramientas.
     */
    public void setPaquete(PaqueteHerramientas p) {
        this.paquete = p;
    }

    /**
     * Asigna el campo de entrenamiento al grupo.
     * @param c Campo de entrenamiento.
     */
    public void setCampo(CampoEntrenamiento c) {
        this.campo = c;
    }

    /**
     * Obtiene el lider del grupo.
     * @return Ninja voluntario lider.
     */
    public NinjaVoluntario getLider() {
        return lider;
    }

    /**
     * Obtiene la lista de aspirantes del grupo.
     * @return Lista de aspirantes.
     */
    public List<Aspirante> getAspirantes() {
        return aspirantes;
    }

    /**
     * Obtiene el paquete de herramientas asignado.
     * @return Paquete de herramientas.
     */
    public PaqueteHerramientas getPaquete() {
        return paquete;
    }

    /**
     * Obtiene el campo de entrenamiento asignado.
     * @return Campo de entrenamiento.
     */
    public CampoEntrenamiento getCampo() {
        return campo;
    }

    /**
     * Imprime el resumen detallado del grupo.
     */
    public void imprimirResumen() {
        System.out.println("==================================================");
        System.out.println("Lider del Grupo: " + lider.getNombre() + " (" + lider.getClan() + ", " + lider.getRango() + ", Nivel: " + lider.getNivelHabilidad() + ")");
        System.out.println("Aspirantes:");
        for (Aspirante a : aspirantes) {
            System.out.println("  - " + a.getNombre() + " (" + a.getClan() + ", Nivel: " + a.getNivelHabilidad() + ")");
        }
        System.out.println("Suma Total de Habilidad: " + getSumaNivelHabilidad());
        if (paquete != null) {
            System.out.println("Paquete Adquirido: " + paquete.getDescripcion());
            System.out.println("Peso Total del Paquete: " + paquete.getPesoTotal() + " kg");
        }
        if (campo != null) {
            System.out.println("Campo Asignado: " + campo.getNombre());
            System.out.println("Descripcion del Campo: " + campo.getDescripcion());
        }
        System.out.println("==================================================\n");
    }
}
