package paqueteAnimal;
public class Mamifero extends Animal {

    public Mamifero(String nombre) {
        super(nombre); 
    }

    public String toString() {
        return "Mamifero[" + super.toString() + "]";
    }
}