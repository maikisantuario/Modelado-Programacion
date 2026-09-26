/**
 * Clase para una Pizza a la mexicana.
 * Se hereda de la clase abstracta Pizza.
 */

public class PizzaMexicana extends Pizza {
    public PizzaMexicana(int id, String nombre, String descripcion, double precio, boolean esVegetariana, TipoMasa tipoMasa) {
        super(id, nombre, descripcion, precio, esVegetariana, tipoMasa);
    }

    @Override
    public void colocarQueso() {
        System.out.println("  -> Colocando queso manchego y queso panela...");
    }

    @Override
    public void colocarProteina() {
        System.out.println("  -> Colocando carne de res, chorizo y chile...");
    }
}