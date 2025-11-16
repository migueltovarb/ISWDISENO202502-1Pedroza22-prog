package paqueteTriangulo;

public class Escaleno extends TrianguloBase {

	public Escaleno(int lado, int hipotenusa) {
		super(lado, hipotenusa);
		
	}

	@Override
	void perimetro() {
		double otroLado = Math.sqrt((hipotenusa * hipotenusa) - (lado * lado));
		double perimetro = lado + otroLado + hipotenusa;
		System.out.println("el perimetro del triangulo Escaleno es de:" + perimetro);

	}

}