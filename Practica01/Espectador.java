import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa a un espectador de la pelea.
 * Implementa la interfaz Observador para recibir las actualizaciones y escribe su propia bitacora en un archivo .txt personalizado.
 * El ID del espectador se genera aleatoriamente.
 */

public class Espectador implements Observador {

    private String id;
    private String personajeFavorito;
    private List<String> bitacoraEventos;

    /**
     * Genera un ID aleatorio con el sig. formato: "espectador###".
     * @param personajeFavorito Nombre del personaje al que apoyas!
     */

    public Espectador(String id,String personajeFavorito) {
        Random random = new Random();
        int numeroAleatorio = 100 + random.nextInt(900);
        this.id = id + numeroAleatorio;
        this.personajeFavorito = personajeFavorito;
        this.bitacoraEventos = new ArrayList<>();
        // Se crea el archivo de bitacora vacio.
        limpiarBitacora();
    }

    @Override
    public void actualizar(String mensaje) {
        // Se guarda el mensaje en la lista 
        bitacoraEventos.add(mensaje);
        // Se escribe en el archivo .txt inmediatamente
        escribirBitacora(mensaje);
        // Imprimimos en consola para que el usuario vea la pelea en vivo
        System.out.println("[" + id + "] " + mensaje);
    }

    @Override
    public void finalizarTransmision(String ganador) {
        String resultado;
        if (ganador.toLowerCase().contains(personajeFavorito.toLowerCase())) {
            resultado = "¡Mi personaje " + personajeFavorito + " ha GANADO ><";
        } else {
            resultado = "Mi personaje  " + personajeFavorito + " ha PERDIDO :c ";
        }

        // Imprimimos en consola

        System.out.println("[" + id + "] --- FIN DE LA TRANSMISION ---");
        System.out.println("[" + id + "] Ganador: " + ganador);
        System.out.println("[" + id + "] " + resultado);

        // Guardamos
        bitacoraEventos.add("--- FIN DE LA TRANSMISION ---");
        bitacoraEventos.add("Ganador: " + ganador);
        bitacoraEventos.add(resultado);
        escribirBitacora("--- FIN DE LA TRANSMISION ---");
        escribirBitacora("Ganador: " + ganador);
        escribirBitacora(resultado);
    }

    /**
     * Escribe un mensaje en el archivo de bitacora personalizado.
     * @param mensaje 
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
     * Limpia el archivo de  la bitacora al inicio de una nueva simulacion o combate
     * y escribe el mensaje de bienvenida epico :v
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

    //Getters
    public String getId() { return id; }
    public String getPersonajeFavorito() { return personajeFavorito; }
    public List<String> getBitacoraEventos() { return bitacoraEventos; }
}
