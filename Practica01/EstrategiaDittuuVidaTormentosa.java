/**
 * Estrategia de vida tormentosa para Dittuu. Libera un ataque devastador
 * y gira generando una tormenta de salud que incrementa la vida exclusivamente a el.
 */
public class EstrategiaDittuuVidaTormentosa implements EstrategiaPelea {

    @Override
    public int atacar() { 
        System.out.println("¡Dittuu desata una tormenta de energia pura, arrasando con todo a su paso!");
        return 22; 
    }

    @Override
    public int defender(int impacto) { 
        System.out.println("¡Dittuu gira velozmente generando una tormenta de salud que le incrementa la vida solo a el (+25 Salud)!");
        return -25; // Devuelve un valor negativo para curar exclusivamente a Dittuu
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Vida Tormentosa"; 
    }
}
