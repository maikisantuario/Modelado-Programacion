/**
 * Producto concreto del Factory Method: Campo Bosque Sombrio.
 */
public class BosqueSombrio implements CampoEntrenamiento {
    @Override
    public String getNombre() {
        return "Bosque Sombrio";
    }

    @Override
    public String getDescripcion() {
        return "Un denso bosque lleno de sombras y obstaculos para desafiar a grupos de habilidad intermedia.";
    }
}
