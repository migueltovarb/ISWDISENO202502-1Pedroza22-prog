package paqueteVeterinaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProgramaVeterinaria {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Duenio> duenos = new ArrayList<>();
        ArrayList<Mascota> mascotas = new ArrayList<>();
        ArrayList<ControlVeterinario> controles = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n MENÚ VETERINARIA ");
            System.out.println("1. Registrar dueño");
            System.out.println("2. Registrar mascota");
            System.out.println("3. Registrar control veterinario");
            System.out.println("4. Listar controles");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!sc.hasNextInt()) {
                System.out.println(" Ingrese un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del dueño: ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Documento: ");
                    String documento = sc.nextLine().trim();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine().trim();

                    if (nombre.isEmpty() || documento.isEmpty() || telefono.isEmpty()) {
                        System.out.println(" Todos los campos son obligatorios.");
                        break;
                    }
                    if (!telefono.matches("\\d+")) {
                        System.out.println(" El teléfono solo debe contener números.");
                        break;
                    }

                    Duenio duenio = new Duenio(nombre, documento, telefono);
                    duenos.add(duenio);
                    duenio.registrarDuenio();
                    break;

                case 2:
                    if (duenos.isEmpty()) {
                        System.out.println(" Primero registre un dueño.");
                        break;
                    }

                    System.out.println("Seleccione el dueño:");
                    for (int i = 0; i < duenos.size(); i++) {
                        System.out.println((i + 1) + ". " + duenos.get(i).getNombre());
                    }

                    int indiceD;
                    if (sc.hasNextInt()) {
                        indiceD = sc.nextInt() - 1;
                        sc.nextLine();
                    } else {
                        System.out.println(" Opción inválida.");
                        sc.next();
                        break;
                    }

                    if (indiceD < 0 || indiceD >= duenos.size()) {
                        System.out.println(" Dueño no válido.");
                        break;
                    }

                    System.out.print("Nombre de la mascota: ");
                    String nomM = sc.nextLine().trim();
                    System.out.print("Especie: ");
                    String especie = sc.nextLine().trim();
                    System.out.print("Edad: ");
                    String edad = sc.nextLine().trim();

                    if (nomM.isEmpty() || especie.isEmpty() || edad.isEmpty()) {
                        System.out.println(" Todos los campos son obligatorios.");
                        break;
                    }

                    boolean existe = false;
                    for (Mascota m : mascotas) {
                        if (m.getNombre().equalsIgnoreCase(nomM) && m.toString().contains(duenos.get(indiceD).getNombre())) {
                            existe = true;
                            break;
                        }
                    }
                    if (existe) {
                        System.out.println(" Ya existe una mascota con ese nombre y dueño.");
                        break;
                    }

                    Mascota mascota = new Mascota(nomM, especie, edad, duenos.get(indiceD));
                    mascotas.add(mascota);
                    mascota.registrarMascota();
                    break;

                case 3:
                    if (mascotas.isEmpty()) {
                        System.out.println(" No hay mascotas registradas.");
                        break;
                    }

                    System.out.println("Seleccione la mascota:");
                    for (int i = 0; i < mascotas.size(); i++) {
                        System.out.println((i + 1) + ". " + mascotas.get(i).getNombre());
                    }

                    int indiceM;
                    if (sc.hasNextInt()) {
                        indiceM = sc.nextInt() - 1;
                        sc.nextLine();
                    } else {
                        System.out.println(" Opción inválida.");
                        sc.next();
                        break;
                    }

                    if (indiceM < 0 || indiceM >= mascotas.size()) {
                        System.out.println("Mascota no válida.");
                        break;
                    }

                    System.out.println("Tipo de control (1.VACUNA, 2.CHEQUEO, 3.DESPARACITACION): ");
                    int tipo;
                    if (sc.hasNextInt()) {
                        tipo = sc.nextInt();
                        sc.nextLine();
                    } else {
                        System.out.println("⚠️ Opción inválida.");
                        sc.next();
                        break;
                    }

                    if (tipo < 1 || tipo > 3) {
                        System.out.println(" Tipo de control no válido.");
                        break;
                    }

                    TipoControl control = TipoControl.values()[tipo - 1];
                    System.out.print("Observación: ");
                    String obs = sc.nextLine().trim();
                    if (obs.isEmpty()) {
                        System.out.println(" La observación no puede estar vacía.");
                        break;
                    }

                    ControlVeterinario nuevo = new ControlVeterinario(new Date(), control, obs);
                    controles.add(nuevo);
                    System.out.println("Control registrado para " + mascotas.get(indiceM).getNombre());
                    break;

                case 4:
                    if (controles.isEmpty()) {
                        System.out.println(" No hay controles registrados.");
                    } else {
                        System.out.println("LISTADO DE CONTROLES ");
                        for (ControlVeterinario c : controles) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 5:
                    System.out.println(" Saliendo del sistema...");
                    break;

                default:
                    System.out.println(" Opción inválida.");
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }
}