package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {
    public static void main(String[] args) {
        // Variable Declaration
        String inputFile = "data/employees.csv";
        String outputFile = "data/transformed_employees.csv";

        List<String[]> data;
        data = CSVManager.readFile(inputFile);

        List<String> outputData = new ArrayList<>();

        int linesRead = data.size();
        int linesTransformed = 0;

        // Transforms each row and counts the number of transformed rows
        for (String[] fields : data) {
            String transformedField = Transformer.transformRow(fields);
            if (transformedField != null) {
                outputData.add(transformedField);
                linesTransformed++;
            }
        }

        CSVManager.writeFile(outputFile, outputData);

        int linesSkipped = linesRead - linesTransformed;

        // Prints required row summary
        System.out.printf("Rows read: %d, Rows transformed: %d, " +
                        "Rows skipped: %d, Output file: data/transformed_employees.csv",
                        linesRead, linesTransformed, linesSkipped);


    }

}
