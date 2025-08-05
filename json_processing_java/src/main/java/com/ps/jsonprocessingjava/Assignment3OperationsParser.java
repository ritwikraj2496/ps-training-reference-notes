package com.ps.jsonprocessingjava;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

class OperationResult {
    public String type;
    public int result;

    // Optional: override toString for display
    @Override
    public String toString() {
        return type + " = " + result;
    }
}

class Operations {
    public List<OperationResult> operations;
}

public class Assignment3OperationsParser {
    public static void main(String[] args) throws Exception {
        String jsonString = "{\n" +
                "  \"operations\": [\n" +
                "    {\"type\": \"add\", \"result\": 15},\n" +
                "    {\"type\": \"subtract\", \"result\": 5},\n" +
                "    {\"type\": \"multiply\", \"result\": 50},\n" +
                "    {\"type\": \"divide\", \"result\": 10}\n" +
                "  ]\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();

        // Parse JSON to Java object
        Operations ops = mapper.readValue(jsonString, Operations.class);

        // Print parsed results
        for (OperationResult op : ops.operations) {
            System.out.println(op.type + " - Result: " + op.result);
        }
    }
}
