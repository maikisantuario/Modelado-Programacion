/**
 * Esta es la interfaz que tiene el contrato para las estrategias de pelea y aplica el patron Strategy.
 */

public interface EstrategiaPelea {

    /**
     * Calcula el danio que inflige al atacar
     * @return 
     */

    int atacar(Combatiente objetivo);

    /**
     * Calcula el danio que recibe al defender.
     * @param impacto Cantidad de danio entrante.
     * @return Cantidad de danio final recibido.
     */

    int defender(Combatiente atacante);

    /**
     * Regresa el nombre de la estrategia o poder actual.
     * @return Nombre del poder.
     */
    String obtenerNombre();
}

