package Circulo;

public class ProgramaCirculo {

	public static void main(String[] args) {
		
		Circulo elCirculo=new Circulo();
		double area=elCirculo.getArea();
		System.out.println("area:"+ area);
		elCirculo.setRadio(300);
		area=elCirculo.getArea();
		
		System.out.println("area:"+ area);
		
		Circulo miSegundoCirculo=new Circulo(400);
		area=miSegundoCirculo.getArea();
		System.out.println("area:"+ area);
		
		double perimetro=miSegundoCirculo.getPerimetro();
		System.out.println("Perimetro:"+perimetro);
		
		System.out.println(miSegundoCirculo);

	}

}
