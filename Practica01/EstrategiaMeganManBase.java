public class EstrategiaMeganManBase implements EstrategiaPelea {

    @Override
    public int atacar() {
        System.out.println("MeganMan apunta con firmeza y dispara!");
        System.out.println(">> Farmeo de aura: Danio critico detectado! 12 de energia!");
        return 12;
    }

    @Override
    public int defender(int impacto) {
        System.out.println("MeganMan activa su armadura de titanio para poder resistir el golpe!");
        System.out.println(">> La armadura reduce el impacto! Danio mitigado en 2 puntos!");
        return Math.max(0, impacto - 2); // Devuelve el danio final
    }

    @Override
    public String obtenerNombre() {
        return "MeganMan Base";
    }
}