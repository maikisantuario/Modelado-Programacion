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
     * Devuelve la descripción del helado agregando los Kiwis,
     * validando que no se superen las 3 porciones.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
        if (contarIngrediente("Kiwis") < 3) {
            return heladoDecorado.getDescripcion() + ", Kiwis";
        } else {
            System.out.println("\u001B[31mNo puedes agregar mas de 3 porciones de Kiwis.\u001B[0m");
            return heladoDecorado.getDescripcion();
        }
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de los Kiwis ($7.0).
     * 
     * @return El costo total con el extra de Manguitos.
     */
    @Override
    public double getPrecio() {
        if (contarIngrediente("Kiwis") < 3) {
            return heladoDecorado.getPrecio() + 7.0;
        }
        return heladoDecorado.getPrecio();
    }
}
