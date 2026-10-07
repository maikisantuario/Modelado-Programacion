/**
 * Producto concreto del Factory Method: Campo Montania Espiritual.
 */
public class MontaniaEspiritual implements CampoEntrenamiento {
    @Override
    public String getNombre() {
        return "Montania Espiritual";
    }

    @Override
    public String getDescripcion() {
        return "Un terreno escarpado y místico reservado para los grupos de mas alto nivel de habilidad.";
    }
}
