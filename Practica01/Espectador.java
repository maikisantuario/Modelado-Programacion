import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa a un espectador de la pelea.
 * Implementa la interfaz Observador para recibir las actualizaciones y escribe su propia bitacora en un archivo .txt personalizado.
 * El ID del espectador se genera aleatoriamente a partir de un prefijo dado.
 */
public class Espectador implements Observador {

    private String id;
    private String personajeFavorito;
    private List<String> bitacoraEventos;

    /**
     * Constructor del Espectador. Genera un ID aleatorio concatenando el id base con un numero.
     * @param id Prefijo o nombre base del espectador ingresado por el usuario.
     * @param personajeFavorito Nombre del personaje al que apoya el espectador.
     */
    public Espectador(String id, String personajeFavorito) {
        Random random = new Random();
        int numeroAleatorio = 100 + random.nextInt(900);
        this.id = id + numeroAleatorio;
        this.personajeFavorito = personajeFavorito;
        this.bitacoraEventos = new ArrayList<>();
        // Se crea el archivo de bitacora vacio.
        limpiarBitacora();
    }

    /**
     * Recibe un mensaje de la arena, lo imprime en consola y lo guarda en la bitacora.
     * @param mensaje El texto con la notificacion de lo que sucede en la batalla.
     */
    @Override
    public void actualizar(String mensaje) {
        // Se guarda el mensaje en la lista 
        bitacoraEventos.add(mensaje);
        // Se escribe en el archivo .txt inmediatamente
        escribirBitacora(mensaje);
        // Imprimimos en consola para que el usuario vea la pelea en vivo
        System.out.println("[" + id + "] " + mensaje);
    }

    /**
     * Recibe la notificacion del fin del combate, evalua si su personaje gano,
     * imprime el resultado final y lo guarda en la bitacora.
     * @param ganador Nombre del combatiente que resulto victorioso.
     */
    @Override
    public void finalizarTransmision(String ganador) {
        String resultado;
        if (ganador.toLowerCase().contains(personajeFavorito.toLowerCase())) {
            resultado = "¡¡Mi personaje " + personajeFavorito + " ha GANADO >.<!!";
        } else {
            resultado = "Mi personaje  " + personajeFavorito + " ha PERDIDO :c ";
        }

        // Imprimimos en consola
        System.out.println("[" + id + "] --- FIN DE LA TRANSMISION ---");
        System.out.println("[" + id + "] Ganador: " + ganador);
        System.out.println("[" + id + "] " + resultado);

        // Guardamos en memoria
        bitacoraEventos.add("--- FIN DE LA TRANSMISION ---");
        bitacoraEventos.add("Ganador: " + ganador);
        bitacoraEventos.add(resultado);
        
        // Escribimos en el archivo
        escribirBitacora("--- FIN DE LA TRANSMISION ---");
        escribirBitacora("Ganador: " + ganador);
        escribirBitacora(resultado);
    }

    /**
     * Escribe un mensaje en el archivo de bitacora personalizado del espectador.
     * @param mensaje El texto o evento que se va a registrar en el archivo .txt.
     */
    private void escribirBitacora(String mensaje) {
        String nombreArchivo = "bitacora_" + id + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, true))) {
            writer.println(mensaje);
        } catch (IOException e) {
            System.err.println("Error al escribir la bitacora de " + id + ": " + e.getMessage());
        }
    }

    /**
     * Limpia el archivo de la bitacora al inicio de una nueva simulacion o combate
     * y escribe el mensaje de bienvenida epico.
     */
    private void limpiarBitacora() {
        String nombreArchivo = "bitacora_" + id + ".txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, false))) {
            writer.println("===============================================================================");
            writer.println("   ¡BIENVENIDO A LA BATALLA PARA FARMEAR AURA!");
            writer.println("   Aqui solo habra UN GANADOR...");
            writer.println("===============================================================================");
            writer.println("Espectador: " + id);
            writer.println("Personaje favorito: " + personajeFavorito);
            writer.println("-------------------------------------------------------------------------------");
            writer.println();
        } catch (IOException e) {
            System.err.println("Error al crear la bitacora de " + id + ": " + e.getMessage());
        }
    }

    /**
     * Obtiene el identificador unico del espectador.
     * @return El ID del espectador.
     */
    public String getId() { return id; }
    
    /**
     * Obtiene el nombre del personaje al que apoya el espectador.
     * @return El nombre del personaje favorito.
     */
    public String getPersonajeFavorito() { return personajeFavorito; }
    
    /**
     * Obtiene la lista en memoria de todos los eventos registrados por el espectador.
     * @return Lista de cadenas con los eventos de la batalla.
     */
    public List<String> getBitacoraEventos() { return bitacoraEventos; }
}
