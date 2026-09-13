import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que se encarga de ser el orquestador del programa
 * concentrándose en la interacción inicial con el usuario y la
 * inicialización de los objetos principales.
 */

public class Main {

    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AZUL = "\u001B[34m";
    public static final String MORADO = "\u001B[35m";
    public static final String ROSA = "\u001B[38;2;255;182;193m";
    public static final String RESET = "\u001B[0m";
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArenaCombate arena = new ArenaCombate();
        List<Combatiente> luchadores = new ArrayList<>();

	System.out.print("Bienvenidx a las super batallas de Aura!!!!\n"+
			 "Ingresa un ID de usuario de tu preferencia:\n >");
	String IDUsuario = scanner.nextLine();

	String luchadorFavorito = "";
	boolean opcionLuchadorValida = false;

	while (!opcionLuchadorValida) {
	    System.out.println("\nEscoja a su luchador favorito:");
	    System.out.println("1. Dittuu");
            System.out.println("2. Korby");
            System.out.println("3. MeganMan");
            System.out.print("> ");

	    String opcionLuchador = scanner.nextLine();

	    switch (opcionLuchador) {
	    case "1":
		luchadorFavorito = "Dittuu";
		System.out.println("\nHas escogido a " + MORADO + "Dittuu\n" +
				   "Habilidades:\n> ☣️ AgujaToxica\n> 🍮 GelatinaDuplicadora\n> ⛈️ VidaTormentosa\n" +
				   "¡Sientan cómo mi aura consume sus esperanzas!" + RESET);
		opcionLuchadorValida = true;
		break;
	    case "2":
		luchadorFavorito = "Korby";
		System.out.println("\nHas escogido a " + ROSA + "Korby\n" +
				   "Habilidades:\n> ❄️ LetItGo\n> 😮‍💨 ElDab-67\n> 😍 ElMasTiernoDelCondado\n" +
				   "¡Tan bonito que te puedes moriiiir!" + RESET);
		opcionLuchadorValida = true;
		break;
	    case "3":
		luchadorFavorito = "MeganMan";
		System.out.println("\nHas escogido a " + AZUL + "MegaMan\n" +
				   "Habilidades:\n> ⚔️ Espada\n> 💣 Bomba\n> 🤖 Mini\n" +
				   "¡Sistema de combate activado! ¡A farmear aura!" + RESET);
		opcionLuchadorValida = true;
		break;
	    default:
		System.out.println("Opción no válida. Por favor, seleccione a uno de los 3 luchadores.");
		break;
	    }
	}
	// Instanciación del usuario como espectador
	//Observador usuario = new Observador(IDUsuario, luchadorFavorito);
	//arena.registrar(usuario);

	/* Creación e inclusión de los combatientes
	   luchadores.add(new Dittuu());
	   luchadores.add(new Korby());
	   luchadores.add(new MeganMan());

	   // Inicio del bucle de simulación
	   // Arena.iniciarPelea(luchadores); */

        scanner.close();
	
    }
}
