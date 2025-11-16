package paqueteFiguraGeometrica;

 class Circulo extends FiguraGeométrica {

	 public Circulo(int valor1, double area, double perimetro) {
		super(valor1, area, perimetro);

	}

	 public double getArea() {
		 area = Math.PI * Math.pow(valor1, 2);
		 return area;
	 }

		public double getPerimetro() {
			perimetro = 2 * Math.PI * valor1;
			return perimetro;
		}

		@Override
		public String toString() {
			return "Circulo [valor1=" + valor1 + ", area=" + area + ", perimetro=" + perimetro + "]";
		}
		
		
}
