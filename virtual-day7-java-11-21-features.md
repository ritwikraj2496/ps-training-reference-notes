# Java 11 & 21 Features

## Object class

**What is Object Class?**

- Every class in Java automatically inherits from the Object class.
- It provides basic methods that all Java objects have.

1. **toString()**

- Purpose: Returns a string representation of the object.
- Why?: Helps print object details in a readable format.

```java
class Person {
    String name;
    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + name;
    }
}

public class Demo {
    public static void main(String[] args) {
        Person p = new Person("Ravi");
        System.out.println(p);  // calls p.toString()
    }
}
```

2. **equals()**

- Purpose: Compares two objects for logical equality.
- Why?: To compare content, not just memory location.

```java
class Book {
    String title;

    Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        Book other = (Book) obj;
        return this.title.equals(other.title);
    }
}

public class Demo {
    public static void main(String[] args) {
        Book b1 = new Book("Java");
        Book b2 = new Book("Java");

        System.out.println(b1.equals(b2));  // true
    }
}
```

3. **hashCode()**

- Purpose: Returns a hash code value for the object.
- Why?: Used in hashing (e.g., HashMap).
- Must override hashCode() when equals() is overridden.
- For every object, JVM generates a unique number which is a hashcode.
- It returns distinct integers for distinct objects. 

**Note:** A common misconception about this method is that the hashCode() method returns the address of the object, which is not correct. It converts the internal address of the object to an integer by using an algorithm. The hashCode() method is native because in Java it is impossible to find the address of an object, so it uses native languages like C/C++ to find the address of the object.

- Use of hashCode() method:

It returns a hash value that is used to search objects in a collection. JVM(Java Virtual Machine) uses the hashcode method while saving objects into hashing-related data structures like HashSet, HashMap, Hashtable, etc. The main advantage of saving objects based on hash code is that searching becomes easy. 

```java
@Override
public int hashCode() {
    return title.hashCode();
}
```
---

## equals() vs == in Java

1. What is ==?

- == checks reference equality.
- It tells whether two references point to the same object in memory.

2. What is equals()?

- equals() checks logical/content equality.
- It tells whether two objects have the same data/content.

3. Why is this important?

- Comparing Strings, custom objects, or wrappers using == often gives unexpected results.
- Use equals() when you care about what's inside the object.

**Example 1: Comparing Strings**

```java
public class StringExample {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");

        System.out.println(s1 == s2);       // true (same pool reference)
        System.out.println(s1 == s3);       // false (new object)
        System.out.println(s1.equals(s3));  // true (same content)
    }
}
```

- Use equals() for comparing string values.

**Example 2: Comparing Wrapper Objects**

```java
public class WrapperExample {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println(a == b);       // true (cached values between -128 to 127)
        System.out.println(c == d);       // false (outside cache range)
        System.out.println(c.equals(d));  // true (same value)
    }
}
```

- Don’t rely on == for comparing Integer, Double, etc. – use equals().

**Example 3: Custom Class without equals()**

```java
class Book {
    String title;
    Book(String title) {
        this.title = title;
    }
}

public class CompareBooks {
    public static void main(String[] args) {
        Book b1 = new Book("Java");
        Book b2 = new Book("Java");

        System.out.println(b1 == b2);       // false (different objects)
        System.out.println(b1.equals(b2));  // false (default equals is like ==)
    }
}
```

- equals() behaves like == if not overridden.

**Example 4: Custom Class with equals() Overridden**

```java
class Book {
    String title;
    Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        Book other = (Book) obj;
        return this.title.equals(other.title);
    }
}

public class CompareBooks {
    public static void main(String[] args) {
        Book b1 = new Book("Java");
        Book b2 = new Book("Java");

        System.out.println(b1 == b2);       // false
        System.out.println(b1.equals(b2));  // true (same title)
    }
}
```

- Always override equals() in custom classes to check content equality.

**Note:**

- Use == to compare primitive values or check if two references are the same object.
- Use equals() to compare actual content or values of objects.

---

## Wrapper Classes & Autoboxing

- What?
Wrapper classes convert primitives to objects: int → Integer, double → Double, etc.

- Autoboxing and Unboxing
Java automatically converts between primitive and wrapper types.

1. Autoboxing
Autoboxing is the automatic conversion of a primitive type (like int, double, char) into its corresponding wrapper class (Integer, Double, Character, etc.)

int → Integer, double → Double, char → Character, etc.

2. Unboxing
Unboxing is the automatic conversion of a wrapper class object back to its primitive type.

**Example 1:**

```java
public class Demo {
    public static void main(String[] args) {
        int a = 10;
        Integer obj = a;  // Autoboxing
        int b = obj;      // Unboxing
        System.out.println(obj + " " + b);
    }
}
```

**Why Do We Need Autoboxing and Unboxing?**

- Collections in Java (like List, Map) do not support primitive types.
- You can't use List<int> — you must use List<Integer>.
- Java handles conversion automatically, so you don’t need to write boilerplate code to convert back and forth between primitives and wrappers.

**Example 2:**

```java
import java.util.*;

public class AutoBoxingExample {
    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();

        int score = 85;

        // Autoboxing: int → Integer
        marks.add(score);

        System.out.println("Marks: " + marks);
    }
}
```

**Output:**
```
Marks: [85]
```

- Java automatically converted int score to Integer using autoboxing.

**Example 3:**

```java
public class UnboxingExample {
    public static void main(String[] args) {
        Integer num = 50;  // Autoboxing from int

        // Unboxing: Integer → int
        int result = num + 20;

        System.out.println("Total: " + result);
    }
}
```

**Output:**
```
Total: 70
```

- Java automatically converted Integer to int during addition using unboxing.

**Note:**

- Autoboxing and Unboxing make Java code cleaner and easier when working with collections or APIs that need objects.
- It reduces the need for manual conversion between primitive types and their wrapper classes.

---

## String vs StringBuilder vs StringBuffer

**String (Immutable)**
- Once created, it cannot be changed.
- Any change creates a new object.

```java
String s = "Hello";
s += " World";  // New object created
```

**StringBuilder (Mutable, Not Thread-Safe)**
- Fast and ideal for single-threaded use.
- Same methods as StringBuffer.
- Faster in single-threaded applications.
- Not synchronized (not thread-safe).

```java
StringBuilder sb = new StringBuilder("Hi");
sb.append(" there");
System.out.println(sb);  // Hi there
```

**StringBuffer (Mutable, Thread-Safe)**
- Slower, but safe in multi-threaded contexts.
- Used when thread safety is required.
- Slower than StringBuilder, but safe for multi-threaded use.

```java
StringBuffer sb = new StringBuffer("Hi");
sb.append(" all");
System.out.println(sb);  // Hi all
```

**Example 1:**

```java
public class StringExample {
    public static void main(String[] args) {
        String str = "Java";
        
        System.out.println("Original: " + str);

        // Important methods
        System.out.println("Length: " + str.length());
        System.out.println("Char at 1: " + str.charAt(1));
        System.out.println("Substring(1, 3): " + str.substring(1, 3));
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Contains 'av': " + str.contains("av"));
        System.out.println("Replace 'a' with 'o': " + str.replace('a', 'o'));
        System.out.println("Equals 'Java': " + str.equals("Java"));
        System.out.println("EqualsIgnoreCase 'java': " + str.equalsIgnoreCase("java"));
        System.out.println("StartsWith 'Ja': " + str.startsWith("Ja"));
        System.out.println("EndsWith 'va': " + str.endsWith("va"));
        System.out.println("Index of 'a': " + str.indexOf('a'));
        System.out.println("Is Empty: " + str.isEmpty());
        System.out.println("Trim: " + "  Java  ".trim());
    }
}
```

**Output:**
```
Original: Java
Length: 4
Char at 1: a
Substring(1, 3): av
Uppercase: JAVA
Lowercase: java
Contains 'av': true
Replace 'a' with 'o': Jovo
Equals 'Java': true
EqualsIgnoreCase 'java': true
StartsWith 'Ja': true
EndsWith 'va': true
Index of 'a': 1
Is Empty: false
Trim: Java
```

**Example 2:**

```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");

        System.out.println("Original: " + sb);

        // Important methods
        sb.append(" World");
        System.out.println("Append: " + sb);

        sb.insert(5, ",");
        System.out.println("Insert: " + sb);

        sb.replace(6, 11, "Java");
        System.out.println("Replace: " + sb);

        sb.delete(5, 6);
        System.out.println("Delete: " + sb);

        sb.reverse();
        System.out.println("Reverse: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}
```

**Output:**
```
Original: Hello
Append: Hello World
Insert: Hello, World
Replace: Hello,Java
Delete: HelloJava
Reverse: avaJolleH
Length: 9
Capacity: 21
```

**Example 3:**

```java
public class StringBuilderExample {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Code");

        System.out.println("Original: " + sb);

        // Important methods
        sb.append(" Lab");
        System.out.println("Append: " + sb);

        sb.insert(4, "-");
        System.out.println("Insert: " + sb);

        sb.replace(5, 8, "Zone");
        System.out.println("Replace: " + sb);

        sb.delete(4, 5);
        System.out.println("Delete: " + sb);

        sb.reverse();
        System.out.println("Reverse: " + sb);

        System.out.println("Length: " + sb.length());
        System.out.println("Capacity: " + sb.capacity());
    }
}
```

**Output:**
```
Original: Code
Append: Code Lab
Insert: Code- Lab
Replace: Code-Zone
Delete: CodeZone
Reverse: enoZedoC
Length: 8
Capacity: 20
```

--- 

## Multithreading Basics

**What is a Thread?**
- A thread is a lightweight unit of a process that runs concurrently.
- It is a process of executing multiple threads simultaneously.
- We use multithreading rather than multiprocessing because threads use a shared memory area.
- Does not allocate separate memory areas, so it saves memory, and context-switching between the threads takes less time than a process.

**Why?**
- To perform multiple tasks at once (e.g., file download + UI interaction).

**Creating Threads**

- Method 1: Extending Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

public class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();  // don't use run()
    }
}
```

- Method 2: Implementing Runnable Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable running");
    }
}

public class Demo {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

**Thread LifeCycle**

![thread-life-cycle](./images/thread_life_cycle.jpg)

- In Java, a thread always exists in any one of the following states. These states are:

1. New
2. Active
3. Blocked / Waiting
4. Timed Waiting
5. Terminated

---

## Channels & Buffers (NIO Basics)

**What?**
- Java NIO (Non-blocking I/O) is a faster, more flexible alternative to traditional I/O (Streams).
- Introduced in Java 1.4 under java.nio package
- Channels: Used to read/write data.
- Buffers: Temporary memory for data.

**Why?**
- Faster, non-blocking I/O operations.
- Works better for large files, real-time systems, or high-performance apps.
- Supports: Buffers instead of streams, Channels to read/write data, Non-blocking and asynchronous I/O


### 1. Buffer – Temporary memory for data**

**What is a Buffer?**

- A Buffer is a block of memory used to store data temporarily during I/O operations.

- Common Methods:

| Method        | Purpose                          |
| ------------- | -------------------------------- |
| `put()`       | Write data into buffer           |
| `get()`       | Read data from buffer            |
| `flip()`      | Switch from write to read mode   |
| `rewind()`    | Reset position to 0 (read again) |
| `clear()`     | Clear buffer for reuse           |
| `remaining()` | Bytes left to read/write         |

**Example:**

```java
import java.nio.*;

public class BufferBasics {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10); // allocate 10 bytes

        buffer.put((byte) 1);
        buffer.put((byte) 2);

        buffer.flip(); // switch to read mode

        while(buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }
}
```

### 2. Channel – The bridge to data sources**

**What is a Channel?**

- A channel represents an open connection to data: files, sockets, etc.
- It can be used for both read and write.
- Think of it like a two-way road between your program and file/device.

**Types of Channels:**

- FileChannel – for files
- SocketChannel, ServerSocketChannel – for network
- DatagramChannel – for UDP

### 3. FileChannel – Read/Write Files with NIO

#### Reading from a File (Using FileChannel)

**Example:**

```java
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class FileReadDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("sample.txt");
        FileChannel channel = fis.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(64);
        channel.read(buffer);

        buffer.flip(); // switch to read mode

        while(buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        channel.close();
        fis.close();
    }
}
```

**Explanation:**

- allocate(64) → buffer size = 64 bytes.
- channel.read(buffer) → loads data into buffer.
- flip() → prepares buffer to be read.
- buffer.get() → reads data byte by byte.

#### Writing to a File (Using FileChannel)

**Example:**

```java
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("output.txt");
        FileChannel channel = fos.getChannel();

        String data = "Hello NIO!";
        ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());

        channel.write(buffer);

        channel.close();
        fos.close();
    }
}
```

**Explanation:**

- wrap() → wraps a byte array into a buffer.
- channel.write() → writes buffer content to file.

#### Buffer Flow (Key Concepts)

```java
ByteBuffer buffer = ByteBuffer.allocate(10);

buffer.put((byte)1);     // write data
buffer.put((byte)2);

buffer.flip();           // switch to read mode
System.out.println(buffer.get()); // read 1

buffer.rewind();         // reset to beginning
System.out.println(buffer.get()); // read 1 again

buffer.clear();          // ready for new write
```

---

## Asynchronous File Operations with AsynchronousFileChannel

**What is it?**

- AsynchronousFileChannel is part of Java NIO.2 (java.nio.channels) introduced in Java 7.
- It allows you to read/write files asynchronously (non-blocking).
- Your program can continue working while file I/O happens in the background.

**Why Use It?**

- Great for performance-sensitive applications (e.g., logging systems, file servers).
- Reduces blocking threads waiting on slow file I/O.
- Useful in event-driven or reactive systems.

**Common Methods:**

- read(ByteBuffer dst, long position)
- write(ByteBuffer src, long position)
- read(..., CompletionHandler)
- write(..., CompletionHandler)

**Example 1: Write to File Asynchronously (with Future)**

```java
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.*;
import java.util.concurrent.Future;

public class AsyncWriteExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("async-write.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(
            path,
            StandardOpenOption.WRITE,
            StandardOpenOption.CREATE
        );

        ByteBuffer buffer = ByteBuffer.wrap("Hello Async File Write!".getBytes());

        Future<Integer> result = channel.write(buffer, 0);

        while (!result.isDone()) {
            System.out.println("Writing in background...");
        }

        System.out.println("Write complete. Bytes written: " + result.get());

        channel.close();
    }
}
```

**Example 2: Read from File Asynchronously (with CompletionHandler)**

```java
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class AsyncReadExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("async-write.txt");
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(100);

        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                attachment.flip();
                byte[] data = new byte[result];
                attachment.get(data);
                System.out.println("Read complete. Content: " + new String(data));
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Read failed: " + exc.getMessage());
            }
        });

        System.out.println("Reading started...");
        Thread.sleep(2000); // wait to let async task complete
        channel.close();
    }
}
```

---

## Selectors & Non-blocking I/O

**What is a Selector?**

- A Selector is a Java NIO component that can monitor multiple channels (sockets) using one thread.
- Commonly used with SocketChannel, ServerSocketChannel
- Ideal for non-blocking servers, e.g., chat servers, HTTP servers

**Why Use Selectors?**

- Efficiently manage multiple client connections
- Use one thread to handle many sockets
- Avoid thread-per-connection overhead

**How it Works**

- Open ServerSocketChannel and configure it as non-blocking.
- Open a Selector.
- Register channels to selector (with interest like OP_ACCEPT, OP_READ).
- Run an event loop to handle events.

**Example: Simple Non-blocking Echo Server**

```java
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(5000));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started on port 5000");

        while (true) {
            selector.select(); // blocks until an event occurs
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();

            while (it.hasNext()) {
                SelectionKey key = it.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    client.register(selector, SelectionKey.OP_READ);
                    System.out.println("New client connected");
                } else if (key.isReadable()) {
                    SocketChannel client = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int bytesRead = client.read(buffer);

                    if (bytesRead == -1) {
                        client.close();
                        System.out.println("Client disconnected");
                    } else {
                        buffer.flip();
                        client.write(buffer); // echo back
                    }
                }

                it.remove(); // very important
            }
        }
    }
}
```

**Key Concepts**

| Concept                | What it does              |
| ---------------------- | ------------------------- |
| `Selector`             | Watches multiple channels |
| `SocketChannel`        | Non-blocking socket       |
| `SelectionKey`         | Tracks registered channel |
| `OP_ACCEPT`, `OP_READ` | Events you can listen for |

---