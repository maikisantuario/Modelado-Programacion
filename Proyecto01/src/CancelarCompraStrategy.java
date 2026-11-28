/**
 * Estrategia que cancela la compra inmediatamente cuando falla la cuenta o el saldo.
 */
public class CancelarCompraStrategy implements IManejoFalloPagoStrategy {

    /**
     * Avisa que la compra se canceló y detiene el intento de pago.
     *
     * @param sesion sesión activa
     * @return {@code false} para no reintentar
     */

    @Override
    public boolean manejarFallo(SesionSingleton sesion) {
	System.out.println("Compra cancelada.");
	return false;
    }
}
