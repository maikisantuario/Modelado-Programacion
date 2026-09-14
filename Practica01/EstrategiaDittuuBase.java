import java.util.Random;

/**
 * Estrategia base para el personaje Dittuu. Mantiene un ataque y defensa básicos.
 */
public class EstrategiaDittuuBase implements EstrategiaPelea {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println(">> Dittuu analiza al rival y ejecuta un golpe con precisión contra " + objetivo.obtenerNombre());
        System.out.println("+ " + auraObtenida + " de Aura 🗿🔥");
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println(">> " + atacante.obtenerNombre() + " ataca a Dittuu, quien adopta una forma gelatinosa para absorber parte del impacto.");
        System.out.println("- " + auraPerdida + " de Aura 🥶💦");
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Base"; 
    }
}
