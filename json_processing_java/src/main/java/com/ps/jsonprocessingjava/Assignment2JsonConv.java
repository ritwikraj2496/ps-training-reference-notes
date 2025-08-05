package com.ps.jsonprocessingjava;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Assignment2JsonConv {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String jsonMultiply = "{\"operation\":\"multiply\",\"operand1\":10,\"operand2\":5}";

        CalculatorRequest req = mapper.readValue(jsonMultiply, CalculatorRequest.class);

        int result = 0;

        switch (req.operation.toLowerCase()) {
            case "add":
                result = req.operand1 + req.operand2;
                break;
            case "multiply":
                result = req.operand1 * req.operand2;
                break;
            case "divide":
                result = req.operand1 / req.operand2;
                break;
            default:
                System.out.println("Unsupported operation");
                return;
        }

        // Step 3: Print result
        System.out.println("Operation: " + req.operation);
        System.out.println("Result: " + result);
    }
}
