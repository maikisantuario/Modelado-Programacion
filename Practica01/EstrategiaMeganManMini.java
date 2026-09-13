/**
 * Estrategia de defensa para MeganMan, saca un mini MeganMan que aumenta la defensa.
 */

public class EstrategiaMeganManMini implements EstrategiaPelea {

    @Override
    public int atacar() {
        System.out.println("MeganMan saca a su forma Mini y comienza a correr en circulos");
        System.out.println(">> ¡PIP PIP PIP! Demasiados disparos, quiere dejar a su openete como colador! 8 de danio!");
        return 8;
    }

    @Override
    public int defender(int impacto) {
        System.out.println("MeganMan Mini se esconde detras de una piedra diminuta");
        System.out.println(">> ¡Demasiado lento! MeganMan Mini esquiva haciendo un backflip. Reduce 6 de danio y aumenta su aura");
        return Math.max(0, impacto - 6);
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan Mini";
    }
}