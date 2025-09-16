public class PieceWorker extends Employee {
    private double wage;
    private double pieces;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wage, double pieces, String address, int age, String type) {
        super(firstName, lastName, socialSecurityNumber, address, age, type);
        if (wage < (double)0.0F) {
            throw new IllegalArgumentException("Wage must be >= 0.0");
        } else if (pieces < (double)0.0F) {
            throw new IllegalArgumentException("Pieces must be >= 0.0");
        } else {
            this.wage = wage;
            this.pieces = pieces;
        }
    }

    public void setWage(double wage) {
        if (wage < (double)0.0F) {
            throw new IllegalArgumentException("Wage must be >= 0.0");
        } else {
            this.wage = wage;
        }
    }

    public double getWage() {
        return this.wage;
    }

    public void setPieces(double pieces) {
        if (pieces < (double)0.0F) {
            throw new IllegalArgumentException("Pieces must be >= 0.0");
        } else {
            this.pieces = pieces;
        }
    }

    public double getPieces() {
        return this.pieces;
    }

    public double earnings() {
        return this.getWage() * this.getPieces();
    }

    public String toString() {
        return String.format("piece worker: %s%n%s: $%,.2f; %s: %,.2f", super.toString(), "Wage", this.getWage(), "Pieces made", this.getPieces());
    }
}
