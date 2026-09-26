/**
 * Clase para la Pizza con pinia.
 */
public class PizzaHawaiana extends Pizza {

    /**
     * Constructor para hacer una Pizza Hawaiana.
     * 
     * @param id identificador de la pizza
     * @param nombre nombre de la pizza
     * @param descripcion descripcion de los ingredientes
     * @param precio costo de la pizza
     * @param esVegetariana ¿la pizza es apta para vegetarianos?
     * @param tipoMasa tipo de masa 
     */
    public PizzaHawaiana(int id, String nombre, String descripcion, double precio, boolean esVegetariana, TipoMasa tipoMasa) {
        super(id, nombre, descripcion, precio, esVegetariana, tipoMasa);
    }

    /**
     * Implementacion para poner el queso en la pizza.
     */
    @Override
    public void colocarQueso() {
        System.out.println("4. Colocando queso mozzarella y un poco de queso cheddar...");
    }

    /**
     * Implementacion para poner la proteina de la pizza.
     */
    @Override
    public void colocarProteina() {
        System.out.println("6. Colocando jamon de pavo y trozos de PINIA...");
    }
}