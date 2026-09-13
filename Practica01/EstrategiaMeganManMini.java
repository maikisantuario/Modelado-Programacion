import java.util.Random;

/**
 * Estrategia de defensa para MeganMan, saca un mini MeganMan que aumenta la defensa.
 */

public class EstrategiaMeganManMini implements EstrategiaPelea {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int danioMini = 300 + random.nextInt(301); // Entre 300 y 600
        System.out.println("MeganMan saca a su forma Mini y comienza a correr en circulos alrededor de " + objetivo.getNombre() + "!");
        System.out.println(">> ¡PIP PIP PIP! Demasiados disparos, quiere dejar a su oponente como colador!");
        System.out.println(VERDE + "+ " + danioMini + " de danio 🔫" + RESET);
        return danioMini;
    }

    @Override
    public int defender(Combatiente atacante) {
        int danioReducido = 800 + random.nextInt(401); // Entre 800 y 1200 (Defensa alta)
        System.out.println("MeganMan Mini se esconde detras de una piedra diminuta mientras " + atacante.getNombre() + " ataca!");
        System.out.println(">> ¡Demasiado lento! MeganMan Mini esquiva haciendo un backflip!");
        System.out.println(ROJO + "- " + danioReducido + " de danio esquivado 🛡️💨" + RESET);
        return danioReducido;
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan Mini";
    }
}