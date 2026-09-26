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
        if (contarIngrediente("Manguitos") < 3) {
            return heladoDecorado.getDescripcion() + ", Manguitos";
        } else {
            System.out.println("\u001B[31mNo puedes agregar mas de 3 porciones de Manguitos.\u001B[0m");
            return heladoDecorado.getDescripcion();
        }
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de los Manguitos ($7.0).
     * 
     * @return El costo total con el extra de Manguitos.
     */
    @Override
    public double getPrecio() {
        if (contarIngrediente("Manguitos") < 3) {
            return heladoDecorado.getPrecio() + 7.0;
        }
        return heladoDecorado.getPrecio();
    }
}
