/**
 * Interfaz que define las acciones posibles para los estados del Robot.
 * Implementa el patron de disenio State.
 */
public interface EstadoRobot {
    /**
     * Accion de llamar o despertar al robot.
     */
    void llamar();

    /**
     * Accion de agregar una pizza a la orden.
     * 
     * @param pizza La pizza que se desea ordenar.
     */
    void ordenarPizza(Pizza pizza);

    /**
     * Accion de agregar un helado a la orden.
     * 
     * @param helado El helado que se desea ordenar.
     */
    void ordenarHelado(Helado helado);

    /**
     * Accion de cancelar la orden actual.
     */
    void cancelar();

    /**
     * Accion de confirmar la orden actual para pasar a preparacion.
     */
    void confirmar();

    /**
     * Accion de preparar la orden actual.
     */
    void preparar();

    /**
     * Accion de entregar la orden al cliente.
     */
    void entregar();
}
