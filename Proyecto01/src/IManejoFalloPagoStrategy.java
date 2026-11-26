/**
 * Interfaz estratégica para decidir qué ocurre cuando falla la validación de cuenta o el pago.
 */
public interface IManejoFalloPagoStrategy {

    /**
     * Determina si se debe reintentar o cancelar la compra tras un fallo.
     *
     * @param sesion sesión activa del cliente
     * @return {@code true} para reintentar, {@code false} para cancelar
     */
    boolean manejarFallo(SesionSingleton sesion);
}
