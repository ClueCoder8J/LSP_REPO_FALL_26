package org.howard.edu.lsp.midterm.inheritance;

public class FullTimeEmployee extends Employee {
    final double overtimeThreshold = 40;
    final double overtimeMultiplier = 1.5;

    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    @Override
    public double calculatePay() {
        double pay;
        if (this.hoursWorked < overtimeThreshold) {
            pay = this.hourlyRate * this.hoursWorked;
        }
        else {
            double overtimeHours = this.hoursWorked - overtimeThreshold;
            double regular_pay = this.hourlyRate * overtimeThreshold;
            double overtime_pay = this.hourlyRate * overtimeHours;
            pay = regular_pay + overtime_pay;
        }
        return pay;
    }
}
