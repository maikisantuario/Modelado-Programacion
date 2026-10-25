import java.util.Collections;
import java.util.Iterator;

/**
 * Adaptador que permite que un DiscoMusical sea tratado como un Producto.
 * Implementa el patron Adapter.
 */
public class AdaptadorDiscoMusical implements Producto {
    private DiscoMusical disco;

    /**
     * Constructor que recibe el disco musical a adaptar.
     */
    public AdaptadorDiscoMusical(DiscoMusical disco) {
        this.disco = disco;
    }

    @Override
    public String getNombre() {
        return disco.getNombre();
    }

    @Override
    public String getGenero() {
        return disco.getGeneroMusical();
    }

    @Override
    public double getPrecio() {
        return disco.getPrecioVenta();
    }

    @Override
    public int getDuracion() {
        return 0;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Disco Musical: " + disco.getNombre() + " - Artista: " + disco.getArtista() + " - Precio: $" + disco.getPrecioVenta());
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("----------------------------------------");
        System.out.println("Disco Musical: " + disco.getNombre());
        System.out.println("Artista: " + disco.getArtista());
        System.out.println("Genero: " + disco.getGeneroMusical());
        System.out.println("Año de estreno: " + disco.getAnioEstreno());
        System.out.println("Precio: $" + disco.getPrecioVenta());
        System.out.println("----------------------------------------");
    }

    @Override
    public void agregar(Producto producto) {
        throw new UnsupportedOperationException("Un disco musical adaptado no tiene hijos.");
    }

    @Override
    public void eliminar(Producto producto) {
        throw new UnsupportedOperationException("Un disco musical adaptado no tiene hijos.");
    }

    @Override
    public Producto obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Un disco musical adaptado no tiene hijos.");
    }

    @Override
    public Iterator<Producto> crearIterador() {
        return Collections.emptyIterator();
    }
}
