package paqueteEmployee;

public class TestEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Valeria", "Torres", 3000);

        System.out.println(emp1);

        System.out.println("ID: " + emp1.getID());
        System.out.println("First Name: " + emp1.getFirstName());
        System.out.println("Last Name: " + emp1.getLastName());
        System.out.println("Full Name: " + emp1.getName());
        System.out.println("Salary: " + emp1.getSalary());
        System.out.println("Annual Salary: " + emp1.getAnnualSalary());

        emp1.raiseSalary(10); 
        System.out.println("New Salary after 10% raise: " + emp1.getSalary());

        emp1.setSalary(5000);
        System.out.println("Updated Salary: " + emp1.getSalary());

        System.out.println(emp1); 
    }
}
