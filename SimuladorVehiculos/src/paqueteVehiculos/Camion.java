package paqueteVehiculos;

public class Camion extends Vehiculo {
    private Remolque remolque;

    public Camion(String matricula) {
        super(matricula);
        this.remolque = null;
    }

    public void ponRemolque(Remolque r) {
        this.remolque = r;
    }

    public void quitaRemolque() {
        this.remolque = null;
    }

    @Override
    public void acelerar(int kmh) {
        velocidad += kmh;
        if (remolque != null && velocidad > 100) {
            System.out.println("¡Demasiado rápido para llevar un remolque!");
        } else {
            System.out.println("El camión aceleró a " + velocidad + " km/h");
        }
    }

    @Override
    public String toString() {
        if (remolque != null) {
            return super.toString() + " con " + remolque.toString();
        } else {
            return super.toString() + " sin remolque";
        }
    }
}