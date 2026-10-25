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

    public String getNombre() { return nombre; }
    public String getArtista() { return artista; }
    public String getGeneroMusical() { return generoMusical; }
    public int getAnioEstreno() { return anioEstreno; }
    public double getPrecioVenta() { return precioVenta; }
}