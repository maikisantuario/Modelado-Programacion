/**
 * Clase para la Pizza  a la mexicana.
 */
public class PizzaMexicana extends Pizza {

    /**
     * Constructor para hacer una Pizza a la mexicana.
     * 
     * @param id identificador de la pizza
     * @param nombre nombre de la pizza
     * @param descripcion descripcion de los ingredientes
     * @param precio costo de la pizza
     * @param esVegetariana ¿la pizza es apta para vegetarianos?
     * @param tipoMasa tipo de masa 
     */
    public PizzaMexicana(int id, String nombre, String descripcion, double precio, boolean esVegetariana, TipoMasa tipoMasa) {
        super(id, nombre, descripcion, precio, esVegetariana, tipoMasa);
    }

    /**
     * Implementacion para poner el queso en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("4. Colocando queso manchego y queso panela...");
    }

    /**
     * Implementacion para poner la proteina de la pizza.
     */
    @Override
    public void colocarProteina() {
        System.out.println("6. Colocando carne de res, chorizo y chile...");
    }
}