# JSON Processing in Java

## Introduction to JSON

### What is JSON?

- JSON = JavaScript Object Notation.
- It's a lightweight data format used for storing and exchanging data.
- It looks like a JavaScript object.

### Why JSON?

- Easy to read and write (human-friendly).
- Used everywhere in web APIs, configs, and data sharing.
- Language-independent.

### Example of JSON:

```json
{
  "name": "Ravi",
  "age": 25,
  "isStudent": false
}
```

### Basic Data Types in JSON:

- String → "Ravi"
- Number → 25
- Boolean → true / false
- Object → {...}
- Array → [1, 2, 3]
- null → null

---

## JSON Parsing in Java

You need to "parse" (read) JSON into Java objects.

**Popular Libraries in Java:**

- Jackson (most widely used)
- Gson (Google’s library)
- org.json (built-in, basic)

We will be using **Jackson**.

---

## Working with Jackson

**Add Jackson to your project:**

```java
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.17.0</version>
</dependency>
```

**Main classes used:**

- **ObjectMapper** – core class to read/write JSON.

---

## Converting JSON to Java & Vice Versa

### Convert Java Object ➡ JSON (Serialization)

**Why?**
To send Java data to frontend/API/another system.

**Example:**

```java
import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    public String name;
    public int age;
    public boolean isEnrolled;

    public Student(String name, int age, boolean isEnrolled) {
        this.name = name;
        this.age = age;
        this.isEnrolled = isEnrolled;
    }
}

public class SerializeExample {
    public static void main(String[] args) throws Exception {
        Student s = new Student("Anjali", 22, true);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(s);

        System.out.println(json);
    }
}
```

**Output:**
```json
{"name":"Anjali","age":22,"isEnrolled":true}
```

### Convert JSON ➡ Java Object (Deserialization)

**Why?**
To receive and work with JSON data inside your Java code.

**Example:**

```java
import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    public String name;
    public int age;
    public boolean isEnrolled;
}

public class DeserializeExample {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"Anjali\",\"age\":22,\"isEnrolled\":true}";

        ObjectMapper mapper = new ObjectMapper();
        Student s = mapper.readValue(json, Student.class);

        System.out.println(s.name + " - " + s.age);
    }
}
```

**Output:**
```
Anjali - 22
```

---

## Handling JSON Arrays & Complex Data Structures

### Handling JSON Arrays

**What if JSON has an array of objects?**

JSON Input:

```json
[
  {"name": "Ravi", "age": 20},
  {"name": "Priya", "age": 23}
]
```

Java Code:

```java
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

class Student {
    public String name;
    public int age;
}

public class JsonArrayExample {
    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"Ravi\",\"age\":20}, {\"name\":\"Priya\",\"age\":23}]";

        ObjectMapper mapper = new ObjectMapper();
        List<Student> students = mapper.readValue(json, new TypeReference<List<Student>>() {});

        for (Student s : students) {
            System.out.println(s.name + " - " + s.age);
        }
    }
}
```

Output:
```
Ravi - 20  
Priya - 23
```

### Complex JSON (Nested Objects)

JSON Input:

```json
{
  "name": "Ravi",
  "marks": {
    "math": 90,
    "science": 85
  }
}
```

Java Code:

```java
class Marks {
    public int math;
    public int science;
}

class Student {
    public String name;
    public Marks marks;
}

public class NestedJsonExample {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\":\"Ravi\",\"marks\":{\"math\":90,\"science\":85}}";

        ObjectMapper mapper = new ObjectMapper();
        Student s = mapper.readValue(json, Student.class);

        System.out.println(s.name + " scored " + s.marks.math + " in Math");
    }
}
```

Output:
```
Ravi scored 90 in Math
```

### JSON to Map and Map to JSON

**Sometimes we don’t want a class – just a flexible key-value map.**

```java
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
```

Convert Map to JSON:

```java
Map<String, Object> data = new HashMap<>();
data.put("course", "Java");
data.put("duration", 30);

String jsonOutput = mapper.writeValueAsString(data);
System.out.println(jsonOutput);
```

---

## Summary

| Task | Jackson Method |
| --------- | ---------- |
| Java ➡ JSON | writeValueAsString(obj) |
| JSON ➡ Java | readValue(json, Class) |
| JSON Array ➡ List | readValue(json, new TypeReference) |
| JSON ➡ Map | readValue(json, Map.class) |
| Nested Object | Use nested Java classes |

---

## Important Note:-

### Jackson needs a default (no-argument) constructor to deserialize JSON into a Java object

When Jackson tries to deserialize:

```java
Student s = mapper.readValue(json, Student.class);
```

It needs to do:

1. new Student() ← This fails if no default constructor exists.
2. Then it sets the fields (name, age, etc.) using setters or direct access.

If you do not define any constructor in your Student class, Java provides a default one — only if you don't define any constructor.

But if your earlier version (with parameterized constructor) still exists or was compiled, Jackson will fail without the no-arg constructor.

---