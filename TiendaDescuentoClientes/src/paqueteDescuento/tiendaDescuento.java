package paqueteDescuento;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class TiendaDescuento {

    
    private static final double DESCUENTO_ROPA = 0.15;        // 15%
    private static final double DESCUENTO_TECNOLOGIA = 0.05;  // 5%
    private static final double DESCUENTO_ALIMENTOS = 0.08;   // 8%

    private static final double UMBRAL_DESCUENTO_ADICIONAL = 500_000.0; // $500.000
    private static final double DESCUENTO_ADICIONAL = 0.05;             // 5% adicional

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        NumberFormat monedaCO = NumberFormat.getCurrencyInstance(Locale.of("es", "CO"));


        System.out.println("Bienvenido a nuestra tienda virtual");
        System.out.println("Como cliente de la tienda virtual, conocerás el valor final a pagar con descuentos.\n");

       
        int cantidad = 0;
        while (cantidad < 1) {
            System.out.print("Ingresa el número de productos que desea comprar (mínimo 1): ");
            String linea = sc.nextLine().trim();
            try {
                cantidad = Integer.parseInt(linea);
                if (cantidad < 1) {
                    System.out.println(" Debe ser un entero mayor o igual a 1.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Debes ingresar un número entero.\n");
            }
        }

        
        double[] precios = new double[cantidad];

        double totalSinDescuento = 0.0;
        double totalConDescuentosPorTipo = 0.0;

        
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\nProducto #" + (i + 1));

            
            String nombre;
            do {
                System.out.print("  Nombre del producto: ");
                nombre = sc.nextLine().trim();
                if (nombre.isEmpty()) {
                    System.out.println("   El nombre no puede estar vacío.");
                }
            } while (nombre.isEmpty());

            
            int tipo = 0;
            while (tipo < 1 || tipo > 3) {
                System.out.print("  Tipo (1: ropa, 2: tecnología, 3: alimentos): ");
                try {
                    tipo = Integer.parseInt(sc.nextLine().trim());
                    if (tipo < 1 || tipo > 3) {
                        System.out.println("   Tipo inválido. Debe ser 1, 2 o 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("   Entrada inválida. Debe ingresar 1, 2 o 3.");
                }
            }

           
            double precio = 0.0;
            while (precio <= 0.0) {
                System.out.print("  Precio: ");
                try {
                    precio = Double.parseDouble(sc.nextLine().trim().replace(",", "."));
                } catch (NumberFormatException e) {
                    System.out.println("   Entrada inválida. Debe ingresar un número válido.");
                }
            }

            precios[i] = precio;

            
            double descuentoTipo;
            switch (tipo) {
                case 1: descuentoTipo = DESCUENTO_ROPA; break;
                case 2: descuentoTipo = DESCUENTO_TECNOLOGIA; break;
                case 3: descuentoTipo = DESCUENTO_ALIMENTOS; break;
                default: descuentoTipo = 0.0;
            }

            totalSinDescuento += precio;
            totalConDescuentosPorTipo += precio * (1 - descuentoTipo);
        }

        
        double totalFinal = totalConDescuentosPorTipo;
        if (totalSinDescuento > UMBRAL_DESCUENTO_ADICIONAL) {
            totalFinal = totalConDescuentosPorTipo * (1 - DESCUENTO_ADICIONAL);
        }

        double ahorro = totalSinDescuento - totalFinal;

        
        System.out.println("\n Compra total ");
        System.out.println("Total sin descuentos: " + monedaCO.format(totalSinDescuento));
        System.out.println("Total con descuentos por tipo: " + monedaCO.format(totalConDescuentosPorTipo));
        if (totalSinDescuento > UMBRAL_DESCUENTO_ADICIONAL) {
            System.out.println("Se aplicó descuento adicional del 5% por superar " +
                    monedaCO.format(UMBRAL_DESCUENTO_ADICIONAL));
        } else {
            System.out.println("No aplica descuento adicional.");
        }
        System.out.println("Total final a pagar: " + monedaCO.format(totalFinal));
        System.out.println("Ahorro total: " + monedaCO.format(ahorro));

        sc.close();
    }
}

