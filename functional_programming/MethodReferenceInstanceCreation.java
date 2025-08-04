package functional_programming;

class Employee {
    private int id;
    private String name;

    public Employee() {
        this.id = 101;
        this.name = "Default Name";
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
}

@FunctionalInterface
interface EmployeeFactory {
    Employee create();
}

public class MethodReferenceInstanceCreation {
    public static void main(String[] args) {
        EmployeeFactory factory = Employee::new;  // Constructor reference
        Employee emp = factory.create();
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
    }
}

