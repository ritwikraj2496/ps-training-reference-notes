package functional_programming;

interface Sayable3{
    public String say(String name);
}

public class LambdaSingleParameter{
    public static void main(String[] args) {

        // Lambda expression with single parameter.
        Sayable3 s1=(name)->{
            return "Hello, "+name;
        };
        System.out.println(s1.say("Sonoo"));

        // You can omit function parentheses
        Sayable3 s2= name ->{
            return "Hello, "+name;
        };

        System.out.println(s2.say("Ritwik"));
    }
}
