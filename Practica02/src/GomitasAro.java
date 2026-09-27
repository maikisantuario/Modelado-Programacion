/**
 * Clase para el ingrediente extra Gomitas de Aro.
 * Hereda de la clase abstracta IngredienteExtra dentro del patrón Decorator.
 */
public class GomitasAro extends IngredienteExtra {

    /**
     * Constructor para agregar Gomitas de Aro al helado.
     * 
     * @param helado El helado (base o decorado) que se desea envolver.
     */
    public GomitasAro(Helado helado) {
        super(helado);
    }

    /**
     * Devuelve la descripción del helado agregando las Gomitas de Aro.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
	return heladoDecorado.getDescripcion() + "\n    + Gomitas de Aro        $06.00";
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de las Gomitas ($6.0).
     * 
     * @return El costo total con el extra de Gomitas.
     */
    @Override
    public double getPrecio() {
        return heladoDecorado.getPrecio() + 6.0;
    }
}
