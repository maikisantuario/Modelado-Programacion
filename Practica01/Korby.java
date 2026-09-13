/**
 * Clase que representa al personaje de Korby heredando de Combatiente.
 */
public class Korby extends Combatiente {
    /**
     * Constructor por defecto para Dittuu.
     */
    public Korby() {
	super("Korby", new EstrategiaKorbyBase());
    }
}
