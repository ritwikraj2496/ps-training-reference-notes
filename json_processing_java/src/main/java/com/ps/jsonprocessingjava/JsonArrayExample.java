package com.ps.jsonprocessingjava;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class JsonArrayExample {
    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"Ravi\",\"age\":20}, {\"name\":\"Priya\",\"age\":23}]";

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = mapper.readValue(json, new TypeReference<List<Student>>() {
        });

        for (Student s : students) {
            System.out.println(s.name + " - " + s.age);
        }
    }
}
