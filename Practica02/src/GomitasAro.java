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
     * Devuelve la descripción del helado agregando las Gomitas de Aro,
     * validando que no se superen las 3 porciones.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
        if (contarIngrediente("GomitasAro") < 3) {
            return heladoDecorado.getDescripcion() + ", Gomitas de Aro";
        } else {
            System.out.println("\u001B[31mNo puedes agregar más de 3 porciones de Gomitas.\u001B[0m");
            return heladoDecorado.getDescripcion();
        }
    }

    /**
     * Devuelve el precio total acumulado del helado sumando el costo de las Gomitas ($6.7).
     * 
     * @return El costo total con el extra de Gomitas.
     */
    @Override
    public double getPrecio() {
        if (contarIngrediente("GomitasAro") < 3) {
            return heladoDecorado.getPrecio() + 6.7;
        }
        return heladoDecorado.getPrecio();
    }
}
