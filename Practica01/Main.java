import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase principal que se encarga de ser el orquestador del programa
 * concentrándose en la interacción inicial con el usuario y la
 * inicialización de los objetos principales.
 */

public class Main {

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
		System.out.println("\nHas escogido a Dittuu\n" +
				   "Habilidades:\n> ☣️ AgujaToxica\n> 🍮 GelatinaDuplicadora\n> ⛈️ VidaTormentosa\n" +
				   "¡Sientan cómo mi aura consume sus esperanzas!");
		opcionLuchadorValida = true;
		break;
	    case "2":
		luchadorFavorito = "Korby";
		System.out.println("\nHas escogido a Korby\n" +
				   "Habilidades:\n>Habilidad1\n>Habilidad2\n>Habilidad3\n" +
				   "catchfrase");
		opcionLuchadorValida = true;
		break;
	    case "3":
		luchadorFavorito = "MegaMan";
		System.out.println("\nHas escogido a MegaMan\n" +
				   "Habilidades:\n>Habilidad1\n>Habilidad2\n>Habilidad3\n" +
				   "'catchfrase'");
		opcionLuchadorValida = true;
		break;
	    default:
		System.out.println("Opción no válida. Por favor, seleccione a uno de los 3 luchadores.");
		break;
	    }
	}
	/* Instanciación del usuario como espectador
        Espectador usuario = new Espectador(IDUsuario, luchadorFavorito);
        arena.registrar(usuario);

        // Creación e inclusión de los combatientes
        luchadores.add(new Dittuu());
        luchadores.add(new Korby());
        luchadores.add(new MeganMan());

        // Inicio del bucle de simulación
	// Arena.iniciarPelea(luchadores); */

        scanner.close();
	
    }
}
