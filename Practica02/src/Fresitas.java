/**
 * Clase para el ingrediente extra Fresitas.
 * Hereda de la clase abstracta IngredienteExtra.
 */
public class Fresitas extends IngredienteExtra {

    /**
     * Constructor para agregar Fresitas al helado.
     * 
     * @param helado El helado que se desea decorar.
     */
    public Fresitas(Helado helado) {
        super(helado);
    }

    /**
     * Devuelve la descripción del helado agregando las Fresitas,
     * validando que no se superen las 3 porciones.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
	return heladoDecorado.getDescripcion() + "\n    + Fresitas              $07.00";		
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de las Fresitas ($7.0).
     * 
     * @return El costo total con el extra de Fresitas.
     */
    @Override
    public double getPrecio() {
	return heladoDecorado.getPrecio() + 7.0;
    }
}
