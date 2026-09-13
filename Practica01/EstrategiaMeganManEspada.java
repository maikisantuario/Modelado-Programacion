/**
 * Estrategia de espada para MeganMan la cual genera una espada que potencia su ataque.
 */

public class EstrategiaMeganManEspada implements EstrategiaPelea {

    @Override
    public int atacar() {
        System.out.println("MeganMan saca su espada y corta en un movimiento de relampago a su oponente!");
        System.out.println(">> Todo a su alrededor resuena! 18 de danio");
        return 18;
    }

    @Override
    public int defender(int impacto) {
        System.out.println("MeganMan usa su espada para desviar el ataque!");
        System.out.println(">> El filo de la espada absorbe parte del impacto. Reduce 4 de danio!");
        return Math.max(0, impacto - 4);
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan Espada";
    }
}