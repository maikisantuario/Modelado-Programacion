/**
 * Estrategia que cancela la compra inmediatamente cuando falla la cuenta o el saldo.
 */
public class CancelarCompraStrategy implements IManejoFalloPagoStrategy {

    @Override
    public boolean manejarFallo(SesionSingleton sesion) {
	System.out.println("Compra cancelada.");
	return false;
    }
}
