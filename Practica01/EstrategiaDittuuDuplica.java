/**
 * Estrategia de duplicacion para Dittuu. Simula la division celular
 * para contraatacar con el doble de fuerza absorbiendo la energia del entorno.
 */
public class EstrategiaDittuuDuplica implements EstrategiaPelea {

    @Override
    public int atacar() { 
        System.out.println("¡Dittuu se divide en dos sombras y ejecuta un ataque duplicado de alto impacto!");
        return 16; 
    }

    @Override
    public int defender(int impacto) { 
        System.out.println("Dittuu usa su clon gelatinoso como escudo señuelo, disipando gran parte del golpe.");
        return impacto - 5; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Duplica"; 
    }
}
