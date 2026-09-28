/**
 * Representa el estado donde el Robot ya recibio la confirmacion de la orden
 * y espera la indicacion para comenzar la a preparar la orden.
 */
public class EstadoConfirmado implements EstadoRobot {
    private Robot robot;

    /**
     * Constructor del estado confirmado.
     * 
     * @param robot Referencia al robot.
     */
    public EstadoConfirmado(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("\nEl robot ya te esta atendiendo y tu orden esta confirmada.");
    }

    @Override
    public void ordenarPizza(Pizza pizza) {
        System.out.println("\nLa orden ya fue confirmada. No puedes agregar mas pizzas.");
    }

    @Override
    public void ordenarHelado(Helado helado) {
        System.out.println("\nLa orden ya fue confirmada. No puedes agregar mas helados.");
    }

    @Override
    public void cancelar() {
        System.out.println("\n¡Lo siento! No me es posible cancelar una orden que ya ha sido confirmada UnU.");
    }

    @Override
    public void confirmar() {
        System.out.println("\nLa orden ya esta confirmada. Solo falta indicar que se prepare.");
    }

    @Override
    public void preparar() {
        System.out.println("\nIniciando la preparacion de la orden...");
        robot.setEstado(new EstadoPreparando(robot));
    }

    @Override
    public void entregar() {
        System.out.println("\nLa orden aun no esta preparada, todavia no se puede entregar.");
    }
}
