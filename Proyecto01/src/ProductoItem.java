/**
 * Representa un producto individual dentro del catalogo.
 * Es el elemento basico que se muestra al cliente.
 */
public class ProductoItem extends ComponenteCatalogo {

    /** El producto asociado a este elemento. */
    private Producto producto;

    /**
     * Constructor del item de producto.
     *
     * @param producto El producto a envolver.
     */
    public ProductoItem(Producto producto) {
        this.producto = producto;
        this.nombre = producto.getNombre();
    }

    /**
     * Obtiene el producto asociado.
     *
     * @return El producto.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Muestra la informacion del producto con formato de arbol.
     *
     * @param indentacion Cadena de espacios para la indentacion.
     */
    @Override
    public void mostrarIdentacion(String indentacion) {
        System.out.println(indentacion + "- " + producto.toString());
    }
}