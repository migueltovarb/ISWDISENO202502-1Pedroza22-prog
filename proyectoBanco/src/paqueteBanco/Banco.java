package paqueteBanco;

public class Banco {
private String titular;
private double cantidad;

public Banco(String titular) {
	super();
	this.titular = titular;
	
}

public Banco(String titular, double cantidad) {
    super();
    this.titular = titular;
    this.cantidad = cantidad;
}
public String getTitular() {
	return titular;
}
public void setTitular(String titular) {
	this.titular = titular;
}
public double getCantidad() {
    return cantidad;
}
public void setCantidad(double cantidad) {
    this.cantidad = cantidad;
}

public void ingresarCantidad(double cantidad){

if(cantidad>0) {
    this.cantidad+=cantidad;
    
    
} else {
    System.out.println("No se puede ingresar una cantidad negativa");
}
}

public void retirarCantidad(double cantidad) {
    if (this.cantidad - cantidad < 0) {
        this.cantidad = 0;
    } else {
        this.cantidad -= cantidad;
    }
}

@Override
public String toString() {
    return "Banco [titular=" + titular + ", cantidad=" + cantidad + "]";
}


}



