package tienda;

/**
 * Representa a un cliente registrado en CheemsMart.
 * Almacena informacion personal, cuenta bancaria, pais de origen y saldo.
 * Implementa el patron Observer para poder recibir ofertas.
 */
public class Cliente implements IObservadorCliente {

    /** Identificador unico del cliente. */
    private String id;

    /** Nombre de usuario para iniciar sesion. */
    private String usuario;

    /** Contrasena del cliente. */
    private String contrasena;

    /** Nombre real del cliente. */
    private String nombre;

    /** Telefono de contacto. */
    private String telefono;

    /** Direccion de envio. */
    private String direccion;

    /** Cuenta bancaria asociada al cliente. */
    private String cuentaBancaria;

    /** Pais de origen del cliente. */
    private String pais;

    /** Saldo disponible del cliente. */
    private double dinero;

    /** Oferta actual recibida (null si no hay oferta). */
    private String ofertaActual;

    /**
     * Constructor completo del cliente.
     *
     * @param id             Identificador unico.
     * @param usuario        Nombre de usuario.
     * @param contrasena     Contrasena.
     * @param nombre         Nombre real.
     * @param telefono       Telefono.
     * @param direccion      Direccion.
     * @param cuentaBancaria Cuenta bancaria.
     * @param pais           Pais de origen.
     * @param dinero         Saldo inicial.
     */
    public Cliente(String id, String usuario, String contrasena, String nombre,
                   String telefono, String direccion, String cuentaBancaria,
                   String pais, double dinero) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cuentaBancaria = cuentaBancaria;
        this.pais = pais;
        this.dinero = dinero;
        this.ofertaActual = null;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return El identificador.
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Valida las credenciales del cliente.
     *
     * @param usuario    Nombre de usuario ingresado.
     * @param contrasena Contrasena ingresada.
     * @return true si coinciden, false de lo contrario.
     */
    public boolean validarCredenciales(String usuario, String contrasena) {
        return this.usuario.equals(usuario) && this.contrasena.equals(contrasena);
    }

    /**
     * Valida la cuenta bancaria del cliente.
     *
     * @param cuenta Cuenta bancaria ingresada.
     * @return true si coincide, false de lo contrario.
     */
    public boolean validarCuenta(String cuenta) {
        return this.cuentaBancaria.equals(cuenta);
    }

    /**
     * Obtiene el pais de origen del cliente.
     *
     * @return El pais.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Obtiene el nombre real del cliente.
     *
     * @return El nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la direccion del cliente.
     *
     * @return La direccion.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Obtiene la cuenta bancaria del cliente.
     *
     * @return La cuenta bancaria.
     */
    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Obtiene el saldo disponible del cliente.
     *
     * @return El saldo.
     */
    public double getDinero() {
        return dinero;
    }

    /**
     * Descuenta un monto del saldo del cliente.
     *
     * @param monto Monto a descontar.
     * @return true si se desconto, false si no hay saldo suficiente.
     */
    public boolean descontarDinero(double monto) {
        if (this.dinero >= monto) {
            this.dinero -= monto;
            return true;
        }
        return false;
    }

    /**
     * Obtiene la oferta actual del cliente.
     *
     * @return La oferta actual o null.
     */
    public String getOfertaActual() {
        return ofertaActual;
    }

    /**
     * Actualiza la oferta del cliente (patron Observer).
     *
     * @param oferta Texto descriptivo de la oferta.
     */
    @Override
    public void actualizarOferta(String oferta) {
        this.ofertaActual = oferta;
    }

    /**
     * Devuelve una representacion en cadena del cliente.
     *
     * @return Cadena con la informacion del cliente.
     */
    @Override
    public String toString() {
        return String.format("Cliente[id=%s, usuario=%s, nombre=%s, pais=%s, saldo=%.2f]",
                id, usuario, nombre, pais, dinero);
    }
}