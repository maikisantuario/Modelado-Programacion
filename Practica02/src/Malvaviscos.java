/**
 * Clase agrega el ingrediente extra "Malvaviscos" para un helado.
 * Implementa el patrón Decorator, envolviendo a un objeto Helado.
 */
public class Malvaviscos extends IngredienteExtra {

    /**
     * Constructor para agregar malvaviscos.
     * 
     * @param helado el helado base al que se le agregaran los malvaviscos
     */
    public Malvaviscos(Helado helado) {
        super(helado);
    }

    /**
     * Obtiene la descripcion del helado incluyendo los malvaviscos.
     * 
     * @return una cadena con la descripcion del helado y el ingrediente extra que se agrego
     */
    @Override
    public String getDescripcion() {
        return heladoDecorado.getDescripcion() + ", Malvaviscos";
    }

    /**
     * Obtiene el precio total del helado incluyendo el costo extra de los malvaviscos
     * 
     * @return el precio del helado mas el costo adicional de los malvaviscos
     */
    @Override
    public double getPrecio() {
        return heladoDecorado.getPrecio() + 10.0; // Costo extra de los malvaviscos
    }
}