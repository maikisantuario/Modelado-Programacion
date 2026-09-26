/**
 * Clase principal para probar el funcionamiento del robot,
 * las pizzas y los helados de la pizzería "El Pequeño Cesarín".
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   BIENVENIDO A EL PEQUEÑO CESARÍN - SUCURSAL 1");
        System.out.println("==================================================\n");

        // Instancia del robot
        Robot robot = new Robot();

        // Intento de interactuar si sigue dormido
        System.out.println("--- Intentando interactuar con el robot dormido ---");
        robot.confirmar();

        // Despertar al robot
        System.out.println("\n--- Llamando al robot ---");
        robot.llamar();

        // Crear la pizza
        System.out.println("\n--- Seleccionando la Pizza ---");
        Pizza pizza = new PizzaCarnivora(
            101, 
            "Pizza Carnívora", 
            "Masa esponjosa con pepperoni, salchicha italiana y tocino", 
            195.0, 
            false, 
            TipoMasa.AMERICANA
        );
        
        // Asignar tipo de masa
        pizza.seleccionarMasa(TipoMasa.AMERICANA);
        robot.ordenarPizza(pizza);

        // Crear el helado y sus extras
        System.out.println("\n--- Seleccionando el Helado y Tops/Ingredientes Extras ---");
        Helado helado = new HeladoBase(SaborHelado.CHOCOLATE);

        // Agregar toppings
        helado = new Fresitas(helado);
        helado = new Manguitos(helado);
        helado = new Manguitos(helado); // Segundo manguito
        helado = new ChispasChocolate(helado);
        helado = new Malvaviscos(helado);

        // Validar que no deje meter más de 3 del mismo ingrediente
        helado = new Manguitos(helado); // Tercer manguito
        helado = new Manguitos(helado); // Este ya no debería dejarlo agregar

        // Agregar el helado a la orden
        robot.ordenarHelado(helado);

        // Confirmar pedido
        System.out.println("\n--- Confirmando la Orden ---");
        robot.confirmar();

        // Preparar
        System.out.println("\n--- Solicitando preparación de la orden ---");
        robot.preparar();

        // Entregar y ticket
        System.out.println("\n--- Solicitando entrega del pedido ---");
        imprimirTicket(robot);
        robot.entregar();

        // Probar pedir algo cuando vuelve a dormirse
        System.out.println("\n--- Intentando ordenar nuevamente sin llamar al robot ---");
        robot.ordenarPizza(pizza);
    }

    /**
     * Imprime el ticket con la orden actual.
     * 
     * @param robot El robot con la orden.
     */
    private static void imprimirTicket(Robot robot) {
        System.out.println("\n==================================================");
        System.out.println("           TICKET DE COMPRA - EL PEQUEÑO CESARÍN");
        System.out.println("==================================================");
        double total = 0.0;

        if (robot.getPizzaOrdenada() != null) {
            Pizza p = robot.getPizzaOrdenada();
            System.out.println("PIZZA:");
            System.out.println("  * " + p.getNombre() + " (" + p.getTipoMasa() + ") - $" + p.getPrecio());
            total += p.getPrecio();
        }

        if (robot.getHeladoOrdenado() != null) {
            Helado h = robot.getHeladoOrdenado();
            System.out.println("HELADO:");
            System.out.println("  * Detalle: " + h.getDescripcion());
            System.out.println("  * Costo total helado: $" + h.getPrecio());
            total += h.getPrecio();
        }

        System.out.println("--------------------------------------------------");
        System.out.println(" TOTAL A PAGAR: $" + total);
        System.out.println("==================================================");
    }
}
