package paqueteJera;

import java.util.Scanner;

public class ProgramaFiguras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Círculo ===");
        Circulo c = new Circulo();
        c.leerRadio();
        System.out.println(c);
        System.out.println("Área del círculo: " + c.area());
        System.out.println("Longitud de la circunferencia: " + c.circunferencia());

        System.out.println("\n=== Cilindro ===");
        System.out.print("Ingrese el radio del cilindro: ");
        double rCil = sc.nextDouble();
        System.out.print("Ingrese la altura del cilindro: ");
        double hCil = sc.nextDouble();

        Cilindro cil = new Cilindro(rCil, hCil);
        System.out.println(cil);
        System.out.println("Área del cilindro: " + cil.area());
        System.out.println("Volumen del cilindro: " + cil.volumen());

        System.out.println("\n=== Cilindro Hueco ===");
        System.out.print("Ingrese el radio externo: ");
        double rExt = sc.nextDouble();
        System.out.print("Ingrese el radio interno: ");
        double rInt = sc.nextDouble();
        System.out.print("Ingrese la altura: ");
        double hHueco = sc.nextDouble();

        CilindroHueco ch = new CilindroHueco(rExt, rInt, hHueco);
        System.out.println(ch);
        System.out.println("Área del cilindro hueco: " + ch.area());
        System.out.println("Volumen del cilindro hueco: " + ch.volumen());

        sc.close();
    }
}