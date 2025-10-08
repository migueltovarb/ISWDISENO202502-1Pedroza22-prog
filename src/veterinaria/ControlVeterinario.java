package veterinaria;


import java.util.Date;

public class ControlVeterinario {
    private Date fecha;
    private String tipoControl;
    private String observaciones;

    public ControlVeterinario(Date fecha, String tipoControl, String observaciones) {
        this.fecha = fecha;
        this.tipoControl = tipoControl;
        this.observaciones = observaciones;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getTipoControl() {
        return tipoControl;
    }

    public String getObservaciones() {
        return observaciones;
    }

    @Override
    public String toString() {
        return "Control[" + tipoControl + " - " + fecha + "] Obs: " + observaciones;
    }
}
