import java.util.Random;

/**
 * Estrategia de duplicacion para Dittuu. Simula la division celular
 * para contraatacar y defenderse utilizando fluctuaciones de aura mediante clones.
 */
public class EstrategiaDittuuGelatinaDuplicadora implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque dividiendo a Dittuu en dos clones gelatinosos para ejecutar
     * un golpe doble. Genera una ganancia aleatoria de aura entre 1000 y 3000.
     * 
     * @param objetivo El combatiente que recibe el ataque.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println(">> ¡Dittuu se divide en dos clones gelatinosos y ejecuta un ataque duplicado contra " + objetivo.getNombre() + "!");
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Defiende a Dittuu utilizando un clon gelatinoso como escudo señuelo 
     * para mitigar el ataque inminente.
     * 
     * @param atacante El combatiente que realiza el ataque original.
     * @return Los puntos de aura que Dittuu pierde tras usar el clon como defensa.
     */
    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println(">> Dittuu usa su clon gelatinoso como escudo señuelo ante la embestida de " + atacante.getNombre() + ".");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de esta estrategia de duplicacion.
     * 
     * @return La cadena "Dittuu Duplica".
     */
    @Override
    public String obtenerNombre() { 
        return "Dittuu Duplica"; 
    }
}
