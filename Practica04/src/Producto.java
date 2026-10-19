
/**
 * Interfaz que representa un producto en la tienda RockBuster.
 * Aplica el patron Composite.
 */
public interface Producto {
    
    /**
     * Obtiene el nombre del producto.
     * @return 
     */
    String getNombre();
    
    /**
     * Obtiene el genero del producto.
     * @return 
     */
    String getGenero();
    
    /**
     * Muestra la informacion completa del productp
     */
    void mostrarResumen();
    
    /**
     * Obtiene el precio de renta/venta del producto
     * @return 
     */
    double getPrecio();
}