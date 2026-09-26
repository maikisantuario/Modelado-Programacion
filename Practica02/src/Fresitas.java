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
        if (contarIngrediente("Fresitas") < 3) {
            return heladoDecorado.getDescripcion() + ", Fresitas";
        } else {
            System.out.println("\u001B[31mNo puedes agregar mas de 3 porciones de Fresitas.\u001B[0m");
            return heladoDecorado.getDescripcion();
        }
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de las Fresitas ($7.0).
     * 
     * @return El costo total con el extra de Fresitas.
     */
    @Override
    public double getPrecio() {
        if (contarIngrediente("Fresitas") < 3) {
            return heladoDecorado.getPrecio() + 7.0;
        }
        return heladoDecorado.getPrecio();
    }
}
