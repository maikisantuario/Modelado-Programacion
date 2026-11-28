import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Decide aleatoriamente si se activa una oferta regional y notifica a los clientes
 * correspondientes según su país y departamento preferido.
 */
public class ServidorOfertas implements ITiendaSujeto {

    /** Lista de clientes observadores registrados. */
    private List<IObserverCliente> observadores;

    /** Mensaje formateado de la oferta vigente. */
    private String ofertaActual;

    /** País objetivo de la oferta activa. */
    private String paisObjetivo;

    /** Departamento incluido en la oferta vigente. */
    private String departamentoOferta;

    /** Porcentaje de descuento aplicado en la oferta vigente. */
    private int porcentajeDescuento;

    /** Indica si existe una oferta activa en el momento actual. */
    private boolean ofertaActiva;

    /** Generador de aleatoriedad para ofertas y descuentos. */
    private Random random;

    /**
     * Construye el servidor de ofertas sin oferta activa inicialmente.
     */
    public ServidorOfertas() {
        this.observadores = new ArrayList<>();
        this.ofertaActiva = false;
        this.random = new Random();
    }

    /**
     * Registra un cliente observador.
     *
     * @param o observador a registrar
     */
    @Override
    public void registrarObservador(IObserverCliente o) {
        if (o != null && !observadores.contains(o)) {
            observadores.add(o);
        }
    }

    /**
     * Elimina un cliente observador.
     *
     * @param o observador a eliminar
     */
    @Override
    public void eliminarObservador(IObserverCliente o) {
        observadores.remove(o);
    }

    /**
     * Notifica la oferta únicamente a los observadores que pertenecen al país objetivo.
     */
    @Override
    public void notificarObservador() {
        if (!ofertaActiva || ofertaActual == null) {
            return;
        }
        for (IObserverCliente o : observadores) {
            if (o instanceof ICliente) {
                ICliente cliente = (ICliente) o;
                if (cliente.getPais().equalsIgnoreCase(paisObjetivo)) {
                    cliente.actualizar(ofertaActual);
                }
            } else {
                o.actualizar(ofertaActual);
            }
        }
    }

    /**
     * Decide de forma aleatoria si se genera una oferta para el país del usuario
     * y asigna el departamento preferido del país con un descuento razonable.
     *
     * @param idioma estrategia de idioma para formatear la oferta
     * @param pais   país de origen del cliente
     */
    public void generarOfertaAleatoria(ILocalizacionStrategy idioma, String pais) {
        // Probabilidad del 60% de activar una oferta en este inicio de sesión
        this.ofertaActiva = random.nextInt(100) < 60;
        if (!this.ofertaActiva) {
            this.paisObjetivo = null;
            this.departamentoOferta = null;
            this.porcentajeDescuento = 0;
            this.ofertaActual = null;
            return;
        }

        this.paisObjetivo = pais;
        if ("Estados Unidos".equalsIgnoreCase(pais)) {
            this.departamentoOferta = "Electronica";
        } else if ("Italia".equalsIgnoreCase(pais)) {
            this.departamentoOferta = "Alimentos";
        } else {
            this.departamentoOferta = "Medicamentos";
        }

        int[] descuentos = {15, 25, 50};
        this.porcentajeDescuento = descuentos[random.nextInt(descuentos.length)];
        this.ofertaActual = idioma.formatearOferta(departamentoOferta, porcentajeDescuento);
    }

    /**
     * Indica si aplica el descuento activo para el país del cliente y el departamento del producto.
     *
     * @param pais         país del cliente
     * @param departamento departamento del producto
     * @return {@code true} si la oferta aplica, {@code false} en caso contrario
     */
    public boolean aplicaDescuento(String pais, String departamento) {
        return ofertaActiva
                && pais != null
                && departamento != null
                && pais.equalsIgnoreCase(paisObjetivo)
                && departamento.equalsIgnoreCase(departamentoOferta);
    }

    /**
     * Obtiene el departamento en oferta.
     *
     * @return departamento de la oferta actual
     */
    public String getDepartamentoOferta() {
        return departamentoOferta;
    }

    /**
     * Obtiene el porcentaje de descuento de la oferta actual.
     *
     * @return porcentaje de descuento
     */
    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
}
