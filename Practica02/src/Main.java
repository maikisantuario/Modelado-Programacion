/**
 * Clase principal para probar el funcionamiento de la pizzería "El Pequeño Cesarín".
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     BIENVENIDO A EL PEQUEÑO CESARÍN");
        System.out.println("==================================================\n");

        // Instancia del robot (inicia dormido)
        Robot robot = new Robot();

        // Intento de interactuar con el robot cuando sigue dormido
        System.out.println("--- Intentando interactuar con el robot dormido ---");
        robot.confirmar();

        // Despertar al robot
        System.out.println("\n--- Despertando al robot ---");
        robot.llamar();

        // Crear pizza (Template Method)
        System.out.println("\n--- Ordenando pizza ---");
        Pizza pizza = new PizzaCarnivora(
            1, 
            "Pizza Carnívora", 
            "Pepperoni, salchicha italiana y tocino", 
            195.0, 
            false, 
            TipoMasa.AMERICANA
        );
        
        // El cliente indica la masa antes de preparar
        pizza.seleccionarMasa(TipoMasa.AMERICANA);
        robot.ordenarPizza(pizza);

        // Crear helado con ingredientes extras (Decorator)
        System.out.println("\n--- Ordenando helado ---");
        Helado helado = new HeladoBase(SaborHelado.CHOCOLATE);

        // Agregando ingredientes extra
        helado = new Fresitas(helado);
        helado = new Manguitos(helado);
        helado = new Manguitos(helado); // Segundo manguito
        helado = new ChispasChocolate(helado);
        helado = new Malvaviscos(helado);

        // Validar límite de máximo 3 porciones por ingrediente
        helado = new Manguitos(helado); // Tercer manguito (permitido)
        helado = new Manguitos(helado); // Cuarto manguito (ya no debe agregarse)

        robot.ordenarHelado(helado);

        // Confirmar la orden
        System.out.println("\n--- Confirmando la orden ---");
        robot.confirmar();

        // Preparar productos
        System.out.println("\n--- Preparando la orden ---");
        robot.preparar();

        // Entregar e imprimir ticket
        System.out.println("\n--- Entregando la orden ---");
        imprimirTicket(robot);
        robot.entregar();

        // Verificar que el robot volvió a dormirse
        System.out.println("\n--- Intentando ordenar nuevamente sin llamar al robot ---");
        robot.ordenarPizza(pizza);
    }

    /**
     * Imprime el ticket de compra con el desglose de los productos y el total.
     * 
     * @param robot El robot con la orden actual.
     */
    private static void imprimirTicket(Robot robot) {
        System.out.println("\n==================================================");
        System.out.println("           TICKET DE COMPRA - EL PEQUEÑO CESARÍN");
        System.out.println("==================================================");
        double total = 0.0;

        if (robot.getPizzaOrdenada() != null) {
            Pizza p = robot.getPizzaOrdenada();
            System.out.println("PIZZA:");
            System.out.println("  * " + p.getNombre() + " - $" + p.getPrecio());
            total += p.getPrecio();
        }

        if (robot.getHeladoOrdenado() != null) {
            Helado h = robot.getHeladoOrdenado();
            System.out.println("HELADO:");
            System.out.println("  * " + h.getDescripcion());
            System.out.println("  * Precio helado: $" + h.getPrecio());
            total += h.getPrecio();
        }

        System.out.println("--------------------------------------------------");
        System.out.println(" TOTAL A PAGAR: $" + total);
        System.out.println("==================================================");
    }
}
