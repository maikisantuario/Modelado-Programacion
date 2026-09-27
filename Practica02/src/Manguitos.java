/**
 * Clase para el ingrediente extra Manguitos.
 * Hereda de la clase abstracta IngredienteExtra.
 */
public class Manguitos extends IngredienteExtra {

    /**
     * Constructor para agregar Manguitos al helado.
     * 
     * @param helado El helado que se desea decorar.
     */
    public Manguitos(Helado helado) {
        super(helado);
    }

    /**
     * Devuelve la descripción del helado agregando los Manguitos,
     * validando que no se superen las 3 porciones.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
	return heladoDecorado.getDescripcion() + "\n    + Manguitos             $07.00";
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de los Manguitos ($7.0).
     * 
     * @return El costo total con el extra de Manguitos.
     */
    @Override
    public double getPrecio() {
            return heladoDecorado.getPrecio() + 7.0;
    }
}
