package paqueteFiguraGeometrica;

class Cuadrado extends FiguraGeométrica {

	public Cuadrado(int valor1, double area, double perimetro) {
		super(valor1, area, perimetro);
		// TODO Auto-generated constructor stub
	}

	public double getArea() {
		area = Math.pow(valor1, 2);
		return area;
	}

	public double getPerimetro() {
		perimetro = 4 * valor1;
		return perimetro;
	}

	@Override
	public String toString() {
		return "Cuadrado [valor1=" + valor1 + ", area=" + area + ", perimetro=" + perimetro + "]";
	}

	
}