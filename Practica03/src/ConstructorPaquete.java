/**
 * Interfaz Builder para la construccion paso a paso de paquetes de herramientas.
 */
public interface ConstructorPaquete {
    void agregarKunai(int cantidad);
    void agregarShuriken(int cantidad);
    void agregarPapelBomba(int cantidad);
    void agregarBombaHumo(int cantidad);
    void agregarBotiquin(int cantidad);
    PaqueteHerramientas obtenerPaquete();
    void reset();
}
