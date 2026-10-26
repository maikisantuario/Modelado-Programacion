import java.util.Iterator;
/**
 * Interfaz que representa un producto en nuestra tienda RockBuster.
 * Aplica el patrón Composite.
 */
public interface Producto {

    /**
     * Obtiene el nombre del producto.
     * @return El nombre del producto.
     */
    public String getNombre();

    /**
     * Obtiene el género del producto.
     * @return El género del producto.
     */
    public String getGenero();

    /**
     * Obtiene el precio del producto.
     * @return El precio del producto.
     */
    public double getPrecio();

    /**
     * Obtiene la duración del producto.
     * @return La duración del producto.
     */
    public int getDuracion();

    /**
     * Muestra un resumen del producto.
     */
    public void mostrarResumen();

    /**
     * Muestra la información detallada del producto.
     */
    public void mostrarDetalle();

    /**
     * Agrega un producto hijo.
     * @param producto El producto a agregar.
     */
    public void agregar(Producto producto);

    /**
     * Elimina un producto hijo.
     * @param producto El producto a eliminar.
     */
    public void eliminar(Producto producto);

    /**
     * Obtiene un producto hijo por su índice.
     * @param indice El índice del hijo.
     * @return El producto correspondiente.
     */
    public Producto obtenerHijo(int indice);

    /**
     * Crea y retorna un iterador para la estructura.
     * @return Un iterador de productos.
     */
    public Iterator<Producto> crearIterador();
}
