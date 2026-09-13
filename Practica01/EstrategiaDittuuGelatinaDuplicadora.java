import java.util.Random;

/**
 * Estrategia de duplicacion para Dittuu. Simula la division celular
 * para contraatacar y defenderse utilizando fluctuaciones de aura.
 */
public class EstrategiaDittuuGelatinaDuplicadora implements EstrategiaPelea {
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println("¡Dittuu se divide en dos clones gelatinosos y ejecuta un ataque duplicado contra " + objetivo.getNombre() + "!");
        System.out.println("+ " + auraObtenida + " de Aura 🗿🔥");
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println("Dittuu usa su clon gelatinoso como escudo señuelo ante la embestida de " + atacante.getNombre() + ".");
        System.out.println("- " + auraPerdida + " de Aura 🥶💦");
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Duplica"; 
    }
}
