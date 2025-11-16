package paqueteBanco;

import java.util.Scanner;

public class programaBanco {

    public static void main(String[] args) {

        Banco cuenta1 = new Banco("Vanessa", 10000);
        Scanner sc = new Scanner(System.in);

        System.out.println("El titular de la cuenta es: " + cuenta1.getTitular());
        System.out.println("El saldo actual es: " + cuenta1.getCantidad());

       
        System.out.println("Ingrese la cantidad que va a ingresar a su cuenta: ");
        double ingreso = sc.nextDouble();
        cuenta1.ingresarCantidad(ingreso);
        System.out.println("Ingreso exitoso. Su cuenta ahora tiene: " + cuenta1.getCantidad());

       
        System.out.println("Ingrese la cantidad que desea retirar: ");
        double retiro = sc.nextDouble();
        cuenta1.retirarCantidad(retiro);
        System.out.println("Operación realizada. Su cuenta ahora tiene: " + cuenta1.getCantidad());

        sc.close();
    }
}