import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Implementación estándar del proceso de compra segura por consola.
 */
public class ProcesoCompraEstandar extends ProcesoCompraTemplate {

    /** Lector de entrada de consola.
     */
    private Scanner scanner;

    /** Servidor de ofertas para aplicar descuentos vigentes.
     */
    private ServidorOfertas ofertas;

    /** Monto final cobrado en la transacción.
     */
    private double totalCobrado;

    /** Copia de los productos incluidos en el ticket.
     */
    private List<Producto> productosComprados;

    /**
     * Construye el proceso de compra estándar.
     *
     * @param estrategiaFallo estrategia ante fallo de pago
     * @param ofertas        servidor de ofertas activo
     * @param scanner 
     */
    public ProcesoCompraEstandar(IManejoFalloPagoStrategy estrategiaFallo, ServidorOfertas ofertas, Scanner scanner) {
        super(estrategiaFallo);
        this.ofertas = ofertas;
        this.scanner = scanner;
        this.productosComprados = new ArrayList<>();
    }

    /**
     * Calcula el total a pagar aplicando descuentos de ofertas activas si corresponden.
     *
     * @return monto total final
     */
    private double calcularTotalFinal() {
        ICliente cliente = sesion.getClienteActual();
        double total = 0.0;
        for (Producto p : sesion.getCarritoActual().getProductos()) {
            double precioUnitario = p.getPrecio();
            if (ofertas != null && ofertas.aplicaDescuento(cliente.getPais(), p.getDepartamento())) {
                precioUnitario = precioUnitario * ((100.0 - ofertas.getPorcentajeDescuento()) / 100.0);
            }
            total += precioUnitario;
        }
        return total;
    }

    @Override
    protected void mostrarResumenCarrito() {
        System.out.println("\n--- RESUMEN DE COMPRA ---");
        for (Producto p : sesion.getCarritoActual().getProductos()) {
            System.out.println(" - " + p.toString());
        }
        System.out.println("Total a pagar: $" + String.format("%.2f", calcularTotalFinal()));
    }

    @Override
    protected String solicitarCuentaBancaria() {
        System.out.println("\n=== COMPRA SEGURA ===");
        System.out.print("Ingresa tu número de cuenta bancaria: ");
        return scanner.nextLine().trim();
    }

    @Override
    protected boolean verificarCuenta(String cuentaIngresada) {
	return sesion.getClienteActual().validarCuenta(cuentaIngresada);
    }

    @Override
    protected boolean procesarPago() {
	ICliente cliente = sesion.getClienteActual();
	double total = calcularTotalFinal();
	if (cliente.getDinero() < total || !cliente.descontarDinero(total)) {
	    return false;
	}
	this.totalCobrado = total;
	this.productosComprados = new ArrayList<>(sesion.getCarritoActual().getProductos());
	return true;
    }

    @Override
    protected Ticket generarTicket() {
        return new Ticket(
                sesion.getClienteActual(),
                productosComprados,
                totalCobrado,
                calcularFechaEntregaAleatoria()
        );
    }

    /**
     * Calcula una fecha estimada de entrega aleatoria entre 1 y 10 días a partir de hoy.
     *
     * @return fecha estimada de entrega
     */
    private String calcularFechaEntregaAleatoria() {
        Random random = new Random();
        int dias = 1 + random.nextInt(10);
        return LocalDate.now().plusDays(dias).toString();
    }
}
