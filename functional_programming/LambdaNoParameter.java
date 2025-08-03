package functional_programming;

interface Sayable {
    public String say(); // public void say();
}

public class LambdaNoParameter {
    public static void main(String[] args) {
        Sayable s = () -> {
            return "I have nothing to say.";
        };

        System.out.println(s.say());
    }
}