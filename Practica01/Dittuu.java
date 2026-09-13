/**
 * Clase que representa al personaje de Dittuu heredando de Combatiente.
 */
public class Dittu extends Combatiente {

    /**
     * Constructor por defecto para Dittuu.
     */
    public Dittuu() {
	super("Dittuu", new EstrategiaDittuuBase());
    }
}
