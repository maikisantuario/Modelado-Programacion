import java.util.ArrayList;
import java.util.List;

/**
 * Implementacion real del catalogo de CheemsMart.
 * Contiene la logica para cargar y organizar todos los productos de la tienda.
 * Esta clase no debe ser accedida directamente por el cliente (se usa el Proxy).
 */
public class CatalogoReal implements ICatalogo {

    /** Lista plana de todos los productos del catalogo. */
    private List<Producto> listaProductos;

    /** Departamento raiz del catalogo (patron Composite). */
    private DepartamentoMenu raizCatalogo;

    /**
     * Constructor que inicializa y carga el catalogo con productos de prueba.
     */
    public CatalogoReal() {
        this.listaProductos = new ArrayList<>();
        this.raizCatalogo = new DepartamentoMenu("Catalogo General CheemsMart");
        cargarProductosIniciales();
    }

    /**
     * Carga productos de prueba y los organiza en departamentos (Composite).
     */
    private void cargarProductosIniciales() {
        DepartamentoMenu electronica = new DepartamentoMenu("Electronica");
        DepartamentoMenu farmacia = new DepartamentoMenu("Farmacia");
        DepartamentoMenu alimentos = new DepartamentoMenu("Alimentos");

        // Productos de Electronica
        Producto p1 = new Producto("1001", "Televisor Smart 4K", "Electronica", 5000.0);
        Producto p2 = new Producto("1002", "Audifonos Bluetooth", "Electronica", 800.0);
        
        // Productos de Farmacia
        Producto p3 = new Producto("2001", "Paracetamol 500mg", "Farmacia", 50.0);
        Producto p4 = new Producto("2002", "Vitamina C", "Farmacia", 120.0);

        // Productos de Alimentos
        Producto p5 = new Producto("3001", "Cafe Molido 1kg", "Alimentos", 250.0);
        Producto p6 = new Producto("3002", "Galletas de Avena", "Alimentos", 35.0);

        // Se agregan a la lista plana
        listaProductos.add(p1);
        listaProductos.add(p2);
        listaProductos.add(p3);
        listaProductos.add(p4);
        listaProductos.add(p5);
        listaProductos.add(p6);

        // Se agregan a los departamentos (Composite)
        electronica.agregar(new ProductoItem(p1));
        electronica.agregar(new ProductoItem(p2));
        
        farmacia.agregar(new ProductoItem(p3));
        farmacia.agregar(new ProductoItem(p4));
        
        alimentos.agregar(new ProductoItem(p5));
        alimentos.agregar(new ProductoItem(p6));

        // Se agregan los departamentos a la raiz
        raizCatalogo.agregar(electronica);
        raizCatalogo.agregar(farmacia);
        raizCatalogo.agregar(alimentos);
    }

    /**
     * Obtiene el catalogo completo en formato de arbol.
     *
     * @return El componente raiz del catalogo.
     */
    @Override
    public ComponenteCatalogo obtenerCatalogo() {
        return raizCatalogo;
    }

    /**
     * Busca un producto por su codigo de barras en la lista plana.
     *
     * @param codigoBarras El codigo de barras a buscar.
     * @return El producto, o null si no existe.
     */
    @Override
    public Producto buscarProducto(String codigoBarras) {
        for (Producto p : listaProductos) {
            if (p.getCodigoBarras().equals(codigoBarras)) {
                return p;
            }
        }
        return null;
    }
}
