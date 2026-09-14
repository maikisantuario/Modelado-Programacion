import java.util.Random;

/**
 * Estrategia de hielo para Korby. Al cantar Korby desbloquea sus
 * poderes de hielo con los que congela a sus enemigos o a si mismo
 * para disminuir el daño de los ataques que se aproximen.
 */
public class EstrategiaKorbyLetItGo implements EstrategiaPelea {
    
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) { 
        int auraObtenida = 1000 + random.nextInt(3001);
        System.out.println("OHHHHH ¿Escuchan ese canto de angel? \n¿Es Korby? ¿¡Cantando!?" +
			   "\nEL FRÍO ES PARTE TAMBIEN DE MIIIIIII" +
			   "\n>> Korby con su poder de hielo ataca a: " + objetivo.obtenerNombre());
        System.out.println(VERDE +"+ " + auraObtenida + " de Aura 🗿🔥"+ RESET);
        return auraObtenida; 
    }

    @Override
    public int defender(Combatiente atacante) { 
        int auraPerdida = 300 + random.nextInt(301); // Entre 300 y 600
	System.out.println(atacante.obtenerNombre() + "intenta atacar a Korby.");
        System.out.println(">> Korby se congela y disipa el ataque de " + atacante.obtenerNombre());
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    @Override
    public String obtenerNombre() { 
        return "Korby LetItGo"; 
    }
}
