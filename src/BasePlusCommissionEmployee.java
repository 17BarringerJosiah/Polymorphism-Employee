public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary, String address, int age, String type) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, address, age, type);
        if (baseSalary < (double)0.0F) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        } else {
            this.baseSalary = baseSalary;
        }
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < (double)0.0F) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        } else {
            this.baseSalary = baseSalary;
        }
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public double earnings() {
        return this.getBaseSalary() + super.earnings();
    }

    public String toString() {
        return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", this.getBaseSalary());
    }
}
