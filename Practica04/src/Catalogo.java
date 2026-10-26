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
            System.out.print((i + 1) + ". ");
	    p.mostrarResumen();
        }
	System.out.println("====================================");
    }

    /**
     * Obtiene el número total de productos en el catálogo.
     * @return Cantidad de productos.
     */
    public int getTamanio(){
	return productos.size();
    }

    /**
     * Obtiene un producto del catalogo segun su numero de indice.
     * @param indice El numero de orden del producto en el listado.
     * @return El producto correspondiente, o null si el indice es invalido.
     */
    public Producto obtenerProductoPorIndice(int indice) {
        if (indice >= 0 && indice < productos.size()) {
            return productos.get(indice);
        }
        return null;
    }

    /**
     * Filtra y muestra los productos por un genero especifico.
     * @param genero El genero a buscar.
     */
    public void filtrarPorGenero(String genero) {
	System.out.println("\n=== PRODUCTOS DEL GÉNERO: " + genero + " ===");
	boolean encontrado = false;
    
	for (int i = 0; i < productos.size(); i++) {
	    Producto p = productos.get(i);
	    if (p.getGenero().equalsIgnoreCase(genero)) {
		System.out.print((i + 1) + ". ");
		p.mostrarResumen();
		encontrado = true;
	    }
	}
    
	if (!encontrado) {
	    System.out.println("No se encontraron productos de ese género.");
	}
	System.out.println("=========================================");
    }

    /**
     * Filtra y muestra los productos que cuesten igual o menos de un costo maximo.
     * @param costoMaximo El limite de precio.
     */
    public void filtrarPorCostoMaximo(double costoMaximo) {
        System.out.println("\n=== PRODUCTOS HASTA $" + costoMaximo + " ===");
	boolean encontrado = false;

	for (int i = 0; i < productos.size(); i++) {
	    Producto p = productos.get(i);
	    if (p.getPrecio() <= costoMaximo) {
		System.out.print((i + 1) + ". ");
		p.mostrarResumen();
		encontrado = true;
	    }
	}

	if (!encontrado) {
	    System.out.println("No se encontraron productos dentro de ese precio.");
	}
	System.out.println("=========================================");
    }
}
