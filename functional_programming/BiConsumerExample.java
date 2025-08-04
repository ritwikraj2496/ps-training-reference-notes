package functional_programming;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printScore = (name, score) ->
            System.out.println(name + " scored " + score + " marks");

        printScore.accept("Ravi", 85);
    }
}

