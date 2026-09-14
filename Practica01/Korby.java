/**
 * Clase que representa al personaje Korby, heredando de la clase Combatiente.
 * Se encarga de inicializar al personaje con sus atributos por defecto.
 */
public class Korby extends Combatiente {
    
    /**
     * Constructor por defecto para Korby.
     * Invoca al constructor de la clase padre asignandole el nombre "Korby" 
     * y equipandolo con la estrategia inicial de combate {@link EstrategiaKorbyBase}.
     */
    public Korby() {
        super("Korby", new EstrategiaKorbyBase());
    }
}
