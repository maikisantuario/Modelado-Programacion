/**
 * Clase abstracta que define el comportamiento comun de los elementos del catalogo.
 * Aplica el patron Composite para representar productos individuales y departamentos.
 */
public abstract class ComponenteCatalogo {

    /** Nombre del componente (producto o departamento). */
    protected String nombre;

    /**
     * Agrega un subcomponente. Por defecto lanza excepcion.
     *
     * @param componente El componente a agregar.
     */
    public void agregar(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operacion no soportada.");
    }

    /**
     * Elimina un subcomponente. Por defecto lanza excepcion.
     *
     * @param componente El componente a eliminar.
     */
    public void eliminar(ComponenteCatalogo componente) {
        throw new UnsupportedOperationException("Operacion no soportada.");
    }

    /**
     * Obtiene un subcomponente en un indice dado.
     * Por defecto lanza excepcion.
     *
     * @param indice El indice del componente.
     * @return El componente en ese indice.
     */
    public ComponenteCatalogo obtenerHijo(int indice) {
        throw new UnsupportedOperationException("Operacion no soportada.");
    }

    /**
     * Muestra la representacion del componente en formato de arbol.
     *
     * @param indentacion Cadena de espacios para la indentacion.
     */
    public abstract void mostrarIdentacion(String indentacion);
}