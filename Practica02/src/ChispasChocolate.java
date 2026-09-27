/**
 * Clase que agrega el ingrediente extra "Chispas de Chocolate" para un helado.
 * Implementa el patron Decorator, envolviendo a un objeto Helado.
 */
public class ChispasChocolate extends IngredienteExtra {

    /**
     * Constructor para agregar chispas de chocolate extras a un helado.
     * 
     * @param helado el helado base al que se le agregaran las chispas de chocolate
     */
    public ChispasChocolate(Helado helado) {
        super(helado);
    }

    /**
     * Obtiene la descripcion del helado incluyendo las chispas de chocolate extras
     * 
     * @return una cadena con la descripcion del helado y el ingrediente extra
     */
    @Override
    public String getDescripcion() {
	return heladoDecorado.getDescripcion() + "\n    + Chispas de Chocolate  $12.00";
    }

    /**
     * Obtiene el precio total del helado incluyendo el costo de las chispas de chocolate extras
     * 
     * @return el precio del helado mas el costo adicional de las chispas de chocolate
     */
    @Override
    public double getPrecio() {
        return heladoDecorado.getPrecio() + 12.0; // Costo extra de las chispas de chocolate
    }
}
