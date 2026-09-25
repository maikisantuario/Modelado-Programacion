/**
 * Clase abstracta que representa una Pizza estanadar en la pizzería.
 * Implementa el patrón Template Method, con el algoritmo de preparación
 * en el método final prepararPizza() y deja los detalles específicos
 * (queso y proteína) a las subclases.
 */
public abstract class Pizza {
    
    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private boolean esVegetariana;
    private TipoMasa tipoMasa;


    public Pizza(int id, String nombre, String descripcion, double precio, boolean esVegetariana, TipoMasa tipoMasa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.esVegetariana = esVegetariana;
        this.tipoMasa = tipoMasa;
    }

    /**
     * Define la secuencia de los pasos a seguir para preparar cualquier pizza.
     */
    public final void prepararPizza() {
        System.out.println("\n--- Iniciando preparación de: " + this.nombre + " ---");
        prepararMasa();
        aplanarMasa();
        colocarSalsa();
        
        
        colocarQueso(); 
        colocarEspecies();
        colocarProteina(); 
        
        meterHorno();
        esperar();
        sacarHorno();
        empaquetar();
        System.out.println("--- " + this.nombre + " lista. ---\n");
    }


    public void prepararMasa() {
        System.out.println("1. Preparando la masa...");
    }

    public void aplanarMasa() {
        System.out.println("2. Aplanando la masa...");
    }

    public void colocarSalsa() {
        System.out.println("3. Colocando salsa de tomate...");
    }

    public void colocarEspecies() {
        System.out.println("5. Colocando especies...");
    }

    public void meterHorno() {
        System.out.println("7. Metiendo al horno...");
    }

    public void esperar() {
        System.out.println("8. Esperando a que se cocine...");
    }

    public void sacarHorno() {
        System.out.println("9. Sacando del horno...");
    }

    public void empaquetar() {
        System.out.println("10. Empaquetando...");
    }


    /**
     * Tipo de queso lleva la pizza.
     */
    public abstract void colocarQueso();

    /**
     * Proteína que lleva esta pizza.
     */
    public abstract void colocarProteina();

    // --- Métodos para la masa  ---

    public void seleccionarMasa(TipoMasa masa) {
        this.tipoMasa = masa;
        System.out.println("Tipo de masa seleccionada: " + masa);
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public boolean isEsVegetariana() { return esVegetariana; }
    public TipoMasa getTipoMasa() { return tipoMasa; }
}