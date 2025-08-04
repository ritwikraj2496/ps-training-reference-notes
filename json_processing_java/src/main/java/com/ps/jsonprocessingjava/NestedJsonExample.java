package com.ps.jsonprocessingjava;

import com.fasterxml.jackson.databind.ObjectMapper;

class Marks {
    public int math;
    public int science;
}

class Student1 {
    public String name;
    public Marks marks;
}

public class NestedJsonExample {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"Ravi\",\"marks\":{\"math\":90,\"science\":85}}";

        ObjectMapper mapper = new ObjectMapper();
        Student1 s = mapper.readValue(json, Student1.class);

        System.out.println(s.name + " scored " + s.marks.math + " in Math");
    }
}
