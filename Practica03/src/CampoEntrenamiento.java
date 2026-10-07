/**
 * Interfaz que define el producto del patron Factory Method para los campos de entrenamiento.
 */
public interface CampoEntrenamiento {
    /**
     * Obtiene el nombre del campo de entrenamiento.
     * @return Nombre del campo.
     */
    String getNombre();

    /**
     * Obtiene la descripcion del campo de entrenamiento.
     * @return Descripcion del campo.
     */
    String getDescripcion();
}
