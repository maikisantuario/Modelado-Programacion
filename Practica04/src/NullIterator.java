import java.util.Iterator;

/**
 * Iterador nulo para elementos individuales o adaptados que no tienen hijos.
 */
public class NullIterator implements Iterator<Producto> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Producto next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operación no soportada.");
    }
}
