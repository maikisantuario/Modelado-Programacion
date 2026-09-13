import java.util.Random;

/**
 * Estrategia de vida tormentosa para Dittuu. Libera un ataque devastador
 * y genera una tormenta de salud exclusiva al defenderse con calculos de aura.
 */
public class EstrategiaDittuuVidaTormentosa implements EstrategiaPelea {
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println("¡Dittuu desata una tormenta de energia pura sobre " + objetivo.getNombre() + ", arrasando con todo!");
        System.out.println("+ " + auraObtenida + " de Aura 🗿🔥");
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println("¡Dittuu gira velozmente ante " + atacante.getNombre() + ", generando una tormenta de salud exclusiva para el!");
        System.out.println("- " + auraPerdida + " de Aura 🥶💦");
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Vida Tormentosa"; 
    }
}
