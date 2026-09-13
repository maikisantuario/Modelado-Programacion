/**
 * Estrategia de ataque para MeganMan, saca una bomba que hace daño a los enemigos.
 */

public class EstrategiaMeganManBomba implements EstrategiaPelea {

    @Override
    public int atacar() {
        System.out.println("MeganMan apunta al cielo y dispara una bomba");
        System.out.println(">> El proyectil brilla y estalla en lo alto de la arena!");
        System.out.println(">> ¡BOOOOOM! ¡Empiezan a caer escombros y metralla por todos lados!");
        System.out.println(">> El ataque golpea a todos los que estan en la arena! 25 de danio!");
        return 25;
    }

    @Override
    public int defender(int impacto) {
        System.out.println("MeganMan esta recargando su bomba y no puede esquivar los escombros...");
        System.out.println(">> ¡CRASH! Recibe el golpe casi de lleno. No puede mitigar el daño por completo!");
        return Math.max(0, impacto - 1);
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan Bomba";
    }
}