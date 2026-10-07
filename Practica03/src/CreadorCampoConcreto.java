/**
 * Creador concreto que decide la instanciacion del campo de entrenamiento.
 */
public class CreadorCampoConcreto implements CreadorDeCampo {
    @Override
    public CampoEntrenamiento crearCampo(int sumaHabilidades) {
        if (sumaHabilidades <= 7) {
            return new ValleDelDragon();
        } else if (sumaHabilidades <= 11) {
            return new BosqueSombrio();
        } else {
            return new MontaniaEspiritual();
        }
    }
}
