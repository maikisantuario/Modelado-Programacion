/**
 * Clase que representa un objeto de poder que aparece en la arena de combate.
 * Contiene la estrategia (poder o habilidad) que adoptara el combatiente 
 * compatible al consumirlo.
 */
public class ObjetoPoder {

    /** Nombre del personaje especifico que puede consumir este objeto. */
    private String personajeAsociado;
    
    /** Nombre visual o descriptivo del objeto en la arena. */
    private String nombreObjeto;
    
    /** La estrategia de pelea o poder que el objeto otorga al ser consumido. */
    private EstrategiaPelea estrategia;
    
    /** Estado del objeto, indica si ya ha sido utilizado en la arena. */
    private boolean consumido;

    /**
     * Constructor de la clase ObjetoPoder. Inicializa el objeto estableciendo 
     * su compatibilidad, nombre visual y la estrategia de combate que otorga, 
     * ademas de marcarlo como no consumido por defecto.
     * 
     * @param personajeAsociado Nombre del personaje al que pertenece o es compatible este item.
     * @param nombreObjeto Nombre visual del item en la arena.
     * @param estrategia La estrategia ({@link EstrategiaPelea}) o poder que otorga.
     */
    public ObjetoPoder(String personajeAsociado, String nombreObjeto, EstrategiaPelea estrategia) {
        this.personajeAsociado = personajeAsociado;
        this.nombreObjeto = nombreObjeto;
        this.estrategia = estrategia;
        this.consumido = false;
    }

    /**
     * Verifica si el objeto es compatible con el personaje que intenta recogerlo.
     * 
     * @param personaje Nombre del personaje que intenta consumirlo.
     * @return true si coinciden los nombres (es compatible), false en caso contrario.
     */
    public boolean esPara(String personaje) {
        return this.personajeAsociado.equals(personaje);
    }

    /**
     * Obtiene la estrategia encapsulada en el objeto.
     * 
     * @return La nueva estrategia de pelea que el personaje debe equipar.
     */
    public EstrategiaPelea obtenerEstrategia() {
        return this.estrategia;
    }

    /**
     * Cambia el estado del objeto a consumido para evitar que sea recogido y 
     * utilizado multiples veces en la misma simulacion.
     */
    public void marcarConsumido() {
        this.consumido = true;
    }

    /**
     * Verifica el estado actual del objeto en la arena.
     * 
     * @return true si el objeto ya fue utilizado por un combatiente, false si sigue disponible.
     */
    public boolean estaConsumido() {
        return this.consumido;
    }

    /**
     * Obtiene el nombre visual del objeto de poder.
     * 
     * @return La cadena de texto con el nombre del objeto.
     */
    public String getNombreObjeto() {
        return nombreObjeto;
    }

    /**
     * Obtiene el nombre del personaje exclusivo al que esta vinculado este objeto.
     * 
     * @return La cadena de texto con el nombre del personaje asociado.
     */
    public String getPersonajeAsociado() {
        return personajeAsociado;
    }
}
