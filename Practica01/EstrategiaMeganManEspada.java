import java.util.Random;

/**
 * Estrategia de espada para MeganMan la cual genera una espada que potencia su ataque.
 */

public class EstrategiaMeganManEspada implements EstrategiaPelea {
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String RESET = "\u001B[0m";
    private Random random = new Random();

    @Override
    public int atacar(Combatiente objetivo) {
        int danioEspada = 1200 + random.nextInt(801); // Entre 1200 y 2000
        System.out.println("MeganMan desenvaina su espada y corta a " + objetivo.obtenerNombre() + " en un movimiento relampago!");
        System.out.println(VERDE + "+ " + danioEspada + " de danio ⚔️" + RESET);
        return danioEspada;
    }

    @Override
    public int defender(Combatiente atacante) {
        int danioReducido = 400 + random.nextInt(201); // Entre 400 y 600
        System.out.println("MeganMan usa su espada para desviar el ataque de " + atacante.obtenerNombre() + "!");
        System.out.println(ROJO + "- " + danioReducido + " de danio bloqueado 🛡️" + RESET);
        return danioReducido;
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan Espada";
    }
}