/**
 * Implementacion de la estrategia de localizacion para el idioma Italiano.
 */
public class ItalianoStrategy implements ILocalizacionStrategy {
    
    /**
     * Genera el saludo en italiano.
     *
     * @param nombre Nombre del cliente.
     * @return El saludo.
     */
    @Override
    public String saludar(String nombre) {
	return "Ciao " + nombre + "! Benvenuto a CheemsMart.";
    }

    /**
     * Genera la despedida en italiano.
     *
     * @return La despedida.
     */
    @Override
    public String despedirse() {
	return "Grazie per aver acquistato da noi! Speriamo di rivederti presto.";
    }

    /**
     * Genera el menu principal en italiano.
     *
     * @return El menu.
     */
    @Override
    public String mensajeMenuPrincipal() {
        return "=== MENU PRINCIPALE ===\n" +
	    "1. Visualizza catalogo\n" +
	    "2. Acquista\n" +
	    "3. Esci\n" +
	    "Seleziona un'opzione: ";
    }

    /**
     * Genera el mensaje de compra exitosa en italiano.
     *
     * @param fecha Fecha estimada de entrega.
     * @return El mensaje.
     */
    @Override
    public String mensajeCompraExitosa(String fecha) {
	return "Acquisto completato con successo! Data di consegna stimata: " + fecha + ".";
    }

    /**
     * Genera el mensaje de error de pago en italiano.
     *
     * @return El mensaje.
     */
    @Override
    public String mensajeErrorPago() {
	return "Errore: Il conto bancario non corrisponde. L'acquisto è stato annullato.";
    }

    /**
     * Formatea una oferta en ingles italiano.
     *
     * @param departamento Departamento de la oferta.
     * @param descuento    Porcentaje de descuento.
     * @return El texto formateado.
     */
    @Override
    public String formatearOferta(String departamento, int descuento) {
	return "OFFERTA SPECIALE! Sconto del " + descuento + "% sui prodotti di " + departamento + ".";
    }
}
