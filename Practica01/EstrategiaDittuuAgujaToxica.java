import java.util.Random;

/**
 * Estrategia de veneno para Dittuu. Forma una cola con aguja para infectar
 * al oponente y genera un capullo acido defensivo usando calculo de aura.
 */
public class EstrategiaDittuuAgujaToxica implements EstrategiaPelea {
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println("¡Dittuu despliega una cola afilada y con la aguja de la cola infecta con toxinas a " + objetivo.getNombre() + "!");
        System.out.println("+ " + auraObtenida + " de Aura 🗿🔥");
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println("Dittuu genera un capullo acido para neutralizar el ataque de " + atacante.getNombre() + ".");
        System.out.println("- " + auraPerdida + " de Aura 🥶💦");
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Veneno"; 
    }
}
