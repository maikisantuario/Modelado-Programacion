import java.util.Scanner;
/**
 * Clase principal de ejecucion. Registra al menos 5 ninjas y 10 aspirantes,
 * ejecuta la logica de la academia y despliega el resumen general.
 */
public class Main {
    /**
     * Punto de entrada del programa.
     * @param args Argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  ALDEA DE LAS CIENCIAS - ACADEMIA NINJA VICKAGE  ");
        System.out.println("==================================================\n");
	
	Scanner scanner = new Scanner(System.in);
	AcademiaNinjas academia = new AcademiaNinjas(10);
	System.out.println("Registro del aspirante interesadx:");
	System.out.print("Nombre: ");
	String nombre = scanner.nextLine();
	int edad = 0;
        while (edad <= 0) {
            System.out.print("Edad: ");
            try {
                edad = Integer.parseInt(scanner.nextLine().trim());
                if (edad <= 0) System.out.println("Por favor ingresa una edad válida.");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número entero para la edad.");
            }
        }
	System.out.println("Clan de procedencia: ");
	System.out.println("1.Fuchiha");
	System.out.println("2.Osomaki");
	System.out.println("3.Naca");
	System.out.println("4.Mortalika");
	System.out.println("5.Akipichi");
	System.out.print(">");

	String opcion = scanner.nextLine();
	String clan = "";

	switch(opcion) {
	case "1": clan = "Fuchiha";
	    break;
	case "2": clan = "Osomaki";
	    break;
	case "3": clan = "Naca";
	    break;
	case "4": clan = "Mortalika";
	    break;
	case "5": clan = "Akipichi";
	    break;
	default:
	    System.out.println("Porfavor, determine su clan de procedencia.");
	}

	int nivelHabilidad = 0;
	while (nivelHabilidad < 1 || nivelHabilidad > 3) {
	    System.out.print("Nivel de Habilidad (1-3): ");
	    try {
		nivelHabilidad = Integer.parseInt(scanner.nextLine());
		if (nivelHabilidad < 1 || nivelHabilidad > 3) {
		    System.out.println("Los niveles de Habilidad son de 1-3. Intenta de nuevo.");
		}
	    } catch (NumberFormatException e) {
		System.out.println("Por favor, ingresa un número válido entre 1 y 3.");
	    }
	}

        academia.registrarAspirante(new Aspirante(nombre, edad, clan, nivelHabilidad));

        /** Registro de al menos 5 Ninjas Voluntarios */
        academia.registrarNinja(new NinjaVoluntario("Kakashi", 27, "Fuchiha", "jonin", 6));
        academia.registrarNinja(new NinjaVoluntario("Iruka", 25, "Naca", "chunin", 4));
        academia.registrarNinja(new NinjaVoluntario("Ebisu", 28, "Osomaki", "chunin", 5));
        academia.registrarNinja(new NinjaVoluntario("Gekkō", 23, "Mortalika", "genin", 4));
        academia.registrarNinja(new NinjaVoluntario("Shizune", 28, "Akipichi", "jonin", 6));

        /** Registro de al menos 10 Aspirantes */
        academia.registrarAspirante(new Aspirante("Aang", 12, "Osomaki", 2));
        academia.registrarAspirante(new Aspirante("Toph", 12, "Fuchiha", 3));
        academia.registrarAspirante(new Aspirante("Zuko", 16, "Naca", 1));
        academia.registrarAspirante(new Aspirante("Shikamaru", 12, "Mortalika", 3));
        academia.registrarAspirante(new Aspirante("Katara", 14, "Akipichi", 2));
        academia.registrarAspirante(new Aspirante("Azula", 14, "Naca", 2));
        academia.registrarAspirante(new Aspirante("Sokka", 15, "Akipichi", 2));
        academia.registrarAspirante(new Aspirante("Iroh", 60, "Naca", 1));
        academia.registrarAspirante(new Aspirante("Suki", 15, "Mortalika", 3));
        academia.registrarAspirante(new Aspirante("Appa", 13, "Akipichi", 2));
        academia.registrarAspirante(new Aspirante("Momo", 13, "Naca", 2));

	System.out.println("==================================================");
	System.out.println("Formando grupos...\n");
	System.out.println("==================================================");
        academia.formarGrupos();

	System.out.println("==================================================");
	System.out.println("Asignación de paquetes de herramientas y campos...");
        System.out.println("==================================================");
	academia.asignarPaquetesYCampos();

	scanner.close();
    }
}
