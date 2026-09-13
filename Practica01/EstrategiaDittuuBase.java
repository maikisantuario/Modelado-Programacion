/**
 *Estrategia base para el personaje Dittuu. Mantiene un ataque y defensa básicos.
 */
public class EstrategiaDittuuBase implements EstrategiaPelea {
    @Override
    public int atacar() { 
        System.out.println("Dittuu analiza al rival y ejecuta un golpe con precision.");
        return 8; 
    }

    @Override
    public int defender(int impacto) { 
        System.out.println("Dittuu adopta una forma gelatinosa para absorber parte del impacto.");
        return impacto - 1; 
    }

    @Override
    public String obtenerNombre() { 
        return "Dittuu Base"; 
    }
}
