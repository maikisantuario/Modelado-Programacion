import java.util.Collections;
import java.util.Iterator;

/**
 * Adaptador que permite que un DiscoMusical sea tratado como un Producto.
 * Implementa el patron Adapter.
 */
public class AdaptadorDiscoMusical implements Producto {
    private DiscoMusical disco;

    /**
     * Constructor que recibe el disco musical a adaptar.
     * @param disco El disco musical a envolver.
     */
    public AdaptadorDiscoMusical(DiscoMusical disco) {
        this.disco = disco;
    }

    /**
     * Obtiene el nombre del disco adaptado.
     * @return El nombre del disco.
     */
    @Override
    public String getNombre() {
        return disco.getNombre();
    }

    /**
     * Obtiene el género musical adaptado como género de producto.
     * @return El género musical.
     */
    @Override
    public String getGenero() {
        return disco.getGeneroMusical();
    }

    /**
     * Obtiene el precio de venta adaptado como precio de producto.
     * @return El precio de venta.
     */
    @Override
    public double getPrecio() {
        return disco.getPrecioVenta();
    }

    /**
     * Obtiene la duración del producto adaptado (0 por defecto para discos).
     * @return La duración en minutos (0).
     */
    @Override
    public int getDuracion() {
        return 0;
    }

    @Override
    public void mostrarResumen() {
	System.out.println(disco.getNombre() + " - $" + String.format("%.2f", disco.getPrecioVenta()));
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("----------------------------------------");
        System.out.println("Disco Musical: " + disco.getNombre());
        System.out.println("Artista: " + disco.getArtista());
        System.out.println("Genero: " + disco.getGeneroMusical());
        System.out.println("Año de estreno: " + disco.getAnioEstreno());
        System.out.println("Precio: $" + disco.getPrecioVenta());
        System.out.println("----------------------------------------");
    }

    /**
     * Lanza una excepción ya que los discos adaptados no tienen hijos.
     * @param producto El producto a agregar.
     */
    @Override
    public void agregar(Producto producto) {
        throw new UnsupportedOperationException("Un disco musical adaptado no tiene hijos.");
    }

    /**
     * Lanza una excepción ya que los discos adaptados no tienen hijos.
     * @param producto El producto a eliminar.
     */
    @Override
    public void eliminar(Producto producto) {
        throw new UnsupportedOperationException("Un disco musical adaptado no tiene hijos.");
    }

    /**
     * Lanza una excepción ya que los discos adaptados no tienen hijos.
     * @param indice El índice del hijo.
     * @return El producto correspondiente.
     */
    @Override
    public Producto obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Un disco musical adaptado no tiene hijos.");
    }

    /**
     * Crea un iterador vacío para el disco adaptado.
     * @return Un iterador vacío.
     */
    @Override
    public Iterator<Producto> crearIterador() {
        return Collections.emptyIterator();
    }
}
