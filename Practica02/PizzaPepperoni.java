/**
 * Clase para la Pizza de Pepperoni.
 */
public class PizzaPepperoni extends Pizza {

    /**
     * Constructor para hacer una Pizza de Pepperoni.
     * 
     * @param id identificador de la pizza
     * @param nombre nombre de la pizza
     * @param descripcion descripción de los ingredientes
     * @param precio costo de la pizza
     * @param esVegetariana ¿la pizza es apta para vegetarianos?
     * @param tipoMasa tipo de masa 
     */
    public PizzaPepperoni(int id, String nombre, String descripcion, double precio, boolean esVegetariana, TipoMasa tipoMasa) {
        super(id, nombre, descripcion, precio, esVegetariana, tipoMasa);
    }

    /**
     * Implementacion especifica para poner el queso en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("  -> Colocando queso mozzarella extra...");
    }

    /**
     * Implementación especifica para poner la proteína de la pizza.
     */
    @Override
    public void colocarProteina() {
        System.out.println("  -> Colocando rodajas de pepperoni...");
    }
}