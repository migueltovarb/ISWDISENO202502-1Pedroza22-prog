package paqueteVeterinaria;

public class Mascota {
private String nombre;
private String especie;
private String edad;
private Duenio duenio;
public Mascota(String nombre, String especie, String edad, Duenio duenio) {
	super();
	this.nombre = nombre;
	this.especie = especie;
	this.edad = edad;
	this.duenio = duenio;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getEspecie() {
	return especie;
}
public void setEspecie(String especie) {
	this.especie = especie;
}
public String getEdad() {
	return edad;
}
public void setEdad(String edad) {
	this.edad = edad;
}
@Override
public String toString() {
	return "Mascota [nombre=" + nombre + ", especie=" + especie + ", edad=" + edad + ", duenio=" + duenio + "]";
}

public void registrarMascota() {

	System.out.println("La mascota " + this.getNombre() + " de especie " + this.getEspecie() + " y edad "
			+ this.getEdad() + " ha sido registrada con el dueño " + this.duenio.getNombre());
}
}
