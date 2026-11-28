/**
 * Interfaz que define el contrato de una estrategia de localizacion (patron Strategy).
 * Permite cambiar dinamicamente el idioma de los mensajes de la tienda.
 */
public interface ILocalizacionStrategy {

    /**
     * Genera un saludo para el cliente.
     *
     * @param nombre Nombre del cliente.
     * @return El saludo en el idioma correspondiente.
     */
    String saludar(String nombre);

    /**
     * Genera el mensaje de despedida.
     *
     * @return La despedida en el idioma correspondiente.
     */
    String despedirse();

    /**
     * Genera el menu principal de la tienda.
     *
     * @return El menu en el idioma correspondiente.
     */
    String mensajeMenuPrincipal();

    /**
     * Genera el mensaje de error cuando no se escoge el numero correcto del menu.
     *
     * @return El mensaje de error.
     */
    String mensajeErrorMenu();

    /**
     * Genera el menu de compra de la tienda.
     *
     * @return El menu en el idioma correspondiente.
     */
    String mensajeMenuCompra();

    /**
     * Genera el mensaje cuando una compra es exitosa.
     *
     * @param fecha Fecha estimada de entrega.
     * @return El mensaje de compra exitosa.
     */
    String mensajeCompraExitosa(String fecha);

    /**
     * Genera el mensaje de error cuando falla el pago.
     *
     * @return El mensaje de error.
     */
    String mensajeErrorPago();

    /**
     * Formatea el texto de una oferta.
     *
     * @param departamento Departamento al que aplica la oferta.
     * @param descuento    Porcentaje de descuento.
     * @return El texto formateado de la oferta.
     */
    String formatearOferta(String departamento, int descuento);

    /**
     * Genera el mensaje que se muestra cuando el saldo del cliente no alcanza
     * para cubrir el total de la compra.
     *
     * @return el mensaje de saldo insuficiente en el idioma de la estrategia
     */
    String mensajeSaldoInsuficiente();
}
