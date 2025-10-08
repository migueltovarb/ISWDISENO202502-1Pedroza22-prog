package veterinaria;

import java.util.*;
import java.text.SimpleDateFormat;

public class SistemaVeterinaria {
    private static List<Dueno> duenos = new ArrayList<>();
    private static List<Mascota> mascotas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE SEGUIMIENTO VETERINARIO ===");
            System.out.println("1. Registrar dueño");
            System.out.println("2. Registrar mascota");
            System.out.println("3. Registrar control veterinario");
            System.out.println("4. Consultar historial de una mascota");
            System.out.println("5. Generar resumen por mascota");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1 -> registrarDueno();
                case 2 -> registrarMascota();
                case 3 -> registrarControl();
                case 4 -> consultarHistorial();
                case 5 -> generarResumen();
            }
        } while (opcion != 0);
    }

    private static void registrarDueno() {
        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String doc = sc.nextLine();
        System.out.print("Teléfono: ");
        String tel = sc.nextLine();

        Dueno nuevo = new Dueno(nombre, doc, tel);
        duenos.add(nuevo);
        System.out.println("Dueño registrado exitosamente.");
    }

    private static void registrarMascota() {
        if (duenos.isEmpty()) {
            System.out.println("Primero registre un dueño.");
            return;
        }

        System.out.print("Nombre de la mascota: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = sc.nextInt(); sc.nextLine();
        System.out.print("Especie: ");
        String especie = sc.nextLine();

        System.out.println("Seleccione el dueño:");
        for (int i = 0; i < duenos.size(); i++) {
            System.out.println((i + 1) + ". " + duenos.get(i));
        }
        int opcion = sc.nextInt(); sc.nextLine();
        Dueno dueno = duenos.get(opcion - 1);

        // Validación: no duplicar nombre + dueño
        for (Mascota m : mascotas) {
            if (m.getNombre().equalsIgnoreCase(nombre) && m.getDueno().equals(dueno)) {
                System.out.println("Ya existe una mascota con ese nombre para este dueño.");
                return;
            }
        }

        mascotas.add(new Mascota(nombre, edad, especie, dueno));
        System.out.println(" Mascota registrada correctamente.");
    }

    private static void registrarControl() {
        if (mascotas.isEmpty()) {
            System.out.println("Primero registre una mascota.");
            return;
        }

        System.out.println("Seleccione la mascota:");
        for (int i = 0; i < mascotas.size(); i++) {
            System.out.println((i + 1) + ". " + mascotas.get(i));
        }
        int opcion = sc.nextInt(); sc.nextLine();
        Mascota mascota = mascotas.get(opcion - 1);

        try {
            System.out.print("Fecha (dd/MM/yyyy): ");
            String fechaStr = sc.nextLine();
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaStr);
            System.out.print("Tipo de control: ");
            String tipo = sc.nextLine();
            System.out.print("Observaciones: ");
            String obs = sc.nextLine();

            mascota.registrarControl(new ControlVeterinario(fecha, tipo, obs));
            System.out.println(" Control registrado exitosamente.");
        } catch (Exception e) {
            System.out.println(" Error en formato de fecha.");
        }
    }

    private static void consultarHistorial() {
        Mascota mascota = seleccionarMascota();
        if (mascota != null) mascota.mostrarHistorial();
    }

    private static void generarResumen() {
        Mascota mascota = seleccionarMascota();
        if (mascota != null) mascota.generarResumen();
    }

    private static Mascota seleccionarMascota() {
        if (mascotas.isEmpty()) {
            System.out.println(" No hay mascotas registradas.");
            return null;
        }
        System.out.println("Seleccione la mascota:");
        for (int i = 0; i < mascotas.size(); i++) {
            System.out.println((i + 1) + ". " + mascotas.get(i));
        }
        int opcion = sc.nextInt(); sc.nextLine();
        return mascotas.get(opcion - 1);
    }
}
