package paqueteTriangulo;

public class Acutangulo extends TrianguloBase {

	public Acutangulo(int lado, int hipotenusa) {
		super(lado, hipotenusa);
	}

	@Override
	void perimetro() {
		double otroLado=Math.sqrt((hipotenusa *hipotenusa)- (lado * lado));
		double perimetro=lado + otroLado + hipotenusa;
		System.out.println("el perimetro del triangulo Acutangulo es de:"+ perimetro);
		
		
	}

}