package paqueteVehiculos;

// Clase base (superclase)
public class Vehiculo {
    protected String matricula;
    protected int velocidad;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
        this.velocidad = 0;
    }

    // Método para acelerar (se puede sobrecargar)
    public void acelerar(int kmh) {
        velocidad += kmh;
        System.out.println("El vehículo aceleró a " + velocidad + " km/h");
    }

    // Sobrecarga del método acelerar (sin parámetro)
    public void acelerar() {
        velocidad += 10;
        System.out.println("El vehículo aceleró automáticamente a " + velocidad + " km/h");
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + ", Velocidad: " + velocidad + " km/h";
    }
}