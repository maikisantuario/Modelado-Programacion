import.java.util.Scanner;

/**
 * Estrategia que permite al cliente reintentar ingresar su cuenta o cancelar la compra.
 */
public class ReintentarPagoStrategy implements IManejoFalloPagoStrategy {

    /**
     * Lector de consola para capturar la decisión del usuario.
     */
    private Scanner scanner;

    /**
     * Construye la estrategia con un lector de consola.
     *
     * @param scanner lector de entrada
     */
    public ReintentarPagoStrategy(Scanner scanner) {
	this.scanner = scanner;
    }

    @Override
    public boolean manejarFallo(SesionSingleton sesion) {
	System.out.print("¿Deseas reintentar? (s/n): ");
	String respuesta = scanner.nextLine().trim().toLowerCase();
	if ("s".equals(respuesta)) {
	    return true;
	}
	System.out.println("Compra cancelada.");
	return false;
    }
}
