import java.io.*;
import java.util.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int id;
    private String designation;
    private double salary;

   
    public Employee(String name, int id, String designation, double salary) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        this.salary = salary;
    }

   
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', designation='" + designation + "', salary=" + salary + "}";
    }
}

public class Main {

    private static final String FILE_NAME = "employees.ser";

    
    public static void addEmployee() {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        
        scanner.nextLine(); // consume newline

        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

      
        Employee employee = new Employee(name, id, designation, salary);

       
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME, true))) {
            out.writeObject(employee); // Serialize and store employee object in the file
            System.out.println("Employee added successfully!");
        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

  
    public static void displayAllEmployees() {
       
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            boolean endOfFile = false;
            while (!endOfFile) {
                try {
                    Employee employee = (Employee) in.readObject();
                    System.out.println(employee);
                } catch (EOFException e) {
                    endOfFile = true; 
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found during deserialization.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading employee data: " + e.getMessage());
        }
    }

    
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add an Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayAllEmployees();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
 
        } while (choice != 3);          
    }

    public static void main(String[] args) {
//OUTPUT:
//Employee Management System
//1. Add an Employee
//2. Display All Employees
//3. Exit
//Enter your choice: arun
//Exception in thread "main" java.util.InputMismatchException
        at java.base/java.util.Scanner.throwFor(Scanner.java:964)
        at java.base/java.util.Scanner.next(Scanner.java:1619)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2284)
        at java.base/java.util.Scanner.nextInt(Scanner.java:2238)
        at Main.displayMenu(Main.java:118)
        at Main.main(Main.java:137)


