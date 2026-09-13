/**
 *Esta es la interfaz que define al sujeto observable en el patron Observer.
 *Administra el registro y la notificacion de eventos en la arena.
 */
public interface Sujeto {

    /**
     * Registra un nuevo observador al evento.
     * @param observador Instancia que desea recibir notificaciones.
     */
    void registrar(Observador observador);

    /**
     *Envia un mensaje general a todos los observadores registrados.
     *@param mensaje Cadena de texto con el detalle del evento.
     */
    void notificar(String mensaje);

}
