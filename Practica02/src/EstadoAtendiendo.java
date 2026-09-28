/**
 * Representa el estado en el que el Robot esta listo para recibir un pedido.
 */
public class EstadoAtendiendo implements EstadoRobot {
    private Robot robot;

    /**
     * Constructor del estado atendiendo.
     * 
     * @param robot Referencia al robot.
     */
    public EstadoAtendiendo(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("El robot ya te esta atendiendo.");
    }

    @Override
    public void ordenarPizza(Pizza pizza) {
        robot.setPizzaOrdenada(pizza);
        System.out.println("Pizza agregada al pedido: " + pizza.getDescripcion());
    }

    @Override
    public void ordenarHelado(Helado helado) {
        robot.setHeladoOrdenado(helado);
        System.out.println("Helado agregado al pedido: " + helado.getDescripcion());
    }

    @Override
    public void cancelar() {
        System.out.println("Orden cancelada. Volviendo a modo dormido.");
        robot.setEstado(new EstadoDormido(robot));
    }

    @Override
    public void confirmar() {
        robot.setEstado(new EstadoConfirmado(robot));
        System.out.println("\nOrden, confirmada :)");
    }

    @Override
    public void preparar() {
        System.out.println("No hay orden seleccionada para preparar.");
    }

    @Override
    public void entregar() {
        System.out.println("No hay orden lista para entregar.");
    }
}