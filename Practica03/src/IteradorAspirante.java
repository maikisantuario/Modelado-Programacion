import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Iterador concreto para recorrer la Hashtable de aspirantes.
 */
public class IteradorAspirante implements Iterador<Aspirante> {
    private Hashtable<String, Aspirante> aspirantes;
    private Enumeration<String> llaves;

    /**
     * Constructor del iterador de aspirantes.
     * @param aspirantes Hashtable con los aspirantes registrados.
     */
    public IteradorAspirante(Hashtable<String, Aspirante> aspirantes) {
        this.aspirantes = aspirantes;
        this.llaves = aspirantes.keys();
    }

    @Override
    public boolean hasNext() {
        return llaves.hasMoreElements();
    }

    @Override
    public Aspirante next() {
        if (hasNext()) {
            String clave = llaves.nextElement();
            return aspirantes.get(clave);
        }
        return null;
    }
}
