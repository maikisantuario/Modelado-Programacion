package tienda;

/**
 * Contrato de un observador de ofertas (patron Observer).
 * Cualquier clase que quiera recibir notificaciones del servidor de ofertas
 * debe utilizar esta interfaz.
 */
public interface IObservadorCliente {

    /**
     * Actualiza al observador con la oferta recibida.
     *
     * @param oferta Texto descriptivo de la oferta.
     */
    void actualizarOferta(String oferta);
}