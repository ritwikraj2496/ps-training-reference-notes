package com.ps.jsonprocessingjava;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class JsonToMap {
    public static void main(String[] args) throws Exception {
        String json = "{\"city\":\"Delhi\",\"pin\":110001}";

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(json, Map.class);

        System.out.println(map.get("city"));  // Output: Delhi
    }
}

