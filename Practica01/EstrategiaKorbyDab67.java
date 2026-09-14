import java.util.Random;

/**
 * Estrategia de ondas para Korby. Simula ondas de viento que empujan y dañan a
 * sus enemigos y disminuyen el daño de los ataques que se aproximen.
 */
public class EstrategiaKorbyDab67 implements EstrategiaPelea {
    
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) { 
        int auraObtenida = 1000 + random.nextInt(5001);
        System.out.println("OMGGGG ¿Qué está haciendo Korby? \n¿Es eso un Dab? ¿¡Y un 67!?" +
			   "\nEl poder del Dab67 genera ondas de viento inigualables :O" +
			   "\n>> Korby con su gran Dab67 empuja por los aires a: " + objetivo.obtenerNombre());
        System.out.println(VERDE +"+ " + auraObtenida + " de Aura 🗿🔥"+ RESET);
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) { 
        int auraPerdida = 500 + random.nextInt(501); // Entre 500 y 1000
	System.out.println(atacante.obtenerNombre() + "intenta atacar a Korby tiene un Dab67 bajo la manga.");
        System.out.println(">> Con el Dab67, Korby logra empujar y disipar el ataque de " + atacante.obtenerNombre());
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Korby Dab67"; 
    }
}
