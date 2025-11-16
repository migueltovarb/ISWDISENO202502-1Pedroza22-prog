package paqueteVehiculos;

public class Carro extends Vehiculo {
    private int numPuertas;

    public Carro(String matricula, int numPuertas) {
        super(matricula);
        this.numPuertas = numPuertas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + ", Puertas: " + numPuertas;
    }
}