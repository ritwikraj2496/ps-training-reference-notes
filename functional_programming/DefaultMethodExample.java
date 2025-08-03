package functional_programming;

interface Vehicle {
    void start(); // abstract method
    default void fuelType() {
        System.out.println("Runs on diesel");
    }
}

class DefaultMethodExample implements Vehicle {
    public void start() {
        System.out.println("Car started");
    }
    public static void main(String[] args) {
        DefaultMethodExample c = new DefaultMethodExample();
        c.start();
        c.fuelType();
    }
}
