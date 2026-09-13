/**
 * Estrategia de veneno para Dittuu. Forma una cola con aguja para infectar
 * al oponente y genera un capullo acido defensivo.
 */
public class EstrategiaDittuuVeneno implements EstrategiaPelea {

    @Override
    public int atacar() { 
        System.out.println("¡Dittuu despliega una cola afilada y con la aguja de la cola infecta con toxinas al oponente!");
        return 12; 
    }

    @Override
    public int defender(int impacto) { 
        System.out.println("Dittuu genera un capullo acido que neutraliza y devuelve parte de la agresion.");
        return impacto - 3; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Veneno"; 
    }
}
