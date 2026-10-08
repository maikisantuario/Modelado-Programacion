/**
 * Builder concreto que asigna pesos a las herramientas y ensambla el PaqueteHerramientas.
 */
public class ConstructorPaqueteConcreto implements ConstructorPaquete {
    private PaqueteHerramientas paqueteActual;

    private static final double PESO_KUNAI = 0.3;
    private static final double PESO_SHURIKEN = 0.15;
    private static final double PESO_PAPEL_BOMBA = 0.05;
    private static final double PESO_BOMBA_HUMO = 0.2;
    private static final double PESO_BOTIQUIN = 0.8;

    /**
     * Constructor del builder concreto. Inicializa un paquete nuevo.
     */
    public ConstructorPaqueteConcreto() {
        this.reset();
    }

    @Override
    public void reset() {
        this.paqueteActual = new PaqueteHerramientas();
    }

    @Override
    public void agregarKunai(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paqueteActual.agregarHerramienta(new Herramienta("Kunai", PESO_KUNAI));
        }
    }

    @Override
    public void agregarShuriken(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paqueteActual.agregarHerramienta(new Herramienta("Shuriken", PESO_SHURIKEN));
        }
    }

    @Override
    public void agregarPapelBomba(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paqueteActual.agregarHerramienta(new Herramienta("Papel Bomba", PESO_PAPEL_BOMBA));
        }
    }

    @Override
    public void agregarBombaHumo(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paqueteActual.agregarHerramienta(new Herramienta("Bomba de Humo", PESO_BOMBA_HUMO));
        }
    }

    @Override
    public void agregarBotiquin(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paqueteActual.agregarHerramienta(new Herramienta("Botiquin", PESO_BOTIQUIN));
        }
    }

    @Override
    public PaqueteHerramientas obtenerPaquete() {
        PaqueteHerramientas resultado = this.paqueteActual;
        this.reset();
        return resultado;
    }
}
