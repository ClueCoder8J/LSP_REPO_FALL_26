package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ETLPipeline {

    public static void main(String[] args) {
        // Define variables for file paths
        String inputFile = "data/employees.csv";
        String outputFile = "data/transformed_employees.csv";

        // Initialize variable for output lines with required header lines
        List<String> data = new ArrayList<>();
        data.add("EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus");

        // Initialize count variables
        int linesRead = 0;
        int linesTransformed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            br.readLine(); // Skip the header line
            String line;

            // While loop keeps going until line does not exist
            while ((line = br.readLine()) != null) {
                linesRead++; // Increment as soon as line is read
                String[] fields = line.split(","); // Split line into individual fields

                // Skips row if the required length (5 fields) is not met
                if (fields.length != 5) {
                    continue;
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
                    continue;
                }

                // Skips row if either hours worked or hourly rate is not a positive value
                if (hoursWorked < 0 || hourlyRate < 0) {
                    continue;
                }

                // Calls functions (defined separately for readability and to make interpreter shut up) to get values for gross pay and pay level
                double grossPay = getGrossPay(hoursWorked, hourlyRate, department);
                String payLevel = getPayLevel(grossPay);

                String employmentStatus = (hoursWorked < 30) ? "Part-Time" : "Full-Time";

                // Formats the values required for the row into a csv format, then adds the row to the data variable
                data.add(String.format("%d, %s, %s, %.2f, %.2f, %.2f, %s, %s", employeeID, name, department, hoursWorked, hourlyRate, grossPay, payLevel, employmentStatus));
                linesTransformed++; // Updates count only after data has been added to

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Writes lines from data to the output file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int linesSkipped = linesRead - linesTransformed; // Calculates the number of lines skipped

        // Prints required row summary
        System.out.printf("Rows read: %d, Rows transformed: %d, Rows skipped: %d, Output file: data/transformed_employees.csv", linesRead, linesTransformed, linesSkipped);
    }

    /**
     * Calculates the gross pay of an employee using the values given
     *
     * @param hoursWorked Number of hours worked by employee
     * @param hourlyRate Employee's hourly rate
     * @param department Department employee works in, used to check if IT department bonus should apply
     * @return Gross pay of employee
     */
    private static double getGrossPay(double hoursWorked, double hourlyRate, String department) {
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

    private static String getPayLevel(double grossPay) {
        String payLevel;
        if (grossPay < 500.00) { payLevel = "Low"; }
        else if (grossPay > 500.00 & grossPay < 999.99) { payLevel = "Standard"; }
        else if (grossPay > 1000.00 & grossPay < 1999.99) { payLevel = "High"; }
        else { payLevel = "Executive"; }

        return payLevel;
    }
}
