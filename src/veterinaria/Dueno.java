package veterinaria;

public class Dueno {
    private String nombreCompleto;
    private String documento;
    private String telefono;

    public Dueno(String nombreCompleto, String documento, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.telefono = telefono;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Dueño: " + nombreCompleto + " (Doc: " + documento + ", Tel: " + telefono + ")";
    }
}
