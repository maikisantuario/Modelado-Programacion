import java.util.Iterator;
import java.util.Collections;

/**
 * Clase que representa una pelicula individual en el catalogo de RockBuster.
 */
public class PeliculaIndividual implements Producto {
    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sinopsis;
    private double precioRenta;

    /**
     * Constructor de PeliculaIndividual.
     * @param nombre Nombre de la película.
     * @param director Director de la película.
     * @param duracion Duración en minutos.
     * @param genero Género cinematográfico.
     * @param sinopsis Sinopsis de la película.
     * @param precioRenta Precio de renta.
     */
    public PeliculaIndividual(String nombre, String director, int duracion, String genero, String sinopsis, double precioRenta) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.precioRenta = precioRenta;
    }

    /**
     * Obtiene el nombre de la película.
     * @return El nombre.
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el género de la película.
     * @return El género.
     */
    @Override
    public String getGenero() {
        return genero;
    }

    /**
     * Obtiene el precio de renta de la película.
     * @return El precio de renta.
     */
    @Override
    public double getPrecio() {
        return precioRenta;
    }

    /**
     * Obtiene la duración de la película.
     * @return La duración en minutos.
     */
    @Override
    public int getDuracion() {
        return duracion;
    }

    /**
     * Obtiene el director de la película.
     * @return El director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Obtiene la sinopsis de la película.
     * @return La sinopsis.
     */
    public String getSinopsis() {
        return sinopsis;
    }

    /**
     * Muestra un resumen de la película.
     */
    @Override
    public void mostrarResumen() {
	System.out.println(nombre + " - $" + String.format("%.2f", precioRenta));
    }

    /**
     * Muestra los detalles completos de la película.
     */
    @Override
    public void mostrarDetalle() {
        System.out.println("----------------------------------------");
        System.out.println("Película: " + nombre);
        System.out.println("Director: " + director);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Genero: " + genero);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Precio: $" + precioRenta);
        System.out.println("----------------------------------------");
    }

    /**
     * Lanza una excepción ya que las películas individuales no tienen hijos.
     * @param producto El producto a agregar.
     */
    @Override
    public void agregar(Producto producto) {
        throw new UnsupportedOperationException("Las películas individuales no tienen hijos.");
    }

    /**
     * Lanza una excepción ya que las películas individuales no tienen hijos.
     * @param producto El producto a eliminar.
     */
    @Override
    public void eliminar(Producto producto) {
        throw new UnsupportedOperationException("Las películas individuales no tienen hijos.");
    }

    /**
     * Lanza una excepción ya que las películas individuales no tienen hijos.
     * @param indice El índice del hijo.
     * @return El producto correspondiente.
     */
    @Override
    public Producto obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Las películas individuales no tienen hijos.");
    }

    /**
     * Crea un iterador vacío para la película individual.
     * @return Un iterador vacío.
     */
    @Override
    public Iterator<Producto> crearIterador() {
        return Collections.emptyIterator();
    }
}
