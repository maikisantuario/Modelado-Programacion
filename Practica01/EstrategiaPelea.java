/**
 * Interfaz que define el contrato para las estrategias de pelea.
 * Aplica el patron de diseño Strategy para permitir el cambio de
 * habilidades y poderes de los combatientes en tiempo de ejecucion.
 */
public interface EstrategiaPelea {

    /**
     * Ejecuta la logica ofensiva y calcula el daño o aura generada al atacar.
     * 
     * @param objetivo El combatiente que recibe el ataque.
     * @return Los puntos de danio infligidos o el aura obtenida tras el ataque.
     */
    int atacar(Combatiente objetivo);

    /**
     * Ejecuta la logica defensiva y calcula el daño o aura perdida al recibir un ataque.
     * 
     * @param atacante El combatiente que realiza el ataque inminente.
     * @return La cantidad de daño o puntos de aura perdidos finalmente tras mitigar el impacto.
     */
    int defender(Combatiente atacante);

    /**
     * Regresa el nombre de la estrategia o poder actual equipado por el combatiente.
     * 
     * @return El nombre descriptivo de la estrategia o poder.
     */
    String obtenerNombre();
}
