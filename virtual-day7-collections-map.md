# Java Collections

## Why Java Collections?

- Java Collections are like containers to store, retrieve, and process groups of objects.
- Helps us to avoid writing boilerplate code for things like dynamic arrays or custom sorting.
- Makes coding easier and more efficient for real-world tasks.

## Java Collection Hierarchy

![java_collection_hierarchy](./images/java-collection-hierarchy.png)

---

## List Interface

**What is List?**

- An ordered collection that allows duplicates.
- You can access elements by index (position).
- Useful when order matters (e.g., shopping cart, student list).

**Implementations:**

### 1. ArrayList

- It uses a dynamic array to store the duplicate element of different data types.
- Fast for reading (get/set by index).
- Slower in insert/remove (especially in the middle).
- The ArrayList class maintains the insertion order
- it is non-synchronized

**Example 1:**

```java
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Amit");
        names.add("Ravi");
        names.add("Amit"); // Allows duplicate
        names.add(1, "Rohit"); // Insert at index

        System.out.println("ArrayList: " + names);
    }
}
```

**Output:**

```
ArrayList: [Amit, Rohit, Ravi, Amit]
```

- "Rohit" is inserted at index 1. Duplicates like "Amit" are allowed.

**Example 2:**

```java
import java.util.*;
public class Main{
    public static void main(String args[]){
        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
        list.add("Mango");//Adding object in arraylist
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");

  //Traversing list through for-each loop
    for(String fruit:list)
        System.out.println(fruit);
    }
}
```

**Output:**

```
Mango
Apple
Banana
Grapes
```

**Example 3:**

```java
import java.util.*;
public class Main{
    public static void main(String args[]){
        ArrayList<String> al=new ArrayList<String>();
        al.add("Mango");
        al.add("Apple");
        al.add("Banana");
        al.add("Grapes");
  
        //accessing the element
        System.out.println("Returning element: "+al.get(1));//it will return the 2nd element, because index starts from 0
        //changing the element
        al.set(1,"Dates");
        //Traversing list
        for(String fruit:al)
            System.out.println(fruit);
        }
}
```

**Output:**
```
Returning element: Apple
Mango
Dates
Banana
Grapes
```

### 2. LinkedList

- Elements are connected via nodes.
- Faster insert/delete in the middle.
- Slower for random access.
- It uses a doubly linked list internally to store the elements.
- It can store the duplicate elements.
- It maintains the insertion order
- it is non-synchronized


**Example 1:**

```java
import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.addFirst("Bangalore");
        cities.addLast("Chennai");

        System.out.println("LinkedList: " + cities);
    }
}
```

**Output:**

```
LinkedList: [Bangalore, Delhi, Mumbai, Chennai]
```

- "Bangalore" added at first and "Chennai" at last.

**Example 2:**

```java
import java.util.*;  
public class Main{  
 public static void main(String args[]){  
 LinkedList<String> ll=new LinkedList<String>();  
           System.out.println("Initial list of elements: "+ll);  
           ll.add("Ravi");  
           ll.add("Vijay");  
           ll.add("Ajay");  
           System.out.println("After invoking add(E e) method: "+ll);  
           //Adding an element at the specific position  
           ll.add(1, "Gaurav");  
           System.out.println("After invoking add(int index, E element) method: "+ll);  
           LinkedList<String> ll2=new LinkedList<String>();  
           ll2.add("Sonoo");  
           ll2.add("Hanumat");  
           //Adding second list elements to the first list  
           ll.addAll(ll2);  
           System.out.println("After invoking addAll(Collection<? extends E> c) method: "+ll);  
           LinkedList<String> ll3=new LinkedList<String>();  
           ll3.add("John");  
           ll3.add("Rahul");  
           //Adding second list elements to the first list at specific position  
           ll.addAll(1, ll3);  
           System.out.println("After invoking addAll(int index, Collection<? extends E> c) method: "+ll);  
           //Adding an element at the first position  
           ll.addFirst("Lokesh");  
           System.out.println("After invoking addFirst(E e) method: "+ll);  
           //Adding an element at the last position  
           ll.addLast("Harsh");  
           System.out.println("After invoking addLast(E e) method: "+ll);           
 }  
}
```

**Output:**
```
Initial list of elements: []
After invoking add(E e) method: [Ravi, Vijay, Ajay]
After invoking add(int index, E element) method: [Ravi, Gaurav, Vijay, Ajay]
After invoking addAll(Collection<? extends E> c) method:
[Ravi, Gaurav, Vijay, Ajay, Sonoo, Hanumat]
After invoking addAll(int index, Collection<? extends E> c) method:
[Ravi, John, Rahul, Gaurav, Vijay, Ajay, Sonoo, Hanumat]
After invoking addFirst(E e) method:
[Lokesh, Ravi, John, Rahul, Gaurav, Vijay, Ajay, Sonoo, Hanumat]
After invoking addLast(E e) method:
[Lokesh, Ravi, John, Rahul, Gaurav, Vijay, Ajay, Sonoo, Hanumat, Harsh]
```

**Example 3:**

```java
import java.util.*;  
public class Main {  
  
        public static void main(String [] args)  
        {  
           LinkedList<String> ll=new LinkedList<String>();  
           ll.add("Ravi");  
           ll.add("Vijay");  
           ll.add("Ajay");  
           ll.add("Anuj");  
           ll.add("Gaurav");  
           ll.add("Harsh");  
           ll.add("Virat");  
           ll.add("Gaurav");  
           ll.add("Harsh");  
           ll.add("Amit");  
           System.out.println("Initial list of elements: "+ll);  
         //Removing specific element from arraylist  
              ll.remove("Vijay");  
              System.out.println("After invoking remove(object) method: "+ll);   
         //Removing element on the basis of specific position  
              ll.remove(0);  
              System.out.println("After invoking remove(index) method: "+ll);   
              LinkedList<String> ll2=new LinkedList<String>();  
              ll2.add("Ravi");  
              ll2.add("Hanumat");  
         // Adding new elements to arraylist  
              ll.addAll(ll2);  
              System.out.println("Updated list : "+ll);   
         //Removing all the new elements from arraylist  
              ll.removeAll(ll2);  
              System.out.println("After invoking removeAll() method: "+ll);   
         //Removing first element from the list  
              ll.removeFirst();  
              System.out.println("After invoking removeFirst() method: "+ll);  
          //Removing first element from the list  
              ll.removeLast();  
              System.out.println("After invoking removeLast() method: "+ll);  
          //Removing first occurrence of element from the list  
              ll.removeFirstOccurrence("Gaurav");  
              System.out.println("After invoking removeFirstOccurrence() method: "+ll);  
          //Removing last occurrence of element from the list  
              ll.removeLastOccurrence("Harsh");  
              System.out.println("After invoking removeLastOccurrence() method: "+ll);  
  
              //Removing all the elements available in the list       
              ll.clear();  
              System.out.println("After invoking clear() method: "+ll);   
       }  
    }
```

**Output:**
```
Initial list of elements: [Ravi, Vijay, Ajay, Anuj, Gaurav, Harsh, Virat, Gaurav, Harsh, Amit]
After invoking remove(object) method: [Ravi, Ajay, Anuj, Gaurav, Harsh, Virat, Gaurav, Harsh, Amit]
After invoking remove(index) method: [Ajay, Anuj, Gaurav, Harsh, Virat, Gaurav, Harsh, Amit]
Updated list : [Ajay, Anuj, Gaurav, Harsh, Virat, Gaurav, Harsh, Amit, Ravi, Hanumat]
After invoking removeAll() method: [Ajay, Anuj, Gaurav, Harsh, Virat, Gaurav, Harsh, Amit]
After invoking removeFirst() method: [Gaurav, Harsh, Virat, Gaurav, Harsh, Amit]
After invoking removeLast() method: [Gaurav, Harsh, Virat, Gaurav, Harsh]
After invoking removeFirstOccurrence() method: [Harsh, Virat, Gaurav, Harsh]
After invoking removeLastOccurrence() method: [Harsh, Virat, Gaurav]
After invoking clear() method: []
```

### ArrayList Vs. LinkedList

| ArrayList | LinkedList |
| --------- | ---------- |
| ArrayList internally uses a dynamic array to store the elements | LinkedList internally uses a doubly linked list to store the elements |
| Manipulation with ArrayList is slow because it internally uses an array. If any element is removed from the array, all the other elements are shifted in memory. | Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory. |
| An ArrayList class can act as a list only because it implements the List only. | The LinkedList class can act as both a list and a queue because it implements the List and Deque interfaces. |
| ArrayList is better for storing and accessing data. | LinkedList is better for manipulating data. |
| Less memory is used. | More memory is used. |

### 3. Vector

- Vector uses a dynamic array to store the data elements.
- it is synchronized

### 4. Stack

- It implements the last-in-first-out data structure, i.e., Stack.

---

## Set Interface

**What is Set?**

- A collection that does not allow duplicate elements.
- Useful when uniqueness matters (e.g., usernames, product IDs).

**Implementations:**

### 1. HashSet

- Unordered, It doesn't maintain the insertion order.
- Fastest for add, remove, and search
- Uses hashing internally - It represents the collection that uses a hash table for storage.
- It contains unique items i.e doesn't allow us to store the duplicate items.

**Example 1:**

```java
import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // Duplicate - ignored

        System.out.println("HashSet: " + fruits);
    }
}
```

**Output:**

```java
HashSet: [Banana, Apple]
```

- Order is not guaranteed in HashSet, and duplicate "Apple" is ignored.

**Example 2:**

```java
import java.util.*;  
class Book {  
int id;  
String name,author,publisher;  
int quantity;  
public Book(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
}  
public class Main {  
public static void main(String[] args) {  
    HashSet<Book> set=new HashSet<Book>();  
    //Creating Books  
    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
    //Adding Books to HashSet  
    set.add(b1);  
    set.add(b2);  
    set.add(b3);  
    //Traversing HashSet  
    for(Book b:set){  
    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
    }  
}  
}  
```

**Output:**
```
101 Let us C Yashwant Kanetkar BPB 8
102 Data Communications & Networking Forouzan Mc Graw Hill 4
103 Operating System Galvin Wiley 6
```

### 2. LinkedHashSet

- It maintains the insertion order.
- Good if you want fast access + predictable order
- It doesn't allow us to store the duplicate items.
- It permits null elements.

**Example 1:**

```java
Set<String> items = new LinkedHashSet<>();
items.add("Pen");
items.add("Notebook");
items.add("Pencil");
System.out.println("LinkedHashSet: " + items);
```

**Output:**

```java
LinkedHashSet: [Pen, Notebook, Pencil]
```

- Maintains insertion order.

**Example 2:**

```java
import java.util.*;  
class Book {  
int id;  
String name,author,publisher;  
int quantity;  
public Book(int id, String name, String author, String publisher, int quantity) {  
    this.id = id;  
    this.name = name;  
    this.author = author;  
    this.publisher = publisher;  
    this.quantity = quantity;  
}  
}  
public class Main {  
public static void main(String[] args) {  
    LinkedHashSet<Book> hs=new LinkedHashSet<Book>();  
    //Creating Books  
    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);  
    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);  
    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);  
    //Adding Books to hash table  
    hs.add(b1);  
    hs.add(b2);  
    hs.add(b3);  
    //Traversing hash table  
    for(Book b:hs){  
    System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);  
    }  
}  
}  
```

**Output:**
```
101 Let us C Yashwant Kanetkar BPB 8
102 Data Communications & Networking Forouzan Mc Graw Hill 4
103 Operating System Galvin Wiley 6
```

### 3. TreeSet

- Sorted in natural order (alphabetically, numerically), elements of the SortedSet are arranged in the increasing (ascending) order.
- Slower than HashSet but useful for sorted data
- It doesn't allow us to store the duplicate items.

```java
Set<Integer> numbers = new TreeSet<>();
numbers.add(30);
numbers.add(10);
numbers.add(20);
System.out.println("TreeSet (Sorted): " + numbers);
```

**Output:**

```java
TreeSet (Sorted): [10, 20, 30]
```

- Automatically sorted in natural ascending order.

---

## Map Interface

**What is Map?**

- A collection of key-value pairs
- Keys must be unique, values can repeat
- Like a dictionary

## Java Collection Hierarchy

![java_map_hierarchy](./images/java-map-hierarchy.png)

**Implementations:**

### 1. HashMap

- Unordered, HashMap maintains no order.
- Fastest for access by key
- Java HashMap contains values based on the key.
- Java HashMap contains only unique keys i.e it cannot have duplicate keys
- Java HashMap may have one null key and multiple null values.
- Java HashMap is non synchronized.

**Example 1:**

```java
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "Amit");
        students.put(2, "Ravi");
        students.put(3, "Amit"); // Same value is allowed

        System.out.println("HashMap: " + students);
    }
}
```

**Output:**

```java
HashMap: {1=Amit, 2=Ravi, 3=Amit}
```

- Keys are unique. Values can repeat. Order is not guaranteed.

**Example 2:**

```java
import java.util.*;  
class Main{  
   public static void main(String args[]){  
      // Creating a HashMap instance  
      Map<Integer,String> map=new HashMap<Integer,String>();     
      // Adding key-value pairs to the map  
      map.put(100,"Amit");  
      map.put(101,"Vijay");  
      map.put(102,"Rahul");    
      // Elements can traverse in any order  
      // Iterating over the entries of the map  
      for(Map.Entry m:map.entrySet()){  
         // Printing the key-value pairs  
         System.out.println(m.getKey()+" "+m.getValue());  
      }  
   }  
} 
```

**Output:**
```
100 Amit
101 Vijay
102 Rahul
```

**Example 3:**

```java
import java.util.*;  
class Main{  
 public static void main(String args[]){  
   HashMap<Integer,String> hm=new HashMap<Integer,String>();    
    System.out.println("Initial list of elements: "+hm);  
      hm.put(100,"Amit");    
      hm.put(101,"Vijay");    
      hm.put(102,"Rahul");   
       
      System.out.println("After invoking put() method ");  
      for(Map.Entry m:hm.entrySet()){    
       System.out.println(m.getKey()+" "+m.getValue());    
      }  
        
      hm.putIfAbsent(103, "Gaurav");  
      System.out.println("After invoking putIfAbsent() method ");  
      for(Map.Entry m:hm.entrySet()){    
           System.out.println(m.getKey()+" "+m.getValue());    
          }  
      HashMap<Integer,String> map=new HashMap<Integer,String>();  
      map.put(104,"Ravi");  
      map.putAll(hm);  
      System.out.println("After invoking putAll() method ");  
      for(Map.Entry m:map.entrySet()){    
           System.out.println(m.getKey()+" "+m.getValue());    
          }  
 }  
} 
```

**Output:**
```
Initial list of elements: {}
After invoking put() method
100 Amit
101 Vijay
102 Rahul
After invoking putIfAbsent() method
100 Amit
101 Vijay
102 Rahul
103 Gaurav
After invoking putAll() method
100 Amit
101 Vijay
102 Rahul
103 Gaurav
104 Ravi
```

### 2. LinkedHashMap

- It contains values based on the key.
- It contains unique elements.
- It may have one null key and multiple null values.
- It is non synchronized.
- It maintains insertion order.

**Example 1:**

```java
import java.util.*;  
class Main{  
 public static void main(String args[]){  
   
  LinkedHashMap<Integer,String> hm=new LinkedHashMap<Integer,String>();  
  
  hm.put(100,"Amit");  
  hm.put(101,"Vijay");  
  hm.put(102,"Rahul");  
  
for(Map.Entry m:hm.entrySet()){  
   System.out.println(m.getKey()+" "+m.getValue());  
  }  
 }  
}  
```

**Output:**
```
100 Amit
101 Vijay
102 Rahul
```

**Example 2:**

```java
import java.util.*;  
class Main{  
 public static void main(String args[]){  
   LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();           
      map.put(100,"Amit");    
     map.put(101,"Vijay");    
     map.put(102,"Rahul");    
       //Fetching key  
       System.out.println("Keys: "+map.keySet());  
       //Fetching value  
       System.out.println("Values: "+map.values());  
       //Fetching key-value pair  
       System.out.println("Key-Value pairs: "+map.entrySet());  
 }  
} 
```

**Output:**
```
Keys: [100, 101, 102]
Values: [Amit, Vijay, Rahul]
Key-Value pairs: [100=Amit, 101=Vijay, 102=Rahul]
```

**Example 3:**

```java
import java.util.*;    
class Book {    
int id;    
String name,author,publisher;    
int quantity;    
public Book(int id, String name, String author, String publisher, int quantity) {    
    this.id = id;    
    this.name = name;    
    this.author = author;    
    this.publisher = publisher;    
    this.quantity = quantity;    
}    
}    
public class Main {    
public static void main(String[] args) {    
    //Creating map of Books    
    Map<Integer,Book> map=new LinkedHashMap<Integer,Book>();    
    //Creating Books    
    Book b1=new Book(101,"Let us C","Yashwant Kanetkar","BPB",8);    
    Book b2=new Book(102,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);    
    Book b3=new Book(103,"Operating System","Galvin","Wiley",6);    
    //Adding Books to map   
    map.put(2,b2);  
    map.put(1,b1);  
    map.put(3,b3);  
      
    //Traversing map  
    for(Map.Entry<Integer, Book> entry:map.entrySet()){    
        int key=entry.getKey();  
        Book b=entry.getValue();  
        System.out.println(key+" Details:");  
        System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);   
    }    
}    
}
```

**Output:**
```
2 Details:
102 Data Communications & Networking Forouzan Mc Graw Hill 4
1 Details:
101 Let us C Yashwant Kanetkar BPB 8
3 Details:
103 Operating System Galvin Wiley 6
```

### 3. TreeMap

- Sorted by keys
- Slower than HashMap
- It contains values based on the key.
- It contains only unique elements.
- It cannot have a null key but can have multiple null values.
- It is non synchronized.
- It maintains ascending order.

**Example 1:**

```java
Map<Integer, String> scores = new TreeMap<>();
scores.put(90, "A");
scores.put(80, "B");
scores.put(100, "A+");
System.out.println("TreeMap (Sorted): " + scores);
```

**Output:**

```java
TreeMap (Sorted): {80=B, 90=A, 100=A+}
```

- Sorted by keys in ascending order.

**Example 2:**

```java
import java.util.*;  
class TreeMap1{  
 public static void main(String args[]){  
   TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
      map.put(100,"Amit");    
      map.put(102,"Ravi");    
      map.put(101,"Vijay");    
      map.put(103,"Rahul");    
        
      for(Map.Entry m:map.entrySet()){    
       System.out.println(m.getKey()+" "+m.getValue());    
      }    
 }  
}
```

**Output:**
```
100 Amit
101 Vijay
102 Ravi
103 Rahul
```

**Example 3:**

```java
import java.util.*;  
public class TreeMap2 {  
   public static void main(String args[]) {  
    TreeMap<Integer,String> map=new TreeMap<Integer,String>();    
      map.put(100,"Amit");    
      map.put(102,"Ravi");    
      map.put(101,"Vijay");    
      map.put(103,"Rahul");    
      System.out.println("Before invoking remove() method");  
      for(Map.Entry m:map.entrySet())  
      {  
          System.out.println(m.getKey()+" "+m.getValue());      
      }  
      map.remove(102);      
      System.out.println("After invoking remove() method");  
      for(Map.Entry m:map.entrySet())  
      {  
          System.out.println(m.getKey()+" "+m.getValue());      
      }  
      }  
}
```

**Output:**
```
Before invoking remove() method
100 Amit
101 Vijay
102 Ravi
103 Rahul
After invoking remove() method
100 Amit
101 Vijay
103 Rahul
```

### 4. ConcurrentHashMap

- Thread-safe version of HashMap
- Used in multi-threaded environments

```java
import java.util.concurrent.*;

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String, Integer> stock = new ConcurrentHashMap<>();
        stock.put("Laptop", 50);
        stock.put("Phone", 30);
        stock.put("Tablet", 20);

        System.out.println("ConcurrentMap: " + stock);
    }
}
```

**Output:**

```java
ConcurrentMap: {Laptop=50, Phone=30, Tablet=20}
```

- Order is not guaranteed but thread-safe operations.

---

## Collections class

Java collection class is used exclusively with static methods that operate on or return collections. It inherits Object class.

**Example 1:**

```java
import java.util.*;  
public class Main {  
    public static void main(String a[]){      
        List<String> list = new ArrayList<String>();  
        list.add("C");  
        list.add("Core Java");  
        list.add("Advance Java");  
        System.out.println("Initial collection value:"+list);  
        Collections.addAll(list, "Servlet","JSP");  
        System.out.println("After adding elements collection value:"+list);  
        String[] strArr = {"C#", ".Net"};  
        Collections.addAll(list, strArr);  
        System.out.println("After adding array collection value:"+list);  
    }  
}  
```

**Output:**
```
Initial collection value:[C, Core Java, Advance Java]
After adding elements collection value:[C, Core Java, Advance Java, Servlet, JSP]
After adding array collection value:[C, Core Java, Advance Java, Servlet, JSP, C#, .Net]
```

**Example 2:**

```java
import java.util.*;  
class Main{  
public static void main(String args[]){  
  
ArrayList<String> al=new ArrayList<String>();  
al.add("Viru");  
al.add("Saurav");  
al.add("Mukesh");  
al.add("Tahir");  
  
Collections.sort(al);  
Iterator itr=al.iterator();  
while(itr.hasNext()){  
System.out.println(itr.next());  
 }  
}  
}
```

**Output:**
```
Mukesh
Saurav
Tahir
Viru
```

**Example 3:**
```java
import java.util.*;  
public class Main {  
    public static void main(String a[]){         
        List<Integer> list = new ArrayList<Integer>();  
        list.add(46);  
        list.add(67);  
        list.add(24);  
        list.add(16);  
        list.add(8);  
        list.add(12);  
        System.out.println("Value of maximum element from the collection: "+Collections.max(list));  
    }  
} 
```

**Output:**
```
Value of maximum element from the collection: 67
```

## Iterators

**Why Iterators?**

- Used to loop through collections one item at a time
- Helps when we want to remove elements safely during iteration

```java
List<String> colors = new ArrayList<>(List.of("Red", "Green", "Blue"));
Iterator<String> it = colors.iterator();
while(it.hasNext()) {
    String color = it.next();
    if(color.equals("Green")) {
        it.remove(); // Safe way to remove
    }
}
System.out.println("After Iterator removal: " + colors);
```

**Output:**

```java
After Iterator removal: [Red, Blue]
```

- "Green" was safely removed during iteration.

### ListIterator (bi-directional for Lists)

```java
List<String> list = new ArrayList<>(List.of("A", "B", "C"));
ListIterator<String> li = list.listIterator();
while (li.hasNext()) {
    System.out.println("Forward: " + li.next());
}
while (li.hasPrevious()) {
    System.out.println("Backward: " + li.previous());
}
```

**Output:**

```java
Forward: A
Forward: B
Forward: C
Backward: C
Backward: B
Backward: A
```

- Demonstrates bi-directional iteration on list.

---

## Comparable vs Comparator

**Why?**

- Helps us sort custom objects like Student, Product, etc.

**Differences:**

| Comparable | Comparator |
| ---------- | ---------- |
| It is introduced in Java 1.2. | Introduced in Java 1.2, enhanced in Java 8 with default methods and lambdas. |
| Syntax: class Student implements Comparable<Student> { public int compareTo(Student s) { ... } } | Syntax: class StudentComparator implements Comparator<Student> { public int compare(Student s1, Student s2) { ... } } |
| Comparable provides a single sorting sequence. In other words, we can sort the collection on the basis of a single element such as id, name, and price. | The Comparator provides multiple sorting sequences. In other words, we can sort the collection on the basis of multiple elements such as id, name, and price etc. |
| Comparable affects the original class, i.e., the actual class is modified. | Comparator does not affect the original class, i.e., the actual class is not modified. |
| Comparable provides compareTo() method to sort elements. | Comparator provides compare() method to sort elements.|

### Comparable (Natural Order – default)

- Implemented inside the class
- Only one way to sort

**Example 1:**

```java
class Student implements Comparable<Student> {
    int marks;
    Student(int marks) { this.marks = marks; }

    public int compareTo(Student s) {
        return this.marks - s.marks; // Ascending
    }

    public String toString() {
        return "Marks: " + marks;
    }
}

public class ComparableDemo {
    public static void main(String[] args) {
        List<Student> list = List.of(new Student(60), new Student(90), new Student(75));
        List<Student> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);
        System.out.println(sortedList);
    }
}
```

**Output:**

```java
[Marks: 60, Marks: 75, Marks: 90]
```

- Sorted in ascending order based on marks.

**Example 2:**

*Student.java*
```java
class Student implements Comparable<Student>{  
    int rollno;  
    String name;  
    int age;  

    Student(int rollno,String name,int age){  
        this.rollno=rollno;  
        this.name=name;  
        this.age=age;  
}  
  
public int compareTo(Student st){  
    if(age==st.age)  
        return 0;  
    else if(age>st.age)  
        return 1;  
    else  
        return -1;  
    }  
} 
```

*TestSort1.java*
```java
import java.util.*;  
public class TestSort1{  
    public static void main(String args[]){  
        ArrayList<Student> al=new ArrayList<Student>();  
        al.add(new Student(101,"Vijay",23));  
        al.add(new Student(106,"Ajay",27));  
        al.add(new Student(105,"Jai",21));  
  
Collections.sort(al);  
    for(Student st:al){  
        System.out.println(st.rollno+" "+st.name+" "+st.age);  
    }  
  }  
} 
```

**Output:**
```
105 Jai 21
101 Vijay 23
106 Ajay 27
```

### Comparator (External sorting logic)

- Used when we want multiple ways to sort

**Example 1:**

```java
class Product {
    int id;
    String name;
    Product(int id, String name) { this.id = id; this.name = name; }

    public String toString() { return id + " - " + name; }
}

class SortByName implements Comparator<Product> {
    public int compare(Product a, Product b) {
        return a.name.compareTo(b.name);
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Product> products = List.of(new Product(2, "Keyboard"), new Product(1, "Mouse"));
        List<Product> sorted = new ArrayList<>(products);
        Collections.sort(sorted, new SortByName());
        System.out.println(sorted);
    }
}
```

**Output:**

```java
[2 - Keyboard, 1 - Mouse]
```

- Sorted by name in alphabetical order — "Keyboard" comes before "Mouse".

**Example 2:**

*Student.java*
```java
class Student{  

    int rollno;  
    String name;  
    int age; 

    Student(int rollno,String name,int age){  
        this.rollno=rollno;  
        this.name=name;  
        this.age=age;  
    }  
}  
```

*AgeComparator.java*
```java
import java.util.*;  
class AgeComparator implements Comparator<Student>{  
    public int compare(Student s1,Student s2){  
        if(s1.age==s2.age)  
            return 0;  
        else if(s1.age>s2.age)  
            return 1;  
        else  
            return -1;  
        }  
} 
```

*NameComparator.java*
```java
import java.util.*;  
class NameComparator implements Comparator<Student>{  
    public int compare(Student s1,Student s2){  
        return s1.name.compareTo(s2.name);  
    }  
}  
```

*Simple.java*
```java
import java.util.*;  
import java.io.*;  
class Simple{  
    public static void main(String args[]){  
    
    ArrayList<Student> al=new ArrayList<Student>();  
    al.add(new Student(101,"Vijay",23));  
    al.add(new Student(106,"Ajay",27));  
    al.add(new Student(105,"Jai",21));  
    
    System.out.println("Sorting by Name");  
    
    Collections.sort(al,new NameComparator());  
    
    for(Student st: al){  
        System.out.println(st.rollno+" "+st.name+" "+st.age);  
    }  
    
    System.out.println("Sorting by age");  
    
    Collections.sort(al,new AgeComparator());  
    
    for(Student st: al){  
        System.out.println(st.rollno+" "+st.name+" "+st.age);  
    }  
  }  
} 
```

**Output:**
```
Sorting by Name
106 Ajay 27
105 Jai 21
101 Vijay 23

Sorting by age
105 Jai 21
101 Vijay 23
106 Ajay 27
```

---
