package functional_programming;

@FunctionalInterface
interface Printer {
    void print();
}

class Message {
    public static void show() {
        System.out.println("Hello from method reference!");
    }
}

public class MethodReferenceStaticMethods {
    public static void main(String[] args) {
        Printer printer = Message::show;
        printer.print(); //Hello from method reference!
    }
}

