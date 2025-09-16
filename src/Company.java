import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Company {

    static void reportControl(Scanner scanner, List<Employee> allEmployees) {

        System.out.println("\n--- Report Menu ---");
        System.out.println("1. Find an employee based on Social Security Number");
        System.out.println("2. Report by Type (Salaried, Hourly, PartTime)");
        System.out.println("3. Report for full time employees between an age range");
        System.out.println("4. Display total number of all employees");
        System.out.println("5. Back to Main Menu");
        System.out.print("Enter your choice: ");
        int choice2 = scanner.nextInt();

        switch (choice2) {
            case 1:
                findEmployeeBySocialSecurityNumber(scanner, allEmployees);
                break;
            case 2:
                displayAllEmployeesByType(scanner, allEmployees);
                break;
            case 3:
                displayEmployeesByAgeRange(scanner, allEmployees);
                break;
            case 4:
                displayTotalNumberOfEmployees(allEmployees);
                break;
            case 5:
                System.out.println("Returning to main menu.");
                break;
            default:
                System.out.println("Invalid choice for high-earning employee report. Please try again.");
                break;
        }
    }

    static void deleteEmployeeByName(Scanner scanner, List<Employee> allEmployees) {
        // Consume leftover newline if any before reading strings
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        System.out.print("Enter the first name of the employee to delete: ");
        String firstNameToDelete = scanner.nextLine();

        System.out.print("Enter the last name of the employee to delete: ");
        String lastNameToDelete = scanner.nextLine();

        boolean foundToDelete = false;
        Iterator<Employee> iterator = allEmployees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getFirstName().equalsIgnoreCase(firstNameToDelete) &&
                    employee.getLastName().equalsIgnoreCase(lastNameToDelete)) {
                iterator.remove();
                foundToDelete = true;
                System.out.println("Employee " + firstNameToDelete + " " + lastNameToDelete + " deleted successfully!");
                break;
            }
        }

        if (!foundToDelete) {
            System.out.println("Employee " + firstNameToDelete + " " + lastNameToDelete + " not found.");
        }
    }

    static void findEmployeeBySocialSecurityNumber(Scanner scanner, List<Employee> allEmployees) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        System.out.print("Enter the Social Security Number/ID of the Employee that you want to find (format: 111-111-1111): ");
        String firstSSNToFind = scanner.nextLine();

        boolean foundBySocialSecurityNumber = true;
        Iterator<Employee> iterator = allEmployees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getSocialSecurityNumber().equalsIgnoreCase(firstSSNToFind)) {
                System.out.println(firstSSNToFind + " is employee: " + employee.getFirstName() + " " + employee.getLastName());
                break;
            }
        }
        if (!foundBySocialSecurityNumber) {
            System.out.println("Employee not found by SNN/ID: " + firstSSNToFind);
        }
    }

    static void displayAllEmployees(Scanner scanner, List<Employee> allEmployees) {
        System.out.println("\n--- Report of All Employees ---");
        if (allEmployees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee employee : allEmployees) {
                System.out.println(employee);
            }
        }
    }

    static void displayAllEmployeesByType(Scanner scanner, List<Employee> allEmployees) {
        System.out.println("\n--- Report Menu ---");
        System.out.println("1: Salaried Employee");
        System.out.println("2: Hourly Employee");
        System.out.println("3: Part-time Employee");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        String employeeTypeToFind = "";

        switch (choice) {
            case 1:
                employeeTypeToFind = "Salaried Employee";
                break;
            case 2:
                employeeTypeToFind = "Hourly Employee";
                break;
            case 3:
                employeeTypeToFind = "Part-Time Employee";
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        System.out.println("\n--- Report of All Employees by Type: " + employeeTypeToFind + " ---");
        boolean found = false;
        for (Employee employee : allEmployees) {
            if (employee.getType().equalsIgnoreCase(employeeTypeToFind)) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found of type: " + employeeTypeToFind);
        }
    }

    static void displayEmployeesByAgeRange(Scanner scanner, List<Employee> allEmployees){
        System.out.println("Enter the age range for the full-time employees you'd like displayed.");
        System.out.println("Enter the bottom of the range: ");
        int bottom = scanner.nextInt();
        System.out.println("Enter the top of the range: ");
        int top = scanner.nextInt();
        List<Employee> ageRangeEmployees = new ArrayList<>();

        for(Employee employee : allEmployees){
            if(employee.getType().equalsIgnoreCase("Salaried Employee") || employee.getType().equalsIgnoreCase("Hourly Employee")){
                if(employee.getAge() > bottom && employee.getAge() < top){
                    ageRangeEmployees.add(employee);
                    System.out.println(ageRangeEmployees);
                }
            }
        }

    }

    static void displayTotalNumberOfEmployees(List<Employee> allEmployees){
            System.out.println("Current number of employees is: " + allEmployees.size());

    }

    static void employeeControl(Scanner scanner, List<Employee> allEmployees) {
        int choice2 = 0;
        System.out.println("\n--- Add Employee Menu ---");
        System.out.println("1. Salaried Employee");
        System.out.println("2. Hourly Employee");
        System.out.println("3. Part-time Employee");
        System.out.print("Enter your choice: ");
        choice2 = scanner.nextInt();
        scanner.nextLine();

        switch (choice2) {
            case 1:
                SalariedEmployee.addSalariedEmployee(scanner, allEmployees);
                break;
            case 2:
                HourlyEmployee.addHourlyEmployee(scanner, allEmployees);
                break;
            case 3:
                PartTimeEmployee.addPartTimeEmployee(scanner, allEmployees);
                break;
            default:
                System.out.println("Invalid choice for adding an employee. Please try again.");
                break;

        }
    }
}


