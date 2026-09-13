import java.util.Random;

/**
 * Estrategia base para el personaje Korby. Mantiene un ataque y defensa básicos.
 */
public class EstrategiaKorbyBase implements EstrategiaPelea {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    private Random random = new Random();
    
    @Override
    public int atacar(Combatiente objetivo) {
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println("Korby aun siendo tan adorable ataca sin piedad a " + objetivo.obtenerNombre());
        System.out.println(VERDE +"+ " + auraObtenida + " de Aura 🗿🔥"+ VERDE);
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) {
        int auraPerdida = 1000 + random.nextInt(2001);
        System.out.println(atacante.obtenerNombre() + " ataca al pobre Korby y se ve una pequeña lagrima salir de su ojo derecho :(");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + ROJO);
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Korby Base"; 
    }
}
