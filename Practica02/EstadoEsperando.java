/**
 * Representa el estado donde el Robot ya recibio productos y espera confirmacion o modificaciones.
 */
public class EstadoEsperando implements EstadoRobot {
    private Robot robot;

    /**
     * Constructor del estado esperando.
     * 
     * @param robot Referencia al robot.
     */
    public EstadoEsperando(Robot robot) {
	this.robot = robot;
    }

    @Override
    public void llamar() {
	System.out.println("El robot ya te esta atendiendo.");
    }

    @Override
    public void ordenarPizza(Pizza pizza) {
	robot.setPizzaOrdenada(pizza);
	System.out.println("Pizza actualizada en la orden: " + pizza.getDescripcion());
    }
    @Override
    public void ordenarHelado(Helado helado) {
        robot.setHeladoOrdenado(helado);
        System.out.println("Helado actualizado en la orden: " + helado.getDescripcion());
    }

    @Override
    public void cancelar() {
        System.out.println("Orden cancelada. Regresando a modo dormido.");
        robot.setPizzaOrdenada(null);
        robot.setHeladoOrdenado(null);
        robot.setEstado(new EstadoDormido(robot));
    }

    @Override
    public void confirmar() {
        System.out.println("Orden confirmada. Pasando a cocina para preparacion.");
        robot.setEstado(new EstadoPreparando(robot));
    }

    @Override
    public void preparar() {
        System.out.println("Debes confirmar la orden antes de comenzar a preparar.");
    }

    @Override
    public void entregar() {
        System.out.println("La orden aun no ha sido preparada.");
    }
}
	
