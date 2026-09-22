package org.howard.edu.lsp.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    /**
     * Reads data from specific CSV file
     *
     * @param inputFile path to the input file for the CSV data
     * @return list of field arrays, one per row
     */
    public static List<String[]> readFile(String inputFile) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            br.readLine(); // Skip the header line

            String line;

            // Splits line at commas
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }

            return data;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Write given data to specified output file
     *
     * @param outputFile path to the output file for the CSV data
     * @param lines data to be written to the output file
     */
    public static void writeFile(String outputFile, List<String> lines) {
        String header = "EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write(header);
            bw.newLine();
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

