import java.util.Iterator;
/**
 * Clase que representa una pelcula individual en el catalogo
 */
public class PeliculaIndividual implements Producto {
    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sinopsis;
    private double precioRenta;

    /**
     * Constructor de PeliculaIndividual
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
        System.out.println("Película: " + nombre);
        System.out.println("Director: " + director);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Genero: " + genero);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Precio: $" + precio);
        System.out.println("----------------------------------------");
    }


    @Override
    public Iterator<Producto> crearIterador() {
        return new NullIterator();
    }
}
