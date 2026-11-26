import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Representa el carrito de compras del cliente donde se agregan productos de uno en uno.
 */
public class CarritoDeCompras {

    /** Lista de productos agregados al carrito. */
    private List<Producto> productos;

    /**
     * Construye un carrito de compras vacío.
     */
    public CarritoDeCompras() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al carrito.
     *
     * @param p producto a agregar
     */
    public void agregarProducto(Producto p) {
        if (p != null) {
            productos.add(p);
        }
    }

    /**
     * Elimina la primera ocurrencia de un producto según su código de barras.
     *
     * @param codigoBarras código de barras del producto a eliminar
     * @return {@code true} si se eliminó algún producto, {@code false} en caso contrario
     */
    public boolean eliminarProducto(String codigoBarras) {
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto actual = it.next();
            if (actual.getCodigoBarras().equals(codigoBarras)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula la suma de precios de los productos en el carrito.
     *
     * @return total acumulado del carrito
     */
    public double calcularTotal() {
        double total = 0.0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    /**
     * Obtiene la lista de productos contenidos en el carrito.
     *
     * @return lista de productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * Devuelve un iterador sobre los productos del carrito.
     *
     * @return iterador de {@link Producto}
     */
    public Iterator<Producto> obtenerIterador() {
        return productos.iterator();
    }

    /**
     * Vacía todos los productos del carrito.
     */
    public void vaciarCarrito() {
        productos.clear();
    }

    /**
     * Indica si el carrito no contiene productos.
     *
     * @return {@code true} si está vacío, {@code false} si tiene productos
     */
    public boolean estaVacio() {
        return productos.isEmpty();
    }
}
