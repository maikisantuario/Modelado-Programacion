/**
 * Singleton que administra el estado de la sesión actual del cliente,
 * su carrito de compras y su estrategia de localización.
 */
public class SesionSingleton {

    /** Instancia única de la sesión global. */
    private static SesionSingleton instancia;

    /** Cliente actualmente autenticado. */
    private ICliente clienteActual;

    /** Carrito de compras asociado a la sesión actual. */
    private CarritoDeCompras carritoActual;

    /** Estrategia de idioma activa según el país del cliente. */
    private ILocalizacionStrategy estrategiaIdioma;

    /**
     * Constructor privado para impedir instanciación externa directa.
     */
    private SesionSingleton() {
        this.carritoActual = new CarritoDeCompras();
    }

    /**
     * Devuelve la instancia única de {@link SesionSingleton}.
     *
     * @return instancia única
     */
    public static SesionSingleton getInstancia() {
        if (instancia == null) {
            instancia = new SesionSingleton();
        }
        return instancia;
    }

    /**
     * Inicia sesión para un cliente autenticado asignando su estrategia de idioma.
     *
     * @param c      cliente autenticado
     * @param idioma estrategia de localización
     */
    public void iniciarSesion(ICliente c, ILocalizacionStrategy idioma) {
        this.clienteActual = c;
        this.estrategiaIdioma = idioma;
        this.carritoActual = new CarritoDeCompras();
    }

    /**
     * Cierra la sesión activa y vacía el carrito.
     */
    public void cerrarSesion() {
        if (this.carritoActual != null) {
            this.carritoActual.vaciarCarrito();
        }
        this.clienteActual = null;
        this.estrategiaIdioma = null;
    }

    /**
     * Obtiene el cliente actualmente autenticado.
     *
     * @return cliente actual o {@code null} si no hay sesión iniciada
     */
    public ICliente getClienteActual() {
        return clienteActual;
    }

    /**
     * Obtiene el carrito de compras de la sesión actual.
     *
     * @return carrito de compras
     */
    public CarritoDeCompras getCarritoActual() {
        return carritoActual;
    }

    /**
     * Obtiene la estrategia de idioma activa.
     *
     * @return estrategia de localización
     */
    public ILocalizacionStrategy getEstrategiaIdioma() {
        return estrategiaIdioma;
    }
}
