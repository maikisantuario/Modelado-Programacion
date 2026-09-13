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

	System.out.println("Bienvenidx a las super batallas de Aura!!!!");
    }
}
