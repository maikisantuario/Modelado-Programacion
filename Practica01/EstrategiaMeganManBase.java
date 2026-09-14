import java.util.Random;

/**
 * Estrategia base para el personaje MeganMan. Mantiene un ataque y defensa basicos
 * haciendo uso de su disparo de cañon y la resistencia de su armadura metalica.
 */
public class EstrategiaMeganManBase implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque basico apuntando con firmeza al objetivo con su cañon.
     * Genera una ganancia aleatoria de aura entre 500 y 1500.
     * 
     * @param objetivo El combatiente que recibe el disparo.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int danioBase = 500 + random.nextInt(1001);
        System.out.println("MeganMan apunta con firmeza a " + objetivo.getNombre() + " y dispara sin piedad!");
        System.out.println(">> ¡Sistema de combate activado: A farmear aura!");
        System.out.println(VERDE + "+ " + danioBase + " de Aura 🗿🔥" + RESET);
        return danioBase;
    }

    /**
     * Defiende a MeganMan utilizando la resistencia de su armadura metalica.
     * Mitiga el golpe enemigo con una perdida de aura calculada entre 200 y 500.
     * 
     * @param atacante El combatiente que realiza el ataque inminente.
     * @return Los puntos de aura que MeganMan pierde tras absorber el impacto.
     */
    @Override
    public int defender(Combatiente atacante) {
        int danioReducido = 200 + random.nextInt(301);
        System.out.println(atacante.getNombre() + " ataca a MeganMan, pero su armadura resiste!");
        System.out.println(">> La armadura reduce el impacto! Danio mitigado 🛡️");
        System.out.println(ROJO + "- " + danioReducido + " de Aura 🥶💦" + RESET);
        return danioReducido;
    }

    /**
     * Obtiene el nombre identificador de la estrategia base de MeganMan.
     * 
     * @return La cadena "MeganMan Base".
     */
    @Override
    public String obtenerNombre() {
        return "MeganMan Base";
    }
}
