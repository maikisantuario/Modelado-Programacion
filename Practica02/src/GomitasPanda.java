/**
 * Clase para el ingrediente extra Gomitas de Panda.
 * Hereda de la clase abstracta IngredienteExtra dentro del patrón Decorator.
 */
public class GomitasPanda extends IngredienteExtra {

    /**
     * Constructor para agregar Gomitas de Panda al helado.
     * 
     * @param helado El helado (base o decorado) que se desea envolver.
     */
    public GomitasPanda(Helado helado) {
        super(helado);
    }

    /**
     * Devuelve la descripción del helado agregando las Gomitas de Panda,
     * validando que no se superen las 3 porciones.
     * 
     * @return La descripción con el ingrediente acumulado.
     */
    @Override
    public String getDescripcion() {
        if (contarIngrediente("GomitasPanda") < 3) {
            return heladoDecorado.getDescripcion() + ", Gomitas de Panda";
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
        if (contarIngrediente("GomitasPanda") < 3) {
            return heladoDecorado.getPrecio() + 6.7;
        }
        return heladoDecorado.getPrecio();
    }
}
