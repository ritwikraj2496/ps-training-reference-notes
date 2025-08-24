# Software Design Principles & Key Practices

**What Are Software Design Principles?**

- Design principles are rules or guidelines that help developers write structured, reliable, and reusable code.
- They are like the traffic rules of coding – they don’t stop you from driving, but help you drive safely and efficiently.

**Why Are They Important?**

- Keeps code organized – easy to read, easy to follow.
- Reduces bugs – cleaner code means fewer mistakes.
- Makes changes easier – when requirements change, code can adapt quickly.
- Encourages reusability – no need to rewrite the same thing again and again.
- Prevents technical debt – saves future headache by doing things right now.

**Benefits of Scalable & Maintainable Code**

A well-written program should be:

- Easier to understand – new developers can join and contribute quickly.
- Simple to modify – updates won’t break other parts of the system.
- Future-proof – supports long-term growth and changes.
- Cost-effective – saves time and money in maintenance.

---

## Three Key Principles: KISS, DRY, YAGNI

---

### KISS – Keep It Simple, Stupid

**What is it?**

KISS means – don’t overcomplicate things. Write your code as simply as possible while still solving the problem.

**Why do we need it?**

- Complicated code = more bugs.
- Simple code = easier to understand and maintain.
- Future changes become easier.

**How it works?**

- Avoid unnecessary layers, logic, or complex tricks.
- Solve the problem in the shortest and clearest way possible.

**Example 1 – Without KISS**

```java
// Overcomplicated
function isEven(num) {
    if ((num / 2) - Math.floor(num / 2) === 0) {
        return true;
    } else {
        return false;
    }
}
```

**Example 1 – With KISS**

```java
// Simple and clear
function isEven(num) {
    return num % 2 === 0;
}
```

**Example 2 – Without KISS**

```java
// Too many conditions for a simple task
if (userAge >= 18) {
    System.out.println("Eligible");
} else if (userAge < 18 && userAge >= 0) {
    System.out.println("Not Eligible");
} else {
    System.out.println("Invalid age");
}
```

**Example 2 – With KISS**

```java
if (userAge < 0) {
    System.out.println("Invalid age");
} else {
    System.out.println(userAge >= 18 ? "Eligible" : "Not Eligible");
}
```

---

### DRY – Don’t Repeat Yourself

**What is it?**

DRY means – avoid writing the same code in multiple places. Put it in one place and reuse it.

**Why do we need it?**

- Reduces errors – if something changes, you update it only once.
- Saves time – reuse instead of rewrite.
- Makes code shorter and cleaner.

**How it works?**

- Use functions, classes, or constants to store common logic.
- Reuse instead of copying and pasting.

**Example 1 – Without DRY**

```java
console.log("Hello, Ritwik!");
console.log("Hello, Anjali!");
console.log("Hello, Sam!");
```

**Example 1 – With DRY**
```java
function greet(name) {
    console.log(`Hello, ${name}!`);
}

greet("Ritwik");
greet("Anjali");
greet("Sam");
```

**Example 2 – Without DRY**

```java
int areaRect1 = length1 * width1;
int areaRect2 = length2 * width2;
int areaRect3 = length3 * width3;
```

**Example 2 – With DRY**

```java
int calculateArea(int length, int width) {
    return length * width;
}

int areaRect1 = calculateArea(length1, width1);
int areaRect2 = calculateArea(length2, width2);
int areaRect3 = calculateArea(length3, width3);
```

---

### YAGNI – You Aren’t Gonna Need It

**What is it?**

YAGNI means – don’t build something “just in case” you might need it later. Build only what is required right now.

**Why do we need it?**

- Avoids wasted effort on features nobody uses.
- Keeps the project clean and focused.
- Saves time and reduces complexity.

**How it works?**

- Focus on current requirements.
- If a feature is needed in the future, add it later.
- Don’t predict and code for imaginary scenarios.

**Example 1 – Without YAGNI**

```java
function calculatePrice(items, discountCode = null, currency = "USD", taxRate = 0.18, couponExpiryDate = null) {
    // Currently, we only use 'items' and 'taxRate'
    // Other parameters are useless right now
    let total = items.reduce((sum, item) => sum + item.price, 0);
    return total + (total * taxRate);
}
```

**Example 1 – With YAGNI**

```java
function calculatePrice(items, taxRate = 0.18) {
    let total = items.reduce((sum, item) => sum + item.price, 0);
    return total + (total * taxRate);
}
```

**Example 2 – Without YAGNI**

```java
class User {
    String name;
    String email;
    String address;
    String facebookId; // not required
    String twitterHandle; // not required
}
```

**Example 2 – With YAGNI**

```java
class User {
    String name;
    String email;
    String address; // Only storing what is needed now
}
```

---

## Quick Recap

| Principle | Meaning                          | Why Important?                               | One-line Reminder                        |
| --------- | -------------------------------- | -------------------------------------------- | ---------------------------------------- |
| **KISS**  | Keep it simple                   | Simple code = fewer bugs, easier maintenance | Don’t make it fancy, make it clear       |
| **DRY**   | Don’t repeat yourself            | Saves time, avoids mistakes                  | Write once, use everywhere               |
| **YAGNI** | Don’t build unnecessary features | Saves time, avoids complexity                | If you don’t need it now, don’t build it |

---

## Production Level / Standard Code Example:

```java
order-management/
 ├── src/main/java/com/example/order/
 │     ├── model/Order.java
 │     ├── service/OrderService.java
 │     └── App.java
 └── pom.xml
```

---