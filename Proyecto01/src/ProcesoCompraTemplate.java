/**
 * Clase abstracta que define el flujo de compra segura mediante Template Method
 * y delega el comportamiento ante fallos a {@link IManejoFalloPagoStrategy}.
 */
public abstract class ProcesoCompraTemplate {

    /** Sesión activa del usuario.
     */
    protected SesionSingleton sesion;

    /** Estrategia utilizada cuando falla la cuenta bancaria o el saldo.
     */
    protected IManejoFalloPagoStrategy estrategiaFallo;

    /**
     * Construye el proceso de compra con la estrategia de manejo de fallo indicada.
     * @param estrategiaFallo estrategia ante fallo de pago
     */
    public ProcesoCompraTemplate(IManejoFalloPagoStrategy estrategiaFallo) {
	this.sesion = SesionSingleton.getInstancia();
	this.estrategiaFallo = estrategiaFallo;
    }

    /**
     * Ejecuta la secuencia de pasos para completar la compra segura.
     */
    public final void ejecutarCompra() {
	if (sesion.getClienteActual() == null || sesion.getCarritoActual().estaVacio()) {
	    System.out.println("No hay productos en el carrito.");
	    return;
	}
	mostrarResumenCarrito();
	boolean aprobado = false;

	while (!aprobado) {
	    String cuenta = solicitarCuentaBancaria();
	    if (validarYProcesarPago(cuenta)) {
		aprobado = true;
	    } else {
		System.out.println(sesion.getEstrategiaIdioma().mensajeErrorPago());
		boolean reintentar = estrategiaFallo.manejarFallo(sesion);
		if (!reintentar) {
		    sesion.getCarritoActual().vaciarCarrito();
		    return;
		}
	    }
	}

	Ticket ticket = generarTicket();
	ticket.imprimirTicket(sesion.getEstrategiaIdioma());
	sesion.getCarritoActual().vaciarCarrito();
    }

    /**
     * Muestra el resumen del carrito y los descuentos.
     */
    protected abstract void mostrarResumenCarrito();

    /**
     * Solicita el número de cuenta bancaria en la pantalla de compra segura.
     *
     * @return número de cuenta ingresado
     */
    protected abstract String solicitarCuentaBancaria();

    /**
     * Valida la cuenta bancaria, aplica ofertas vigentes y descuenta el saldo del cliente.
     *
     * @param cuentaIngresada cuenta bancaria ingresada
     * @return {@code true} si el pago fue exitoso, {@code false} en caso contrario
     */
    protected abstract boolean validarYProcesarPago(String cuentaIngresada);

    /**
     * Genera el {@link Ticket} con los productos comprados, total y fecha estimada de entrega.
     *
     * @return ticket generado
     */
    protected abstract Ticket generarTicket();
}
