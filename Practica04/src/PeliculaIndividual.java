import java.util.Iterator;
import java.util.Collections;

/**
 * Clase que representa una pelicula individual en el catalogo.
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

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getGenero() {
        return genero;
    }

    @Override
    public double getPrecio() {
        return precioRenta;
    }
    
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

    @Override
    public void mostrarResumen() {
        System.out.println("Película: " + nombre + " - Precio: $" + precioRenta);
    }

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

    @Override
    public void agregar(Producto producto) {
        throw new UnsupportedOperationException("Las películas individuales no tienen hijos.");
    }

    @Override
    public void eliminar(Producto producto) {
        throw new UnsupportedOperationException("Las películas individuales no tienen hijos.");
    }

    @Override
    public Producto obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Las películas individuales no tienen hijos.");
    }

    @Override
    public Iterator<Producto> crearIterador() {
        return Collections.emptyIterator();
    }
}
