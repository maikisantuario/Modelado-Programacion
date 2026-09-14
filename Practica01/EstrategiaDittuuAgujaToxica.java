import java.util.Random;

/**
 * Estrategia de veneno para Dittuu. Forma una cola con aguja para infectar
 * al oponente y genera un capullo acido defensivo usando calculo de aura.
 */
public class EstrategiaDittuuAgujaToxica implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de números aleatorios para calcular el aura obtenida o perdida. */
    private Random random = new Random();

    /**
     * Realiza un ataque venenoso contra el objetivo usando una aguja toxica.
     * Genera una cantidad de aura aleatoria entre 1000 y 3000.
     * 
     * @param objetivo El combatiente que recibe el ataque.
     * @return Los puntos de aura generados por el ataque.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println(">> ¡Dittuu despliega una cola afilada y con la aguja de la cola infecta con toxinas a " + objetivo.getNombre() + "!");
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Defiende a Dittuu generando un capullo acido para neutralizar el impacto.
     * Reduce el danio recibido calculando una perdida de aura entre 1000 y 3000.
     * 
     * @param atacante El combatiente que realiza el ataque original.
     * @return Los puntos de aura perdidos a pesar de la defensa.
     */
    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println(">> Dittuu genera un capullo acido para neutralizar el ataque de " + atacante.getNombre() + ".");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de esta estrategia.
     * 
     * @return El nombre "Dittuu Veneno".
     */
    @Override
    public String obtenerNombre() { 
        return "Dittuu Veneno"; 
    }
}
