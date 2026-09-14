import java.util.Random;

/**
 * Estrategia de espada para MeganMan, la cual genera una espada de energia 
 * que potencia sus ataques cuerpo a cuerpo y sirve para desviar ataques enemigos.
 */
public class EstrategiaMeganManEspada implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque rapido y letal desenvainando una espada de energia.
     * Genera una ganancia aleatoria de aura entre 1200 y 2000.
     * 
     * @param objetivo El combatiente que recibe el corte relampago.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int danioEspada = 1200 + random.nextInt(801);
        System.out.println("MeganMan desenvaina su espada y corta a " + objetivo.getNombre() + " en un movimiento relampago!");
        System.out.println(VERDE + "+ " + danioEspada + " de Aura ⚔️" + RESET);
        return danioEspada;
    }

    /**
     * Utiliza la hoja de la espada para desviar o bloquear el ataque inminente del enemigo.
     * Reduce el impacto con una perdida de aura calculada entre 400 y 600.
     * 
     * @param atacante El combatiente que realiza el ataque ofensivo.
     * @return Los puntos de aura que MeganMan pierde tras el bloqueo.
     */
    @Override
    public int defender(Combatiente atacante) {
        int danioReducido = 400 + random.nextInt(201);
        System.out.println("MeganMan usa su espada para desviar el ataque de " + atacante.getNombre() + "! 🛡️");
        System.out.println(ROJO + "- " + danioReducido + " de Aura 🥶💦" + RESET);
        return danioReducido;
    }

    /**
     * Obtiene el nombre identificador de esta estrategia de combate cuerpo a cuerpo.
     * 
     * @return La cadena "MeganMan Espada".
     */
    @Override
    public String obtenerNombre() {
        return "MeganMan Espada";
    }
}
