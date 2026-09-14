/**
 * Clase que representa al combatiente Dittuu, heredando de la clase abstracta Combatiente.
 * Se encarga de inicializar al personaje con sus atributos por defecto y prepararlo para la batalla.
 */
public class Dittuu extends Combatiente {

    /**
     * Constructor por defecto para Dittuu.
     * Invoca al constructor de la clase padre asignandole el nombre "Dittuu" 
     * y equipandolo con la estrategia inicial de combate {@link EstrategiaDittuuBase}.
     */
    public Dittuu() {
        super("Dittuu", new EstrategiaDittuuBase());
    }
}
