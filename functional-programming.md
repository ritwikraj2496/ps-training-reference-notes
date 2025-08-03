# Functional Style Java - Default Methods

## What is a Default Method?

In Java, an interface can now have methods with a body using the default keyword. These methods are not abstract and do not force implementation in the implementing class.

## Why use Default Methods?

Default methods allow interface designers to add new methods to interfaces without breaking existing implementations. This is useful in evolving APIs like Java Collections.

### Syntax:

```java
interface MyInterface {
    default void show() {
        System.out.println("This is a default method");
    }
}
```

### Example:

```java
interface Vehicle {
    void start(); // abstract method
    default void fuelType() {
        System.out.println("Runs on diesel");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started");
    }
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c.fuelType();
    }
}
```

#### Output:

```
Car started
Runs on diesel
```

---

# Functional Interfaces

Let's understand What and Why of Functional Interfaces, look at the example given below:

```java
interface Drawable{
    public void draw();
}

public class LambdaExpressionExample {
    public static void main(String[] args) {
        int width=10;

        //Drawable implementation using anonymous class
        Drawable d=new Drawable(){
            public void draw(){System.out.println("Drawing "+width);}
        };

        d.draw();
    }
}
```

- Output of the above code will be "Drawing 10", but it is quite verbose.
- It works because we are using an anonymous class to implement the Drawable interface, and hence constructor gives approval to create the object of the interface.
- If we add one more declared method in the interface, we need to implement that method as well, which makes the code more verbose, for example:

```java
interface Drawable{
    public void draw();
    public void color(); // New method added
}

public class LambdaExpressionExample {
    public static void main(String[] args) {
        int width=10;

        //Drawable implementation using anonymous class
        Drawable d=new Drawable(){
            public void draw(){System.out.println("Drawing "+width);}
            public void color(){System.out.println("Coloring the drawing");} // Implementing new method
        };

        d.draw();
    }
}
```

- Output of the above code will be "Drawing 10 Coloring the drawing", but now we have to implement the new method as well, which makes the code more verbose.
- let's make the code less verbose using functional interfaces and lambda expressions, for example:

```java
interface Drawable{
    public void draw();
}

public class LambdaExpressionExample {
    public static void main(String[] args) {
        int width=10;

        //Drawable implementation using anonymous class
        Drawable d = () -> System.out.println("Drawing "+width);
        d.draw();
    }
}
```

- Output of the above code will be "Drawing 10", but now we are using a functional interface and lambda expression to implement the interface, which makes the code less verbose and more readable.
- but now we won't be able to add any new methods to the interface, because if we do that, we will have to implement that method as well, and we won't be able to do that using lambda expression, because lambda expression can only implement one abstract method, which is the functional interface.

Hence, **we can say that a functional interface is an interface that that contains exactly one abstract method**, and _it can have any number of default methods, static methods, but can contain only one abstract method. It can also declare methods of object class._

**Functional Interface** is also known as **Single Abstract Method Interfaces or SAM Interfaces**. It is a new feature in Java, that helps to achieve functional programming approach.

### Example:

```java
@FunctionalInterface
interface sayable{
    void say(String msg);
}

public class FunctionalInterfaceExample implements sayable{
    public void say(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctionalInterfaceExample fie = new FunctionalInterfaceExample();
        fie.say("Hello there");
    }
}
```

#### Output:

```
Hello there
```

In the following example, a functional interface is extending to a non-functional interface.

```java
interface Doable{
    default void doIt(){
        System.out.println("Do it now");
    }
}

@FunctionalInterface
interface Sayable extends Doable{
    void say(String msg);   // abstract method
}

public class FunctionalInterfaceExample3 implements Sayable{
    public void say(String msg){
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctionalInterfaceExample3 fie = new FunctionalInterfaceExample3();
        fie.say("Hello there");
        fie.doIt();
    }
}
```

#### Output:

```
Hello there
Do it now
```

---

# Lambda Syntax & Using Lambdas

## What is a Lambda Expression?

A Lambda Expression is a short block of code which takes in parameters and returns a value. It provides a clear and concise way to implement a method from a functional interface.

## Why use Lambdas?

- Reduces boilerplate code.
- Brings functional programming to Java.
- Makes code more readable.

## Syntax:

```java
(parameter1, parameter2) -> { body }
```

### Java lambda expression consists of the following three components:

- Argument-list: It can be empty or non-empty as well.
- Arrow-token: It is used to link the arguments list and body of expression.
- Body: It contains expressions and statements for lambda expression.

**Note:**

- If there's one parameter, parentheses are optional.
- If body has one line, braces are optional.

1. No Parameter Syntax :-

```java
() -> {
//Body of no parameter lambda
}
```

2. One Parameter Syntax :-

```java
(p1) -> {
//Body of single parameter lambda
}
```

3. Two Parameter Syntax :-

```java
(p1,p2) -> {
//Body of multiple parameter lambda
}
```

## Interface Without Lambda Expression:

```java
interface Addable {
    int add(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Addable ad = new Addable() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        System.out.println(ad.add(10, 20)); // Output: 30
    }
}
```

#### Output:

```
30
```

## Interface With Lambda Expression:

```java
interface Addable {
    int add(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        Addable ad = (a, b) -> a + b;
        System.out.println(ad.add(10, 20));
    }
}
```

#### Output:

```
30
```

## Lambda Expression Complex Example:

```java
import java.util.Arrays;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {

        // Create a list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Example 1: Using forEach with a lambda expression
        System.out.println("Example 1: Using forEach");
        numbers.forEach(number -> System.out.print(number + " "));
        System.out.println();  // New line for better output formatting

        // Example 2: Using map and reduce to calculate the sum of squares
        System.out.println("Example 2: Using map and reduce");
        int sumOfSquares = numbers.stream()
                                  .map(x -> x * x)
                                  .reduce(0, Integer::sum);
        System.out.println("Sum of squares: " + sumOfSquares);

        // Example 3: Using filter to get even numbers
        System.out.println("Example 3: Using filter");
        List<Integer> evenNumbers = numbers.stream()
                                          .filter(x -> x % 2 == 0)
                                          .toList();  // Convert stream to list (Java 16+)
        System.out.println("Even numbers: " + evenNumbers);
    }
}
```

#### Output:

```
Example 1: Using forEach
1 2 3 4 5 6 7 8 9 10
Example 2: Using map and reduce
Sum of squares: 385
Example 3: Using filter
Even numbers: [2, 4, 6, 8, 10]
```

## A lambda expression can have zero or any number of arguments

**Let's see some Examples:**

### Java Lambda Expression Example: No Parameter

```java
interface Sayable{
    public String say();   //public void say();
}

public class LambdaExpressionExample3{
    public static void main(String[] args) {
    Sayable s=()->{
        return "I have nothing to say.";
    };

    // Sayable s = () -> System.out.println("I have nothing to say.");
    // s.say();

    System.out.println(s.say());
    }
}
```

#### Output:

```
I have nothing to say.
```

### Java Lambda Expression Example: Single Parameter

```java
interface Sayable{
    public String say(String name);
}

public class LambdaExpressionExample4{
    public static void main(String[] args) {

        // Lambda expression with single parameter.
        Sayable s1=(name)->{
            return "Hello, "+name;
        };
        System.out.println(s1.say("Sonoo"));

        // You can omit function parentheses
        Sayable s2= name ->{
            return "Hello, "+name;
        };

        System.out.println(s2.say("Sonoo"));
    }
}
```

#### Output:

```
Hello, Sonoo
Hello, Sonoo
```

### Java Lambda Expression Example: Multiple Parameters

```java
@FunctionalInterface
interface ThreeParametersFunctionalInterface {
    double calculateAverage(double a, double b, double c);
}

public class LambdaExample{
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
```

#### Output:

```
Average: 20.0
```

### Java Lambda Expression Example: with return keyword

In Java lambda expression, if there is only one statement, you may or may not use return keyword. You must use the return keyword when the lambda expression contains multiple statements.

```java
interface Addable{
    int add(int a,int b);
}

public class LambdaExpressionExample6 {
    public static void main(String[] args) {

        // Lambda expression without return keyword.
        Addable ad1=(a,b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Lambda expression with return keyword.
        Addable ad2=(int a,int b)->{
                            return (a+b);
                            };
        System.out.println(ad2.add(100,200));
    }
}
```

#### Output:

```
30
300
```

### Java Lambda Expression Example: without return keyword

```java
interface MyFunctionalInterface {
    int add(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {

        // Lambda expression without using the return keyword
        MyFunctionalInterface addition = (a, b) -> a + b;

        // Using the lambda expression to perform addition
        int result = addition.add(5, 7);

        // Displaying the result
        System.out.println("Result of addition: " + result);
    }
}
```

#### Output:

```
Result of addition: 12
```

### Java Lambda Expression Example: Foreach Loop

```java
import java.util.*;

public class LambdaExpressionExample7{
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();

        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(  //method version of for Each loop
            (n)->System.out.println(n)
        );
    }
}
```

#### Output:

```
ankit
mayank
irfan
jai
```

#### Example:

```java
import java.util.*;

public class LambdaList {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ravi", "Priya", "Arun");
        names.forEach(name -> System.out.println("Hello " + name));
    }
}
```

#### Output:

```
Hello Ravi
Hello Priya
Hello Arun
```

### Java Lambda Expression Example: Multiple Statements

```java
@FunctionalInterface
interface Sayable{
    String say(String message);
}

public class LambdaExpressionExample8{
    public static void main(String[] args) {

        // You can pass multiple statements in lambda expression
        Sayable person = (message)-> {
            String str1 = "I would like to say, ";
            String str2 = str1 + message;
            return str2;
        };
            System.out.println(person.say("time is precious."));
    }
}
```

#### Output:

```
I would like to say, time is precious.
```

---

# Functional Descriptors & Method References

## What is a Functional Descriptor?

It is the **abstract method** signature that a functional interface defines. Lambda expressions and method references must **match this descriptor.**

Example: Runnable has void run() → Lambda must match () -> {}

## What is a Method Reference?

Instead of writing a lambda that **calls a method**, we can use :: to refer directly to an existing method.

## Why Method References?

- Even shorter and cleaner syntax.
- Better readability when just calling an existing method.

### Syntax:

```java
ClassName::methodName
```

### Example:

```java
import java.util.*;

public class MethodRefExample {
    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("One", "Two", "Three");
        list.forEach(MethodRefExample::printMsg); // it's going to work only with static method, because of normal method we need to use object
    }
}
```

#### Output:

```
One
Two
Three
```

### Method Reference for Instance Creation:

```java
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

public class MethodReferenceInstanceDemo {
    public static void main(String[] args) {
        EmployeeFactory factory = Employee::new;  // Constructor reference
        Employee emp = factory.create();
        System.out.println("ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());
    }
}
```

#### Output:

```
ID: 101
Name: Default Name
```

---

# Types of Predefined Functional Interfaces/Choosing Functional Interfaces

Java offers a number of function interfaces, and developers can even define their own function interfaces to suit their specific needs.

| Interface         | Description                                                                       |
| ----------------- | --------------------------------------------------------------------------------- |
| Consumer<T>       | It represents an operation that accepts a single argument and returns no result   |
| BiConsumer<T,U>   | It represents an operation that accepts two input arguments and returns no result |
| Function<T,R>     | It represents a function that accepts one argument and returns a result           |
| BiFunction<T,U,R> | It represents a function that accepts two arguments and returns a a result        |
| Predicate<T>      | It represents a predicate (boolean-valued function) of one argument               |
| BiPredicate<T,U>  | It represents a predicate (boolean-valued function) of two argument               |

## Consumer<T>

**What:**
Takes a single input and performs an action — does not return anything.

**Use Case:**
Printing, modifying state, logging, etc.

**Example:**

```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> greet = name -> System.out.println("Hello, " + name);
        greet.accept("Ritwik");
    }
}
```

**Output:**

```
Hello, Ritwik
```

## BiConsumer<T, U>

**What:**
Takes two inputs, performs an action — no return.

**Use Case:**
Key-value printing, pair-wise operations.

**Example:**

```java
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printScore = (name, score) ->
            System.out.println(name + " scored " + score + " marks");

        printScore.accept("Ravi", 85);
    }
}
```

**Output:**

```
Ravi scored 85 marks
```

## Function<T, R>

**What:**
Takes an input T and returns a result R.

**Use Case:**
Conversion, mapping, transformation.

**Example:**

```java
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> getLength = str -> str.length();
        System.out.println(getLength.apply("Functional"));
    }
}
```

**Output:**

```
10
```

## BiFunction<T, U, R>

**What:**
Takes two inputs and returns a result.

**Use Case:**
Combining two values into one, calculations, object creation.

**Example:**

```java
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(5, 4));
    }
}
```

**Output:**

```
20
```

## Predicate<T>

**What:**
Takes one input and returns boolean.

**Use Case:**
Filtering, condition checks.

**Example:**

```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> isLong = str -> str.length() > 5;
        System.out.println(isLong.test("Hello"));      // false
        System.out.println(isLong.test("Training"));   // true
    }
}
```

**Output:**

```
false
true
```

## BiPredicate<T, U>

**What:**
Takes two inputs and returns a boolean.

**Use Case:**
Condition check between two values.

**Example:**

```java
import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<String, String> isSameLength = (a, b) -> a.length() == b.length();

        System.out.println(isSameLength.test("java", "code"));    // true
        System.out.println(isSameLength.test("hello", "worlds")); // false
    }
}
```

**Output:**

```
true
false
```

---

# Constructor References

## What is it?

Constructor reference refers to a constructor using ClassName::new. Useful when creating new objects in a functional style (e.g., with Supplier, Function, etc.).

### Example:

```java
import java.util.function.Supplier;

class Sample {
    Sample() {
        System.out.println("Constructor called!");
    }
}

public class ConstructorRef {
    public static void main(String[] args) {
        Supplier<Sample> supplier = Sample::new;
        supplier.get(); // creates object
    }
}
```

#### Output:

```
Constructor called!
```

---

# Streams API — What are Streams?

## What is a Stream?

A Stream is a sequence of data (like a pipeline) that you can perform operations on — filtering, mapping, reducing — without modifying the original data source.

## Why use Streams?

- Clean and functional style
- Enables lazy, parallel, and chained processing
- Simplifies collection manipulation

## Stream Pipeline:

1. Source → Collection, Array, I/O
2. Intermediate Ops → map, filter, sort (returns Stream)
3. Terminal Ops → forEach, collect, reduce (produces result)

## Advantages of Stream API:

| Feature              | Benefit                                     |
| -------------------- | ------------------------------------------- |
| Lazy Evaluation      | Improves performance by delaying processing |
| Parallel Processing  | Streams can run in parallel easily          |
| No Side Effects      | Promotes immutability and safer code        |
| Short, Readable Code | Less boilerplate with chaining              |

## Stream Operations:

**Intermediate Operations (do not produce final result):**

- map(): Transforms each element
- filter(): Selects based on condition
- flatMap(): Flattens nested structures

**Terminal Operations (trigger stream processing):**

- forEach(): Loops through
- collect(): Gathers results into list/set/map
- reduce(): Combines elements into single value

## Streams vs Collections:

| Feature         | Collections                                   | Streams                                        |
| --------------- | --------------------------------------------- | ---------------------------------------------- |
| Stores data?    | Yes                                           | No (operates/process on data)                  |
| Size known?     | Yes                                           | No                                             |
| Mutability      | Can be modified                               | Immutable by design                            |
| When evaluated? | Immediate                                     | Lazy (unless terminal op)                      |
| Can be reused?  | Yes                                           | No (one-time use)                              |
| Example         | List<Integer> numbers = Arrays.asList(1,2,3); | numbers.stream().forEach(System.out::println); |

## Intermediate Operations: map(), filter(), flatMap()

### map(): Transforms each item

```java
List<String> names = Arrays.asList("Ravi", "Priya");
List<String> upper = names.stream()
                          .map(String::toUpperCase)
                          .collect(Collectors.toList());
System.out.println(upper); // [RAVI, PRIYA]
```

### filter(): Selects matching items

```java
List<Integer> nums = Arrays.asList(5, 10, 15, 20);
List<Integer> evens = nums.stream()
                          .filter(n -> n % 2 == 0)
                          .collect(Collectors.toList());
System.out.println(evens); // [10, 20]
```

### flatMap(): Flattens nested structures

```java
List<List<String>> data = Arrays.asList(
    Arrays.asList("A", "B"),
    Arrays.asList("C", "D")
);
List<String> flat = data.stream()
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
System.out.println(flat); // [A, B, C, D]
```

## Terminal Operations: forEach(), collect(), reduce()

### forEach(): For printing or actions

```java
List<String> list = Arrays.asList("A", "B", "C");
list.stream().forEach(System.out::println);
```

### collect(): Gather into List/Set/Map

```java
List<String> result = Stream.of("a", "b", "c")
                            .collect(Collectors.toList());
System.out.println(result); // [a, b, c]
```

### reduce(): Combine to single result

```java
int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (a, b) -> a + b);
System.out.println(sum); // 10
```

## Numeric Streams: IntStream, LongStream, DoubleStream

**What are Numeric Streams?**

Streams with primitive types for performance and built-in numeric operations.

### IntStream.range(): Numbers in range

```java
IntStream.range(1, 5)
         .forEach(System.out::print); // 1234
```

### mapToInt(), sum(), average()

```java
List<String> words = Arrays.asList("apple", "banana");
int totalLength = words.stream()
                       .mapToInt(String::length)
                       .sum();
System.out.println(totalLength); // 11
```

### DoubleStream.average()

```java
DoubleStream prices = DoubleStream.of(9.99, 14.99, 19.99);
System.out.println(prices.average().getAsDouble()); // 14.99
```

---

# Important Notes

- **Lambda Expressions Work Only With Functional Interfaces**, A lambda expression represents an implementation of a single abstract method — which is exactly what a functional interface provides.

- **Functional interface can have default/static methods**, but still must have only one abstract method

- Cannot assign lambda to non-functional interfaces, **Compiler will throw error** — it can't infer which method the lambda is for

- **Custom/Predefined functional interfaces works** too, as long as they follow the SAM rule (Single Abstract Method)

---

# Practice Questions Solved

## Q1: Lambda Expression for Even or Odd

_Problem:_

- Define a functional interface NumberCheck with a method boolean check(int n).
- Write a lambda expression that checks whether a given number is even or odd.
- Test it with a sample number like 7.

_Solution:_

```java
@FunctionalInterface
interface NumberCheck {
    boolean check(int n);
}

public class EvenOddLambda {
    public static void main(String[] args) {
        NumberCheck isEven = (n) -> n % 2 == 0;

        int num = 7;
        if (isEven.check(num)) {
            System.out.println(num + " is even");
        } else {
            System.out.println(num + " is odd"); //7 is odd
        }
    }
}
```

## Q2: Lambda to Count Characters in a String

_Problem:_

- Create a functional interface StringLengthFinder with a method int findLength(String str).
- Use a lambda to return the number of characters in a string.
- Test with input "Lambda".

_Solution:_

```java
@FunctionalInterface
interface StringLengthFinder {
    int findLength(String str);
}

public class StringLengthDemo {
    public static void main(String[] args) {
        StringLengthFinder finder = (str) -> str.length();

        String input = "Lambda";
        System.out.println("Length of \"" + input + "\" is: " + finder.findLength(input)); //Length of "Lambda" is: 6
    }
}
```

## Q3: Method Reference to Print a Message

_Problem:_

- Define a functional interface Printer with a method void print().
- Use a method reference to bind it to a static method show() in a class Message that prints "Hello from method reference!".

_Solution:_

```java
@FunctionalInterface
interface Printer {
    void print();
}

class Message {
    public static void show() {
        System.out.println("Hello from method reference!");
    }
}

public class MethodRefStaticDemo {
    public static void main(String[] args) {
        Printer printer = Message::show;
        printer.print(); //Hello from method reference!
    }
}
```

## Q4: Lambda to Convert to Uppercase

_Problem:_

- Define a functional interface TextTransformer with method String transform(String text).
- Use a lambda expression to convert the input string to uppercase.
- Test with "java rocks".

_Solution:_

```java
@FunctionalInterface
interface TextTransformer {
    String transform(String text);
}

public class UppercaseLambda {
    public static void main(String[] args) {
        TextTransformer toUpper = (text) -> text.toUpperCase();

        String input = "java rocks";
        System.out.println("Uppercase: " + toUpper.transform(input)); //Uppercase: JAVA ROCKS
    }
}
```

## Q5: Method Reference to an Instance Method

_Problem:_

- Create a class Calculator with an instance method int square(int x).
- Define a functional interface SquareCalculator with method int calculate(int x).
- Use a method reference to the instance method, and call it with value 6.

_Solution:_

```java
@FunctionalInterface
interface SquareCalculator {
    int calculate(int x);
}

class Calculator {
    public int square(int x) {
        return x * x;
    }
}

public class MethodRefInstanceDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        SquareCalculator sq = calc::square;

        int input = 6;
        System.out.println("Square of " + input + " is: " + sq.calculate(input)); //Square of 6 is: 36
    }
}
```

---
