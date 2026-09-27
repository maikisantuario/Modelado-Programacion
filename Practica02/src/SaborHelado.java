/**
 * Representa los sabores base disponibles para los helados en la heladería,
 * definiendo su nombre descriptivo y su costo base correspondiente. 
 */
public enum SaborHelado {
    CHOCOLATE ("Chocolate", 30.0),
    VAINILLA ("Vainilla", 35.0),
    FRESA ("Fresa", 30.0);

    private final String descripcion;
    private final double precio;

    /**
     * Constructor del enum que inicializa el sabor con su descripción y precio.
     *
     * @param descripcion Nombre representativo del sabor.
     * @param precio Costo base asociado al sabor.
     */
    SaborHelado(String descripcion, double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
    }

    /**
     * Obtiene la descripción o nombre legible del sabor.
     * @return El nombre del sabor como {@code String}.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene el precio base del sabor.
     * @return El costo del sabor como {@code double}.
     */
    public double getPrecio() {
        return precio;
    }
}
