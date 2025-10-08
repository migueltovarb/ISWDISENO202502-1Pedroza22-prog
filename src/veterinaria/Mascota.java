package veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private int edad;
    private String especie;
    private Dueno dueno;
    private List<ControlVeterinario> controles;

    public Mascota(String nombre, int edad, String especie, Dueno dueno) {
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
        this.dueno = dueno;
        this.controles = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public Dueno getDueno() { return dueno; }

    public void registrarControl(ControlVeterinario control) {
        controles.add(control);
    }

    public void mostrarHistorial() {
        System.out.println("Historial de " + nombre + ":");
        for (ControlVeterinario c : controles) {
            System.out.println(" - " + c);
        }
    }

    public void generarResumen() {
        System.out.println("Resumen Mascota:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Especie: " + especie);
        System.out.println("Edad: " + edad);
        System.out.println("Dueño: " + dueno.getNombreCompleto());
        System.out.println("Controles registrados: " + controles.size());
    }

    @Override
    public String toString() {
        return "Mascota: " + nombre + " (" + especie + ", " + edad + " años)";
    }
}
