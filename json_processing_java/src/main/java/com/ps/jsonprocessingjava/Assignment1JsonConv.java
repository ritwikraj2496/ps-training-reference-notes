package com.ps.jsonprocessingjava;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Assignment1JsonConv {
    public static void main(String[] args) throws Exception {

        CalculatorResponse resp = new CalculatorResponse(15);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(resp);

        System.out.println("JSON Output: " + jsonString);
    }
}
