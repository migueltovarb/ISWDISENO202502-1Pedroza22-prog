package paqueteAnimal;
public class Gato extends Mamifero {

    public Gato(String nombre) {
        super(nombre);
    }

    public void saludar() {
        System.out.println("Miau miau miau");
    }

    public String toString() {
        return "Gato[" + super.toString() + "]";
    }
}