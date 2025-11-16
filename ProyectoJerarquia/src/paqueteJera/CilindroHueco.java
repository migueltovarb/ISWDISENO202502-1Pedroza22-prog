package paqueteJera;

public class CilindroHueco extends Cilindro {
    private double radioInterno;

    public CilindroHueco(double radioExterno, double radioInterno, double altura) {
        super(radioExterno, altura);
        this.radioInterno = radioInterno;
    }

    public double area() {
        double areaLateralExterna = 2 * Math.PI * radio * altura;
        double areaLateralInterna = 2 * Math.PI * radioInterno * altura;
        double areaBases = 2 * Math.PI * (Math.pow(radio, 2) - Math.pow(radioInterno, 2));
        return areaLateralExterna + areaLateralInterna + areaBases;
    }

    public double volumen() {
        return Math.PI * altura * (Math.pow(radio, 2) - Math.pow(radioInterno, 2));
    }

    @Override
    public String toString() {
        return "CilindroHueco[" + super.toString() + ", radioInterno=" + radioInterno + "]";
    }
}