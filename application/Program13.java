package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program13 {

	public static void main(String[] args) {
		//import libraries
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		//read a integer number
		System.out.print("How many employees will be registered? ");
		int n = input.nextInt();
		
		//read the data (id, name, salary) of each employee
		List<Employee> list = new ArrayList<>();
		

		
		for (int i = 1; i <= n; i++) {
			
			System.out.println("Employee #"+ i);
			
			System.out.print("Id: ");
			int id = input.nextInt();
			while (hasId(list, id)) {  //while has id in use, you will need to write another id
				System.out.println("id already token. Try again: ");
				id = input.nextInt();
			}
			
			System.out.print("Name: ");
			input.nextLine();
			String name = input.nextLine();
			System.out.print("Salary: ");
			double salary = input.nextDouble();
			
			list.add(new Employee(id, name, salary));
			
		}

		//increase x% of salary of the chose employee id, if the id doesn't exist, show a message
		System.out.println();
		System.out.println("Enter the employee id that will have salary increase: ");
		int id = input.nextInt();
		
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id doesn't exist!");
		}
		
		else {
			System.out.println("Enter the percentage: ");
			double percentage = input.nextDouble();	
			emp.increaseSalary(percentage);
		}
		
		//show the list of the employees

		System.out.println();
		System.out.println("List of employees: ");
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		
		input.close();
	}

	private static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
