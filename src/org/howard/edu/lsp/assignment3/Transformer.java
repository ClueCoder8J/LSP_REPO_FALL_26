package org.howard.edu.lsp.assignment3;

public class Transformer {

    final double HOURS = 40.00;

    /**
     *
     * @param fields the data to be transformed
     * @return the transformed data
     */
    public static String transformRow(String[] fields) {
        // Skips row if the required length (5 fields) is not met
        if (fields.length != 5) {
            return null;
        }

        // Trim whitespace from each field
        for (int i = 0; i < fields.length; i++) {
            fields[i] = fields[i].trim();
        }

        String name = fields[1].toUpperCase(); // Ensures names are all uppercase
        String department = fields[2]; // Keeps department name unchanged

        // Declaration of number-based variables
        int employeeID;
        double hoursWorked;
        double hourlyRate;

        // Attempts to convert value into respective number types, if value cannot be converted then row is skipped
        try {
            employeeID = Integer.parseInt(fields[0]);
            hoursWorked = Double.parseDouble(fields[3]);
            hourlyRate = Double.parseDouble(fields[4]);
        } catch (NumberFormatException e) {
            return null;
        }

        // Skips row if either hours worked or hourly rate is not a positive value
        if (hoursWorked < 0 || hourlyRate < 0) {
            return null;
        }

        // Calls functions to get values for gross pay and pay level
        double grossPay = getGrossPay(hoursWorked, hourlyRate, department);
        String payLevel = getPayLevel(grossPay);

        String employmentStatus = (hoursWorked < 30) ? "Part-Time" : "Full-Time";

        return String.format("%d,%s,%s,%.2f,%.2f,%.2f,%s,%s",
                employeeID, name, department, hoursWorked,
                hourlyRate, grossPay, payLevel, employmentStatus);
    }

    /**
     * Calculates the gross pay of an employee using the values given
     *
     * @param hoursWorked Number of hours worked by employee
     * @param hourlyRate Employee's hourly rate
     * @param department Department employee works in, used to check if IT department bonus should apply
     * @return Gross pay of employee
     */
    public static double getGrossPay(double hoursWorked, double hourlyRate, String department) {
        final double HOURS = 40.00;
        double grossPay;

        if (hoursWorked <= HOURS) {
            grossPay = hourlyRate * hoursWorked;
        }
        else {
            double overtimeHours = hoursWorked - HOURS;
            double overtimeRate = hourlyRate * 1.5;
            grossPay = (overtimeHours * overtimeRate) + (HOURS * hourlyRate);
        }

        if (department.equals("IT")) {
            grossPay += grossPay * 0.05;
        }

        grossPay = Math.round(grossPay * 100.00) / 100.00;

        return grossPay;
    }

    /**
     * Determines an Employee's pay level based on their gross pay
     *
     * @param grossPay Employee's gross pay
     * @return the pay level of the employee
     */
    private static String getPayLevel(double grossPay) {
        String payLevel;
        if (grossPay < 500.00) { payLevel = "Low"; }
        else if (grossPay >= 500.00 & grossPay < 999.99) { payLevel = "Standard"; }
        else if (grossPay >= 1000.00 & grossPay < 1999.99) { payLevel = "High"; }
        else { payLevel = "Executive"; }

        return payLevel;
    }
}

