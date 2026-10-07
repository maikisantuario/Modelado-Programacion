/**
 * Interfaz Creador del patron Factory Method.
 */
public interface CreadorDeCampo {
    /**
     * Metodo de fabrica para crear un campo de entrenamiento segun la suma de habilidades.
     * @param sumaHabilidades Suma total de habilidad del grupo.
     * @return Instancia concreta de CampoEntrenamiento.
     */
    CampoEntrenamiento crearCampo(int sumaHabilidades);
}
