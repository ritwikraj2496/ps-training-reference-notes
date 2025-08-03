package functional_programming;

interface Drawable1 {
    public void draw();
}

public class LambdaExpressionExample1 {
    public static void main(String[] args) {
        int width = 10;

        // Drawable implementation using anonymous class
        Drawable1 d = () -> System.out.println("Drawing " + width);
        d.draw();
    }
}
