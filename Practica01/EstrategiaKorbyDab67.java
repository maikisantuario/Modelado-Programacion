import java.util.Random;

/**
 * Estrategia de ondas para Korby. Simula ondas de viento que empujan y dañan a
 * sus enemigos y disminuyen el daño de los ataques que se aproximen mediante
 * el poder legendario del Dab67.
 */
public class EstrategiaKorbyDab67 implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque ejecutando un poderoso Dab67 que genera ondas de viento inigualables.
     * Genera una ganancia aleatoria de aura entre 1000 y 6000.
     * 
     * @param objetivo El combatiente que recibe el ataque y es empujado por los aires.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) { 
        int auraObtenida = 1000 + random.nextInt(5001);
        System.out.println("OMGGGG ¿Qué está haciendo Korby? \n¿Es eso un Dab? ¿¡Y un 67!?" +
                           "\nEl poder del Dab67 genera ondas de viento inigualables :O" +
                           "\n>> Korby con su gran Dab67 empuja por los aires a: " + objetivo.obtenerNombre());
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Defiende a Korby utilizando las ondas del Dab67 para disipar el ataque enemigo.
     * Reduce significativamente el impacto, con una perdida de aura calculada entre 500 y 1000.
     * 
     * @param atacante El combatiente que realiza el ataque inicial.
     * @return Los puntos de aura que Korby pierde tras bloquear la embestida.
     */
    @Override
    public int defender(Combatiente atacante) { 
        int auraPerdida = 500 + random.nextInt(501);
        System.out.println(atacante.obtenerNombre() + " intenta atacar a Korby pero tiene un Dab67 bajo la manga.");
        System.out.println(">> Con el Dab67, Korby logra empujar y disipar el ataque de " + atacante.obtenerNombre());
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de esta estrategia especial de ondas.
     * 
     * @return La cadena "Korby Dab67".
     */
    @Override
    public String obtenerNombre() { 
        return "Korby Dab67"; 
    }
}
