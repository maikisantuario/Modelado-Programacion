import java.util.Random;

/**
 * Estrategia base para el personaje MeganMan.
 */

public class EstrategiaMeganManBase implements EstrategiaPelea {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int danioBase = 500 + random.nextInt(1001); // Entre 500 y 1500
        System.out.println("MeganMan apunta con firmeza a " + objetivo.getNombre() + " y dispara sin piedad!");
        System.out.println(">> ¡Sistema de combate activado: A farmear aura!");
        System.out.println(VERDE + "+ " + danioBase + " de Aura 🗿🔥" + RESET);
        return danioBase;
    }

    @Override
    public int defender(Combatiente atacante) {
        int danioReducido = 200 + random.nextInt(301); // Entre 200 y 500
        System.out.println(atacante.getNombre() + " ataca a MeganMan, pero su armadura resiste!");
        System.out.println(">> La armadura reduce el impacto!" + " Danio mitigado 🛡️");
        System.out.println(ROJO + "- " + danioReducido + " de Aura 🥶💦" + RESET);
        return danioReducido;
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan Base";
    }
}
