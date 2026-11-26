import java.util.ArrayList;
import java.util.List;

/**
 * Representa un departamento (nodo compuesto) dentro del catalogo.
 * Puede contener tanto productos individuales como otros subdepartamentos.
 */
public class DepartamentoMenu extends ComponenteCatalogo {

    /** Lista de componentes hijos (productos o subdepartamentos). */
    private List<ComponenteCatalogo> componentes;

    /**
     * Constructor de un departamento.
     *
     * @param nombre Nombre del departamento.
     */
    public DepartamentoMenu(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    /**
     * Agrega un componente al departamento.
     *
     * @param componente El componente a agregar.
     */
    @Override
    public void agregar(ComponenteCatalogo componente) {
        componentes.add(componente);
    }

    /**
     * Elimina un componente del departamento.
     *
     * @param componente El componente a eliminar.
     */
    @Override
    public void eliminar(ComponenteCatalogo componente) {
        componentes.remove(componente);
    }

    /**
     * Obtiene un componente hijo por su indice.
     *
     * @param indice Indice del componente.
     * @return El componente hijo.
     */
    @Override
    public ComponenteCatalogo obtenerHijo(int indice) {
        if (indice >= 0 && indice < componentes.size()) {
            return componentes.get(indice);
        }
        return null;
    }

    /**
     * Muestra el departamento y todos sus componentes con formato de arbol.
     *
     * @param indentacion Cadena de espacios para la indentacion.
     */
    @Override
    public void mostrarIdentacion(String indentacion) {
        System.out.println(indentacion + "+-- DEPARTAMENTO: " + nombre);
        for (ComponenteCatalogo componente : componentes) {
            componente.mostrarIdentacion(indentacion + "    ");
        }
    }
}