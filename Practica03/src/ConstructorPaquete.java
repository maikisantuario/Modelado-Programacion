/**
 * Interfaz que define los pasos para construir un paquete de herramientas ninjaa
 * Implementa el patron Builder.
 */
public interface ConstructorPaquete {
    
    /**
     * Agrega una cantidad especifica de Kunais al paquete.
     * @param cantidad Numero de Kunais a agregar.
     */
    void agregarKunai(int cantidad);
    
    /**
     * Agrega una cantidad especifica de Shurikens al paquete.
     * @param cantidad Numero de Shurikens a agregar.
     */
    void agregarShuriken(int cantidad);
    
    /**
     * Agrega una cantidad especifica de Papeles Bomba al paquete.
     * @param cantidad Numero de Papeles Bomba a agregar.
     */
    void agregarPapelBomba(int cantidad);
    
    /**
     * Agrega una cantidad especifica de Bombas de Humo al paquete.
     * @param cantidad Numero de Bombas de Humo a agregar.
     */
    void agregarBombaHumo(int cantidad);
    
    /**
     * Agrega una cantidad especifica de Botiquines al paquete.
     * @param cantidad Numero de Botiquines a agregar.
     */
    void agregarBotiquin(int cantidad);
    
    /**
     * regresa el paquete de herramientas ya construido.
     * @return El objeto PaqueteHerramientas final.
     */
    PaqueteHerramientas obtenerPaquete();
}