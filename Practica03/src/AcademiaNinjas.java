import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Controlador principal de la academia que gestiona el registro,
 * la formacion de grupos utilizando el Iterator, asignacion de paquetes (Builder)
 * y campos de entrenamiento (Factory Method).
 */
public class AcademiaNinjas {
    private Hashtable<String, Aspirante> aspirantes;
    private NinjaVoluntario[] ninjas;
    private int contadorNinjas;
    private List<Grupo> gruposArmados;

    /**
     * Constructor de la AcademiaNinjas.
     * @param capacidadNinjas Capacidad maxima del arreglo de ninjas voluntarios.
     */
    public AcademiaNinjas(int capacidadNinjas) {
        this.aspirantes = new Hashtable<>();
        this.ninjas = new NinjaVoluntario[capacidadNinjas];
        this.contadorNinjas = 0;
        this.gruposArmados = new ArrayList<>();
    }

    /**
     * Registra un aspirante en la Hashtable.
     * @param a Aspirante a registrar.
     */
    public void registrarAspirante(Aspirante a) {
        aspirantes.put(a.getNombre(), a);
    }

    /**
     * Registra un ninja voluntario en el Arreglo.
     * @param n NinjaVoluntario a registrar.
     */
    public void registrarNinja(NinjaVoluntario n) {
        if (contadorNinjas < ninjas.length) {
            ninjas[contadorNinjas++] = n;
        } else {
            System.out.println("Se ha alcanzado la capacidad maxima de ninjas voluntarios.");
        }
    }

    /**
     * Crea un iterador para recorrer la Hashtable de aspirantes.
     * @return Instancia de Iterador para Aspirante.
     */
    public Iterador<Aspirante> crearIteradorAspirantes() {
        return new IteradorAspirante(aspirantes);
    }

    /**
     * Crea un iterador para recorrer el Arreglo de ninjas.
     * @return Instancia de Iterador para NinjaVoluntario.
     */
    public Iterador<NinjaVoluntario> crearIteradorNinjas() {
        return new IteradorNinjas(ninjas);
    }

    /**
     * Forma los grupos uno a uno relacionando ninjas y aspirantes mediante sus iteradores.
     */
    public void formarGrupos() {
        Iterador<NinjaVoluntario> itNinjas = crearIteradorNinjas();
        Iterador<Aspirante> itAspirantes = crearIteradorAspirantes();

        while (itNinjas.hasNext()) {
            NinjaVoluntario lider = itNinjas.next();
            Grupo grupo = new Grupo(lider);

            int capacidad = lider.getCapacidadAspirantes();
            for (int i = 0; i < capacidad; i++) {
                if (itAspirantes.hasNext()) {
                    Aspirante a = itAspirantes.next();
                    grupo.agregarAspirante(a);
                } else {
                    break;
                }
            }
            gruposArmados.add(grupo);
        }

        if (itAspirantes.hasNext()) {
            System.out.println("--- COMUNICADO DE LA ACADEMIA NINJA ---");
            System.out.println("Ofrecemos una sincera disculpa a los siguientes aspirantes por no contar con suficientes ninjas voluntarios disponibles en esta ocasion:");
            while (itAspirantes.hasNext()) {
                Aspirante sobrante = itAspirantes.next();
                System.out.println(" - " + sobrante.getNombre() + " (Clan " + sobrante.getClan() + ")");
            }
            System.out.println("---------------------------------------\n");
        }
    }

    /**
     * Asigna paquetes de herramientas y campos de entrenamiento a cada grupo armado.
     */
    public void asignarPaquetesYCampos() {
        ConstructorPaqueteConcreto builder = new ConstructorPaqueteConcreto();
        DirectorPaquetes director = new DirectorPaquetes(builder);
        CreadorDeCampo fabricaCampos = new CreadorCampoConcreto();

        int contadorGrupo = 0;
        for (Grupo g : gruposArmados) {
            contadorGrupo++;

            if (contadorGrupo % 4 == 1) {
                g.setPaquete(director.construirPaqueteBasico());
            } else if (contadorGrupo % 4 == 2) {
                g.setPaquete(director.construirPaqueteAvanzado());
            } else if (contadorGrupo % 4 == 3) {
                g.setPaquete(director.construirPaqueteTactico());
            } else {
                builder.reset();
                builder.agregarKunai(2);
                builder.agregarShuriken(3);
                builder.agregarBotiquin(1);
                g.setPaquete(builder.obtenerPaquete());
            }

            CampoEntrenamiento campo = fabricaCampos.crearCampo(g.getSumaNivelHabilidad());
            g.setCampo(campo);

            g.imprimirResumen();
        }
    }
}
