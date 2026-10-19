/**
 * Interfaz que representa un producto en nuestra tienda RockBuster.
 * Aplica el patrón Composite.
 */
public interface Producto {
    
    /**
     * Obtiene el nombre del producto.
     * @return 
     */
    String getNombre();
    
    /**
     * Obtiene el genero del producto
     * @return 
     */
    String getGenero();
    
    /**
     * Muestra la informacion completa del producto
     */
    void mostrarResumen();
    
    /**
     * Obtiene el precio de renta/venta del producto
     * @return 
     */
    double getPrecio();
}