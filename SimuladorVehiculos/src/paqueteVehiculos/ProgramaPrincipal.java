package paqueteVehiculos;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        // Polimorfismo de subtipo
        Vehiculo v1 = new Carro("AYG985", 4);
        Vehiculo v2 = new Camion("HUY346");

        v1.acelerar(50);
        System.out.println(v1.toString());

        v2.acelerar(60);
        System.out.println(v2.toString());

        // Usamos métodos específicos de subclases con conversión de tipo
        Camion camion = (Camion) v2;
        Remolque remolque = new Remolque(3000);
        camion.ponRemolque(remolque);

        camion.acelerar(50); // Aquí se aplica la sobrescritura
        System.out.println(camion.toString());
    }
}