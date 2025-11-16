package paquetePersona;


import java.util.Scanner;

public class ProgramaPersona {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Persona person = new Persona("Juan Andres Luna", "Fátima" );
        System.out.println(person.toString());
        
        person.getName();
        System.out.println(" El nombre es: "+ person.getName());
        
        person.getAdress();
        System.out.println(" La direccion es: "+ person.getAdress());
        

        Student student = new Student("Vanessa Mena ", "Santa Clara","Ingenieria de software ", 2003,1200.50 );
		System.out.println(student.toString());
		
		student.getProgram();
		System.out.println(" El programa es: "+ student.getProgram());
		
		System.out.println(" Ingrese el nuevo programa del estudiante:  ");
		String newProgram=sc.nextLine();
		student.setProgram(newProgram);
		System.out.println("el nuevo programa del estudiante es:"+ student.getProgram());
		System.out.println("La info actualizada del estudiante: " + student.toString());
		
		

		Staff staff = new Staff("Yeison Romo", "Los Laureles", "Veterinaria ", 3000.75);
		System.out.println(staff.toString());
		
		staff.getPay();
		System.out.println(" El pago es: "+ staff.getPay());
		
		System.out.println(" Ingrese el nuevo pago del staff:  ");
		double newPay=sc.nextDouble();
		staff.setPay(newPay);
		System.out.println("el nuevo pago del staff es:"+ staff.getPay());
		System.out.println("La info actualizada del staff: " + staff.toString());
	}

}