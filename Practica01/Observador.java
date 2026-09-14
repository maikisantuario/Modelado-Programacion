/**
 * Interfaz que define el contrato para los observadores (espectadores) del combate.
 * Aplica el patron de diseño Observer, permitiendo que los entes registrados
 * reciban notificaciones en tiempo real sobre los eventos que ocurren en la arena.
 */
public interface Observador {

    /**
     * Recibe una actualizacion enviada por el Sujeto observable (la arena).
     * 
     * @param mensaje Cadena de texto con el detalle sobre un ataque, defensa, 
     *                consumo de objeto u otro evento relevante en el combate.
     */
    void actualizar(String mensaje);

    /**
     * Recibe la notificacion de que el combate ha concluido y procede a 
     * ejecutar las acciones de cierre, como guardar el registro (log) de la pelea.
     * 
     * @param ganador Nombre del combatiente que resulto victorioso en la arena.
     */
    void finalizarTransmision(String ganador);
}
