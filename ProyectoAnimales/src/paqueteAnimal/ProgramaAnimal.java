package paqueteAnimal;
public class ProgramaAnimal {

    public static void main(String[] args) {

        Animal a = new Animal("Animal generico");
        System.out.println(a);

        Mamifero m = new Mamifero("Mamifero generico");
        System.out.println(m);

        Gato g = new Gato("Margarita");
        System.out.println(g);
        g.saludar();

        Perro p1 = new Perro("Zaira");
        Perro p2 = new Perro("Luna");
        System.out.println(p1);
        p1.saludar();
        p1.saludar(p2);
    }
}