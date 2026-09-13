import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que gestiona la arena de combate, asigna un nombre aleatorio al escenario
 * y notifica en tiempo real cada situacion y evento a los espectadores.
 */
public class ArenaCombate implements Sujeto {

    protected List<Observador> espectadores;
    protected String nombreArena;
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
            "Coliseo Ciberetico", 
            "Cúpula de Plasma", 
            "Estadio Dimensional", 
            "Arena de Sombras Gelatinosas", 
            "Coliseo del Nexo Estelar"
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
        ObjetoPoder objeto = new ObjetoPoder(personaje.getNombre(), "Objeto Especial de " + this.nombreArena, personaje.estrategiaActual);
        boolean consumido = personaje.consumirObjeto(objeto);
        if (consumido) {
            notificar("¡SITUACION EN ARENA!: " + personaje.getNombre() + " encontro y consumio un objeto de poder en " + this.nombreArena + "!");
        }
    }

    /**
     * Procesa el ataque entre combatientes y notifica la situacion detallada del intercambio.
     * @param personaje Combatiente atacante.
     * @param defensor Combatiente defensor.
     * @param seDefiende Indica si el defensor usa su defensa.
     */
    public void procesarAtaque(Combatiente personaje, Combatiente defensor, boolean seDefiende) {
        notificar("¡TURNO DE ACCION!: " + personaje.getNombre() + " se prepara para atacar a " + defensor.getNombre() + ".");
        
        int dano = personaje.realizarAtaque();
        
        // Notificamos el impacto antes de aplicarlo
        notificar("Reporte desde " + this.nombreArena + ": Impacto lanzado con un valor base de " + dano + ".");
        
        defensor.recibirImpacto(dano, seDefiende);
        
        notificar("Estado actual -> " + defensor.getNombre() + " cuenta ahora con " + defensor.getPorcentajeVida() + "% de vida.");
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

    public String getNombreArena() {
        return nombreArena;
    }
}
