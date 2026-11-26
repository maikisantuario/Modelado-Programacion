/**
 * Representa a un cliente registrado en la tienda virtual CheemsMart.
 * Implementa {@link IObserverCliente} para recibir notificaciones de ofertas
 * correspondientes a su país de origen.
 */
public class Cliente implements IObserverCliente {
    /** Identificador único del cliente. */
    private String id;

    /** Nombre de usuario para iniciar sesión. */
    private String usuario;

    /** Contraseña de acceso del cliente. */
    private String contrasena;

    /** Nombre completo del cliente. */
    private String nombre;

    /** Número telefónico del cliente. */
    private String telefono;

    /** Dirección de entrega del cliente. */
    private String direccion;

    /** Número de cuenta bancaria asociada para compra segura. */
    private String cuentaBancaria;

    /** País de origen que determina la localización de la interfaz. */
    private String pais;

    /** Saldo disponible del cliente para realizar compras. */
    private double dinero;

    /**
     * Construye un cliente con todos sus datos de registro y saldo inicial.
     *
     * @param id             identificador único del cliente
     * @param usuario        nombre de usuario
     * @param contrasena     contraseña de acceso
     * @param nombre         nombre completo
     * @param telefono       teléfono de contacto
     * @param direccion      dirección de domicilio
     * @param cuentaBancaria cuenta bancaria asociada
     * @param pais           país de origen
     * @param dinero         saldo disponible
     */

    public Cliente(String id, String usuario, String contrasena, String nombre, String nombre, String telefono, String direccion, String cuentaBancaria, String pais, double dinero) {
	this.id = id;
	this.usuario = usuario;
	this.contrasena = contrasena;
	this.nombre = nombre;
	this.telefono = telefono;
	this.direccion = direccion;
	this.cuentaBancaria = cuentaBancaria;
	this.pais = pais;
	this.dinero = dinero;
    }

    /**
     * Obtiene el nombre de usuario del cliente.
     *
     * @return nombre de usuario
     */
    public String getUsuario() {
	return usuario;
    }

    /**
     * Verifica si la contraseña ingresada coincide con la registrada.
     *
     * @param pass contraseña ingresada
     * @return {@code true} si coincide, {@code false} en caso contrario
     */
    public boolean validarContrasena(String pass) {
        return contrasena != null && contrasena.equals(pass);
    }

    /**
     * Verifica si el número de cuenta bancaria coincide con la cuenta asociada al cliente.
     *
     * @param cuenta número de cuenta bancaria ingresado
     * @return {@code true} si coincide, {@code false} en caso contrario
     */
    public boolean validarCuenta(String cuenta) {
        return cuentaBancaria != null && cuentaBancaria.equals(cuenta);
    }

    /**
     * Obtiene el país de origen del cliente.
     *
     * @return país de origen
     */
    public String getPais() {
        return pais;
    }

    /**
     * Obtiene el dinero disponible del cliente.
     *
     * @return saldo actual
     */
    public double getDinero() {
        return dinero;
    }

    /**
     * Descuenta un monto del saldo del cliente si cuenta con fondos suficientes.
     *
     * @param monto cantidad a descontar
     * @return {@code true} si se realizó el descuento, {@code false} si no alcanza el saldo
     */
    public boolean descontarDinero(double monto) {
        if (monto < 0 || dinero < monto) {
            return false;
        }
        dinero -= monto;
        return true;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la dirección de entrega del cliente.
     *
     * @return dirección del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Recibe y muestra una notificación de oferta enviada por el servidor.
     *
     * @param oferta mensaje de oferta formateado
     */
    @Override
    public void actualizar(String oferta) {
	System.out.println("[" + nombre + " (" + pais + ")]: " + oferta);
    }
}
