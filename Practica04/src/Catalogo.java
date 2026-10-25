import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa el catalogo general de la tienda RockBuster.
 * Contiene una unica lista de todos los productos.
 */
public class Catalogo {
    private List<Producto> productos;

    /**
     * Constructor de la clase Catalogo.
     * Inicializa la lista unificada de productos.
     */
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
        System.out.println("\n=== CATALOGO COMPLETO ROCKBUSTER ===");
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " - $" + p.getPrecio());
        }
	System.out.println("====================================");
    }

    /**
     * Obtiene un producto del catalogo segun su numero de indice.
     * @param indice El numero de orden del producto en el listado.
     * @return El producto correspondiente, o null si el indice es invalido.
     */
    public Producto obtenerProductoPorIndice(int indice) {
        if (indice > 0 && indice <= productos.size()) {
            return productos.get(indice - 1);
        }
        return null;
    }

    /**
     * Filtra y muestra los productos por un genero especifico.
     * @param genero El genero a buscar.
     */
    public void filtrarPorGenero(String genero) {
        System.out.println("\n=== PRODUCTOS DEL GENERO: " + genero + " ===");
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getGenero().equalsIgnoreCase(genero)) {
                System.out.println("- " + p.getNombre() + " - $" + p.getPrecio());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos con ese genero.");
        }
        System.out.println("=========================================");
    }

    /**
     * Filtra y muestra los productos que cuesten igual o menos de un costo maximo.
     * @param costoMaximo El limite de precio.
     */
    public void filtrarPorCostoMaximo(double costoMaximo) {
        System.out.println("\n=== PRODUCTOS CON PRECIO <= $" + costoMaximo + " ===");
        boolean encontrado = false;
        for (Producto p : productos) {
            if (p.getPrecio() <= costoMaximo) {
                System.out.println("- " + p.getNombre() + " - $" + p.getPrecio());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron productos dentro de ese rango de precio.");
        }
        System.out.println("==================================================");
    }
}
