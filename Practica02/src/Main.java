import java.util.Scanner;

/**
 * Clase principal para probar el funcionamiento de la pizzería "El Pequeño Cesarín".
 * El robot automatiza por completo sus estados y procesos internos.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();
        boolean salir = false;

        System.out.println("\n=============================================================");
        System.out.println("     BIENVENIDO A EL PEQUEÑO CESARÍN");
        System.out.println("=============================================================");

        while (!salir) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ordenar Pizza (Máximo 1)");
            System.out.println("2. Ordenar Helado (Máximo 1)");

	    // Las opciones de cancelar y salir aparecen siempre
            System.out.println("3. Cancelar orden");
            System.out.println("4. Salir de la sucursal");
            
            // La opción de pagar solo aparece al final si hay algo en la orden
            if (robot.getPizzaOrdenada() != null || robot.getHeladoOrdenado() != null) {
                System.out.println("5. Confirmar orden actual");
		System.out.println("6. Preparar orden actual");
		System.out.println("7. Solicitar Entrega");
            }
            
            System.out.print("Elige una opción: ");
            
            String opcion = scanner.nextLine();

            switch (opcion) {
	    case "1":
		// Despertar al robot automáticamente si está dormido
		robot.llamar();

		if (robot.getPizzaOrdenada() != null) {
		    System.out.println("Ya tienes una pizza en la orden. Límite de 1 por cliente.");
		} else {
		    ordenarPizza(scanner, robot);
		}
		break;
                    
	    case "2":
		// Despertar al robot automáticamente si está dormido
		robot.llamar();

		if (robot.getHeladoOrdenado() != null) {
		    System.out.println("Ya tienes un helado en la orden. Límite de 1 por cliente.");
		} else {
		    ordenarHelado(scanner, robot);
		}
		break;
		
	    case "3":
		System.out.println("\n--- Cancelando orden ---");
		robot.cancelar(); // El robot se vuelve a dormir y limpia la orden
		break;
                    
	    case "4":
		// Si el usuario quiere salir, verificamos si dejó una orden pendiente
		if (robot.getPizzaOrdenada() != null || robot.getHeladoOrdenado() != null) {
		    System.out.print("\nTienes una orden en curso. ¿Deseas cancelarla? (sí/no): ");
		    String respuesta = scanner.nextLine().trim().toLowerCase();
                        
		    if (respuesta.equals("sí") || respuesta.equals("si")) {
			System.out.println("\n¡¡¡¡¡ Cancelando orden pendiente !!!!!");
			robot.cancelar();
		    } else {
			continue;
		    }
		}
		salir = true;
		break;

	    case "5":
		robot.confirmar();
                break;

	    case "6":
		robot.preparar();
		break;
	    case "7":
		System.out.println("\n[Solicitando entrega al robot]");
		if (robot.getEstadoActual() instanceof EstadoEsperando)
		    imprimirTicket(robot);
                robot.entregar(); // Se entrega y el estado lo devuelve a dormir internamente
                break;
                    
	    default:
		System.out.println("Opción no válida.");
            }
        }
        
        System.out.println("\n¡Gracias por visitar El Pequeño Cesarín! Vuelve pronto.");
        scanner.close();
    }

    private static void ordenarPizza(Scanner scanner, Robot robot) {
        TipoMasa masa = null;
       
        // Valida la masa hasta que elija una opción válida
        while (masa == null) {
            System.out.println("\n--- TIPOS DE MASA ---");
            System.out.println("1. Americana");
            System.out.println("2. Napolitana");
            System.out.println("3. Romana");
            System.out.print("Elige tu masa: ");
            String masaInput = scanner.nextLine();
            
            switch (masaInput) {
	    case "1": masa = TipoMasa.AMERICANA; break;
	    case "2": masa = TipoMasa.NAPOLITANA; break;
	    case "3": masa = TipoMasa.ROMANA; break;
	    default:
		System.out.println("Opción no válida. Debe seleccionar uno de los tipos de masa disponibles.");
            }
        }

        Pizza pizza = null;
        
        // Valida la especialidad hasta que elija una opción valida
        while (pizza == null) {
            System.out.println("\n--- ESPECIALIDADES DE PIZZA ---");
            System.out.println("1. Carnívora (Ingredientes: Pepperoni, salchicha italiana y tocino)");
            System.out.println("2. Hawaiana (Ingredientes: Jamón de pavo y trozos de piña)");
            System.out.println("3. Margarita (Ingredientes: Queso mozzarella fresco y rodajas de tomate)");
            System.out.println("4. Mexicana (Ingredientes: Carne de res, chorizo y chile)");
            System.out.println("5. Pepperoni (Ingredientes: Muchas rodajas de pepperoni)");
            System.out.print("Elige tu pizza: ");
            String pizzaInput = scanner.nextLine();

            switch (pizzaInput) {
	    case "1": pizza = new PizzaCarnivora(1, "Pizza Carnívora", "Pepperoni, salchicha italiana y tocino", 195.0, false, masa); break;
	    case "2": pizza = new PizzaHawaiana(2, "Pizza Hawaiana", "Jamón de pavo y trozos de piña", 150.0, false, masa); break;
	    case "3": pizza = new PizzaMargarita(3, "Pizza Margarita", "Queso mozzarella fresco y rodajas de tomate", 130.0, true, masa); break;
	    case "4": pizza = new PizzaMexicana(4, "Pizza Mexicana", "Carne de res, chorizo y chile", 170.0, false, masa); break;
	    case "5": pizza = new PizzaPepperoni(5, "Pizza Pepperoni", "Muchas rodajas de pepperoni", 140.0, false, masa); break;
	    default: 
		System.out.println("Opción no válida. Debe seleccionar una de las especialidades disponibles.");
            }
        }
        
        pizza.seleccionarMasa(masa);
        robot.ordenarPizza(pizza);
        System.out.println("¡Pizza agregada a la orden!");
    }

    private static void ordenarHelado(Scanner scanner, Robot robot) {
        Helado helado = null;
        
        // Verifica que elija uno de los 3 sabores base válido
        while (helado == null) {
            System.out.println("\n--- SABORES DE HELADO ---");
            System.out.println("1. Chocolate");
            System.out.println("2. Vainilla");
            System.out.println("3. Fresa");
            System.out.print("Elige el sabor base: ");
            String saborInput = scanner.nextLine();

            switch (saborInput) {
	    case "1": helado = new HeladoBase(SaborHelado.CHOCOLATE); break;
	    case "2": helado = new HeladoBase(SaborHelado.VAINILLA); break;
	    case "3": helado = new HeladoBase(SaborHelado.FRESA); break;
	    default: 
		System.out.println("Opción no válida. Debe seleccionar uno de los 3 sabores disponibles.");
            }
        }

        // Ciclo para agregar extras; la opción de terminar solo sale si ya escogió un ingrediente
        boolean agregando = true;
        int extrasAgregados = 0;
        
        // Contadores individuales
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0;
        
        while (agregando) {
            System.out.println("\n--- INGREDIENTES EXTRAS (Máximo 3 en total) ---");
            System.out.println("1. Fresitas");
            System.out.println("2. Manguitos");
            System.out.println("3. Chispas de Chocolate");
            System.out.println("4. Malvaviscos");
            System.out.println("5. Kiwis");
            System.out.println("6. Gomitas de gusano");
            System.out.println("7. Gomitas de panda");
            System.out.println("8. Gomitas de aro");
            
            if (extrasAgregados > 0) {
                System.out.println("9. Terminar de agregar ingredientes");
            }
            
            System.out.print("Elige una opción: ");
            String extra = scanner.nextLine().trim();
            
            switch (extra) {
	    case "1":
		if (c1 < 3) {
		    helado = new Fresitas(helado);
		    System.out.println("-> Fresitas agregadas.");
		    c1++;
		    extrasAgregados++;
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mLímite máximo de Fresitas alcanzado (3).\u001B[0m");
		}
		break;
    
	    case "2":
		if (c2 < 3) {
		    helado = new Manguitos(helado);
		    System.out.println("-> Manguitos agregados.");
		    c2++;
		    extrasAgregados++;
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mNo puedes agregar más porciones.\u001B[0m");
		}
		break;
	    case "3":
		if (c3 < 3) {
		    helado = new ChispasChocolate(helado);
		    System.out.println("-> Chispas de chocolate agregadas.");
		    c3++;
		    extrasAgregados++;
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mNo puedes agregar más porciones.\u001B[0m");
		}
		break;
	    case "4":
		if (c4 < 3) {
		    helado = new Malvaviscos(helado);
		    System.out.println("-> Malvaviscos agregados.");
		    c4++;
		    extrasAgregados++; 
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mNo puedes agregar más porciones.\u001B[0m");
		}
		break;
	    case "5":
		if (c5 < 3) {
		    helado = new Kiwis(helado);
		    System.out.println("-> Kiwis agregados.");
		    c5++;
		    extrasAgregados++; 
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mNo puedes agregar más porciones.\u001B[0m");
		}
		break;
	    case "6":
		if (c6 < 3) {
		    helado = new GomitasGusano(helado);
		    System.out.println("-> Gomitas de gusano agregadas.");
		    c6++;
		    extrasAgregados++;
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mNo puedes agregar más porciones.\u001B[0m");
		}
		break;
	    case "7":
		if (c7 < 3) {
		    helado = new GomitasPanda(helado);
		    System.out.println("-> Gomitas de panda agregadas.");
		    c7++;
		    extrasAgregados++;
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mNo puedes agregar más porciones.\u001B[0m");
		}
		break;
	    case "8":
		if (c8 < 3) {
		    helado = new GomitasAro(helado);
		    System.out.println("-> Gomitas de aro agregadas.");
		    c8++;
		    extrasAgregados++;
		} else {
		    System.out.println("Ya alcanzó el límite máximo permitido para este ingrediente.");
		    System.out.println("\u001B[31mNo puedes agregar más porciones.\u001B[0m");
		}
		break;
	    case "9": 
		if (extrasAgregados > 0) {
		    agregando = false;
		} else {
		    System.out.println("Opción no válida.");
		}
		break;
	    default: 
		System.out.println("Opción no válida.");
            }
        }
        
        robot.ordenarHelado(helado);
        System.out.println("¡Helado agregado a la orden!");
    }

    private static void imprimirTicket(Robot robot) {
        System.out.println("\n=============================================================");
        System.out.println("           TICKET DE COMPRA - EL PEQUEÑO CESARÍN");
        System.out.println("=============================================================");
        double total = 0.0;

        if (robot.getPizzaOrdenada() != null) {
            Pizza p = robot.getPizzaOrdenada();
            System.out.println("PIZZA:");
            System.out.println("  * " + p.getNombre() + " - $" + p.getPrecio());
            // Mostramos los ingredientes específicos en el ticket final
            System.out.println("  * Ingredientes: " + p.getDescripcion());
            total += p.getPrecio();
        }

        if (robot.getHeladoOrdenado() != null) {
            Helado h = robot.getHeladoOrdenado();
            System.out.println("HELADO:");
            System.out.println("  * " + h.getDescripcion());
            System.out.println("  * Precio helado: $" + h.getPrecio());
            total += h.getPrecio();
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println(" TOTAL A PAGAR: $" + total);
        System.out.println("==============================================================");
    }
}
