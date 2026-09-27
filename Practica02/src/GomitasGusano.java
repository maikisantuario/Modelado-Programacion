/**
 * Clase para el ingrediente extra Gomitas de Gusano.
 * Hereda de la clase abstracta IngredienteExtra dentro del patrón Decorator.
 */
public class GomitasGusano extends IngredienteExtra {

    /**
     * Constructor para agregar Gomitas de Gusano al helado.
     * 
     * @param helado El helado (base o decorado) que se desea envolver.
     */
    public GomitasGusano(Helado helado) {
        super(helado);
    }

    /**
     * Devuelve la descripción del helado agregando las Gomitas de Gusando.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
	return heladoDecorado.getDescripcion() + "\n    + Gomitas de Gusano     $08.00";
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de las Gomitas ($8.0).
     * 
     * @return El costo total con el extra de Gomitas.
     */
    @Override
    public double getPrecio() {
            return heladoDecorado.getPrecio() + 8.0;
    }
}
