package paqueteAnimal;
public class Animal {

    protected String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Animal[nombre=" + nombre + "]";
    }
}