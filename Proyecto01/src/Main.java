import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static List<ICliente> clientesRegistrados = new ArrayList<>();
    private static ICatalogo catalogo = new CatalogoProxy();
    private static ServidorOfertas servidorOfertas;

    public static void main (String[] args) {
	Scanner scanner = new Scanner(System.in);
	inicializarClientes();
	
	System.out.println("============= CheemsMart - Tienda en Linea =============");
	while (true) {
	    ICliente cliente = autenticarUsuario(scanner);
	    if (cliente == null)
		break;
	    ILocalizacionStrategy idioma = asignarEstrategiaIdioma(cliente.getPais());
	    System.out.println(idioma.saludar(cliente.getNombre()));
	    mostrarMenuTienda(scanner, idioma, cliente);
	}
	System.out.println("🇲🇽¡Hasta pronto! / 🇺🇸See you later! / 🇮🇹A presto!");
	

    }
    
    private static void inicializarClientes(){
	ClienteReal clienteReal1 = new ClienteReal("SIGMA67", "regsoav", "c0n7r4s3n4", "Regina", "5566667777", "Arboledas 12 Col Ampliacion Tepepan Xochimilco CDMX", "12345678910", "Mexico", 30000);
	ClienteReal clienteReal2 = new ClienteReal("SABC234", "cirosdiego", "c0n7r4s3n42", "Diego", "5512345678", "Via Regina 98 Como Brienno", "12345678912", "Italia", 30000);
	ClienteReal clienteReal3 = new ClienteReal("LOLI74S", "maikisantuario", "c0n7r4s3n43", "Maiki", "5512345678", "San Jose 40 Street Road  California USA", "12345678913", "Estados Unidos", 3000);
	ICliente cliente1 = new ClienteProxy(clienteReal1);
	ICliente cliente2 = new ClienteProxy(clienteReal2);
	ICliente cliente3 = new ClienteProxy(clienteReal3);

	clientesRegistrados.add(cliente1);
	clientesRegistrados.add(cliente2);
	clientesRegistrados.add(cliente3);
    }
    
    private static ICliente autenticarUsuario(Scanner sc) {
	ICliente cliente = null;
	
	while (cliente == null) {
	    System.out.print("🇲🇽usuario / 🇺🇸username / 🇮🇹utente: \n > ");
	    String usuario = sc.nextLine();
gg	    if (usuario.equalsIgnoreCase("salida"))
		return null;
	    System.out.print("🇲🇽contrasena / 🇺🇸🇮🇹password: \n > ");
	    String contrasena = sc.nextLine();
	    for (ICliente c : clientesRegistrados) {
		if (c.getUsuario().equalsIgnoreCase(usuario) && c.validarContrasena(contrasena)) {
		    cliente = c;
		}
	    }
	    if  (cliente == null)
		System.out.println(" 🇲🇽Usuario o contrasena incorrectos, Vuelva a intentarlo. \n 🇺🇸Incorrect  username or password, Please try again. \n 🇮🇹Nome utente o password non corretti. Riprova.");
	}
	return cliente;
    }
    
    private static ILocalizacionStrategy asignarEstrategiaIdioma(String pais){
	ItalianoStrategy italiano = new ItalianoStrategy();
	EspanolLatinoStrategy espanol = new EspanolLatinoStrategy();
	InglesUsaStrategy ingles = new InglesUsaStrategy();
	if (pais.equalsIgnoreCase("Italia")) {
	    return italiano;
	}
	if (pais.equalsIgnoreCase("Mexico")) {
	    return espanol;
	}
	if (pais.equalsIgnoreCase("Estados Unidos")) {
	    return ingles;
	}
	return espanol;
    }
    private static void mostrarMenuTienda(Scanner sc, ILocalizacionStrategy idioma, ICliente cliente){
	boolean sesion = true;
	while (sesion) {
	    System.out.println(idioma.mensajeMenuPrincipal());
	    try {
		int opcion = Integer.parseInt(sc.nextLine());
		if (opcion == 1) {
		    // cliente.obtenerCatalogo();
		} else if (opcion == 2) {
		    // compra
		} else if (opcion == 3) {
		    System.out.println(idioma.despedirse());
		    sesion = false;
		    //return opcion;
		} else {
		    System.out.println(idioma.mensajeErrorMenu());
		}
	    } catch (NumberFormatException e) {
		System.out.println(idioma.mensajeErrorMenu());
	    }
	}
    }
}
