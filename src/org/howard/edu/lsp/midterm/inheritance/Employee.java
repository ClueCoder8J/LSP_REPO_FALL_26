package org.howard.edu.lsp.midterm.inheritance;

public abstract class Employee {
    protected final double hoursWorked;
    protected final double hourlyRate;

    public Employee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    public abstract double calculatePay();

}
