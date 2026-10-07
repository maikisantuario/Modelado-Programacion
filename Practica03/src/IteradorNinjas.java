/**
 * Iterador concreto para recorrer el arreglo de ninjas voluntarios.
 */
public class IteradorNinjas implements Iterador<NinjaVoluntario> {
    private NinjaVoluntario[] ninjas;
    private int posicion;

    /**
     * Constructor del iterador de ninjas.
     * @param ninjas Arreglo de ninjas voluntarios.
     */
    public IteradorNinjas(NinjaVoluntario[] ninjas) {
        this.ninjas = ninjas;
        this.posicion = 0;
    }

    @Override
    public boolean hasNext() {
        return posicion < ninjas.length && ninjas[posicion] != null;
    }

    @Override
    public NinjaVoluntario next() {
        if (hasNext()) {
            return ninjas[posicion++];
        }
        return null;
    }
}
