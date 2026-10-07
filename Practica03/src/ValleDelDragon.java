/**
 * Producto concreto del Factory Method: Campo Valle del Dragon.
 */
public class ValleDelDragon implements CampoEntrenamiento {
    @Override
    public String getNombre() {
        return "Valle del Dragon";
    }

    @Override
    public String getDescripcion() {
        return "Un terreno plano y sereno ideal para ninjas principiantes o grupos de bajo nivel de habilidad.";
    }
}
