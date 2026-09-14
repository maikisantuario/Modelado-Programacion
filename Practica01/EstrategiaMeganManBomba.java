import java.util.Random;

/**
 * Estrategia de ataque explosivo para MeganMan. Lanza una bomba que genera
 * un gran impacto de area afectando a los enemigos cercanos en la arena.
 */
public class EstrategiaMeganManBomba implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque de alto impacto lanzando una bomba al aire que explota sobre la arena.
     * Genera una ganancia aleatoria de aura entre 2000 y 3000.
     * 
     * @param objetivo El combatiente que recibe el impacto principal del ataque.
     * @return Los puntos de aura generados/ganados tras la explosion.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int danioBomba = 2000 + random.nextInt(1001);
        System.out.println("MeganMan apunta al cielo y dispara una bomba!");
        System.out.println(">> El proyectil brilla y estalla en lo alto de la arena!");
        System.out.println(">> ¡BOOOOOM! ¡Empiezan a caer escombros y metralla por todos lados!");
        System.out.println(">> El ataque golpea a " + objetivo.getNombre() + " y a todos los que estan en la arena!");
        System.out.println(VERDE + "+ " + danioBomba + " de Aura 💣🔥" + RESET);
        return danioBomba;
    }

    /**
     * Intenta defenderse mientras recarga la bomba, recibiendo un impacto de escombros.
     * La perdida de aura calculada se encuentra entre 100 y 200.
     * 
     * @param atacante El combatiente que realiza la embestida enemiga.
     * @return Los puntos de aura que MeganMan pierde tras el impacto.
     */
    @Override
    public int defender(Combatiente atacante) {
        int danioReducido = 100 + random.nextInt(101);
        System.out.println("MeganMan esta recargando su bomba y no puede esquivar los escombros de " + atacante.getNombre() + "!");
        System.out.println(">> ¡CRASH! Recibe el golpe casi de lleno!");
        System.out.println(ROJO + "- " + danioReducido + " de Aura 💥" + RESET);
        return danioReducido;
    }

    /**
     * Obtiene el nombre identificador de esta estrategia explosiva.
     * 
     * @return La cadena "MeganMan Bomba".
     */
    @Override
    public String obtenerNombre() {
        return "MeganMan Bomba";
    }
}
