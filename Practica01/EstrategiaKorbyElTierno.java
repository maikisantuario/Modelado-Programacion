import java.util.Random;

/**
 * Estrategia de ternura para Korby. Korby tiene el poder de irradiar
 * tanta ternura que logra desconcentrar a sus oponentes para atacarlos
 * o, en ocasiones, para que le tengan más piedad.
 */
public class EstrategiaKorbyElTierno implements EstrategiaPelea {
    
    /** Constante para imprimir texto en color rojo en la consola. */
    public static final String ROJO = "\u001B[31m";
    
    /** Constante para imprimir texto en color verde en la consola. */
    public static final String VERDE = "\u001B[32m";
    
    /** Constante para resetear el color de texto en la consola. */
    public static final String RESET = "\u001B[0m";
    
    /** Generador de numeros aleatorios para calcular el danio o ganancia de aura. */
    private Random random = new Random();

    /**
     * Realiza un ataque distrayendo al objetivo con extrema ternura para luego
     * atacarlo por la espalda. Genera una ganancia de aura entre 1000 y 3000.
     * 
     * @param objetivo El combatiente que recibe el ataque traicionero.
     * @return Los puntos de aura generados/ganados tras el impacto.
     */
    @Override
    public int atacar(Combatiente objetivo) { 
        int auraObtenida = 1000 + random.nextInt(2001);
        System.out.println("Miren a esa pequenia criatura tan tierna awwww \nMis ojos no pueden ver entre tanta luz de belleza" +
                           "\nAWWWWWWWWWW KORBYYYYY" +
                           "\n>> Korby paraliza con ternura a: " + objetivo.obtenerNombre() +
                           " y aprovecha el momento para atacarlos por la espalda.");
        System.out.println(VERDE + "+ " + auraObtenida + " de Aura 🗿🔥" + RESET);
        return auraObtenida; 
    }

    /**
     * Defiende a Korby utilizando su aspecto adorable para cautivar al rival, 
     * logrando que este se apiade y reduzca significativamente la fuerza de su golpe.
     * La perdida de aura se calcula entre 500 y 700.
     * 
     * @param atacante El combatiente que realiza el ataque inminente.
     * @return Los puntos de aura que Korby pierde tras el ataque mitigado.
     */
    @Override
    public int defender(Combatiente atacante) { 
        int auraPerdida = 500 + random.nextInt(201);
        System.out.println(atacante.obtenerNombre() + " intenta atacar a Korby.");
        System.out.println(">> Korby utiliza su ternura para confundir a " + atacante.obtenerNombre() +
                           " y este cautivado, se apiada del bello Korby y reduce el ataque.");
        System.out.println(ROJO + "- " + auraPerdida + " de Aura 🥶💦" + RESET);
        return auraPerdida; 
    }

    /**
     * Obtiene el nombre identificador de esta dulce y letal estrategia.
     * 
     * @return La cadena "Korby ElTierno".
     */
    @Override
    public String obtenerNombre() { 
        return "Korby ElTierno"; 
    }
}
