import java.util.List;
import java.util.Scanner;

public class SalariedEmployee extends Employee {
    private double weeklySalary;
    private double benefit;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary, String address, double benefit, int age, String type) {
        super(firstName, lastName, socialSecurityNumber, address, age, type);
        if (weeklySalary < (double) 0.0F) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        } else {
            this.weeklySalary = weeklySalary;
        }
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < (double) 0.0F) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        } else {
            this.weeklySalary = weeklySalary;
        }
    }

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    public double earnings() {
        return this.getWeeklySalary() * this.getBenefit();
    }

    public double getBenefit() {
        return benefit;
    }

    public void setBenefit(double benefit) {
        this.benefit = benefit;
    }

    public String toString() {
        return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", this.getWeeklySalary());
    }

    static void addSalariedEmployee(Scanner scanner, List<Employee> allEmployees) {
        System.out.println("\nEnter information for the new Salaried Employee:");

        System.out.print("\nEnter employee first name: ");
        String firstName = scanner.nextLine();

        System.out.print("\nEnter employee last name: ");
        String lastName = scanner.nextLine();

        System.out.print("\nEnter employee social security number/ID: ");
        String socialSecurityNumber = scanner.nextLine();

        System.out.print("\nEnter employee weekly salary: ");
        double weeklySalary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("\nEnter employee address: ");
        String address = scanner.nextLine();

        System.out.print("\nEnter employee benefit: ");
        double benefit = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\nEnter employee age: ");
        int age = scanner.nextInt();

        String type = "Salaried Employee";

        SalariedEmployee newSalariedEmployee = new SalariedEmployee(firstName, lastName, socialSecurityNumber, weeklySalary, address, benefit, age, type);
        allEmployees.add(newSalariedEmployee);

        System.out.println("New Salaried Employee added successfully!");
    }
}


