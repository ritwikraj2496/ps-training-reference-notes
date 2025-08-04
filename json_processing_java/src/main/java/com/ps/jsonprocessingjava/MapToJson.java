package com.ps.jsonprocessingjava;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MapToJson {
    public static void main(String[] args) throws JsonProcessingException {
        Map<String, Object> data = new HashMap<>();
        data.put("course", "Java");
        data.put("duration", 30);

        ObjectMapper mapper = new ObjectMapper();
        String jsonOutput = mapper.writeValueAsString(data);
        System.out.println(jsonOutput);

    }
}
