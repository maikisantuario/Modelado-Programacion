/**
 * Representa la base concreta de un helado.
 * Define el sabor inicial y proporciona los métodos base para obtener
 * la descripción y el precio antes de agregar ingredientes extra.
 */
public class HeladoBase {
    
    public SaborHelado sabor;

    /**
     * Construye un nuevo helado base con el sabor especificado.
     * @param sabor El {@link SaborHelado} asignado a la base.
     */
    public HeladoBase(SaborHelado sabor) {
        this.sabor = sabor;
    }

    /**
     * Obtiene la descripción textual del helado base.
     * @return Una cadena que indica el sabor del helado.
     */
    @Override
    public String getDescripcion() {
        return "Helado de " + sabor.getDescripcion();
    }

    /**
     * Obtiene el costo base del helado según el sabor elegido.
     * @return El precio del helado base como {@code double}.
     */
    @Override
    public double getPrecio() {
        return sabor.getPrecio();
    }
}
