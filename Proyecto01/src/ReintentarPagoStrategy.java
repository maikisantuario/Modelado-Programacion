import java.util.Scanner;

/**
 * Estrategia que le pregunta al usuario si quiere intentar el pago otra vez o cancelar.
 */
public class ReintentarPagoStrategy implements IManejoFalloPagoStrategy {

    /**
     * Lector para leer la respuesta del usuario.
     */
    private Scanner scanner;

    /**
     * CCrea la estrategia con el lector de entrada
     *
     * @param scanner lector de entrada
     */
    public ReintentarPagoStrategy(Scanner scanner) {
	this.scanner = scanner;
    }

    /**
     * Consulta si el usuario quiere volver a intentar el pago o cancelar.
     *
     * @param sesion sesión activa
     * @return {@code true} si responde "s", {@code false} en otro caso
     */
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
