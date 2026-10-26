import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Clase que representa una saga o contenedor de productos (Composite).
 */
public class Saga implements Producto {

    private String nombre;
    private String descripcion;
    private List<Producto> componentes;

    /**
     * Constructor de Saga.
     * @param nombre Nombre de la saga.
     * @param descripcion Descripción de la saga.
     */
    public Saga(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.componentes = new ArrayList<>();
    }

    /**
     * Agrega un producto a la saga.
     * @param producto El producto a agregar.
     */
    @Override
    public void agregar(Producto producto) {
        componentes.add(producto);
    }

    /**
     * Elimina un producto de la saga.
     * @param producto El producto a eliminar.
     */
    @Override
    public void eliminar(Producto producto) {
        componentes.remove(producto);
    }

    /**
     * Obtiene un producto hijo por su índice.
     * @param indice El índice del hijo.
     * @return El producto correspondiente.
     */
    @Override
    public Producto obtenerHijo(int indice) {
        return componentes.get(indice);
    }

    /**
     * Obtiene el nombre de la saga.
     * @return El nombre de la saga.
     */
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getGenero() {
        if (!componentes.isEmpty()) {
            return componentes.get(0).getGenero();
        }
        return "Mixto";
    }

    /**
     * Obtiene el género predominante de la saga.
     * @return El género de la saga.
     */
    @Override
    public double getPrecio() {
        double sumaTotal = 0.0;
        for (Producto p : componentes) {
            sumaTotal += p.getPrecio();
        }
        return sumaTotal * 0.95; // 5% de descuento por saga
    }

    /**
     * Obtiene la duración total de la saga sumando sus componentes.
     * @return La duración total en minutos.
     */
    public int getDuracion() {
        int duracionTotal = 0;
        for (Producto p : componentes) {
            duracionTotal += p.getDuracion();
        }
        return duracionTotal;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("[Saga] " + nombre + " (Incluye " + componentes.size() + " elementos) - Precio con 5% de descuento: $" + String.format("%.2f", getPrecio()));
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("----------------------------------------");
        System.out.println("DETALLE DE SAGA:");
        System.out.println("Nombre      : " + nombre);
        System.out.println("Descripcion : " + descripcion);
        System.out.println("Duracion    : " + getDuracion() + " minutos");
        System.out.println("Precio total: $" + getPrecio() + " (Incluye 5% de descuento)");
        System.out.println("Componentes de la saga:");
        for (Producto p : componentes) {
            System.out.println("  - " + p.getNombre());
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Crea y retorna un iterador para los componentes de la saga.
     * @return Un iterador de productos.
     */
    @Override
    public Iterator<Producto> crearIterador() {
        return componentes.iterator();
    }
}
