import java.util.Random;

/**
 * Estrategia base para el personaje Dittuu. Mantiene un ataque y defensa basicos
 * sin alteraciones de estado, ideal para combates neutrales.
 */
public class EstrategiaDittuuBase implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque basico contra el oponente mediante un golpe de precision.
     * Genera una ganancia aleatoria de aura entre 1000 y 3000.
     * 
     * @param objetivo El combatiente que recibe el ataque.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println(">> Dittuu analiza al rival y ejecuta un golpe con precisión contra " + objetivo.obtenerNombre());
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Defiende a Dittuu adoptando una forma gelatinosa para absorber parte del impacto.
     * Calcula una reduccion de aura recibida entre 1000 y 3000.
     * 
     * @param atacante El combatiente que realiza el ataque.
     * @return Los puntos de aura que Dittuu pierde tras absorber el impacto.
     */
    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println(">> " + atacante.obtenerNombre() + " ataca a Dittuu, quien adopta una forma gelatinosa para absorber parte del impacto.");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de la estrategia base.
     * 
     * @return La cadena "Dittuu Base".
     */
    @Override
    public String obtenerNombre() { 
        return "Dittuu Base"; 
    }
}
