/**
 * Clase para la Pizza Hawaiana.
 * Se hereda de la clase abstracta Pizza.
 */
public class PizzaHawaiana extends Pizza {

    public PizzaHawaiana(int id, String nombre, String descripcion, double precio, boolean esVegetariana, TipoMasa tipoMasa) {
        super(id, nombre, descripcion, precio, esVegetariana, tipoMasa);
    }

    @Override
    public void colocarQueso() {
        System.out.println("  -> Colocando queso mozzarella y un poco de queso cheddar...");
    }

    @Override
    public void colocarProteina() {
        System.out.println("  -> Colocando jamon de pavo y trozos de PINIA...");
    }
}