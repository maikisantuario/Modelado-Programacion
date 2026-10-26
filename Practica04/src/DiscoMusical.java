/**
 * Clase que representa un disco musical en nuestra tienda.
 * Es el objeto "Adaptado" en el patron Adapter.
 */
public class DiscoMusical {
    private String nombre;
    private String artista;
    private String generoMusical;
    private int anioEstreno;
    private double precioVenta;

    /**
     * Constructor del Disco Musical.
     */
    public DiscoMusical(String nombre, String artista, String generoMusical, int anioEstreno, double precioVenta) {
        this.nombre = nombre;
        this.artista = artista;
        this.generoMusical = generoMusical;
        this.anioEstreno = anioEstreno;
        this.precioVenta = precioVenta;
    }

    /**
     * Obtiene el nombre del disco.
     * @return El nombre.
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * Obtiene el artista del disco.
     * @return El artista.
     */
    public String getArtista() {
	return artista;
    }

    /**
     * Obtiene el género musical del disco.
     * @return El género musical.
     */
    public String getGeneroMusical() {
	return generoMusical;
    }

    /**
     * Obtiene el año de estreno del disco.
     * @return El año de estreno.
     */
    public int getAnioEstreno() {
	return anioEstreno;
    }

    /**
     * Obtiene el precio de venta del disco.
     * @return El precio de venta.
     */
    public double getPrecioVenta() {
	return precioVenta;
    }
}
