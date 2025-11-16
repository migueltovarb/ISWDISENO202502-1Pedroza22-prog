package paqueteAccount;

public class Account {
    private String id;
    private String owner;
    private double balance;

  
    public Account(String id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    
    public void credit(double amount) {
        balance += amount;
    }

    public void debit(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Fondos insuficientes para retirar " + amount);
        }
    }

    public void transferTo(Account other, double amount) {
        if (amount <= balance) {
            this.debit(amount);
            other.credit(amount);
        } else {
            System.out.println("Fondos insuficientes para transferir " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }


    @Override
    public String toString() {
        return "Account[id=" + id + ", owner=" + owner + ", balance=" + balance + "]";
    }
}
