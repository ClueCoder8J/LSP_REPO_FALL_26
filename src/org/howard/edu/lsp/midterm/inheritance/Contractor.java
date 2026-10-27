package org.howard.edu.lsp.midterm.inheritance;

public class Contractor extends Employee {
    private static final double CONTRACTOR_MULTIPLIER = 1.15;

    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        return this.hourlyRate * this.hoursWorked * CONTRACTOR_MULTIPLIER;
    }
}
