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
	ILocalizacionStrategy idioma = sesion.getEstrategiaIdioma();
	mostrarResumenCarrito();
	boolean aprobado = false;

	while (!aprobado) {
	    String cuenta = solicitarCuentaBancaria();
	    if (!verificarCuenta(cuenta)) {
		System.out.println(idioma.mensajeErrorPago());
		if (!estrategiaFallo.manejarFallo(sesion)) {
		    sesion.getCarritoActual().vaciarCarrito();
		    return;
		}
	    } else if (!procesarPago()) {
		System.out.println(idioma.mensajeSaldoInsuficiente());
		sesion.getCarritoActual().vaciarCarrito();
		return;
	    } else {
		aprobado = true;
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
     * Verifica que la cuenta ingresada coincida con la del cliente.
     *
     * @param cuentaIngresada cuenta bancaria ingresada
     * @return {@code true} si coincide, {@code false} en caso contrario
     */
    protected abstract boolean verificarCuenta(String cuentaIngresada);

    /**
     * Aplica las ofertas vigentes y descuenta el total del saldo del cliente.
     *
     * @return {@code true} si se cobró, {@code false} si el saldo no alcanza
     */
    protected abstract boolean procesarPago();

    /**
     * Genera el {@link Ticket} con los productos comprados, total y fecha estimada de entrega.
     *
     * @return ticket generado
     */
    protected abstract Ticket generarTicket();
}
