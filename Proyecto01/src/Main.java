import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase principal de la tienda virtual CheemsMart.
 * Administra el ciclo de inicio de sesión, selección de idioma, notificación
 * de ofertas, navegación del catálogo y flujo de compra por consola.
 */
public class Main {

    /** Lista de clientes registrados en el sistema. */
    private static List<ICliente> clientesRegistrados = new ArrayList<>();

    /** Proxy de acceso al catálogo de productos. */
    private static ICatalogo catalogo = new CatalogoProxy();

    /** Servidor encargado de generar y notificar ofertas a los clientes. */
    private static ServidorOfertas servidorOfertas = new ServidorOfertas();

    /**
     * Metodo principal que inicia la tienda y atiende las sesiones
     * hasta que se escriba salida.
     *
     * @param args Argumentos de linea de comandos.
     */
    public static void main (String[] args) {
	Scanner scanner = new Scanner(System.in);
	inicializarClientes();
	
	
	System.out.println("============= CheemsMart - Tienda en Linea =============");
	while (true) {
	    System.out.println("(🇲🇽escriba 'salida' para salir / 🇺🇸type 'salida' to exit / 🇮🇹digitare 'salida' per uscire)");
	    ICliente cliente = autenticarUsuario(scanner);
	    if (cliente == null)
		break;
	    ILocalizacionStrategy idioma = asignarEstrategiaIdioma(cliente.getPais());
	    System.out.println(idioma.saludar(cliente.getNombre()));
	    SesionSingleton.getInstancia().iniciarSesion(cliente, idioma);
	    servidorOfertas.generarOfertaAleatoria(idioma, cliente.getPais());
	    servidorOfertas.notificarObservador();
	    mostrarMenuTienda(scanner, idioma, cliente);
	}
	System.out.println("🇲🇽¡Hasta pronto! / 🇺🇸See you later! / 🇮🇹A presto!");
	

    }

    /**
     * Crea los clientes iniciales, los protege mediante {@link ClienteProxy},
     * los agrega a la lista de registrados y los suscribe al servidor de ofertas.
     */
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

	servidorOfertas.registrarObservador(cliente1);
	servidorOfertas.registrarObservador(cliente2);
	servidorOfertas.registrarObservador(cliente3);
    }

    /**
     * Solicita usuario y contrasena hasta autenticar a un cliente
     * o recibir la palabra salida.
     *
     * @param sc Scanner para leer la entrada por consola.
     * @return El cliente autenticado, o null si se indica salir.
     */
    private static ICliente autenticarUsuario(Scanner sc) {
	ICliente cliente = null;
	
	while (cliente == null) {
	    System.out.print("🇲🇽usuario / 🇺🇸username / 🇮🇹utente: \n > ");
	    String usuario = sc.nextLine();
	    if (usuario.equalsIgnoreCase("salida"))
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

    /**
     * Regresa la estrategia de localizacion correspondiente al pais del cliente.
     *
     * @param pais Pais del cliente.
     * @return La estrategia de idioma asociada.
     */
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

    /**
     * Muestra el menu principal de la tienda y atiende las opciones del cliente
     * mientras dure la sesion.
     *
     * @param sc      Scanner para leer la opcion elegida.
     * @param idioma  Estrategia de localizacion activa.
     * @param cliente Cliente autenticado en la sesion actual.
     */
    private static void mostrarMenuTienda(Scanner sc, ILocalizacionStrategy idioma, ICliente cliente){
	boolean sesion = true;
	while (sesion) {
	    System.out.println(idioma.mensajeMenuPrincipal());
	    
	    try {
		int opcion = Integer.parseInt(sc.nextLine());
		if (opcion == 1) {
		    ComponenteCatalogo raiz = catalogo.obtenerCatalogo();
		    raiz. mostrarIdentacion("");
		} else if (opcion == 2) {
		    realizarCompra(sc,idioma);
		} else if (opcion == 3) {
		    System.out.println(idioma.despedirse());
		    SesionSingleton.getInstancia().cerrarSesion();
		    sesion = false;
		} else {
		    System.out.println(idioma.mensajeErrorMenu());
		}
	    } catch (NumberFormatException e) {
		System.out.println(idioma.mensajeErrorMenu());
	    }
	}
    }

    /**
     * Gestiona el flujo de compra: permite agregar productos de uno en uno,
     * cancelar la compra o terminarla para pasar a la compra segura.
     *
     * @param sc     lector de consola compartido
     * @param idioma estrategia de localización del cliente
     */
    private static void realizarCompra(Scanner sc, ILocalizacionStrategy idioma){
	CarritoDeCompras carrito = SesionSingleton.getInstancia().getCarritoActual();
	boolean comprando = true;
	while (comprando) {
	    ComponenteCatalogo raiz = catalogo.obtenerCatalogo();
	    raiz. mostrarIdentacion("");
	    System.out.println(idioma.mensajeMenuCompra());
	    try {
		int opcion = Integer.parseInt(sc.nextLine());
		if (opcion == 1) {
		    // AGREGAR AL CARRITO
		    System.out.print("Codigo de barras: ");
		    String codigo = sc.nextLine().trim();
		    Producto p = catalogo.buscarProducto(codigo);
		    if (p == null) {
			System.out.println("Producto no encontrado.");
		    } else {
			carrito.agregarProducto(p);
			System.out.println("Agregado: " + p.getNombre());
		    }
		} else if (opcion == 2) {
		    // CANCELAR COMPRA
		    carrito.vaciarCarrito();
		    comprando = false;
		} else if (opcion == 3) {
		    // TERMINAR COMRPA
		    if (carrito.estaVacio()) {
			System.out.println("El carrito esta vacio.");
		    } else {
			IManejoFalloPagoStrategy fallo = new ReintentarPagoStrategy(sc);
			ProcesoCompraEstandar proceso = new ProcesoCompraEstandar(fallo, servidorOfertas, sc);
			proceso.ejecutarCompra();
			comprando = false;
		    }
		} else {
		    System.out.println(idioma.mensajeErrorMenu());
		}
	    } catch (NumberFormatException e) {
		System.out.println(idioma.mensajeErrorMenu());
	    }
	}			       
    } 
}
