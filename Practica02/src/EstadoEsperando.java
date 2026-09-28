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
	System.out.println("\nEl robot ya te esta atendiendo.");
    }

    @Override
    public void ordenarPizza(Pizza pizza) {
	System.out.println("\nYa no se pueden agregar productos, esperando indicacion para la entrega.");
    }
    @Override
    public void ordenarHelado(Helado helado) {
	System.out.println("\nYa no se pueden agregar productos, esperando indicacion para la entrega.");
    }

    @Override
    public void cancelar() {
        System.out.println("\nNo es posible cancelar una orden que ya esta Preparada.");;
    }

    @Override
    public void confirmar() {
        System.out.println("\nOrden confirmada y preparada, esperando indicacion para la entrega.");
    }

    @Override
    public void preparar() {
        System.out.println("\nOrden preparada, esperando indicacion para la entrega.");
    }

    @Override
    public void entregar() {
	System.out.println("\nEntregando orden completada al cliente. Buen provecho!");
	robot.setEstado(new EstadoDormido(robot));
	robot.setPizzaOrdenada(null);
	robot.setHeladoOrdenado(null);
    }
}
	
