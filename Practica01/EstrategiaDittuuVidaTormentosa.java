import java.util.Random;

/**
 * Estrategia de vida tormentosa para Dittuu. Libera un ataque devastador
 * y genera una tormenta de salud exclusiva al defenderse con calculos de aura.
 */
public class EstrategiaDittuuVidaTormentosa implements EstrategiaPelea {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println("¡Dittuu desata una tormenta de energia pura sobre " + objetivo.getNombre() + ", arrasando con todo!");
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println("¡Dittuu gira velozmente ante " + atacante.getNombre() + ", generando una tormenta de salud exclusiva para el!");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Vida Tormentosa"; 
    }
}
