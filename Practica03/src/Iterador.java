/**
 * Interfaz generica para el patron Iterator.
 * @param <T> Tipo de elemento a iterar.
 */
public interface Iterador<T> {
    /**
     * Verifica si existen mas elementos en la coleccion.
     * @return true si hay mas elementos, false en caso contrario.
     */
    boolean hasNext();

    /**
     * Obtiene el siguiente elemento de la coleccion.
     * @return Siguiente elemento de tipo T.
     */
    T next();
}
