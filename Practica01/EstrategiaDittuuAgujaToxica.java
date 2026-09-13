import java.util.Random;

/**
 * Estrategia de veneno para Dittuu. Forma una cola con aguja para infectar
 * al oponente y genera un capullo acido defensivo usando calculo de aura.
 */
public class EstrategiaDittuuAgujaToxica implements EstrategiaPelea {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println("¡Dittuu despliega una cola afilada y con la aguja de la cola infecta con toxinas a " + objetivo.getNombre() + "!");
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println("Dittuu genera un capullo acido para neutralizar el ataque de " + atacante.getNombre() + ".");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Veneno"; 
    }
}
