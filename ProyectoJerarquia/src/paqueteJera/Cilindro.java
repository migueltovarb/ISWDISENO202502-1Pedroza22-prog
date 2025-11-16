package paqueteJera;

public class Cilindro extends Circulo {
    protected double altura;

    public Cilindro() {
    }

    public Cilindro(double radio, double altura) {
        super(radio);
        this.altura = altura;
    }

    public double area() {
        return 2 * Math.PI * radio * altura + 2 * Math.PI * Math.pow(radio, 2);
    }

    public double volumen() {
        return Math.PI * Math.pow(radio, 2) * altura;
    }

    @Override
    public String toString() {
        return "Cilindro[" + super.toString() + ", altura=" + altura + "]";
    }
}