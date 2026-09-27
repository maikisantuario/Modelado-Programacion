/**
 * Clase para el ingrediente extra Kiwis.
 * Hereda de la clase abstracta IngredienteExtra.
 */
public class Kiwis extends IngredienteExtra {

    /**
     * Constructor para agregar Kiwis al helado.
     * 
     * @param helado El helado que se desea decorar.
     */
    public Kiwis(Helado helado) {
        super(helado);
    }

    /**
     * Devuelve la descripción del helado agregando los Kiwis.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
	return heladoDecorado.getDescripcion() + "\n    + Kiwis                 $07.00";
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de los Kiwis ($7.0).
     * 
     * @return El costo total con el extra de Manguitos.
     */
    @Override
    public double getPrecio() {
            return heladoDecorado.getPrecio() + 7.0;
    }
}
