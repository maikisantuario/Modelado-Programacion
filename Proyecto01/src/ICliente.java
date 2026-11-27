/**
 * Interfaz común del cliente dentro del patrón Proxy.
 * Es implementada tanto por {@link ClienteReal}, que guarda los datos,
 * como por {@link ClienteProxy}, que controla el acceso a él.
 * Extiende {@link IObserverCliente} para que cualquiera de los dos pueda recibir
 * las ofertas enviadas por el servidor.
 */
public interface ICliente extends IObserverCliente {
    /**
     * Obtiene el nombre de usuario del cliente.
     *
     * @return nombre de usuario
     */
    String getUsuario();

    /**
     * Verifica si la contraseña ingresada coincide con la registrada.
     *
     * @param pass contraseña ingresada
     * @return {@code true} si coincide, {@code false} en caso contrario
     */
    boolean validarContrasena(String pass);

    /**
     * Verifica si el número de cuenta bancaria coincide con la cuenta
     * asociada al cliente.
     *
     * @param cuenta número de cuenta bancaria ingresado
     * @return {@code true} si coincide, {@code false} en caso contrario
     */
    boolean validarCuenta(String cuenta);

    /**
     * Obtiene el país de origen del cliente.
     *
     * @return país de origen
     */
    String getPais();

    /**
     * Obtiene el dinero disponible del cliente.
     *
     * @return saldo actual
     */
    double getDinero();

    /**
     * Descuenta un monto del saldo del cliente si cuenta con fondos suficientes.
     *
     * @param monto cantidad a descontar
     * @return {@code true} si se realizó el descuento, {@code false} si no
     *         se pudo realizar
     */
    boolean descontarDinero(double monto);

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre completo
     */
    String getNombre();

    /**
     * Obtiene la dirección de entrega del cliente.
     *
     * @return dirección del cliente
     */
    String getDireccion();
}
