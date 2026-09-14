/**
 * Interfaz que define al Sujeto observable dentro del patron de diseño Observer.
 * Es la encargada de administrar el registro de los espectadores y la emision 
 * de notificaciones sobre los eventos que ocurren en la arena de combate.
 */
public interface Sujeto {

    /**
     * Registra un nuevo observador (espectador) para que comience a recibir 
     * actualizaciones del combate en tiempo real.
     * 
     * @param observador Instancia que implementa la interfaz {@link Observador} 
     *                   y desea suscribirse a las notificaciones.
     */
    void registrar(Observador observador);

    /**
     * Envia un mensaje general a todos los observadores que han sido registrados previamente.
     * 
     * @param mensaje Cadena de texto con el detalle del evento ocurrido en la arena 
     *                (ataques, cambios de estrategia, resultados, etc.).
     */
    void notificar(String mensaje);

}
