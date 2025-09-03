package ControlAsistencia;

import java.util.Scanner;

public class ControlAsistencia {

    private static final int DIAS_SEMANA = 5;
    private static final int NUM_ESTUDIANTES = 4;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] asistencia = registrarAsistencias();
        boolean datosCargados = true;

        int opcion;
        do {
            System.out.println("\n===== MENÚ CONTROL DE ASISTENCIA =====");
            System.out.println("1. Ver asistencia individual");
            System.out.println("2. Ver resumen general");
            System.out.println("3. Volver a registrar asistencias");
            System.out.println("4. Salir");
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    if (datosCargados) {
                        verAsistenciaIndividual(asistencia);
                    }
                    break;

                case 2:
                    if (datosCargados) {
                        verResumenGeneral(asistencia);
                    }
                    break;

                case 3:
                    asistencia = registrarAsistencias();
                    datosCargados = true;
                    break;

                case 4:
                    System.out.println("Saliste del sistema...");
                    break;

                default:
                    System.out.println(" Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    private static char[][] registrarAsistencias() {
        char[][] datos = new char[NUM_ESTUDIANTES][DIAS_SEMANA];
        System.out.println("\n=== Registro de Asistencias ===");

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.println("\nEstudiante #" + (i + 1));
            for (int j = 0; j < DIAS_SEMANA; j++) {
                datos[i][j] = leerAsistencia("Día " + (j + 1) + " (P=Presente, A=Ausente): ");
            }
        }
        System.out.println("Registro completado.");
        return datos;
    }

    private static void verAsistenciaIndividual(char[][] asistencia) {
        int estudiante = leerEntero("Ingrese el número de estudiante (1-" + NUM_ESTUDIANTES + "): ") - 1;

        if (estudiante < 0 || estudiante >= NUM_ESTUDIANTES) {
            System.out.println(" Número de estudiante inválido.");
            return;
        }

        System.out.println("\nAsistencia del estudiante #" + (estudiante + 1));
        for (int j = 0; j < DIAS_SEMANA; j++) {
            System.out.println("Día " + (j + 1) + ": " + asistencia[estudiante][j]);
        }
    }

   
    private static void verResumenGeneral(char[][] asistencia) {
        System.out.println("\n=== Resumen General ===");

        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            int total = 0;
            for (int j = 0; j < DIAS_SEMANA; j++) {
                if (asistencia[i][j] == 'P') {
                    total++;
                }
            }
            System.out.println("Estudiante #" + (i + 1) + " asistió " + total + " días.");
        }

        System.out.print("\nEstudiantes que asistieron todos los días: ");
        boolean alguno = false;
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            boolean completo = true;
            for (int j = 0; j < DIAS_SEMANA; j++) {
                if (asistencia[i][j] == 'A') {
                    completo = false;
                    break;
                }
            }
            if (completo) {
                System.out.print((i + 1) + " ");
                alguno = true;
            }
        }
        if (!alguno) {
            System.out.print("Ninguno");
        }
        System.out.println();

        int maxAusencias = -1;
        int diaMax = -1;
        for (int j = 0; j < DIAS_SEMANA; j++) {
            int ausencias = 0;
            for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                if (asistencia[i][j] == 'A') {
                    ausencias++;
                }
            }
            if (ausencias > maxAusencias) {
                maxAusencias = ausencias;
                diaMax = j + 1;
            }
        }
        System.out.println("Día con mayor número de ausencias: Día " + diaMax + " (" + maxAusencias + " ausencias)");
    }


    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Error: Ingrese un número entero válido.");
            }
        }
    }

    private static char leerAsistencia(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine().trim().toUpperCase();
            if (entrada.equals("P") || entrada.equals("A")) {
                return entrada.charAt(0);
            } else {
                System.out.println(" Error: Solo se permite 'P' o 'A'.");
            }
        }
    }
}
