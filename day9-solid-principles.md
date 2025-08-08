# Introduction – What is SOLID?

**What:**

- SOLID is a set of five design principles for writing clean, understandable, and maintainable object-oriented code.

**Why we need it:**

- Helps us avoid messy, hard-to-change code.
- Makes code easier to extend without breaking existing features.
- Improves team collaboration – everyone can understand the design.

**The Five Principles:**

S – Single Responsibility Principle (SRP)

O – Open/Closed Principle (OCP)

L – Liskov Substitution Principle (LSP)

I – Interface Segregation Principle (ISP)

D – Dependency Inversion Principle (DIP)

- Think of SOLID as rules for “good manners” in coding – follow them and your code won’t annoy future you or your teammates.

---

## S – Single Responsibility Principle (SRP)

**What:**

- A class should do only one thing and have one reason to change.
- If your class is doing too many jobs, it becomes complicated and hard to maintain.

**Why:**

- Easier to understand.
- Fewer bugs when you change something.
- Testing becomes simpler.

**How it works:**

- Split different responsibilities into separate classes.
- Example: Don’t mix “data calculation” and “file saving” in the same class.

**Example 1 – Bad vs Good**

- Bad

```java
class Invoice {
    void calculateTotal() { /* logic */ }
    void saveToDatabase() { /* logic */ }
}
```

*Note: One class is doing calculation + database work.*

- Good

```java
class InvoiceCalculator {
    void calculateTotal() { /* logic */ }
}

class InvoiceRepository {
    void saveToDatabase() { /* logic */ }
}
```

*Note: Now each class has one job.*

**Example 2 – Notification Service**

- Bad

```java
class NotificationService {
    void sendEmail() { /* send email */ }
    void logNotification() { /* write logs */ }
}
```

*Note: Two responsibilities – sending + logging.*

- Good

```java
class EmailSender {
    void sendEmail() { /* send email */ }
}

class NotificationLogger {
    void logNotification() { /* write logs */ }
}
```

*Note: Easy to maintain and test.*

---

## O – Open/Closed Principle (OCP)

**What:**

- Classes should be open for extension, but closed for modification.
- Meaning – you should be able to add new features without changing existing code.

**Why:**

- Prevents breaking existing functionality.
- Reduces risk when adding new features.

**How it works:**

- Use interfaces, abstract classes, and inheritance so new behaviour can be added without touching old code.

**Example 1 – Shape Area Calculation**

- Bad:

```java
class AreaCalculator {
    double calculate(Object shape) {
        if (shape instanceof Circle) { /* circle area */ }
        else if (shape instanceof Square) { /* square area */ }
        return 0;
    }
}
```

*Note: Adding a new shape means modifying this class.*


- Good:

```java
interface Shape {
    double area();
}

class Circle implements Shape {
    public double area() { /* circle area */ }
}

class Square implements Shape {
    public double area() { /* square area */ }
}

class AreaCalculator {
    double calculate(Shape shape) {
        return shape.area();
    }
}
```

*Note: Add new shapes by extending, not changing.*

**Example 2 – Payment System**

- Bad:

```java
class PaymentProcessor {
    void process(String type) {
        if (type.equals("CreditCard")) { /* ... */ }
        else if (type.equals("PayPal")) { /* ... */ }
    }
}
```

*Note: Adding another payment type means modifying code.*

- Good:

```java
interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    public void pay() { /* credit card logic */ }
}

class PayPalPayment implements Payment {
    public void pay() { /* PayPal logic */ }
}

class PaymentProcessor {
    void process(Payment payment) {
        payment.pay();
    }
}
```

*Note: Easily add new payment methods without touching PaymentProcessor.*

---

## L – Liskov Substitution Principle (LSP)

**What:**

- Subclasses should be replaceable with their parent class without breaking the program.
- If something works with a parent type, it should also work if you use any of its children without breaking anything.

**Why:**

- Prevents surprises in behaviour.
- Ensures code works with both base and derived classes.

**How it works:**

- A subclass should follow the rules of the parent class and not change expected behaviour.
- Child classes should behave like their parent without surprises.

**Example 1 – Bird Problem**

- Bad:

```java
class Bird {
    void fly() { /* flying */ }
}

class Ostrich extends Bird {
    void fly() { throw new UnsupportedOperationException(); }
}
```

*Note: Ostrich can’t fly – breaks expectations.*

- Good:

```java
class Bird { }

class FlyingBird extends Bird {
    void fly() { /* flying */ }
}

class Ostrich extends Bird {
    void walk() { /* walking */ }
}
```

*Note: Separate flying and non-flying birds.*

**Example 2 – Rectangle/Square**

- Bad:

```java
class Rectangle {
    void setWidth(int w) { /* ... */ }
    void setHeight(int h) { /* ... */ }
}

class Square extends Rectangle {
    // overrides setWidth/Height in unexpected ways
}
```

*Note: Square changes expected rectangle behaviour.*

- Good:

```java
interface Shape {
    int area();
}

class Rectangle implements Shape { /* ... */ }
class Square implements Shape { /* ... */ }
```

*Note: Treat them as separate shapes.*

---

## I – Interface Segregation Principle (ISP)

**What:**

- Don’t force classes to implement methods they don’t use.
- Prefer many small, specific interfaces over one big interface.
- Don’t force someone to use features they don’t need — give them only the tools they’ll actually use.

**Why:**

- Classes stay clean.
- Less confusion for implementers.
- Many small toolboxes are better than one heavy, cluttered toolbox.

**How it works:**

- Break large interfaces into smaller, role-specific ones.

**Example 1 – Bad vs Good Printer Interface**

- Bad:

```java
interface Printer {
    void print();
    void scan();
    void fax();
}

class SimplePrinter implements Printer {
    public void print() { /* ok */ }
    public void scan() { /* not needed */ }
    public void fax() { /* not needed */ }
}
```

- Good:

```java
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class SimplePrinter implements Printer {
    public void print() { /* ok */ }
}
```

**Example 2 – Payment Interfaces**

- Bad:

```java
interface Payment {
    void payOnline();
    void payOffline();
}

class OnlinePayment implements Payment {
    public void payOnline() { /* ok */ }
    public void payOffline() { /* useless */ }
}
```

- Good:

```java
interface OnlinePay {
    void payOnline();
}

interface OfflinePay {
    void payOffline();
}
```

---

## D – Dependency Inversion Principle (DIP)

**What:**

- Depend on abstractions (interfaces), not concrete classes.
- High-level modules shouldn’t depend on low-level modules – both should depend on abstractions.
- Rely on plans, not on the people building them — so you can change the builder without changing the plan."

**Why:**

- Makes code flexible.
- Easy to change implementation without affecting other parts.

**How it works:**

- Write code to work with interfaces, not specific classes.
- Work with ideas, not fixed things, so you can swap the details anytime.

**Example 1 – Message Sending**

- Bad:

```java
class EmailService {
    void sendEmail() { /* email logic */ }
}

class Notification {
    private EmailService emailService = new EmailService();
}
```

*Note: Notification is tightly bound to EmailService.*

- Good:

```java
interface MessageService {
    void sendMessage();
}

class EmailService implements MessageService {
    public void sendMessage() { /* email logic */ }
}

class Notification {
    private MessageService service;
    Notification(MessageService service) {
        this.service = service;
    }
}
```

*Note: Can use Email, SMS, or any other service.*

**Example 2 – Payment Processing**

- Bad:

```java
// Low-level module (Concrete class)
class CreditCardPayment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

// High-level module directly depends on a concrete class
class PaymentProcessor {
    private CreditCardPayment payment = new CreditCardPayment(); // ❌ Locked to CreditCard

    public void process(double amount) {
        payment.pay(amount);
    }
}

// Demo
public class BadDIPExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.process(5000); // Works only with CreditCardPayment
    }
}
```

*Note:* 

- *Locked to one payment type.*
- *Tightly coupled: PaymentProcessor is stuck with CreditCardPayment.*
- *If you need UPIPayment or PayPalPayment, you have to edit PaymentProcessor code (violates Open/Closed Principle too).*

- Good:

```java
// Abstraction
interface Payment {
    void pay(double amount);
}

// Low-level modules (Implementations)
class CreditCardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI.");
    }
}

// High-level module depends on abstraction
class PaymentProcessor {
    private Payment payment;

    // Inject the Payment dependency (Constructor Injection)
    public PaymentProcessor(Payment payment) {
        this.payment = payment;
    }

    public void process(double amount) {
        payment.pay(amount);
    }
}

// Demo
public class GoodDIPExample {
    public static void main(String[] args) {
        // We can swap payment method without touching PaymentProcessor code
        PaymentProcessor processor1 = new PaymentProcessor(new CreditCardPayment());
        processor1.process(5000);

        PaymentProcessor processor2 = new PaymentProcessor(new UPIPayment());
        processor2.process(2000);
    }
}
```

*Note:*

- *Pass any Payment implementation.*
- *Loose coupling: PaymentProcessor doesn’t know the payment type details.*
- *Easy to extend: Add PayPalPayment tomorrow without changing PaymentProcessor.*
- *Test-friendly: You can inject a mock payment method for unit testing.*

---

## Production Level / Standard Code Example:

```java
solid-principles-demo/
│
├── src/
│   ├── models/
│   │   ├── Order.java                // SRP example (Single Responsibility)
│   │   ├── Product.java               // SRP helper class
│   │   ├── Customer.java              // SRP helper class
│   │
│   ├── services/
│   │   ├── OrderService.java          // SRP + OCP example
│   │   ├── PaymentService.java        // DIP example (depends on interface)
│   │   ├── NotificationService.java   // DIP + ISP example
│   │
│   ├── payment/
│   │   ├── PaymentProcessor.java      // Interface for DIP
│   │   ├── CreditCardPayment.java     // OCP example (new payment method)
│   │   ├── PaypalPayment.java         // OCP example (another payment method)
│   │
│   ├── notification/
│   │   ├── EmailNotifier.java         // ISP example (implements specific interface)
│   │   ├── SmsNotifier.java           // ISP example (implements specific interface)
│   │
│   ├── interfaces/
│   │   ├── Notifier.java              // ISP example
│   │   ├── PaymentProcessor.java      // DIP abstraction
│   │
│   ├── utils/
│   │   ├── OrderValidator.java        // SRP example (validation separated)
│   │
│   ├── MainApp.java                   // Entry point - ties everything together
│
├── README.md
└── pom.xml                            // Maven config (or build.gradle if Gradle)
```

**How it maps to SOLID:**

- S (Single Responsibility) → Order.java, OrderService.java, OrderValidator.java (Each class has one reason to change)
- O (Open/Closed) → CreditCardPayment.java, PaypalPayment.java (Add payment types without modifying existing code)
- L (Liskov Substitution) → Any PaymentProcessor implementation can replace another without breaking code
- I (Interface Segregation) → Notifier.java allows separate interfaces for Email/SMS instead of one big notification interface
- D (Dependency Inversion) → OrderService depends on PaymentProcessor abstraction, not concrete payment classes

---