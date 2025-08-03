package functional_programming;

@FunctionalInterface
interface ThreeParametersFunctionalInterface {
    double calculateAverage(double a, double b, double c);
}

public class LambdaMultipleParameters {
    public static void main(String[] args) {
        // Using lambda expression to implement the calculateAverage method
        ThreeParametersFunctionalInterface myLambda = (a, b, c) -> {

            // Code to be executed with the parameters
            return (a + b + c) / 3.0;
        };

        // Invoking the method defined in the lambda expression
        double average = myLambda.calculateAverage(10.0, 20.0, 30.0);
        System.out.println("Average: " + average);
    }
}
