/**
 * Clase que representa al combatiente MeganMan!
 * y se hereda de la clase abstracta Combatiente.
 */
public class MeganMan extends Combatiente {

    /**
     *Inicializa al personaje con su nombre y su estrategia base.
     */
    public MeganMan() {
        super("MeganMan", new EstrategiaMeganManBase());
    }
}