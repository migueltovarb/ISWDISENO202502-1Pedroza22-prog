package paqueteSistemaRestaurantes;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<Plato> platos;

    
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.platos = new ArrayList<>();
    }

    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public double calcularTotal() {
        double total = 0;
        for (Plato plato : platos) {
            total += plato.getPrecio();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(cliente).append("\nPlatos:\n");
        for (Plato p : platos) {
            sb.append("- ").append(p).append("\n");
        }
        sb.append(String.format("Total: $%.2f", calcularTotal()));
        return sb.toString();
    }
}
