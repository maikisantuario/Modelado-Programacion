import java.util.List;

/**
 * Representa el ticket emitido al concretar una compra, incluyendo la fecha estimada de entrega.
 */
public class Ticket {

    /** Cliente que realizó la compra. */
    private Cliente cliente;

    /** Lista de productos comprados. */
    private List<Producto> productos;

    /** Monto total pagado en la transacción. */
    private double totalPagado;

    /** Fecha estimada de entrega a domicilio. */
    private String fechaEntrega;

    /**
     * Construye un ticket con los datos finales de la compra.
     *
     * @param cliente      cliente comprador
     * @param productos    productos adquiridos
     * @param totalPagado  total pagado
     * @param fechaEntrega fecha estimada de entrega
     */
    public Ticket(Cliente cliente, List<Producto> productos, double totalPagado, String fechaEntrega) {
        this.cliente = cliente;
        this.productos = productos;
        this.totalPagado = totalPagado;
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Imprime el ticket y el mensaje de compra exitosa en el idioma del cliente.
     *
     * @param idioma estrategia de localización del cliente
     */
    public void imprimirTicket(ILocalizacionStrategy idioma) {
        System.out.println("\n==========================================");
        System.out.println("            TICKET CHEEMSMART             ");
        System.out.println("==========================================");
        System.out.println(idioma.mensajeCompraExitosa(fechaEntrega));
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("------------------------------------------");
        for (Producto p : productos) {
            System.out.println("  * " + p.getNombre() + " (" + p.getDepartamento() + ") - $"
                    + String.format("%.2f", p.getPrecio()));
        }
        System.out.println("------------------------------------------");
        System.out.println("Total pagado: $" + String.format("%.2f", totalPagado));
        System.out.println("Saldo restante: $" + String.format("%.2f", cliente.getDinero()));
        System.out.println("==========================================\n");
    }
}
