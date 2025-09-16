import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> allEmployees = new ArrayList<>();
        int choice = 0;

        do {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add an employee");
            System.out.println("2. Delete an employee");
            System.out.println("3. Report of all employees");
            System.out.println("4. Report of employees based on criteria");
            System.out.println("5. File control");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Company.employeeControl(scanner, allEmployees);
                    break;
                case 2:
                    Company.deleteEmployeeByName(scanner, allEmployees);
                    break;
                case 3:
                    Company.displayAllEmployees(scanner, allEmployees);
                    break;
                case 4:
                    Company.reportControl(scanner, allEmployees);
                    break;
                case 5:
                    FileControl.controlFiles(scanner, allEmployees);
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        } while (choice != 6);
        scanner.close();
    }
    }
