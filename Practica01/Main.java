import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

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
        List<Combatiente> luchadores = new ArrayList<>();

	System.out.print("Bienvenidx a las super batallas de Aura!!!!\n"+
			 "Ingresa un ID de usuario de tu preferencia:\n > ");
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
				   "Habilidades:\n> ☣️ AgujaToxica\n> 🦠 GelatinaDuplicadora\n> ⛈️ VidaTormentosa\n" +
				   "¡Sientan cómo mi aura consume sus esperanzas!\n" + RESET);
		opcionLuchadorValida = true;
		break;
	    case "2":
		luchadorFavorito = "Korby";
		System.out.println("\nHas escogido a " + ROSA + "Korby\n" +
				   "Habilidades:\n> ❄️ LetItGo\n> 💨 ElDab-67\n> 🥰 ElMasTiernoDelCondado\n" +
				   "¡Lo que tengo de tierno lo tengo de aura! uwu\n" + RESET);
		opcionLuchadorValida = true;
		break;
	    case "3":
		luchadorFavorito = "MeganMan";
		System.out.println("\nHas escogido a " + AZUL + "MeganMan\n" +
				   "Habilidades:\n> ⚔️ Espada\n> 💣 Bomba\n> 🤖 Mini\n" +
				   "¡Sistema de combate activado! ¡A farmear aura!\n" + RESET);
		opcionLuchadorValida = true;
		break;
	    default:
		System.out.println("Opción no válida. Por favor, seleccione a uno de los 3 luchadores.");
		break;
	    }
	}
	ArenaCombate arena = new ArenaCombate();
	// Instanciación del usuario como espectador
	Espectador usuario = new Espectador(IDUsuario, luchadorFavorito);
	arena.registrar(usuario);
	// Inicio del bucle de simulación
	Random random = new Random();
	int opcionCaso = random.nextInt(4) + 1;

	System.out.println("\n**********************************************************************************");
	System.out.println("¡¡¡Dentro de la arena tenemos a Korby, a Dittu y a Meganman!!!");
	switch (opcionCaso) {
	case 1:
	    System.out.println("¡QUE LA BATALLA DE AURA COMIENCE Y QUE GANE EL MAS SIGMA!");
	    luchadores = caso1();
	    break;
	case 2:
	    System.out.println("¡QUE LA BATALLA DE AURA COMIENCE Y QUE GANE EL MAS SIXSEVEN!");
	    luchadores = caso2();
	    break;
	case 3:
	    System.out.println("¡QUE LA BATALLA DE AURA COMIENCE Y QUE GANE EL MAS ALPHA!");
	    luchadores = caso3();
	    break;
	case 4:
	    System.out.println("¡QUE LA BATALLA DE AURA COMIENCE Y QUE GANE EL QUE TENGA QUE GANAR!");
	    luchadores = caso4();
	    break;
	}
	
	System.out.println("**********************************************************************************");
	ejecutarBatalla(arena, luchadores);
        scanner.close();	
    }

    
    
    private static List<Combatiente> caso1() {
	Combatiente dittuu = new Dittuu();
	Combatiente korby = new Korby();
	Combatiente meganMan = new MeganMan();
	
        List<Combatiente> lista = new ArrayList<>();
        dittuu.setEstrategia(new EstrategiaDittuuAgujaToxica());
        korby.setEstrategia(new EstrategiaKorbyLetItGo());
	meganMan.setEstrategia(new EstrategiaMeganManEspada());

	lista.add(dittuu);
	lista.add(korby);
	lista.add(meganMan);
        return lista;
    }
    private static List<Combatiente> caso2() {
	Combatiente dittuu = new Dittuu();
	Combatiente korby = new Korby();
	Combatiente meganMan = new MeganMan();

        List<Combatiente> lista = new ArrayList<>();
        dittuu.setEstrategia(new EstrategiaDittuuGelatinaDuplicadora());
	korby.setEstrategia(new EstrategiaKorbyElTierno());
	meganMan.setEstrategia(new EstrategiaMeganManBomba());

	lista.add(dittuu);
	lista.add(korby);
	lista.add(meganMan);
	return lista;
    }

    private static List<Combatiente> caso3() {
	Combatiente dittuu = new Dittuu();
	Combatiente korby = new Korby();
	Combatiente meganMan = new MeganMan();

	List<Combatiente> lista = new ArrayList<>();
	dittuu.setEstrategia(new EstrategiaDittuuVidaTormentosa());
	korby.setEstrategia(new EstrategiaKorbyDab67());
	meganMan.setEstrategia(new EstrategiaMeganManMini());

	lista.add(dittuu);
	lista.add(korby);
	lista.add(meganMan);
	return lista;
    }

    private static List<Combatiente> caso4() {
	Combatiente dittuu = new Dittuu();
	Combatiente korby = new Korby();
	Combatiente meganMan = new MeganMan();
	Random random = new Random();
	
	// Asignar estrategia aleatoria a Dittuu (3 opciones)
	switch (random.nextInt(3)) {
        case 0: dittuu.setEstrategia(new EstrategiaDittuuAgujaToxica()); break;
        case 1: dittuu.setEstrategia(new EstrategiaDittuuGelatinaDuplicadora()); break;
        case 2: dittuu.setEstrategia(new EstrategiaDittuuVidaTormentosa()); break;
	}

	// Asignar estrategia aleatoria a Korby (3 opciones)
	switch (random.nextInt(3)) {
        case 0: korby.setEstrategia(new EstrategiaKorbyLetItGo()); break;
        case 1: korby.setEstrategia(new EstrategiaKorbyElTierno()); break;
        case 2: korby.setEstrategia(new EstrategiaKorbyDab67()); break;
	}

	// Asignar estrategia aleatoria a MeganMan (3 opciones)
	switch (random.nextInt(3)) {
        case 0: meganMan.setEstrategia(new EstrategiaMeganManEspada()); break;
        case 1: meganMan.setEstrategia(new EstrategiaMeganManBomba()); break;
        case 2: meganMan.setEstrategia(new EstrategiaMeganManMini()); break;
	}

	List<Combatiente> lista = new ArrayList<>();
	lista.add(dittuu);
	lista.add(korby);
	lista.add(meganMan);
	return lista;
    }

    private static void ejecutarBatalla(ArenaCombate arena, List<Combatiente> luchadores) {
        Random random = new Random();
        int ronda = 1;

        while (ronda <= 6) {
            Combatiente atacante = obtenerLuchador(luchadores, random, null);
            Combatiente defensor = obtenerLuchador(luchadores, random, atacante);

            boolean seDefiende = random.nextBoolean();

            if (random.nextInt(100) < 25) {
                arena.generarYConsumirObjeto(atacante);
            }

	    arena.procesarAtaque(atacante, defensor, seDefiende, luchadores);
	    ronda++;
        }

        Combatiente ganador = obtenerGanador(luchadores);
        if (ganador != null) {
            System.out.println("\n**********************************************************************************");
            arena.finalizar(ganador.getNombre() + " con " + ganador.getAura() + " pts de Aura 🔥!");
            System.out.println("**********************************************************************************");
        }
    }

    private static Combatiente obtenerLuchador(List<Combatiente> lista, Random random, Combatiente excluido) {
        List<Combatiente> candidatos = new ArrayList<>();
        for (Combatiente c : lista) {
            if (c.tieneAura() && c != excluido) {
                candidatos.add(c);
            }
        }
        return candidatos.get(random.nextInt(candidatos.size()));
    }
    
    private static Combatiente obtenerGanador(List<Combatiente> lista) {
        Combatiente ganador = null;
        int maxAura = -1;
        for (Combatiente c : lista) {
            if (c.getAura() > maxAura) {
                maxAura = c.getAura();
                ganador = c;
            }
        }
        return ganador;
    }
}
