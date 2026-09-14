import java.util.Random;

/**
 * Clase abstracta que representa al personaje combatiente.
 * Contiene los atributos basicos y los comportamientos para pelear,
 * defenderse y consumir objetos dentro de la arena.
 */
public abstract class Combatiente {

    /** Constante para el color rojo en consola. */
    public static final String ROJO = "\u001B[31m";
    /** Constante para el color verde en consola. */
    public static final String VERDE = "\u001B[32m";
    /** Constante para resetear el color en consola. */
    public static final String RESET = "\u001B[0m";

    /** Nombre del combatiente. */
    protected String nombre;
    /** Estrategia de combate que el personaje usa actualmente. */
    protected EstrategiaPelea estrategiaActual;
    /** Puntos de aura (salud/poder) del personaje. */
    protected int aura;
    /** Generador de numeros aleatorios para los calculos de combate. */
    protected Random random;

    /**
     * Constructor que inicializa los atributos basicos del combatiente.
     * @param nombre Nombre del personaje.
     * @param estrategiaBase Estrategia inicial con la que comienza a pelear.
     */
    public Combatiente(String nombre, EstrategiaPelea estrategiaBase) {
        this.nombre = nombre;
        this.aura = 6007;
        this.estrategiaActual = estrategiaBase;
        this.random = new Random();
    }

    /**
     * Cambia la estrategia de la nueva pelea.
     * @param nuevaEstrategia La nueva estrategia de pelea que adoptara el combatiente.
     */
    public void setEstrategia(EstrategiaPelea nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
    }

    /**
     * Obtiene la estrategia actual del combatiente.
     * @return El objeto EstrategiaPelea actual.
     */
    public EstrategiaPelea getEstrategiaActual() {
        return estrategiaActual;
    }

    /**
     * Consume un objeto de poder para cambiar de estrategia.
     * @param objeto El objeto de poder que se va a consumir.
     * @return true si el objeto fue consumido exitosamente, false en caso contrario.
     */
    public boolean consumirObjeto(ObjetoPoder objeto) {
        if (objeto != null && !objeto.estaConsumido()) {
            this.setEstrategia(objeto.obtenerEstrategia());
            objeto.marcarConsumido();
            System.out.println(this.nombre + " ha consumido " + objeto.getNombreObjeto() + " y ahora tiene: " + this.estrategiaActual.obtenerNombre());
            return true;
        }
        return false;
    }

    /**
     * Realiza un ataque usando la estrategia nueva.
     * @param objetivo Personaje que recibe el ataque.
     * @return Los puntos de aura generados/ganados tras el ataque.
     */
    public int realizarAtaque(Combatiente objetivo) {
        int auraGanada = this.estrategiaActual.atacar(objetivo);
        this.aura += auraGanada;
        System.out.println(this.nombre + " ataca con " + this.estrategiaActual.obtenerNombre() + " ganando " + VERDE + "+" + auraGanada + " de Aura." + RESET);
        return auraGanada;
    }

    /**
     * Recibe un golpe en combate y calcula el danio recibido.
     * @param atacante Personaje que realiza el ataque.
     * @param seDefiende true si el personaje logra usar su habilidad defensiva, false si recibe impacto critico.
     * @return Los puntos de aura perdidos por el impacto.
     */
    public int recibirImpacto(Combatiente atacante, boolean seDefiende) {
        int auraPerdida;

        if (seDefiende) {
            auraPerdida = this.estrategiaActual.defender(atacante);
            System.out.println(this.nombre + " se defiende con " + this.estrategiaActual.obtenerNombre() + " reduciendo el danio.");
        } else {
            auraPerdida = 1500 + random.nextInt(1501);
            System.out.println(this.nombre + " se distrajo y recibio el golpe directo de " + atacante.obtenerNombre() + "!");
            System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        }

        // Se descuenta el aura una sola vez al finalizar el cálculo
        this.aura = Math.max(0, this.aura - auraPerdida);
        return auraPerdida;
    }

    /**
     * Verifica si el combatiente sigue en el combate (su aura es mayor a 0).
     * @return true si tiene aura restante, false si fue derrotado.
     */
    public boolean tieneAura() {
        return this.aura > 0;
    }

    /**
     * Obtiene el nombre del combatiente.
     * @return El nombre del personaje.
     */
    public String getNombre() { return nombre; }
    
    /**
     * Obtiene el nombre del combatiente (alias de getNombre).
     * @return El nombre del personaje.
     */
    public String obtenerNombre() { return nombre; }
    
    /**
     * Obtiene la cantidad de aura actual del combatiente.
     * @return Los puntos de aura.
     */
    public int getAura() { return aura; }
    
    /**
     * Obtiene el nombre del poder o habilidad actual equipada.
     * @return El nombre de la estrategia en uso.
     */
    public String getNombrePoder() { return estrategiaActual.obtenerNombre(); }
}