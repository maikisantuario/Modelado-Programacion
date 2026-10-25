import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el catalogo general de la tienda RockBuster.
 * Contiene una unica lista de todos los productos.
 */
public class Catalogo {
    private List<Producto> productos;

    public Catalogo() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un producto al catalogo
     * @param producto El producto (pelicula, saga o disco) a agregar.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Muestra todos los productos del catalogo (solo nombre y precio).
     */
    public void mostrarCatalogoCompleto() {
        System.out.println("\n=== Catalogo completo ===");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " - $" + p.getPrecio());
        }
    }

    /**
     * Filtra y muestra los productos por un genero específico.
     * @param genero El genero a buscar.
     */
    public void filtrarPorGenero(String genero) {
        System.out.println("\n=== Productos del genero: " + genero + " ===");
        for (Producto p : productos) {
            if (p.getGenero().equalsIgnoreCase(genero)) {
                System.out.println("- " + p.getNombre() + " - $" + p.getPrecio());
            }
        }
    }

    /**
     * Filtra y muestra los productos que cuesten igual o menos de un costo maximo
     * @param costoMaximo El limite de precio.
     */
    public void filtrarPorCostoMaximo(double costoMaximo) {
        System.out.println("\n=== Productos con precio <= $" + costoMaximo + " ===");
        for (Producto p : productos) {
            if (p.getPrecio() <= costoMaximo) {
                System.out.println("- " + p.getNombre() + " - $" + p.getPrecio());
            }
        }
    }
}