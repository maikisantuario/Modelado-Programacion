/**
 * Clase que representa un objeto de poder que aparece en la arena.
 * Contiene la estrategia que adoptara el combatiente al consumirlo.
 */
public class ObjetoPoder {

    private String personajeAsociado;
    private String nombreObjeto;
    private EstrategiaPelea estrategia;
    private boolean consumido;

    /**
     * @param personajeAsociado Nombre del personaje al que pertenece este item.
     * @param nombreObjeto Nombre visual del item en la arena.
     * @param estrategia La estrategia o poder que otorga.
     */
    public ObjetoPoder(String personajeAsociado, String nombreObjeto, EstrategiaPelea estrategia) {
        this.personajeAsociado = personajeAsociado;
        this.nombreObjeto = nombreObjeto;
        this.estrategia = estrategia;
        this.consumido = false;
    }

    /**
     * Verifica si el objeto es compatible con el personaje.
     * @param personaje Nombre del personaje que intenta consumirlo.
     * @return true si coinciden los nombres.
     */
    public boolean esPara(String personaje) {
        return this.personajeAsociado.equals(personaje);
    }

    /**
     * Obtiene la estrategia encapsulada en el objeto.
     * @return La nueva estrategia de pelea.
     */
    public EstrategiaPelea obtenerEstrategia() {
        return this.estrategia;
    }

    /**
     * Cambia el estado del objeto a consumido para evitar usos duplicados.
     */
    public void marcarConsumido() {
        this.consumido = true;
    }

    /**
     * Verifica el estado actual del objeto.
     * @return true si el objeto ya fue utilizado.
     */
    public boolean estaConsumido() {
        return this.consumido;
    }

    public String getNombreObjeto() {
	return nombreObjeto;
    }
    public String getPersonajeAsociado() {
	return personajeAsociado;
    }
}
