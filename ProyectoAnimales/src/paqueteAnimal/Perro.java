package paqueteAnimal;
public class Perro extends Mamifero {

    public Perro(String nombre) {
        super(nombre);
    }

    public void saludar() {
        System.out.println("Guau");
    }

    public void saludar(Perro otroPerro) {
        System.out.println("Guau guau guau");
    }

    public String toString() {
        return "Perro[" + super.toString() + "]";
    }
}