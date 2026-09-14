/**
 * Clase que representa al combatiente MeganMan, heredando de la clase abstracta Combatiente.
 * Se encarga de inicializar al personaje con sus atributos por defecto y prepararlo para la batalla.
 */
public class MeganMan extends Combatiente {

    /**
     * Constructor por defecto para MeganMan.
     * Invoca al constructor de la clase padre asignandole el nombre "MeganMan" 
     * y equipandolo con la estrategia inicial de combate {@link EstrategiaMeganManBase}.
     */
    public MeganMan() {
        super("MeganMan", new EstrategiaMeganManBase());
    }
}
