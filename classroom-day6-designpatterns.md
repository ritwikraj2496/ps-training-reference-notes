# Design Patterns

## What are Design Patterns?

- Design patterns are proven solutions to common problems in software design.
- They are like templates that can be reused in different projects.

In simple words:
- Think of them like blueprints for solving coding problems.
- Just like architects use building blueprints, developers use design patterns to write organized, reusable, and reliable code.

## Why do we need Design Patterns?

- Software projects often face recurring problems (object creation, communication between classes, code organization).
- Without patterns, developers may reinvent the wheel and end up with messy, duplicated, or hard-to-maintain code.

Benefits of Design Patterns:

1. Reusability → Same solution can be applied in many projects.
2. Readability → Other developers understand the code quickly.
3. Scalability → Easy to extend when requirements change.
4. Maintainability → Bugs can be fixed faster and code is easier to update.

## GOF (Gang of Four) Design Patterns

- The term comes from the famous book “Design Patterns: Elements of Reusable Object-Oriented Software” (1994) written by four authors.
- It introduced 23 patterns, classified into 3 groups:

1. Creational Patterns → Deal with object creation (e.g., Singleton, Factory, Builder).
   - Helps in creating objects in a controlled, flexible way instead of using direct new.
   - Examples: Singleton, Factory, Builder, Prototype.

2. Structural Patterns → Deal with class/object composition (e.g., Adapter, Decorator, Composite).
   - Helps organize relationships between classes/objects to make systems flexible and efficient.
   - Examples: Adapter, Decorator, Facade, Composite.

3. Behavioral Patterns → Deal with communication between objects (e.g., Observer, Strategy, Command).
   - Focuses on how objects interact and communicate.
   - Examples: Observer, Strategy, Command, Iterator.

## Hands-On Examples on Design Patterns

### Singleton Pattern (Creational)

**What is it?**

- Ensures only one object of a class is created throughout the program.
- Provides a global point of access to that object.

**Why?**

- Useful when we want only one shared resource, e.g., logging system, configuration, database connection.

**How it works?**

- Class constructor is made private.
- Provides a static method to get the single instance.

**Example 1: Logger**

```java
class Logger {
    private static Logger instance;  // single instance

    private Logger() {} // private constructor

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");
        System.out.println(logger1 == logger2); // true (same object)
    }
}
```

**Example 2: Database Connection**

```java
class Database {
    private static Database connection;

    private Database() {
        System.out.println("Connected to DB!");
    }

    public static Database getConnection() {
        if (connection == null) {
            connection = new Database();
        }
        return connection;
    }
}

public class Main {
    public static void main(String[] args) {
        Database db1 = Database.getConnection();
        Database db2 = Database.getConnection();

        System.out.println(db1 == db2); // true (same object)
    }
}
```

### Factory Pattern (Creational)

**What is it?**

- Provides a way to create objects without exposing the creation logic.
- Instead of new, we use a factory method.

**Why?**

- When we need to create different types of objects but keep the code flexible and loosely coupled.
- Example: UI library (buttons, textboxes), shape creation, payment gateways.

**How it works?**

- A Factory class decides which object to return, based on input.

**Example 1: Shape Factory**

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape {
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ShapeFactory {
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) return new Circle();
        if (type.equalsIgnoreCase("square")) return new Square();
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape1 = factory.getShape("circle");
        Shape shape2 = factory.getShape("square");

        shape1.draw(); // Drawing Circle
        shape2.draw(); // Drawing Square
    }
}
```

**Example 2: Payment Factory**

```java
interface Payment {
    void pay(int amount);
}

class CreditCard implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPI implements Payment {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class PaymentFactory {
    public Payment getPayment(String method) {
        if (method.equalsIgnoreCase("credit")) return new CreditCard();
        if (method.equalsIgnoreCase("upi")) return new UPI();
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentFactory factory = new PaymentFactory();
        Payment pay1 = factory.getPayment("credit");
        Payment pay2 = factory.getPayment("upi");

        pay1.pay(1000);
        pay2.pay(500);
    }
}
```

### Builder Pattern (Creational)

**What is it?**

- Used to construct complex objects step by step.
- Instead of a huge constructor with many parameters, we build an object in parts.

**Why?**

- Makes object creation flexible, readable, and manageable.
- Especially useful when an object has many optional fields.

**Example 1: Building a Burger**

```java
class Burger {
    private String bread;
    private String patty;
    private String cheese;
    private String sauce;

    private Burger(Builder builder) {
        this.bread = builder.bread;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.sauce = builder.sauce;
    }

    public String toString() {
        return "Burger with " + bread + ", " + patty + ", " + cheese + ", " + sauce;
    }

    static class Builder {
        private String bread;
        private String patty;
        private String cheese;
        private String sauce;

        public Builder bread(String bread) { this.bread = bread; return this; }
        public Builder patty(String patty) { this.patty = patty; return this; }
        public Builder cheese(String c**heese) { this.cheese = cheese; return this; }
        public Builder sauce(String sauce) { this.sauce = sauce; return this; }

        public Burger build() { return new Burger(this); }
    }
}

public class Main {
    public static void main(String[] args) {
        Burger burger = new Burger.Builder()
                          .bread("Wheat")
                          .patty("Chicken")
                          .cheese("Cheddar")
                          .sauce("Mayo")
                          .build();

        System.out.println(burger);
    }
}
```

**Example 2: Building a Computer**

```java
class Computer {
    private String cpu;
    private String ram;
    private String storage;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + "]";
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;

        public Builder cpu(String cpu) { this.cpu = cpu; return this; }
        public Builder ram(String ram) { this.ram = ram; return this; }
        public Builder storage(String storage) { this.storage = storage; return this; }
        public Computer build() { return new Computer(this); }
    }
}

public class Main {
    public static void main(String[] args) {
        Computer comp = new Computer.Builder()
                           .cpu("Intel i7")
                           .ram("16GB")
                           .storage("512GB SSD")
                           .build();

        System.out.println(comp);
    }
}
```

### Prototype Pattern (Creational)

**What is it?**

- Creates a new object by cloning an existing object.
- Instead of building from scratch, we copy a ready-made object.

**Why?**

- Saves time and resources when object creation is expensive.
-Useful when creating similar objects with small modifications.

**Example 1: Cloning a Document**

```java
class Document implements Cloneable {
    String content;

    Document(String content) { this.content = content; }

    public Document clone() {
        try {
            return (Document) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Document doc1 = new Document("Report Template");
        Document doc2 = doc1.clone();

        System.out.println(doc1.content); // Report Template
        System.out.println(doc2.content); // Report Template
    }
}
```

**Example 2: Game Character Clone**

```java
class Character implements Cloneable {
    String name;
    int power;

    Character(String name, int power) {
        this.name = name; this.power = power;
    }

    public Character clone() {
        try { return (Character) super.clone(); }
        catch (CloneNotSupportedException e) { return null; }
    }

    public String toString() {
        return name + " [Power: " + power + "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Character hero = new Character("Warrior", 100);
        Character cloneHero = hero.clone();

        System.out.println(hero);
        System.out.println(cloneHero);
    }
}
```

### Adapter Pattern (Structural)

**What is it?**

- Works as a bridge between two incompatible interfaces.
- Converts one interface into another so classes can work together.

**Why?**

- Useful when integrating legacy code with new systems.
- Example: Mobile charger adapter (different plugs, same output).

**Example 1: Mobile Charger Adapter**

```java
interface Charger {
    void charge();
}

class OldCharger {
    void oldCharge() {
        System.out.println("Charging with old charger...");
    }
}

class ChargerAdapter implements Charger {
    OldCharger oldCharger = new OldCharger();

    public void charge() {
        oldCharger.oldCharge(); // adapting
    }
}

public class Main {
    public static void main(String[] args) {
        Charger charger = new ChargerAdapter();
        charger.charge();
    }
}
```

**Example 2: Media Player Adapter**

```java
interface MediaPlayer {
    void play(String filename);
}

class MP3Player implements MediaPlayer {
    public void play(String filename) {
        System.out.println("Playing MP3: " + filename);
    }
}

class MP4Player {
    void playMP4(String filename) {
        System.out.println("Playing MP4: " + filename);
    }
}

class MediaAdapter implements MediaPlayer {
    MP4Player mp4 = new MP4Player();

    public void play(String filename) {
        mp4.playMP4(filename);
    }
}

public class Main {
    public static void main(String[] args) {
        MediaPlayer player1 = new MP3Player();
        MediaPlayer player2 = new MediaAdapter();

        player1.play("song.mp3");
        player2.play("video.mp4");
    }
}
```

### Decorator Pattern (Structural)

**What is it?**

- Allows adding new features to an object dynamically without changing its structure.
- Wraps an object inside another object.

**Why?**

- Useful for extending object behavior without modifying original code.
- Example: Coffee shop → Add milk, add sugar, add cream.

**Example 1: Coffee Shop**

```java
interface Coffee {
    String getDescription();
    double getCost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }
    public double getCost() { return 50; }
}

class MilkDecorator implements Coffee {
    Coffee coffee;
    MilkDecorator(Coffee coffee) { this.coffee = coffee; }

    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double getCost() { return coffee.getCost() + 10; }
}

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " = Rs." + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " = Rs." + coffee.getCost());
    }
}
```

**Example 2: Text Formatting**

```java
interface Text {
    String format();
}

class PlainText implements Text {
    public String format() { return "Hello World"; }
}

class BoldDecorator implements Text {
    Text text;
    BoldDecorator(Text text) { this.text = text; }

    public String format() { return "<b>" + text.format() + "</b>"; }
}

public class Main {
    public static void main(String[] args) {
        Text msg = new PlainText();
        System.out.println(msg.format());

        msg = new BoldDecorator(msg);
        System.out.println(msg.format());
    }
}
```

### Observer Pattern (Behavioral)

**What is it?**

- A publisher-subscriber model.
- When one object changes, all dependent objects are notified automatically.

**Why?**

- Useful when multiple objects need to react to changes in one object.
- Example: Notification systems, stock market updates, chat apps.

**How it works?**

- Subject → Holds list of observers and notifies them.
- Observers → Subscribe to subject and get updates.

**Example 1: News Publisher**

```java
import java.util.*;

interface Observer {
    void update(String news);
}

class Subscriber implements Observer {
    String name;
    Subscriber(String name) { this.name = name; }

    public void update(String news) {
        System.out.println(name + " received: " + news);
    }
}

class NewsPublisher {
    private List<Observer> subscribers = new ArrayList<>();

    public void addSubscriber(Observer o) { subscribers.add(o); }
    public void notifyAll(String news) {
        for (Observer o : subscribers) {
            o.update(news);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NewsPublisher publisher = new NewsPublisher();

        Observer s1 = new Subscriber("Alice");
        Observer s2 = new Subscriber("Bob");

        publisher.addSubscriber(s1);
        publisher.addSubscriber(s2);

        publisher.notifyAll("Breaking News: Java is awesome!");
    }
}
```

**Example 2: Stock Price Update**

```java
import java.util.*;

interface StockObserver {
    void update(double price);
}

class Investor implements StockObserver {
    String name;
    Investor(String name) { this.name = name; }

    public void update(double price) {
        System.out.println(name + " notified: Stock price is " + price);
    }
}

class Stock {
    private List<StockObserver> observers = new ArrayList<>();
    private double price;

    public void addObserver(StockObserver o) { observers.add(o); }

    public void setPrice(double price) {
        this.price = price;
        for (StockObserver o : observers) {
            o.update(price);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();

        stock.addObserver(new Investor("John"));
        stock.addObserver(new Investor("Emma"));

        stock.setPrice(100.5);
        stock.setPrice(102.3);
    }
}
```

### Iterator Pattern (Behavioral)

**What is it?**

- Provides a way to access elements of a collection sequentially without exposing the internal structure.

**Why?**

- Useful when you want to loop through different data structures (lists, sets) in a consistent way.

**Example 1: Book Collection (Java)**

```java
import java.util.*;

class Book {
    String title;
    Book(String title) { this.title = title; }
    public String toString() { return title; }
}

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Java Basics"));
        books.add(new Book("Design Patterns"));

        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
```

**Example 2: Custom Iterator**

```java
class NameCollection {
    String[] names = {"Alice", "Bob", "Charlie"};

    public Iterator getIterator() {
        return new Iterator();
    }

    class Iterator {
        int index = 0;

        public boolean hasNext() {
            return index < names.length;
        }

        public String next() {
            if (hasNext()) return names[index++];
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        NameCollection collection = new NameCollection();
        NameCollection.Iterator it = collection.getIterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
```