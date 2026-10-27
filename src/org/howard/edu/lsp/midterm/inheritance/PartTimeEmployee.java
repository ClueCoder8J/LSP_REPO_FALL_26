package org.howard.edu.lsp.midterm.inheritance;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        return this.hourlyRate * this.hoursWorked;
    }
}
