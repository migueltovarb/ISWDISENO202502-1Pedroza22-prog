package paqueteJera;

import java.util.Scanner;

public class Circulo {
    protected double radio;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
    }

    public void leerRadio() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el radio del círculo: ");
        radio = sc.nextDouble();
    }

    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double circunferencia() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Circulo[radio=" + radio + "]";
    }
}
