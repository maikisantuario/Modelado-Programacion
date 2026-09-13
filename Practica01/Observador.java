/**
 * Interfaz para los observadores (espectadores) del combate.
 */
public interface Observador {

    /**
     * Recibe una actualizacion del Sujeto observable.
     * @param mensaje Detalle del ataque, defensa o consumo de objeto.
     */
    void actualizar(String mensaje);

    /**
     * Recibe la notificacion final y procede a guardar el registro.
     * @param ganador Nombre del personaje que resulto victorioso.
     */
    void finalizarTransmision(String ganador);
}
