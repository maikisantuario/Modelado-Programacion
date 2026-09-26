/**
 * Representa el estado inactivo o dormido del Robot.
 */
public class EstadoDormido implements EstadoRobot {
    private Robot robot;

    /**
     * Constructor del estado dormido.
     * 
     * @param robot Referencia al robot.
     */
    public EstadoDormido(Robot robot) {
	this.robot = robot;
    }

    @Override
    public void llamar() {
	System.out.println("Robot despertando... Hola! En que puedo ayudarte?");
	robot.setEstado(new EstadoAtendiendo);
    }

    @Override
    public void ordenarPizza(Pizza pizza) {
        System.out.println("El robot esta dormido. Primero debes llamarlo.");
    }

    @Override
    public void ordenarHelado(Helado helado) {
        System.out.println("El robot esta dormido. Primero debes llamarlo.");
    }

    @Override
    public void cancelar() {
        System.out.println("El robot esta dormido, no hay orden que cancelar.");
    }
    
    @Override
    public void confirmar() {
        System.out.println("El robot esta dormido, no hay orden que confirmar.");
    }

    @Override
    public void preparar() {
        System.out.println("El robot esta dormido, no puede preparar nada.");
    }

    @Override
    public void entregar() {
        System.out.println("El robot esta dormido, no hay orden que entregar.");
    }
}
