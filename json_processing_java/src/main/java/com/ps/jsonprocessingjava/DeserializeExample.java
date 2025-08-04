package com.ps.jsonprocessingjava;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializeExample {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"Anjali\",\"age\":22,\"isEnrolled\":true}";

        ObjectMapper mapper = new ObjectMapper();
        Student s = mapper.readValue(json, Student.class);

        System.out.println(s.name + " - " + s.age);
    }
}
