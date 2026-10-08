/**
 * Director del patron Builder que define las recetas prefabricadas de paquetes.
 */
public class DirectorPaquetes {
    private ConstructorPaquete constructor;

    /**
     * Constructor del Director.
     * @param constructor Instancia de ConstructorPaquete a utilizar.
     */
    public DirectorPaquetes(ConstructorPaquete constructor) {
        this.constructor = constructor;
    }

    /**
     * Establece o cambia el constructor utilizado por el director.
     * @param constructor Nuevo constructor de paquetes.
     */
    public void setConstructor(ConstructorPaquete constructor) {
        this.constructor = constructor;
    }

    /**
     * Construye un Paquete Basico: 1 Kunai, 1 Shuriken, 1 Botiquin.
     * @return PaqueteHerramientas prefabricado basico.
     */
    public PaqueteHerramientas construirPaqueteBasico() {
        constructor.reset();
        constructor.agregarKunai(1);
        constructor.agregarShuriken(1);
        constructor.agregarBotiquin(1);
        return constructor.obtenerPaquete();
    }

    /**
     * Construye un Paquete Avanzado: 2 Shuriken, 3 Papeles Bomba, 2 Bombas de Humo, 2 Botiquines.
     * @return PaqueteHerramientas prefabricado avanzado.
     */
    public PaqueteHerramientas construirPaqueteAvanzado() {
        constructor.reset();
        constructor.agregarShuriken(2);
        constructor.agregarPapelBomba(3);
        constructor.agregarBombaHumo(2);
        constructor.agregarBotiquin(2);
        return constructor.obtenerPaquete();
    }

    /**
     * Construye un Paquete Tactico: 3 Kunai, 2 Shuriken, 4 Papeles Bomba, 2 Bombas de Humo.
     * @return PaqueteHerramientas prefabricado tactico.
     */
    public PaqueteHerramientas construirPaqueteTactico() {
        constructor.reset();
        constructor.agregarKunai(3);
        constructor.agregarShuriken(2);
        constructor.agregarPapelBomba(4);
        constructor.agregarBombaHumo(2);
        return constructor.obtenerPaquete();
    }
}
