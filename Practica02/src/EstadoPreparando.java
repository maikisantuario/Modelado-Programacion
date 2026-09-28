/**
 * Representa el estado donde el Robot esta preparando y listo para entregar los alimentos.
 */
public class EstadoPreparando implements EstadoRobot {
    private Robot robot;

    /**
     * Constructor del estado preparando.
     * 
     * @param robot Referencia al robot.
     */
    public EstadoPreparando(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void llamar() {
        System.out.println("\nEl robot esta ocupado en la cocina.");
    }

    @Override
    public void ordenarPizza(Pizza pizza) {
        System.out.println("\nNo se pueden agregar productos mientras se esta preparando la orden.");
    }

    @Override
    public void ordenarHelado(Helado helado) {
        System.out.println("\nNo se pueden agregar productos mientras se esta preparando la orden.");
    }

    @Override
    public void cancelar() {
        System.out.println("\nNo es posible cancelar una orden que ya esta en preparacion.");
    }

    @Override
    public void confirmar() {
        System.out.println("\nLa orden ya fue confirmada y esta preparandose.");
    }

    @Override
    public void preparar() {
	System.out.println("\n====== INICIANDO PREPARACIÓN DE LA ORDEN ======");
	if (robot.getPizzaOrdenada() != null) {
	    robot.getPizzaOrdenada().prepararPizza();
	}
	if (robot.getHeladoOrdenado() != null) {
	    System.out.println("\n------ Preparando Helado ------");
	    System.out.println("Detalle: " + robot.getHeladoOrdenado().getDescripcion());
	}
	System.out.println("\n¡Orden preparada exitosamente! Listo para entregar.");
	robot.setEstado(new EstadoEsperando(robot));
    }

    @Override
    public void entregar() {
	System.out.println("\nLa orden aun no ha sido preparada.");
    }
}
