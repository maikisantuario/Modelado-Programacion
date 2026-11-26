package tienda;

/**
 * Interfaz que define el contrato del catalogo de productos.
 * Permite abstraer el acceso al catalogo real mediante un Proxy.
 */
public interface ICatalogo {

    /**
     * Obtiene el catalogo completo organizado jerarquicamente.
     *
     * @return El componente raiz del catalogo.
     */
    ComponenteCatalogo obtenerCatalogo();

    /**
     * Busca un producto en el catalogo segun su codigo de barras.
     *
     * @param codigoBarras El codigo de barras del producto.
     * @return El producto encontrado, o null si no existe.
     */
    Producto buscarProducto(String codigoBarras);
}
