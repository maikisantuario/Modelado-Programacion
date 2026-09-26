public class PizzaHawaiana extends Pizza {
    public PizzaHawaiana(int id, String nombre, String descripcion, double precio, boolean esVegetariana, TipoMasa tipoMasa) {
        super(id, nombre, descripcion, precio, esVegetariana, tipoMasa);
    }

    @Override
    public void colocarQueso() {
        System.out.println("  -> Colocando queso mozzarella y un toque de cheddar...");
    }

    @Override
    public void colocarProteina() {
        System.out.println("  -> Colocando jamón de pavo y trozos de pinia...");
    }
}