import java.util.Random;

/**
 * Estrategia de defensa y evasión para MeganMan. Adopta una forma "Mini" 
 * que disminuye su poder de ataque, pero aumenta drásticamente su capacidad 
 * para esquivar y defenderse de los ataques enemigos.
 */
public class EstrategiaMeganManMini implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque rápido y escurridizo corriendo en círculos y disparando 
     * pequeñas ráfagas. Genera una ganancia de daño/aura baja, entre 300 y 600.
     * 
     * @param objetivo El combatiente que recibe las múltiples ráfagas de disparos.
     * @return Los puntos de daño infligidos al objetivo.
     */
    @Override
    public int atacar(Combatiente objetivo) {
        int danioMini = 300 + random.nextInt(301); // Entre 300 y 600
        System.out.println("MeganMan saca a su forma Mini y comienza a correr en circulos alrededor de " + objetivo.getNombre() + "!");
        System.out.println(">> ¡PIP PIP PIP! Demasiados disparos, quiere dejar a su oponente como colador!");
        System.out.println(VERDE + "+ " + danioMini + " de danio 🔫" + RESET);
        return danioMini;
    }

    /**
     * Defiende a MeganMan utilizando su diminuto tamaño y gran agilidad para 
     * esquivar los ataques enemigos casi por completo. Logra evadir un daño calculado entre 800 y 1200 (Defensa alta).
     * 
     * @param atacante El combatiente que intenta golpear a la forma Mini.
     * @return Los puntos de daño mitigados o esquivados exitosamente.
     */
    @Override
    public int defender(Combatiente atacante) {
        int danioReducido = 800 + random.nextInt(401); 
        System.out.println("MeganMan Mini se esconde detras de una piedra diminuta mientras " + atacante.getNombre() + " ataca!");
        System.out.println(">> ¡Demasiado lento! MeganMan Mini esquiva haciendo un backflip!");
        System.out.println(ROJO + "- " + danioReducido + " de danio esquivado 🛡️💨" + RESET);
        return danioReducido;
    }

    /**
     * Obtiene el nombre identificador de esta estrategia evasiva.
     * 
     * @return La cadena "MeganMan Mini".
     */
    @Override
    public String obtenerNombre() {
        return "MeganMan Mini";
    }
}
