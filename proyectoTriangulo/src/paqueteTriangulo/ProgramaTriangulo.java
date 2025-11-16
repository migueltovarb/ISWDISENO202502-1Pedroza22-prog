package paqueteTriangulo;

public class ProgramaTriangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 Acutangulo tAcu=new Acutangulo(3, 5);
 Escaleno tEsc=new Escaleno(4, 6);
 
 //parte de la clase acutangulo
 tAcu.calcularAreaHipotenusa(tAcu.getLado(), tAcu.getHipotenusa());
 tAcu.perimetro();
 
 //parte de la clase escaleno
 tEsc.calcularAreaHipotenusa(tEsc.getLado(), tEsc.getHipotenusa());
 tEsc.perimetro();
	
	}

}