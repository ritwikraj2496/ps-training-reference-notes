# IDE and Debugging Techniques

## IntelliJ IDEA Walkthrough

**Opening or Creating a Java Project:**

1. Open IntelliJ IDEA.
2. Create New Project → Choose Java → Select SDK (e.g., Java 17) → Click Next.
3. Name your project (e.g., DemoProject) → Click Finish.
4. IntelliJ will generate the structure.

**Important Sections:**

| Section                     | Description                                                            |
| --------------------------- | ---------------------------------------------------------------------- |
| **Project Explorer (Left)** | Shows all files/folders of your project.                               |
| **Editor (Center)**         | Where you write and view code.                                         |
| **Run/Debug Tabs (Bottom)** | Shows output, error logs, variables, and breakpoints during debugging. |
| **Toolbar (Top)**           | Contains run, debug, build, VCS, etc. options.                         |

**Essential Shortcuts for Java Development**

| Shortcut             | Description                                 |
| -------------------- | ------------------------------------------- |
| `Shift` (Double Tap) | Search everything (files, classes, actions) |
| `Ctrl + N`           | Go to Class                                 |
| `Ctrl + Shift + N`   | Go to File                                  |
| `Ctrl + Alt + L`     | Auto-format code                            |
| `Ctrl + /`           | Toggle single-line comment                  |
| `Ctrl + Shift + /`   | Block comment                               |
| `Alt + Enter`        | Quick fixes, suggestions                    |
| `Ctrl + D`           | Duplicate line                              |
| `Ctrl + Y`           | Delete line                                 |
| `Shift + F10`        | Run the program                             |
| `Shift + F9`         | Debug the program                           |
| `Ctrl + Shift + F10` | Run current file                            |
| `Ctrl + Q`           | View documentation                          |
| `F2`                 | Jump to next error/warning                  |

---

## Debugging in IntelliJ IDEA – Step by Step

**Step 1: Write Sample Java Code**

```java
public class Calculator {
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public static void main(String[] args) {
        int sum = add(10, 20);
        System.out.println("Sum = " + sum);
    }
}
```

**Step 2: Add Breakpoint**

- Click in the left margin next to the line you want to debug (e.g., inside the add method).
- A red dot appears – this is a breakpoint.

**Step 3: Start Debugging**

- Right-click on main() → Click Debug
- OR use shortcut Shift + F9
- The program pauses at the breakpoint.

**Step 4: Inspect Variables**

- Hover over variables to see their values.
- Use the "Variables" panel at the bottom to explore all current variables.

**Step 5: Use Step Controls**

| Button                  | Action                                        |
| ----------------------- | --------------------------------------------- |
| ▶️ Resume (F9)          | Continue to next breakpoint                   |
| ⬇ Step Over (F8)        | Move to next line without going inside method |
| 🔽 Step Into (F7)       | Go inside the method call                     |
| ⬆ Step Out (Shift + F8) | Exit current method and go to caller          |
| ⏹ Stop                  | Stop the debugger                             |

---

## Debugging Techniques

| Technique                  | Description                                                                    |
| -------------------------- | ------------------------------------------------------------------------------ |
| **Step Over (F8)**         | Use to go line by line without entering functions.                             |
| **Step Into (F7)**         | Debug inside functions/methods for deeper inspection.                          |
| **Evaluate Expression**    | Use `Alt + F8` to evaluate or test expressions at runtime.                     |
| **Watch Variables**        | Track specific variables for value changes.                                    |
| **Conditional Breakpoint** | Right-click breakpoint → Add condition (`a == 5`) to pause only when true.     |
| **Exception Breakpoint**   | Add a breakpoint for exceptions (Run > View Breakpoints > + > Java Exception). |

---

## Troubleshooting Common Errors

| Issue                              | How to Fix                                                                                 |
| ---------------------------------- | ------------------------------------------------------------------------------------------ |
| ❌ **Build failed**                 | Click **Build > Rebuild Project**, check console for detailed message.                     |
| 🛑 **Main class not found**        | Right-click file > Set as Main class, ensure correct class is selected in Run Config.      |
| ❗**Cannot resolve symbol**         | Check for typos, import issues. Use `Alt + Enter` for suggestions.                         |
| ⚠️ **Red underlines everywhere**   | Might be SDK issue. Go to **File > Project Structure > Project SDK** and set it correctly. |
| 🧩 **Missing plugins or features** | Go to **File > Settings > Plugins** and install needed ones (e.g., Lombok, Maven, etc.).   |

---

## Practicing Debugging: Mini Exercises

**Exercise 1: Find the bug**

```java
public class Multiply {
    public static int multiply(int a, int b) {
        int result = a + b;  // ❌ Bug: should be a * b
        return result;
    }

    public static void main(String[] args) {
        int ans = multiply(5, 4);
        System.out.println("Result = " + ans);
    }
}
```

**Steps:**

1. Add breakpoint at multiply method.
2. Start debugging.
3. Use step-into (F7), inspect result.
4. Realize the logic issue.
5. Fix: change a + b → a * b.

**Exercise 2: Conditional Logic Bug – Find the Grade**

```java
public class GradeChecker {
    public static String getGrade(int marks) {
        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "Fail";
    }

    public static void main(String[] args) {
        int score = 75;
        String grade = getGrade(score);
        System.out.println("Grade = " + grade);
    }
}
```

**Task:**

- The student scored 75, but the grade printed is incorrect. Debug and fix it.

**Steps:**

1. Add a breakpoint inside getGrade() at the first if.
2. Start debugging (Shift + F9).
3. Use Step Over (F8) to walk through each condition.
4. Observe which block is being executed.
5. Inspect score and see which logic fails.
6. Realize the bug: the order of >= checks causes incorrect flow.

**Fix:**

- Change else if (marks >= 75) to else if (marks >= 75 && marks < 90).

**Example 3: Loop Counter Error – Print Sum of First N Numbers** 

```java
public class LoopSum {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;

        for (int i = 1; i <= n; i++); {  // <-- Bug: semicolon after for loop
            sum = sum + i;
        }

        System.out.println("Sum = " + sum);
    }
}
```

**Task:**

- The output is not as expected. Debug to find the mistake in the loop.

**Steps:**

1. Add breakpoint at for loop.
2. Step into or over – observe if the loop runs or skips.
3. Inspect value of sum and see if it changes.
4. Realize the loop block is empty due to semicolon.

**Fix:**

- Remove the semicolon (;) after the for loop.

```java
for (int i = 1; i <= n; i++) {
    sum = sum + i;
}
```

**Exercise 4: Calculator Division – Runtime Exception**

```java
public class Divider {
    public static int divide(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 0;
        int result = divide(x, y);
        System.out.println("Result = " + result);
    }
}
```

**Task:**

- The program crashes at runtime. Use debugging to figure out where and why.

**Steps:**

1. Add a breakpoint at divide() call.
2. Start debugging.
3. Inspect values of x and y.
4. Step into the method – see where exception occurs.
5. Understand that division by zero is the problem.

**Fix:**

- Add validation check before dividing:

```java
if (b == 0) {
    System.out.println("Cannot divide by zero");
} else {
    int result = divide(x, y);
    System.out.println("Result = " + result);
}
```
--- 

## Tips:

- Use Alt + F8 to test values while paused at breakpoints.
- Try changing input values to explore other logic paths.
- Always double-check loop boundaries, if-else chains, and arithmetic operations.
- Use Exception Breakpoints to catch runtime errors before they crash the app.

---