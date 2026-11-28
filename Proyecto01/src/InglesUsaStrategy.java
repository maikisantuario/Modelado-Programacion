/**
 * Implementacion de la estrategia de localizacion para el idioma Ingles USA.
 */
public class InglesUsaStrategy implements ILocalizacionStrategy {
    
    /**
     * Genera el saludo en Ingles americano.
     *
     * @param nombre Nombre del cliente.
     * @return El saludo.
     */
    @Override
    public String saludar(String nombre) {
        return "Hello " + nombre + "! Welcome to CheemsMart.";
    }

    /**
     * Genera la despedida en Ingles americano.
     *
     * @return La despedida.
     */
    @Override
    public String despedirse() {
        return "Thanks for shopping with us! Hope to see you again soon.";
    }

    /**
     * Genera el menu principal en Ingles americano.
     *
     * @return El menu.
     */
    @Override
    public String mensajeMenuPrincipal() {
        return "=== MAIN MENU ===\n" +
	    "1. View catalog\n" +
	    "2. Purchase\n" +
	    "3. Exit \n" +
	    "Select an option: ";
    }

    /**
     * Genera el mensaje de error de menu en ingles americano.
     *
     * @return El mensaje.
     */
    @Override
    public String mensajeErrorMenu() {
        return "Error: Invalid input. Please try again.";
    }

    /**
     * Genera el menu de compra en Ingles americano.
     *
     * @return El menu.
     */
    @Override
    public String mensajeMenuCompra() {
        return "=== SHOP MENU ===\n" +
	    "1. Add to cart\n" +
	    "2. Cancel Purchase\n" +
	    "3. Finish purchase\n" +
	    "Select an option: ";
    }

    /**
     * Genera el mensaje de compra exitosa en ingles americano.
     *
     * @param fecha Fecha estimada de entrega.
     * @return El mensaje.
     */
    @Override
    public String mensajeCompraExitosa(String fecha) {
        return "Purchase completed successfully! Estimated delivery date: " + fecha + ".";
    }

    /**
     * Genera el mensaje de error de pago en ingles americano.
     *
     * @return El mensaje.
     */
    @Override
    public String mensajeErrorPago() {
        return "Error: Bank account does not match. The purchase has been canceled.";
    }

    /**
     * Formatea una oferta en ingles americano.
     *
     * @param departamento Departamento de la oferta.
     * @param descuento    Porcentaje de descuento.
     * @return El texto formateado.
     */
    @Override
    public String formatearOferta(String departamento, int descuento) {
        return "SPECIAL OFFER! " + descuento + "% discount on " + departamento + " products.";
    }

    /**
     * Genera el mensaje de saldo insuficiente en ingles americano.
     *
     * @return El mensaje.
     */
    @Override
    public String mensajeSaldoInsuficiente() {
	return "Error: Insufficient funds. The purchase has been canceled.";
    }
}
