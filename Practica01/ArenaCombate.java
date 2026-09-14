import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que gestiona la arena de combate, asigna un nombre aleatorio al escenario
 * y notifica en tiempo real cada situacion y evento a los espectadores.
 */
public class ArenaCombate implements Sujeto {

    /** Lista de observadores registrados en las gradas. */
    protected List<Observador> espectadores;
    
    /** Nombre asignado aleatoriamente a la arena. */
    protected String nombreArena;
    
    /** Generador de valores aleatorios para la logica del escenario. */
    protected Random random;

    /**
     * Constructor que inicializa la lista de espectadores y selecciona un nombre aleatorio para la arena.
     */
    public ArenaCombate() {
        this.espectadores = new ArrayList<>();
        this.random = new Random();
        this.nombreArena = seleccionarNombreAleatorio();
        System.out.println("¡Bienvenidos a la arena de combate: " + this.nombreArena + "!");
    }

    /**
     * Selecciona aleatoriamente el nombre del escenario de batalla.
     * @return Nombre de la arena.
     */
    private String seleccionarNombreAleatorio() {
        String[] nombres = {
            "Bucle de Aurabytes", 
            "Cupula Aurea", 
            "Estadio Auralan", 
            "Pumaura Locura en Ciencias",
	    "La maquina de AuraTuring",
	    "El cafecin: aura de nunca jamas"
        };
        return nombres[random.nextInt(nombres.length)];
    }

    /**
     * Registra un observador en la arena.
     * @param observador Observador a registrar.
     */
    @Override
    public void registrar(Observador observador) {
        this.espectadores.add(observador);
        notificar("Nuevo espectador conectado desde las gradas de " + this.nombreArena + ".");
    }

    /**
     * Notifica un mensaje a todos los espectadores conectados.
     * @param mensaje Mensaje a transmitir.
     */
    @Override
    public void notificar(String mensaje) {
        for (Observador obs : espectadores) {
            obs.actualizar(mensaje);
        }
    }

    /**
     * Genera un objeto de poder aleatorio, permitiendo que el combatiente lo consuma
     * y notificando la situacion a la arena.
     * @param personaje Combatiente que intenta consumir el objeto.
     */
    public void generarYConsumirObjeto(Combatiente personaje) {
        ObjetoPoder objeto = new ObjetoPoder(personaje.getNombre(), "Objeto Especial de " + this.nombreArena, personaje.getEstrategiaActual());
        boolean consumido = personaje.consumirObjeto(objeto);
        if (consumido) {
            notificar("¡SITUACION EN ARENA!: " + personaje.getNombre() + " encontro y consumio un objeto de poder en " + this.nombreArena + "!");
        }
    }

    /**
     * Procesa el ataque entre combatientes y notifica la situacion detallada del intercambio.
     * @param atacante Combatiente atacante.
     * @param defensor Combatiente defensor.
     * @param seDefiende Indica si el defensor usa su defensa.
     * @param todosLosLuchadores Lista con los 3 combatientes de la pelea.
     */
    public void procesarAtaque(Combatiente atacante, Combatiente defensor, boolean seDefiende, List<Combatiente> todosLosLuchadores) {
        notificar("¡TURNO DE ACCION!: " + atacante.getNombre() + " se prepara para atacar a " + defensor.getNombre() + ".");

        int auraGanada = atacante.realizarAtaque(defensor);
        notificar("Reporte desde " + this.nombreArena + ": " + atacante.getNombre() +
		  " ha generado " + auraGanada + " de Aura 🗿📈.");

        int auraPerdida = defensor.recibirImpacto(atacante, seDefiende);
        notificar("Reporte desde " + this.nombreArena + ": " + defensor.getNombre() + " ha perdido " +
		  auraPerdida + " de Aura 🫠📉.");
        
        // Notificacion de los marcadores de Aura actualizados
	StringBuilder estadoAura = new StringBuilder("Estado de Aura: ");
	for (Combatiente c : todosLosLuchadores) {
        estadoAura.append(c.getNombre()).append(": ").append(c.getAura()).append(" pts de Aura 🔥. || ");
	}
        notificar(estadoAura.toString().trim());
    }

    /**
     * Finaliza el combate y avisa a los observadores sobre el resultado final.
     * @param ganador Nombre del combatiente victorioso.
     */
    public void finalizar(String ganador) {
        String mensajeFinal = "¡El combate en " + this.nombreArena + " ha finalizado! El gran ganador es: " + ganador;
        notificar(mensajeFinal);
        for (Observador obs : espectadores) {
            obs.finalizarTransmision(ganador);
        }
    }

    /**
     * Obtiene el nombre de la arena de combate actual.
     * @return El nombre de la arena.
     */
    public String getNombreArena() {
        return nombreArena;
    }
}
