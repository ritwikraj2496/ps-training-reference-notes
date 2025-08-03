package functional_programming;

@FunctionalInterface
interface Sayable1 {
    void say(String msg);
}

public class FunctionalInterfaceExample1 implements Sayable1 {
    public void say(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctionalInterfaceExample1 fie = new FunctionalInterfaceExample1();
        fie.say("Hello there");
    }
}
