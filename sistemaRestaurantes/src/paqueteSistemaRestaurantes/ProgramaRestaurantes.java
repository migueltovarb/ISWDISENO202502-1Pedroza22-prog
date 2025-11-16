package paqueteSistemaRestaurantes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramaRestaurantes {
    private static List<Plato> menu = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar Plato");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Crear Pedido");
            System.out.println("4. Ver Menu");
            System.out.println("5. Ver Clientes");
            System.out.println("6. Ver Pedidos");
            System.out.println("7. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1 -> registrarPlato(sc);
                case 2 -> registrarCliente(sc);
                case 3 -> crearPedido(sc);
                case 4 -> verMenu();
                case 5 -> verClientes();
                case 6 -> verPedidos();
                case 7 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (opcion != 7);

        sc.close();
    }

   

    private static void registrarPlato(Scanner sc) {
        System.out.print("Nombre del plato: ");
        String nombre = sc.nextLine();
        System.out.print("Tipo del plato: ");
        String tipo = sc.nextLine();
        System.out.print("Precio del plato: ");
        double precio = sc.nextDouble();

        Plato plato = new Plato(nombre, tipo, precio);
        menu.add(plato);
        System.out.println("Plato registrado con exito.");
    }

    private static void registrarCliente(Scanner sc) {
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Telefono del cliente: ");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(nombre, telefono);
        clientes.add(cliente);
        System.out.println("Cliente registrado con exito.");
    }

    private static void crearPedido(Scanner sc) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }
        if (menu.isEmpty()) {
            System.out.println("No hay platos en el menu.");
            return;
        }

        System.out.println("Seleccione un cliente:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i));
        }
        int clienteIndex = sc.nextInt() - 1;
        sc.nextLine();

        if (clienteIndex < 0 || clienteIndex >= clientes.size()) {
            System.out.println("Cliente invalido.");
            return;
        }

        Pedido pedido = new Pedido(clientes.get(clienteIndex));

        String continuar;
        do {
            System.out.println("Seleccione un plato del menu:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i));
            }
            int platoIndex = sc.nextInt() - 1;
            sc.nextLine();

            if (platoIndex >= 0 && platoIndex < menu.size()) {
                pedido.agregarPlato(menu.get(platoIndex));
                System.out.println("Plato agregado al pedido.");
            } else {
                System.out.println("Plato invalido.");
            }

            System.out.print("¿Desea agregar otro plato? (s/n): ");
            continuar = sc.nextLine();
        } while (continuar.equalsIgnoreCase("s"));

        pedidos.add(pedido);
        System.out.println("Pedido creado con exito.");
    }

    private static void verMenu() {
        if (menu.isEmpty()) {
            System.out.println("No hay platos en el menu.");
        } else {
            System.out.println("--- MENU ---");
            for (Plato p : menu) {
                System.out.println(p);
            }
        }
    }

    private static void verClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("--- CLIENTES ---");
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    private static void verPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("--- PEDIDOS ---");
            for (Pedido p : pedidos) {
                System.out.println(p);
                System.out.println("----------------");
            }
        }
    }
}
