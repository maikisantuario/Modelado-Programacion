/**
 * Director que se encarga de orquestar la construccion de los paquetes prefabricados.
 * Utiliza a ConstructorPaquete para armar los paquetes paso a paso.
 */
public class DirectorPaquetes {
    private ConstructorPaquete constructor;

    /**
     * Constructor del Director.
     * @param constructor El builder concreto 
     */
    public DirectorPaquetes(ConstructorPaquete constructor) {
        this.constructor = constructor;
    }

    /**
     * Construye el Paquete Basico con las cantidades ya establecidas
     */
    public void construirPaqueteBasico() {
        constructor.agregarKunai(1);
        constructor.agregarShuriken(1);
        constructor.agregarBotiquin(1);
    }

    /**
     * Construye el Paquete Avanzado con las cantidades ya establecidas
     */
    public void construirPaqueteAvanzado() {
        constructor.agregarShuriken(2);
        constructor.agregarPapelBomba(3);
        constructor.agregarBombaHumo(2);
        constructor.agregarBotiquin(2);
    }

    /**
     * Construye el Paquete Tactico con las cantidades ya establecidas
     */
    public void construirPaqueteTactico() {
        constructor.agregarKunai(3);
        constructor.agregarShuriken(2);
        constructor.agregarPapelBomba(4);
        constructor.agregarBombaHumo(2);
    }
}