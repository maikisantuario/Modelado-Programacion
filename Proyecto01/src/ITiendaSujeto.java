/**
 * Interfaz que define el rol del Sujeto (Subject) dentro del patrón de diseño Observer.
 * Permite gestionar la suscripción de clientes observadores y notificarles sobre cambios
 * o eventos relevantes en la tienda (como nuevas ofertas o actualizaciones).
 */
public interface ITiendaSujeto {
    /**
     * Registra un nuevo observador para que reciba futuras notificaciones.
     *
     * @param o Instancia de {@link IObserverCliente} que desea suscribirse.
     */
    public void registrarObservador(IObserverCliente o);
    /**
     * Elimina a un observador de la lista de suscritos, para que deje de
     * recibir notificaciones.
     *
     * @param o Instancia de {@link IObserverCliente} que se desea dar de baja.
     */
    public void eliminarObservador(IObserverCliente o);
    /**
     * Notifica a los observadores registrados que corresponda sobre la
     * oferta actual.
     */
    public void notificarObservador();
}
