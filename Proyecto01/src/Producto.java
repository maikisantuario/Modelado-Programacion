/**
 * Representa un producto disponible en el catalogo de CheemsMart.
 * Almacena codigo de barras, nombre, departamento y precio.
 */
public class Producto {

    /** Codigo de barras unico del producto. */
    private String codigoBarras;

    /** Nombre del producto. */
    private String nombre;

    /** Departamento al que pertenece el producto. */
    private String departamento;

    /** Precio del producto. */
    private double precio;

    /**
     * Constructor completo de un producto.
     *
     * @param codigoBarras Codigo de barras unico.
     * @param nombre       Nombre del producto.
     * @param departamento Departamento del producto.
     * @param precio       Precio del producto.
     */
    public Producto(String codigoBarras, String nombre, String departamento, double precio) {
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.departamento = departamento;
        this.precio = precio;
    }

    /**
     * Obtiene el codigo de barras del producto.
     *
     * @return El codigo de barras.
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el departamento del producto.
     *
     * @return El departamento.
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Devuelve una representacion en cadena del producto.
     *
     * @return Cadena con la informacion del producto.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s - %s - $%.2f", codigoBarras, nombre, departamento, precio);
    }
}