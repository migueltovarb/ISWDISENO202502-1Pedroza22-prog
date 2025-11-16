package paqueteAsistenciaEstudiantes;

import java.util.Scanner;

public class Asistencia {

    static final int DIAS_SEMANA = 5;
    static final int NUM_ESTUDIANTES = 4;

    static String[][] asistencia = new String[NUM_ESTUDIANTES][DIAS_SEMANA];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        registrarAsistencia(scanner);

        do {
            System.out.println("\nMenú de opciones");
            System.out.println("1. Ver asistencia individual");
            System.out.println("2. Ver resumen general");
            System.out.println("3. Volver a registrar asistencia");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");

        
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println(" Error: Ingresa un número válido.");
                scanner.nextLine();
                continue; 
            }

            switch (opcion) {
                case 1:
                    verAsistenciaIndividual(scanner);
                    break;
                case 2:
                    resumenGeneral();
                    break;
                case 3:
                    registrarAsistencia(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    static void registrarAsistencia(Scanner scanner) {
        System.out.println("\nRegistro de asistencia");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            for (int j = 0; j < DIAS_SEMANA; j++) {
                String input;
                do {
                    System.out.print("Estudiante " + (i + 1) + ", Día " + (j + 1) + " (P/A): ");
                    input = scanner.nextLine().toUpperCase();
                } while (!input.equals("P") && !input.equals("A"));
                asistencia[i][j] = input;
            }
        }
    }

    static void verAsistenciaIndividual(Scanner scanner) {
        System.out.print("Ingresa el número del estudiante (1-" + NUM_ESTUDIANTES + "): ");
        if (scanner.hasNextInt()) {
            int est = scanner.nextInt() - 1;
            scanner.nextLine();
            if (est >= 0 && est < NUM_ESTUDIANTES) {
                System.out.print(" Asistencia del estudiante " + (est + 1) + ": ");
                for (int j = 0; j < DIAS_SEMANA; j++) {
                    System.out.print(asistencia[est][j] + " ");
                }
                System.out.println();
            } else {
                System.out.println("Número de estudiante inválido.");
            }
        } else {
            System.out.println(" Debes ingresar un número.");
            scanner.nextLine();
        }
    }

    static void resumenGeneral() {
        System.out.println("\nResumen General");

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            int total = 0;
            for (int j = 0; j < DIAS_SEMANA; j++) {
                if (asistencia[i][j].equals("P")) total++;
            }
            System.out.println("Estudiante " + (i + 1) + ": " + total + " asistencias");
        }

        System.out.print("Estudiantes con asistencia perfecta: ");
        boolean hayPerfectos = false;
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            boolean perfecto = true;
            for (int j = 0; j < DIAS_SEMANA; j++) {
                if (asistencia[i][j].equals("A")) {
                    perfecto = false;
                    break;
                }
            }
            if (perfecto) {
                System.out.print((i + 1) + " ");
                hayPerfectos = true;
            }
        }
        if (!hayPerfectos) System.out.print("Ninguno");
        System.out.println();

        int maxAusencias = -1;
        int diaMax = -1;
        for (int j = 0; j < DIAS_SEMANA; j++) {
            int ausencias = 0;
            for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                if (asistencia[i][j].equals("A")) ausencias++;
            }
            if (ausencias > maxAusencias) {
                maxAusencias = ausencias;
                diaMax = j;
            }
        }
        System.out.println("Día con más ausencias: Día " + (diaMax + 1) + " (" + maxAusencias + " ausencias)");
    }
}
