package paqueteFiguraGeometrica;

 class Triangulo  extends FiguraGeométrica{

		public Triangulo(int valor1, double area, double perimetro) {
		super(valor1, area, perimetro);

	}

		public int valor2;

		public int getValor2() {
			return valor2;
		}

		public void setValor2(int valor2) {
			this.valor2 = valor2;
		}

		public double getArea() {
			area = (valor1 * valor2) / 2.0;
			return area;
		}

		public double getPerimetro() {
			
			double hipotenusa = Math.sqrt(Math.pow(valor1, 2) + Math.pow(valor2, 2));
			perimetro = valor1 + valor2 + hipotenusa;
			return perimetro;
		}
		
		@Override
		public String toString() {
			return "Triangulo [valor2=" + valor2 + ", valor1=" + valor1 + ", area=" + area + ", perimetro=" + perimetro
					+ "]";
		}
}
