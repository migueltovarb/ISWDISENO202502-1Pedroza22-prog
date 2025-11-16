package paqueteFiguraGeometrica;

public class ProgramaFiguras {

	public static void main(String[] args) {

//CIRCULO
		Circulo circulo = new Circulo(5, 2, 4);
System.out.println("Círculo:" + circulo.toString());
circulo.getArea();
System.out.println("Área del círculo:" + circulo.getArea());
circulo.getPerimetro();
System.out.println("Perímetro del círculo:" + circulo.getPerimetro());

System.out.println("---------------------");

//CUADRADO
Cuadrado cuadrado = new Cuadrado(4, 2, 7);
System.out.println("Cuadrado:" + cuadrado.toString());
cuadrado.getArea();
System.out.println("Área del cuadrado:" + cuadrado.getArea());
cuadrado.getPerimetro();
System.out.println("Perímetro del cuadrado:" + cuadrado.getPerimetro());

System.out.println("--------------------");

//RECTANGULO
Rectangulo rectangulo = new Rectangulo(4, 9, 2);
	rectangulo.setValor2(6);
	System.out.println("Rectángulo:" + rectangulo.toString());
	rectangulo.getArea();
	System.out.println("Área del rectángulo:" + rectangulo.getArea());
	rectangulo.getPerimetro();
	System.out.println("Perímetro del rectángulo:" + rectangulo.getPerimetro());
	
System.out.println("----------------------");

	//TRIANGULO
	Triangulo triangulo = new Triangulo(3, 2, 3);
	triangulo.setValor2(4);
	System.out.println("Triángulo:" + triangulo.toString());
	triangulo.getArea();
	System.out.println("Área del triángulo:" + triangulo.getArea());
	triangulo.getPerimetro();
	System.out.println("Perímetro del triángulo:" + triangulo.getPerimetro());
	
	System.out.println("----------------------");
	
	//CUBO
	Cubo cubo = new Cubo(3, 5, 1);
	System.out.println("Cubo:" + cubo.toString());
	cubo.getArea();
	System.out.println("Área del cubo:" + cubo.getArea());
	
	
	}

}