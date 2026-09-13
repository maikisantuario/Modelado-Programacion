/**
 * Clase abstracta que representa al personaje combatiente.
 * Contiene los atributos basicos.
 */

public abstract class Combatiente {

    protected String nombre;
    protected EstrategiaPelea estrategiaActual;
    protected int porcentajeVida;
    protected boolean vivo;

    /**
     * @param nombre Nombre del personaje.
     * @param estrategiaBase Estrategia inicial con la que comienza a pelear.
     */
    public Combatiente(String nombre, EstrategiaPelea estrategiaBase) {
        this.nombre = nombre;
        this.estrategiaActual = estrategiaBase;
        this.porcentajeVida = 100; // Inicia con la vida completa
        this.vivo = true;
    }

    /**
     * Cambia la estrategia de la nueva pelea.
     * @param nuevaEstrategia 
     */
    public void setEstrategia(EstrategiaPelea nuevaEstrategia) {
        this.estrategiaActual = nuevaEstrategia;
    }

    /**
     * Consume un objeto de poder para cambiar de estrategia.
     * @param objeto
     * @return
     */

    public boolean consumirObjeto(ObjetoPoder objeto) {
        if (objeto != null && !objeto.estaConsumido()) {
            this.setEstrategia(objeto.obtenerEstrategia());
            objeto.marcarConsumido();
            System.out.println(this.nombre + " ha consumido " + objeto.getNombreObjeto() + " y ahora tiene: " + this.estrategiaActual.obtenerNombre());
            return true;
        }
        return false;
    }

    /**
     * Realiza un ataque usando la estrategia nueva
     * @return El danio infligido.
     */
    public int realizarAtaque() {
        if (!this.vivo) return 0;
        int danio = this.estrategiaActual.atacar();
        System.out.println(this.nombre + " ataca con " + this.estrategiaActual.obtenerNombre() + " causo " + danio + " de danio.");
        return danio;
    }

    /**
     * Recibe un golpe en combate.
     * @param impacto Danio entrante.
     * @param seDefiende 
     */
    public void recibirImpacto(int impacto, boolean seDefiende) {
        if (!this.vivo) return;

        int danioFinal = impacto;
        if (seDefiende) {
            danioFinal = this.estrategiaActual.defender(impacto);
            System.out.println(this.nombre + " se defiende con " + this.estrategiaActual.obtenerNombre() + " reduciendo el danio a " + danioFinal + ".");
        } else {
            System.out.println(this.nombre + " recibio " + danioFinal + " de danio.");
        }

        this.porcentajeVida -= danioFinal;
        if (this.porcentajeVida <= 0) {
            this.porcentajeVida = 0;
            this.vivo = false;
            System.out.println(this.nombre + " ha sido derrotado.");
        }
    }

    /**
     * Verifica si el combatiente sigue en el combate.
     * @return
     */
    public boolean estaVivo() {
        return this.vivo;
    }

    public String getNombre() { return nombre; }
    public int getPorcentajeVida() { return porcentajeVida; }
    public String getNombrePoder() { return estrategiaActual.obtenerNombre(); }
}
