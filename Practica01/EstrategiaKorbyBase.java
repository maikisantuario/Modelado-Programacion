import java.util.Random;

/**
 * Estrategia base para el personaje Korby. Mantiene un ataque y defensa basicos,
 * destacando por su apariencia adorable pero efectividad en combate.
 */
public class EstrategiaKorbyBase implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();
    
    /**
     * Realiza un ataque basico contra el oponente siendo adorable pero implacable.
     * Genera una ganancia aleatoria de aura entre 1000 y 3000.
     * 
     * @param objetivo El combatiente que recibe el ataque.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println(">> Korby aun siendo tan adorable ataca sin piedad a " + objetivo.obtenerNombre());
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Responde a la ofensiva enemiga recibiendo el golpe y derramando una pequena lagrima.
     * Calcula una reduccion de aura recibida entre 1000 y 3000.
     * 
     * @param atacante El combatiente que realiza el ataque inminente.
     * @return Los puntos de aura que Korby pierde tras el impacto.
     */
    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println(">> " + atacante.obtenerNombre() + " ataca al pobre Korby y se ve una pequeña lagrima salir de su ojo derecho :(");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de la estrategia base de Korby.
     * 
     * @return La cadena "Korby Base".
     */
    @Override
    public String obtenerNombre() { 
        return "Korby Base"; 
    }
}
