package com.ps.jsonprocessingjava;

import com.fasterxml.jackson.databind.ObjectMapper;

// Convert Java Object To JSON
public class SerializeExample {
    public static void main(String[] args) throws Exception {
        Student s = new Student("Anjali", 22, true);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(s);

        System.out.println(json);
    }
}
