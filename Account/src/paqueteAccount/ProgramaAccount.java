package paqueteAccount;

public class ProgramaAccount {

    public static void main(String[] args) {
        
    
        Account acc1 = new Account("A1001", "Valeria", 5000);
        Account acc2 = new Account("A1002", "Gabriel", 2000);

      
        System.out.println(acc1);
        System.out.println(acc2);

       
        acc1.credit(1500);
        System.out.println("Saldo después de abonar 1500: " + acc1.getBalance());

        
        acc1.debit(3000);
        System.out.println("Saldo después de retirar 3000: " + acc1.getBalance());

     
        acc1.debit(10000);

      
        acc1.transferTo(acc2, 2000);
        System.out.println("Saldo acc1: " + acc1.getBalance());
        System.out.println("Saldo acc2: " + acc2.getBalance());

        
        acc1.transferTo(acc2, 10000);

        
        System.out.println(acc1);
        System.out.println(acc2);
    }
}
