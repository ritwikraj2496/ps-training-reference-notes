package functional_programming;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> greet = name -> System.out.println("Hello, " + name);
        greet.accept("Ritwik");
    }
}

