import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	Catalogo catalogo = new Catalogo();

	PeliculaIndividual p1 = new PeliculaIndividual("El Gato Ensombrerado", "Alessandro Carloni", 80, "Comedia", "Un travioso felino irrumpe en el hogar de dos niños.", 67.67);
	
	Saga sagaHarryPotter = new Saga("Harry Potter", "Adapta las novelas de J.K. Rowling a través de 8 películas principales (estrenadas entre 2001 y 2011) que narran la lucha de un joven mago contra el malvado Lord Voldemort.");
	PeliculaIndividual hp1 = new PeliculaIndividual("Harry Potter y la piedra filosofal", "Chris Columbus", 152, "Fantasia", "En su undécimo cumpleaños, Harry descubre que es un mago y es aceptado en Hogwarts.", 150.00);
	PeliculaIndividual hp2 = new PeliculaIndividual("Harry Potter y la camara secreta", "Chris Columbus", 161, "Fantasia", "Harry regresa a Hogwarts y enfrenta la misteriosa amenaza de la Cámara Secreta.", 150.00);
	PeliculaIndividual hp3 = new PeliculaIndividual("Harry Potter y el prisionero de Azkaban", "Alfonso Cuarón", 142, "Fantasia", "Sirius Black escapa de la prisión de Azkaban y busca a Harry.", 150.00);
	PeliculaIndividual hp4 = new PeliculaIndividual("Harry Potter y el caliz de fuego", "Mike Newell", 157, "Fantasia", "Harry es seleccionado de manera misteriosa para competir en el Torneo de los Tres Magos.", 150.00);
	PeliculaIndividual hp5 = new PeliculaIndividual("Harry Potter y la Orden del Fenix", "David Yates", 138, "Fantasia", "Harry y sus amigos forman el Ejército de Dumbledore ante el regreso no oficial de Voldemort.", 150.00);
	PeliculaIndividual hp6 = new PeliculaIndividual("Harry Potter y el misterio del principe", "David Yates", 153, "Fantasia", "Harry encuentra un antiguo libro de pociones perteneciente al Príncipe Mestizo mientras explora el pasado de Voldemort.", 150.00);
	PeliculaIndividual hp7 = new PeliculaIndividual("Harry Potter y las Reliquias de la Muerte - Parte 1", "David Yates", 146, "Fantasia", "Harry, Ron y Hermione emprenden la búsqueda para destruir los Horrocruxes fuera de Hogwarts.", 150.00);
	PeliculaIndividual hp8 = new PeliculaIndividual("Harry Potter y las Reliquias de la Muerte - Parte 2", "David Yates", 130, "Fantasia", "La batalla final entre las fuerzas del bien y Voldemort se desencadena en Hogwarts.", 150.00);
	sagaHarryPotter.agregar(hp1);
	sagaHarryPotter.agregar(hp2);
	sagaHarryPotter.agregar(hp3);
	sagaHarryPotter.agregar(hp4);
	sagaHarryPotter.agregar(hp5);
	sagaHarryPotter.agregar(hp6);
	sagaHarryPotter.agregar(hp7);
	sagaHarryPotter.agregar(hp8);
	
	Saga sagaLosHambrientos = new Saga("Los Juegos del Hambre", "Es una franquicia de cine distópica basada en las novelas de Suzanne Collins, ambientada en la nación totalitaria de Panem.");
	PeliculaIndividual jh1 = new PeliculaIndividual("Los Juegos del Hambre: Balada de Pajaros Cantores y Serpientes", "Francis Lawrence", 157, "Distopia", "Años antes de ser presidente, el joven Coriolanus Snow es mentor en los décimos Juegos del Hambre.", 3.99);
	PeliculaIndividual jh2 = new PeliculaIndividual("Los Juegos del Hambre: Amanecer en la Cosecha", "Francis Lawrence", 158, "Distopia", "Sigue la historia de Haymitch Abernathy durante el Segundo Vasallaje de los 25 (50º Juegos).", 4.99);
	PeliculaIndividual jh3 = new PeliculaIndividual("Los Juegos del Hambre", "Gary Ross", 142, "Distopia", "Katniss Everdeen se ofrece como voluntaria para salvar a su hermana en una competición a muerte.", 2.99);
	PeliculaIndividual jh4 = new PeliculaIndividual("Los Juegos del Hambre: En Llamas", "Francis Lawrence", 146, "Distopia", "Katniss y Peeta deben volver a luchar en el Vasallaje de los 25 contra antiguos campeones.", 2.99);
	PeliculaIndividual jh5 = new PeliculaIndividual("Los Juegos del Hambre: Sinsajo - Parte 1", "Francis Lawrence", 123, "Distopia", "Katniss se convierte en la figura simbólica de la rebelión desde el misterioso Distrito 13.", 3.99);
	PeliculaIndividual jh6 = new PeliculaIndividual("Los Juegos del Hambre: Sinsajo - Parte 2", "Francis Lawrence", 137, "Distopia", "La rebelión se dirige al Capitolio para dar el golpe final al Presidente Snow.", 3.99);
	sagaLosHambrientos.agregar(jh1);
	sagaLosHambrientos.agregar(jh2);
	sagaLosHambrientos.agregar(jh3);
	sagaLosHambrientos.agregar(jh4);
	sagaLosHambrientos.agregar(jh5);
	sagaLosHambrientos.agregar(jh6);

	DiscoMusical kidKrow = new DiscoMusical("Kid Krow", "Conan Gray", "Indie Pop", 2020, 190.00);
	DiscoMusical superache = new DiscoMusical("Superache", "Conan Gray", "Indie Pop", 2022, 200.00);
	DiscoMusical foundHeaven = new DiscoMusical("Found Heaven", "Conan Gray", "Pop / Synth-Pop", 2024, 220.00);
	DiscoMusical wishbone = new DiscoMusical("Wishbone", "Conan Gray", "Indie Pop", 2025, 210.00);

	catalogo.agregarProducto(new AdaptadorDiscoMusical(wishbone));
	catalogo.agregarProducto(new AdaptadorDiscoMusical(kidKrow));
	catalogo.agregarProducto(new AdaptadorDiscoMusical(superache));
	catalogo.agregarProducto(new AdaptadorDiscoMusical(foundHeaven));
	catalogo.agregarProducto(p1);
	catalogo.agregarProducto(sagaHarryPotter);
	catalogo.agregarProducto(hp1);
	catalogo.agregarProducto(hp2);
	catalogo.agregarProducto(hp3);
	catalogo.agregarProducto(hp4);
	catalogo.agregarProducto(hp5);
	catalogo.agregarProducto(hp6);
	catalogo.agregarProducto(hp7);
	catalogo.agregarProducto(hp8);
	catalogo.agregarProducto(sagaLosHambrientos);
	catalogo.agregarProducto(jh1);
	catalogo.agregarProducto(jh2);
	catalogo.agregarProducto(jh3);
	catalogo.agregarProducto(jh4);
	catalogo.agregarProducto(jh5);
	catalogo.agregarProducto(jh6);
	
	boolean salir = false;
	while (!salir) {
	    System.out.println("======= Bienvenidx a la Tienda de Peliculas y Musica RockBuster =======");
	    System.out.println("Escoga la accion que desee realizar: ");
	    System.out.println("1. Ver el catálogo completo");
	    System.out.println("2. Filtrar por género");
	    System.out.println("3. Filtrar por un costo máximo");
	    System.out.println("4. Salir");
	    System.out.print("> ");

	    String opc = scanner.nextLine();

	    switch(opc) {
	    case "1":
		catalogo.mostrarCatalogoCompleto();
		seleccionarDetallesProducto(catalogo, scanner);
		break;
	    case "2":
		System.out.print("\nEspecifique el género a filtrar: ");
		String genero = scanner.nextLine();
		catalogo.filtrarPorGenero(genero);
		seleccionarDetallesProducto(catalogo, scanner);
		break;
	    case "3":
		System.out.print("\nEspecifique el costo máximo de precio: ");
		try {
		    double max = Double.parseDouble(scanner.nextLine());
		    catalogo.filtrarPorCostoMaximo(max);
		    seleccionarDetallesProducto(catalogo, scanner);
		} catch (NumberFormatException e) {
		    System.out.println("Monto inválido. Ingrese un valor numérico.");
		}
		break;
	    case "4":
		salir = true;
		System.out.println("Gracias por visitarnos, esperamos hayas encontrado todo lo que necesitas!!! :D");
		break;
	    default:
		System.out.println("Opcion Invalida. Intente de nuevo.");
		break;
	    }
	}
	scanner.close();
    }

    /**
     * Método auxiliar para solicitar al usuario un número de producto y mostrar sus detalles.
     * @param catalogo Instancia del catálogo de la tienda.
     * @param scanner Escáner de consola.
     */
    private static void seleccionarDetallesProducto(Catalogo catalogo, Scanner scanner) {
	System.out.print("Seleccione el numero del producto para poder ver sus detalles: (Seleccione 0 para volver)\n> ");
	try {
            int opcion = Integer.parseInt(scanner.nextLine());
	    if (opcion == 0) return;
	    Producto p = catalogo.obtenerProductoPorIndice(opcion - 1);
            if (p != null) {
		System.out.println("\nMostrando detalles del Producto...");
                p.mostrarDetalle();
            } else {
                System.out.println("Número fuera de rango.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Regresando al menú principal...");
        }
    }
}
