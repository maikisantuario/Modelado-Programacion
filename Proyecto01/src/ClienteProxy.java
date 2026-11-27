/**
 * Proxy de protección para el cliente.
 * Representa a {@link ClienteReal} ante el resto del sistema y controla el
 * acceso a sus operaciones sensibles: no permite descontar dinero hasta que
 * la cuenta bancaria haya sido verificada con {@link #validarCuenta(String)}.
 * El resto de las operaciones se delegan directamente al cliente real.
 */
public class ClienteProxy implements ICliente {
    /** Cliente real al que este proxy representa. */
    private ClienteReal clienteReal;
    
    /** Indica si la cuenta bancaria fue verificada para la compra en curso. */
    private boolean cuentaVerificada;
    
    /**
     * Construye un proxy para un cliente real.
     *
     * @param clienteReal cliente real al que se controlará el acceso
     */
    public ClienteProxy() {
	this.clienteReal = clienteReal;
	this.cuentaVerificad = null;
    }
    
    /**
     * Obtiene el nombre de usuario del cliente.
     *
     * @return nombre de usuario
     */
    @Override
    public String getUsuario() {
	return clienteReal.getUsuario();
    }
    
    /**
     * Verifica si la contraseña ingresada coincide con la registrada.
     *
     * @param pass contraseña ingresada
     * @return {@code true} si coincide, {@code false} en caso contrario
     */
    @Override
    public boolean validarContrasena(String pass) {
        return clienteReal.validarContrasena(pass);
    }

    /**
     * Verifica si el número de cuenta bancaria coincide con la cuenta asociada
     * al cliente real y guarda el resultado para autorizar el cobro.
     *
     * @param cuenta número de cuenta bancaria ingresado
     * @return {@code true} si coincide, {@code false} en caso contrario
     */
    @Override
    public boolean validarCuenta(String cuenta) {
	cuentaVerificada = clienteReal.validarCuenta(cuenta);
        return cuentaVerificada;
    }
    
    /**
     * Obtiene el país de origen del cliente.
     *
     * @return país de origen
     */
    @Override
    public String getPais() {
	return clienteReal.getPais();
    }

    /**
     * Obtiene el dinero disponible del cliente.
     *
     * @return saldo actual
     */
    @Override
    public double getDinero() {
	return clienteReal.getDinero();
    }

    /**
     * Descuenta un monto del saldo del cliente si cuenta con fondos suficientes.
     * 
     * @param monto cantidad a descontar
     * @return {@code true} si se realizó el descuento, {@code false} si la
     *         cuenta no fue verificada, el monto es negativo o no alcanza el saldo
     */
    @Override
    public boolean descontarDinero(double monto) {
	if (!cuentaVerificada) {
            return false;
        }
        boolean descontado = clienteReal.descontarDinero(monto);
        if (descontado) {
            cuentaVerificada = false;
        }
        return descontado;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre completo
     */
    @Override
    public String getNombre() {
	return clienteReal.getNombre();
    }

    /**
     * Obtiene la dirección de entrega del cliente.
     *
     * @return dirección del cliente
     */
    @Override
    public String getDireccion() {
	return clienteReal.getDireccion();
    }

    /**
     * Recibe y muestra una notificación de oferta enviada por el servidor.
     *
     * @param oferta mensaje de oferta formateado
     */
    @Override
    public void actualizar(String oferta) {
        clienteReal.actualizar(oferta);
    }
}
