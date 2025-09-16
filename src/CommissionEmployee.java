public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales, double commissionRate, String address, int age, String type) {
        super(firstName, lastName, socialSecurityNumber, address, age, type);
        if (!(commissionRate <= (double)0.0F) && !(commissionRate >= (double)1.0F)) {
            if (grossSales < (double)0.0F) {
                throw new IllegalArgumentException("Gross sales must be >= 0.0");
            } else {
                this.grossSales = grossSales;
                this.commissionRate = commissionRate;
            }
        } else {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < (double)0.0F) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        } else {
            this.grossSales = grossSales;
        }
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (!(commissionRate <= (double)0.0F) && !(commissionRate >= (double)1.0F)) {
            this.commissionRate = commissionRate;
        } else {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public double earnings() {
        return this.getCommissionRate() * this.getGrossSales();
    }

    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f", "commission employee", super.toString(), "gross sales", this.getGrossSales(), "commission rate", this.getCommissionRate());
    }
}

