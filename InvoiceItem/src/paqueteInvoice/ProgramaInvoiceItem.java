package paqueteInvoice;

public class ProgramaInvoiceItem {

    public static void main(String[] args) {

        
        InvoiceItem item1 = new InvoiceItem("A101", "Laptop", 2, 3500.50);

        
        System.out.println(item1); 

        System.out.println("ID: " + item1.getID());
        System.out.println("Descripción: " + item1.getDesc());
        System.out.println("Cantidad: " + item1.getQty());
        System.out.println("Precio unitario: " + item1.getUnitPrice());
        System.out.println("Total: " + item1.getTotal());

        
        item1.setQty(3);
        System.out.println("Nueva cantidad: " + item1.getQty());
        System.out.println("Nuevo total: " + item1.getTotal());

        
        item1.setUnitPrice(4000);
        System.out.println("Nuevo precio unitario: " + item1.getUnitPrice());
        System.out.println("Nuevo total: " + item1.getTotal());

      
        System.out.println(item1);
    }
}
