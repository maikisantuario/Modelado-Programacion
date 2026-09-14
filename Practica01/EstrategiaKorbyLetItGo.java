import java.util.Random;

/**
 * Estrategia de hielo para Korby. Al cantar, Korby desbloquea sus
 * poderes de hielo con los que congela a sus enemigos o a si mismo
 * para disminuir el daño de los ataques que se aproximen.
 */
public class EstrategiaKorbyLetItGo implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque helado inspirado en su canto de cristal.
     * Genera una ganancia aleatoria de aura entre 1000 y 4000.
     * 
     * @param objetivo El combatiente que recibe el ataque de hielo.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) { 
        int auraObtenida = 1000 + random.nextInt(3001);
        System.out.println("OHHHHH ¿Escuchan ese canto de angel? \n¿Es Korby? ¿¡Cantando!?" +
                           "\nEL FRÍO ES PARTE TAMBIEN DE MIIIIIII" +
                           "\n>> Korby con su poder de hielo ataca a: " + objetivo.obtenerNombre());
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Defiende a Korby congelándose a sí mismo para bloquear y disipar la embestida enemiga.
     * Reduce significativamente el impacto, con una pérdida de aura calculada entre 300 y 600.
     * 
     * @param atacante El combatiente que realiza el ataque inicial.
     * @return Los puntos de aura que Korby pierde tras congelarse defensivamente.
     */
    @Override
    public int defender(Combatiente atacante) { 
        int auraPerdida = 300 + random.nextInt(301);
        System.out.println(atacante.obtenerNombre() + " intenta atacar a Korby.");
        System.out.println(">> Korby se congela y disipa el ataque de " + atacante.obtenerNombre());
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de esta helada estrategia.
     * 
     * @return La cadena "Korby LetItGo".
     */
    @Override
    public String obtenerNombre() { 
        return "Korby LetItGo"; 
    }
}
