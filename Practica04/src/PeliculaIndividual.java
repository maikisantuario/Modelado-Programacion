/**
 * Clase que representa una pelicula individual en nuestro catalogo
 */
public class PeliculaIndividual implements Producto {
    private String nombre;
    private String director;
    private int duracion;
    private String genero;
    private String sinopsis;
    private double precio;

    /**
     * Constructor de PeliculaIndividual.
     * 
     * @param nombre 
     * @param director
     * @param duracion 
     * @param genero 
     * @param sinopsis 
     * @param precio 
     */
    public PeliculaIndividual(String nombre, String director, int duracion, String genero, String sinopsis, double precio) {
        this.nombre = nombre;
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.precio = precio;
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
        return precio;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Pelicula: " + nombre);
        System.out.println("Director: " + director);
        System.out.println("Duración: " + duracion + " min");
        System.out.println("Genero: " + genero);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Precio: $" + precio);
        System.out.println("----------------------------------------");
    }
}