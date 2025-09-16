import java.util.List;
import java.util.Scanner;

public class PartTimeEmployee extends Employee {
    private double wage;
    private double hours;

    public PartTimeEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hours, String address, int age, String type) {
        super(firstName, lastName, socialSecurityNumber, address, age, type);
        if (wage < (double)0.0F) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        } else if (!(hours < (double)0.0F) && !(hours > (double)168.0F)) {
            this.wage = wage;
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
    }

    public void setWage(double wage) {
        if (wage < (double)0.0F) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        } else {
            this.wage = wage;
        }
    }

    public double getWage() {
        return this.wage;
    }

    public void setHours(double hours) {
        if (!(hours < (double)0.0F) && !(hours > (double)168.0F)) {
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
    }

    public double getHours() {
        return this.hours;
    }

    public double earnings() {
        return this.getHours() <= (double)40.0F ? this.getWage() * this.getHours() : (double)40.0F * this.getWage() + (this.getHours() - (double)40.0F) * this.getWage() * (double)1.5F;
    }

    public String toString() {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "hourly wage", this.getWage(), "hours worked", this.getHours());
    }

    static void addPartTimeEmployee(Scanner scanner, List<Employee> allEmployees) {
        System.out.println("\nEnter information for the new Part-time Employee:");
        System.out.print("Enter employee first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter employee last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter employee social security number/ID: ");
        String socialSecurityNumber = scanner.nextLine();
        System.out.print("Enter employee address: ");
        String address = scanner.nextLine();
        System.out.print("Enter employee hourly wage: ");
        double hourlyWage = scanner.nextDouble();
        System.out.print("Enter employee hours worked: ");
        double hoursWorked = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("\nEnter employee age: ");
        int age = scanner.nextInt();
        String type = "Part-Time Employee";

        PartTimeEmployee newPartTimeEmployee = new PartTimeEmployee(firstName, lastName, socialSecurityNumber, hourlyWage, hoursWorked, address, age, type);
        allEmployees.add(newPartTimeEmployee);
        System.out.println("New Part-time Employee added successfully!");
    }
}

