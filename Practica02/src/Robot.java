/**
 * Clase Contexto que representa al Robot repartidor de pizzas y helados.
 * Mantiene la referencia al estado actual y a los productos ordenados.
 */
public class Robot {
    private EstadoRobot estadoActual;
    private Pizza pizzaOrdenada;
    private Helado heladoOrdenado;

    /**
     * Constructor por defecto del Robot. Inicia en EstadoDormido.
     */
    public Robot() {
        this.estadoActual = new EstadoDormido(this);
    }

    /**
     * Actualiza el estado actual del Robot.
     * 
     * @param nuevoEstado El nuevo estado a asignar.
     */
    public void setEstado(EstadoRobot nuevoEstado) {
        this.estadoActual = nuevoEstado;
    }

    /**
     * Obtiene el estado actual del Robot.
     * 
     * @return El estado actual.
     */
    public EstadoRobot getEstadoActual() {
        return estadoActual;
    }

    /**
     * Obtiene la pizza ordenada.
     * 
     * @return La pizza ordenada.
     */
    public Pizza getPizzaOrdenada() {
        return pizzaOrdenada;
    }

    /**
     * Asigna una pizza a la orden del Robot.
     * 
     * @param pizzaOrdenada La pizza a ordenar.
     */
    public void setPizzaOrdenada(Pizza pizzaOrdenada) {
        this.pizzaOrdenada = pizzaOrdenada;
    }

    /**
     * Obtiene el helado ordenado.
     * 
     * @return El helado ordenado.
     */
    public Helado getHeladoOrdenado() {
        return heladoOrdenado;
    }

    /**
     * Asigna un helado a la orden del Robot.
     * 
     * @param heladoOrdenado El helado a ordenar.
     */
    public void setHeladoOrdenado(Helado heladoOrdenado) {
        this.heladoOrdenado = heladoOrdenado;
    }

    /**
     * Delega la accion de llamar al estado actual.
     */
    public void llamar() {
        estadoActual.llamar();
    }

    /**
     * Delega la accion de ordenar pizza al estado actual.
     * 
     * @param pizza La pizza a agregar.
     */
    public void ordenarPizza(Pizza pizza) {
        estadoActual.ordenarPizza(pizza);
    }

    /**
     * Delega la accion de ordenar helado al estado actual.
     * 
     * @param helado El helado a agregar.
     */
    public void ordenarHelado(Helado helado) {
        estadoActual.ordenarHelado(helado);
    }

    /**
     * Delega la accion de cancelar la orden al estado actual.
     */
    public void cancelar() {
        estadoActual.cancelar();
    }

    /**
     * Delega la accion de confirmar la orden al estado actual.
     */
    public void confirmar() {
        estadoActual.confirmar();
    }

    /**
     * Delega la accion de preparar la orden al estado actual.
     */
    public void preparar() {
        estadoActual.preparar();
    }

    /**
     * Delega la accion de entregar la orden al estado actual.
     */
    public void entregar() {
        estadoActual.entregar();
    }
}
