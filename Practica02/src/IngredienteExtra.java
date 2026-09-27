/**
 * Clase abstracta que actúa como el Decorador Abstracto dentro del patrón Decorator.
 * Permite añadir ingredientes extra a cualquier objeto de tipo Helado,
 * modificando dinámicamente su descripción y costo.
 */
public abstract class IngredienteExtra implements Helado {
    
    /** Referencia al helado (base o previamente decorado) que se va a envolver. */
    public Helado heladoDecorado;

    /**
     * Construye un nuevo ingrediente extra.
     * 
     * @param helado Instancia de {@link Helado} sobre la cual se agregará el ingrediente.
     */
    public IngredienteExtra(Helado helado) {
        this.heladoDecorado = helado;
    }

    /**
     * Obtiene la descripción base acumulada.
     * 
     * @return Descripción del helado decorado.
     */
    @Override
    public String getDescripcion() {
        return heladoDecorado.getDescripcion();
    }

    /**
     * Obtiene el precio acumulado hasta el momento.
     * 
     * @return Precio actual acumulado.
     */
    @Override
    public double getPrecio() {
        return heladoDecorado.getPrecio();
    }

    /**
     * Cuenta cuántas veces se ha agregado un ingrediente específico en la cadena de decoración.
     * 
     * @param nombre Nombre del ingrediente a buscar.
     * @return Cantidad de apariciones del ingrediente.
     */
    public int contarIngrediente(String nombre) {
        int contador = 0;
        Helado actual = this;
        
        while (actual instanceof IngredienteExtra) {
            if (actual.getClass().getSimpleName().equalsIgnoreCase(nombre)) {
                contador++;
            }
            actual = ((IngredienteExtra) actual).heladoDecorado;
        }
        return contador;
    }
}
