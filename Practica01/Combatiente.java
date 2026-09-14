import java.util.Random;

/**
 * Clase abstracta que representa al personaje combatiente.
 * Contiene los atributos basicos.
 */
public abstract class Combatiente {

    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";

    protected String nombre;
    protected EstrategiaPelea estrategiaActual;
    protected int aura;
    protected Random random;

    /**
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
     * @param nuevaEstrategia 
     */
    public void setEstrategia(EstrategiaPelea nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
    }

    public EstrategiaPelea getEstrategiaActual() {
        return estrategiaActual;
    }

    /**
     * Consume un objeto de poder para cambiar de estrategia.
     * @param objeto
     * @return
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
     * Realiza un ataque usando la estrategia nueva
     * @param objetivo Personaje que recibe el ataque
     * @return El aura ganada.
     */
    public int realizarAtaque(Combatiente objetivo) {
        int auraGanada = this.estrategiaActual.atacar(objetivo);
        this.aura += auraGanada;
        System.out.println(this.nombre + " ataca con " + this.estrategiaActual.obtenerNombre() + " ganando " + VERDE + "+" + auraGanada + " de Aura." + RESET);
        return auraGanada;
    }

    /**
     * Recibe un golpe en combate.
     * @param atacante Personaje que realiza el ataque.
     * @param seDefiende 
     * @return El aura perdida.
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
     * Verifica si el combatiente sigue en el combate.
     * @return
     */
    public boolean tieneAura() {
        return this.aura > 0;
    }

    public String getNombre() { return nombre; }
    public String obtenerNombre() { return nombre; }
    public int getAura() { return aura; }
    public String getNombrePoder() { return estrategiaActual.obtenerNombre(); }
}
