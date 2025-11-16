package paqueteFiguraGeometrica;

 class Rectangulo extends FiguraGeométrica {
	 
	 public Rectangulo(int valor1, double area, double perimetro) {
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
			area = valor1 * valor2;
			return area;
		}

		public double getPerimetro() {
			perimetro = 2 * (valor1 + valor2);
			return perimetro;
		}

		@Override
		public String toString() {
			return "Rectangulo [valor2=" + valor2 + ", valor1=" + valor1 + ", area=" + area + ", perimetro=" + perimetro
					+ "]";
		}

		
}
