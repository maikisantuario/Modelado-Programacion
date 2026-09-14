import java.util.Random;

/**
 * Estrategia de vida tormentosa para Dittuu. Libera un ataque devastador
 * y genera una tormenta de salud exclusiva al defenderse con calculos de aura.
 */
public class EstrategiaDittuuVidaTormentosa implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque desatando una tormenta de energia pura sobre el rival.
     * Genera una ganancia aleatoria de aura entre 1000 y 3000.
     * 
     * @param objetivo El combatiente que recibe el ataque.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println(">> ¡Dittuu desata una tormenta de energia pura sobre " + objetivo.getNombre() + ", arrasando con todo!");
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Defiende a Dittuu girando velozmente para generar una tormenta protectora.
     * Reduce el impacto del ataque calculando una perdida de aura entre 1000 y 3000.
     * 
     * @param atacante El combatiente que realiza el ataque inminente.
     * @return Los puntos de aura que Dittuu pierde tras ejecutar su defensa.
     */
    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println(">> ¡Dittuu gira velozmente ante " + atacante.getNombre() + ", generando una tormenta de salud exclusiva para el!");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de esta estrategia de tormenta.
     * 
     * @return La cadena "Dittuu Vida Tormentosa".
     */
    @Override
    public String obtenerNombre() { 
        return "Dittuu Vida Tormentosa"; 
    }
}
