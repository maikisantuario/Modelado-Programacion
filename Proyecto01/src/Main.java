import java.util.Scanner;
import java.util.List;

public class Main {
    private static List<ICliente> clientesRegistrados;
    private static ICatalogo catalogo;
    private static ServidorOfertas servidorOfertas;

    public static void main (String[] args) {
	Scanner scanner = new Scanner(System.in);
	inicializarClientes();

	System.out.println("============= CheemsMart - Tienda en Linea =============");
	while (autenticarUsuario() == null) {
	    
	    autenticarUsuario(scanner);
	}
	
	// saludar() -> usario se registra -> menú con las opciones de: ver catálogo, realizar una compra, o salir. ->
    }
    
    private static void inicializarClientes(){
	ClienteReal cliente1 = new ClienteReal("SIGMA67", "regsoav", "c0n7r4s3n4", "Regina", "5566667777", "Arboledas 12 Col Ampliacion Tepepan Xochimilco CMDX", "12345678910", "Mexico", 30000);
	ClienteReal cliente2 = new ClienteReal("SABC234", "cirosdiego", "c0n7r4s3n42", "Diego", "5512345678", "Arboledas 13 Col Ampliacion Tepepan Xochimilco CMDX", "12345678912", "Italia", 30000);
	ClienteReal cliente3 = new ClienteReal("LOLI74S", "maikisantuario", "c0n7r4s3n43", "Maiki", "5512345678", "Arboledas 13 Col Ampliacion Tepepan Xochimilco CMDX", "12345678913", "Italia", 30000);
	clientesRegistrados.add(cliente1);
	clientesRegistrados.add(cliente2);
	clientesRegistrados.add(cliente3);
    }
    private static ICliente autenticarUsuario(Scanner sc) {
	System.out.print("Ingrese su usuario: ");
	String usuario = sc.nextLine();
	System.out.print("Ingrese su contrasena: ");
	String contrasena = sc.nextLine();
	for (ICliente c : clientesRegistrados)
	    if (!c.equals(sc)) {
	    return null;
	    }
	else
	    return null;
	return null;
    }
    private static ILocalizacionStrategy asignarEstrategiaIdioma(String pais){
	return null;    }
    private static void mostrarMenuTienda(Scanner sc){
	return;
    }
}
