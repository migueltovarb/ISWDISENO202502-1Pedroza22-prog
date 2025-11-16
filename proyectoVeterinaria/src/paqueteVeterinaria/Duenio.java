package paqueteVeterinaria;

public class Duenio {
private String nombre;
private String documento;
private String telefono;
public Duenio(String nombre, String documento, String telefono) {
	super();
	this.nombre = nombre;
	this.documento = documento;
	this.telefono = telefono;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDocumento() {
	return documento;
}
public void setDocumento(String documento) {
	this.documento = documento;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
@Override
public String toString() {
	return "Duenio [nombre=" + nombre + ", documento=" + documento + ", telefono=" + telefono + "]";
}

public void registrarDuenio() {
    
    System.out.println("El dueño " + this.getNombre() + " con documento " + this.getDocumento() + " y teléfono "
            + this.getTelefono() + " ha sido registrado.");
}
}