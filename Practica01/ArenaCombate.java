import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la arena de combate y notifica a los espectadores.
 */
public class ArenaCombate implements Sujeto {

    protected List<Observador> espectadores;

    /**
     * Constructor que inicializa la lista de espectadores.
     */
    public ArenaCombate() {
        this.espectadores = new ArrayList<>();
    }

    /**
     * Registra un observador.
     * @param observador Observador a registrar.
     */
    public void registrar(Observador observador) {
        this.espectadores.add(observador);
    }

    /**
     * Notifica un mensaje a todos los espectadores.
     * @param mensaje Mensaje a transmitir.
     */
    public void notificar(String mensaje) {
        for (Observador obs : espectadores) {
            obs.actualizar(mensaje);
        }
    }

    /**
     * Genera y permite consumir un objeto al combatiente.
     * @param personaje Combatiente que intenta consumir el objeto.
     */
    public void generarYConsumirObjeto(Combatiente personaje) {
        ObjetoPoder objeto = new ObjetoPoder(personaje.getNombre(), "Objeto Especial", personaje.estrategiaActual);
        personaje.consumirObjeto(objeto);
    }

    /**
     * Procesa el ataque entre combatientes.
     * @param personaje Combatiente atacante.
     * @param defensor Combatiente defensor.
     * @param seDefiende Indica si el defensor usa su defensa.
     */
    public void procesarAtaque(Combatiente personaje, Combatiente defensor, boolean seDefiende) {
        int dano = personaje.realizarAtaque();
        defensor.recibirImpacto(dano, seDefiende);
    }

    /**
     * Finaliza el combate y avisa a los observadores.
     * @param ganador Nombre del ganador.
     */
    public void finalizar(String ganador) {
        notificar("Combate finalizado. Ganador: " + ganador);
        for (Observador obs : espectadores) {
            obs.finalizarTransmision(ganador);
        }
    }
}
