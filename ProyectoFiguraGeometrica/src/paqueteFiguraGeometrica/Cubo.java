package paqueteFiguraGeometrica;


class Cubo extends Cuadrado {
	
	
	public Cubo(int valor1, double area, double perimetro) {
		super(valor1, area, perimetro);
		// TODO Auto-generated constructor stub
	}

	public double getArea() {
		area = 6 * super.getArea();
		return area;
	}

	@Override
	public String toString() {
		return "Cubo [valor1=" + valor1 + ", area=" + area + ", perimetro=" + perimetro + "]";
	}

	
}