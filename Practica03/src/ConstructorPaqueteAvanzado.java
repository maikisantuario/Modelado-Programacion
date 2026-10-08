/**
 * Constructor concreto que arma el Paquete Avanzado.
 * Contiene: 2 Shurikens, 3 Papeles Bomba, 2 Bombas de Humo, 2 Botiquines.
 */
public class ConstructorPaqueteAvanzado implements ConstructorPaquete {
    private PaqueteHerramientas paquete;

    public ConstructorPaqueteAvanzado() {
        this.paquete = new PaqueteHerramientas();
    }

    @Override
    public void agregarKunai(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paquete.agregarHerramienta(new Herramienta("Kunai", 0.5));
        }
    }

    @Override
    public void agregarShuriken(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paquete.agregarHerramienta(new Herramienta("Shuriken", 0.2));
        }
    }

    @Override
    public void agregarPapelBomba(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paquete.agregarHerramienta(new Herramienta("Papel Bomba", 0.1));
        }
    }

    @Override
    public void agregarBombaHumo(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paquete.agregarHerramienta(new Herramienta("Bomba de Humo", 0.3));
        }
    }

    @Override
    public void agregarBotiquin(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            paquete.agregarHerramienta(new Herramienta("Botiquin", 1.0));
        }
    }

    @Override
    public PaqueteHerramientas obtenerPaquete() {
        return this.paquete;
    }
}