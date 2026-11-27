/**
 * Implementacion de la estrategia de localizacion para el idioma Espanol Latino.
 */
public class EspanolLatinoStrategy implements ILocalizacionStrategy {
    
    /**
     * Genera el saludo en espanol latino.
     *
     * @param nombre Nombre del cliente.
     * @return El saludo.
     */
    @Override
    public String saludar(String nombre) {
        return "¡Hola " + nombre + "! Bienvenide a CheemsMart.";
    }

    /**
     * Genera la despedida en espanol latino.
     *
     * @return La despedida.
     */
    @Override
    public String despedirse() {
        return "¡Gracias por su compra! Vuelva pronto.";
    }

    /**
     * Genera el menu principal en espanol latino.
     *
     * @return El menu.
     */
    @Override
    public String mensajeMenuPrincipal() {
        return "=== MENU PRINCIPAL ===\n" +
               "1. Ver catalogo\n" +
               "2. Realizar una compra\n" +
               "3. Salir\n" +
               "Seleccione una opcion: ";
    }

    /**
     * Genera el mensaje de error de menu en espanol latino.
     *
     * @return El mensaje.
     */
    @Override
    public String mensajeErrorMenu() {
        return "Error: Entrada no válida. Vuelva a intentarlo.";
    }

    /**
     * Genera el mensaje de compra exitosa en espanol latino.
     *
     * @param fecha Fecha estimada de entrega.
     * @return El mensaje.
     */
    @Override
    public String mensajeCompraExitosa(String fecha) {
        return "¡Compra realizada con exito! Su pedido llegara aproximadamente el " + fecha + ".";
    }

    /**
     * Genera el mensaje de error de pago en espanol latino.
     *
     * @return El mensaje.
     */
    @Override
    public String mensajeErrorPago() {
        return "Error: La cuenta bancaria no coincide. La compra ha sido cancelada.";
    }

    /**
     * Formatea una oferta en espanol latino.
     *
     * @param departamento Departamento de la oferta.
     * @param descuento    Porcentaje de descuento.
     * @return El texto formateado.
     */
    @Override
    public String formatearOferta(String departamento, int descuento) {
        return "¡OFERTA ESPECIAL! Descuento del " + descuento + "% en productos de " + departamento + ".";
    }
}
