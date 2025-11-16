package paqueteTriangulo;

abstract class TrianguloBase {
	
	protected int lado;
	protected int hipotenusa;
	
	//constructor
	public TrianguloBase(int lado, int hipotenusa) {
		super();
		this.lado = lado;
		this.hipotenusa = hipotenusa;
	}
	
	abstract void perimetro(); //metodo abstracto
	
	
	
	void calcularAreaHipotenusa(int lado, int hipotenusa) {
		int otroLado= (int) Math.sqrt((hipotenusa * hipotenusa)- (lado * lado));
		double area=(lado * otroLado) / 2;
		System.out.println("El area del triangulo es: " + area);
		}
	
	
	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}

	public int getHipotenusa() {
		return hipotenusa;
	}

	public void setHipotenusa(int hipotenusa) {
		this.hipotenusa = hipotenusa;
	}
	
	

}