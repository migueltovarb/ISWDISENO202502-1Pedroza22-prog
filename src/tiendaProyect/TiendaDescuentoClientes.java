package tiendaProyect;
import java.util.Scanner;
public class TiendaDescuentoClientes {

    // Descuentos por tipo de producto (constantes final)
    private static final double DESCUENTO_ROPA = 0.10;       // 10%
    private static final double DESCUENTO_TECNOLOGIA = 0.05; // 5%
    private static final double DESCUENTO_ALIMENTOS = 0.08;  // 8%
    private static final double DESCUENTO_ADICIONAL = 0.07;  // 7% adicional si supera umbral
    private static final double UMBRAL = 600000;             // $600,000

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("===== TIENDA VIRTUAL - DESCUENTO CLIENTES =====");

        double totalSinDescuento = 0;
        double totalConDescuento = 0;

        int n = leerEntero("Ingrese el número de productos a comprar (mínimo 1): ");
        if (n < 1) {
            System.out.println("Debe ingresar al menos un producto.");
            return;
        }

        double[] precios = new double[n];

        int i = 0;
        while (i < n) {
            System.out.println("\nProducto #" + (i + 1));
            String nombre = leerTexto("Ingrese nombre del producto: ");

            int tipo;
            do {
                tipo = leerEntero("Ingrese tipo (1: Ropa, 2: Tecnología, 3: Alimentos): ");
                if (tipo < 1 || tipo > 3) {
                    System.out.println("❌ Tipo inválido. Intente de nuevo.");
                }
            } while (tipo < 1 || tipo > 3);

            double precio = leerDouble("Ingrese precio: ");

            double precioConDescuento = precio;
            switch (tipo) {
                case 1:
                    precioConDescuento -= precio * DESCUENTO_ROPA;
                    break;
                case 2:
                	precioConDescuento -= precio * DESCUENTO_TECNOLOGIA;
                    break;
                case 3:
                    precioConDescuento -= precio * DESCUENTO_ALIMENTOS;
                    break;
            }

            precios[i] = precioConDescuento;
            totalSinDescuento += precio;
            totalConDescuento += precioConDescuento;

            i++;
        }

        if (totalSinDescuento > UMBRAL) {
            totalConDescuento -= totalConDescuento * DESCUENTO_ADICIONAL;
        }

        double ahorro = totalSinDescuento - totalConDescuento;

        System.out.println("\n===== RESUMEN DE COMPRA =====");
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("Total con descuento: $" + totalConDescuento);
        System.out.println("Ahorro total: $" + ahorro);
    }

    // ================= MÉTODOS DE VALIDACIÓN =================

    private static int leerEntero(String mensaje) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número entero válido.");
            }
        }
    }

    private static double leerDouble(String mensaje) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Double.parseDouble(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido (puede tener decimales).");
            }
        }
    }

    private static String leerTexto(String mensaje) {
        String texto;
        while (true) {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return texto;
            } else {
                System.out.println("❌ Error: Solo se permiten letras.");
            }
        }
    }
}