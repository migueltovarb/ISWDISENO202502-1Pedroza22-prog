package paqueteVeterinaria;
import java.util.Date;
public class ControlVeterinario {
private Date fecha;
private TipoControl control;
private String observacion;
public ControlVeterinario(Date fecha, TipoControl control, String observacion) {
	super();
	this.fecha = fecha;
	this.control = control;
	this.observacion = observacion;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public TipoControl getControl() {
	return control;
}
public void setControl(TipoControl control) {
	this.control = control;
}
public String getObservacion() {
	return observacion;
}
public void setObservacion(String observacion) {
	this.observacion = observacion;
}
@Override
public String toString() {
	return "ControlVeterinario [fecha=" + fecha + ", control=" + control + ", observacion=" + observacion + "]";
}
public void registrarControl() {
    
    System.out.println("Control veterinario registrado: " + this.toString());
}

}