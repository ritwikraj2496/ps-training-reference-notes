# Java 8, 11 & 21 features

## Utility Classes

### Properties Class in Java

**What is it?**

- A subclass of Hashtable used to maintain configuration data as key-value pairs, where both key and value are strings.
- Mostly used for reading .properties files (like config.properties).

**Why do we need it?**

- Useful to store and retrieve application configuration like DB URLs, usernames, passwords, messages, etc.
- Works well with file I/O for reading/writing settings.

**How it works?**

- Uses load(InputStream) to read .properties files.
- Uses getProperty(key) to read values.

**Example 1:**

```java
import java.io.FileReader;
import java.util.Properties;

public class PropertiesExample1 {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.load(new FileReader("config.properties"));

        String dbUrl = props.getProperty("db.url");
        String username = props.getProperty("db.username");

        System.out.println("DB URL: " + dbUrl);
        System.out.println("Username: " + username);
    }
}
```

**Sample config.properties:**

```
db.url=jdbc:mysql://localhost:3306/mydb
db.username=root
db.password=admin123
```

**Example 2:**

```java
import java.util.*;
public class PropDemo {

   public static void main(String args[]) {
      Properties capitals = new Properties();
      Set states;
      String str;

      capitals.put("Illinois", "Springfield");
      capitals.put("Missouri", "Jefferson City");
      capitals.put("Washington", "Olympia");
      capitals.put("California", "Sacramento");
      capitals.put("Indiana", "Indianapolis");

      // Show all states and capitals in hashtable.
      states = capitals.keySet();   // get set-view of keys
      Iterator itr = states.iterator();

      while(itr.hasNext()) {
         str = (String) itr.next();
         System.out.println("The capital of " + str + " is " +
            capitals.getProperty(str) + ".");
      }
      System.out.println();

      // look for state not in list -- specify default
      str = capitals.getProperty("Florida", "Not Found");
      System.out.println("The capital of Florida is " + str + ".");
   }
}
```

**Output:**

```
The capital of Missouri is Jefferson City.
The capital of Illinois is Springfield.
The capital of Indiana is Indianapolis.
The capital of California is Sacramento.
The capital of Washington is Olympia.

The capital of Florida is Not Found.
```

**Example 3:**

```java
// Java program to demonstrate Properties class to get all the system properties
import java.util.*;
import java.io.*;

public class PropertiesExample2 {
    public static void main(String[] args) throws Exception
    {
        // get all the system properties
        Properties p = System.getProperties();

        // stores set of properties information
        Set set = p.entrySet();

        // iterate over the set
        Iterator itr = set.iterator();
        while (itr.hasNext()) {

            // print each property
            Map.Entry entry = (Map.Entry)itr.next();
            System.out.println(entry.getKey() + " = "
                               + entry.getValue());
        }
    }
}
```

**Example 4:**

```java
// Java program to demonstrate Properties class to create the properties file
import java.util.*;
import java.io.*;

public class PropertiesExample3 {
    public static void main(String[] args) throws Exception
    {
        // create an instance of Properties
        Properties p = new Properties();

        // add properties to it
        p.setProperty("name", "Carol Joseph");
        p.setProperty("email",
                      "caroljoseph.code@gmail.com");

        // store the properties to a file
        p.store(new FileWriter("info.properties"),
                "Sample Properties Example");
    }
}
```

---

### Random Class in Java

**What is it?**

- A utility class to generate random numbers.
- Comes from java.util.Random.
- It returns a random number between 0.0 (inclusive), and 1.0 (exclusive)

**Why do we need it?**

- Useful in games, simulations, random testing, OTP generation, etc.

**How it works?**

- Can generate random integers, doubles, booleans, etc.

**Example 1:**

```java
public class Main {
  public static void main(String[] args) {
    int randomNum = (int)(Math.random() * 101);  // 0 to 100
    System.out.println(randomNum);
  }
}
```

**Example 2:**

```java
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random rand = new Random();

        int randomInt = rand.nextInt(100); // 0 to 99
        double randomDouble = rand.nextDouble(); // 0.0 to 1.0
        boolean randomBoolean = rand.nextBoolean();

        System.out.println("Random Int: " + randomInt);
        System.out.println("Random Double: " + randomDouble);
        System.out.println("Random Boolean: " + randomBoolean);
    }
}
```

**Example 3:**

```java
import java.util.Random;

public class RandomClassExample1 {

	public static void main(String[] args) {

		// create random object
		Random randomNumbers = new Random();

		System.out.println("----------Random Boolean---------" );
		/*
		 * Returns the next pseudo random boolean value which
		 * may be used in a toss for a match
		 */
		boolean value = randomNumbers.nextBoolean();
		System.out.println("The random boolean value is: " + value);

		/*
		 * Returns the next pseudo random integer value between 0 and 5
		 * because if we use '6' then, it will give random numbers from 0 to 6
		 * hence incrementing it by 1 you can use it as a result of a dice roll
		 */
		System.out.println("\n----------Random Integer---------" );
		System.out.println("Die Roll: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("Die Roll: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("Die Roll: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("Die Roll: " + (randomNumbers.nextInt(6)+1) );
		System.out.println("Die Roll: " + (randomNumbers.nextInt(6)+1) );

		// return the next pseudo random long value
		Long val = randomNumbers.nextLong();
		System.out.println("\n----------Random Long---------" );
		System.out.println("Random Long value: " + val);

		/*
		 * Generates random bytes and puts them in an array, which you can for some
		 * desired unpredictable result that is summing all the values in the array
		 */

		System.out.println("\n----------Random Bytes---------" );
		byte[] bytes = new byte[8];
		randomNumbers.nextBytes(bytes);

		System.out.print("These are the random bytes = [ ");
		for (int i = 0; i < bytes.length; i++) {
			System.out.printf("%d ", bytes[i]);
		}
		System.out.println("]");
	}
}
```

**Output:**

```
----------Random Boolean---------
The random boolean value is: true

----------Random Integer---------
Die Roll: 4
Die Roll: 6
Die Roll: 1
Die Roll: 1
Die Roll: 3

----------Random Long---------
Random Long value: -6029959293504570824

----------Random Bytes---------
These are the random bytes = [ -37 90 -98 -70 23 -111 19 108 ]
```

---

### UUID Class in Java

**What is it?**

- A class to generate Universally Unique Identifiers (UUIDs).
- Comes from java.util.UUID.

**Why do we need it?**

- Used when we need a unique identifier like session ID, user ID, file name, etc.

**How it works?**

- You call UUID.randomUUID() which gives a unique 128-bit value.

**Example:**

```java
import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        System.out.println("UUID 1: " + id1.toString());
        System.out.println("UUID 2: " + id2.toString());
        System.out.println("UUID version: " + id1.version());
    }
}
```

---

### Calendar Class

**What is it?**

- A class from java.util to work with dates and times (before java.time API).
- It is abstract; you typically use Calendar.getInstance() to get a calendar object.

**Why do we need it?**

- Useful for adding, subtracting, or modifying dates (like getting the next week’s date).

**How it works?**

- Provides methods like add(), get(), set() to manipulate date components.

**Example 1:**

```java
import java.util.Calendar;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        System.out.println("Current Date: " + cal.getTime());

        cal.add(Calendar.DATE, 7); // Add 7 days
        System.out.println("After 7 Days: " + cal.getTime());
    }
}
```

**Example 2:**

```java
// Date getTime(): It is used to return a Date object representing this Calendar's time value.

import java.util.*;
public class Calendar1 {
    public static void main(String args[])
    {
        Calendar c = Calendar.getInstance();
        System.out.println("The Current Date is:" + c.getTime());
    }
}
```

**Output:**

```
The Current Date is:Wed Aug 06 11:10:40 UTC 2025
```

**Example 3:**

```java
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
   public static void main(String[] args) {

      // create calendar objects.
      Calendar cal = Calendar.getInstance();
      Calendar future = Calendar.getInstance();

      // print the current date
      System.out.println("Current date: " + cal.getTime());

      // change year in future calendar
      future.set(Calendar.YEAR, 2025);
      System.out.println("Year is " + future.get(Calendar.YEAR));

      // check if calendar date is after current date
      Date time = future.getTime();

      if (future.after(cal)) {
         System.out.println("Date " + time + " is after current date.");
      }
   }
}
```

**Output:**

```
Current date: Fri Sep 23 14:35:06 IST 2022
Year is 2025
Date Tue Sep 23 14:35:06 IST 2025 is after current date.
```

**Example 4:**

```java
// Program to demonstrate getMaximum() method of Calendar class

import java.util.*;
public class Calendar3 {
    public static void main(String[] args)
    {
        // creating calendar object
        Calendar calendar = Calendar.getInstance();

        int max = calendar.getMaximum(Calendar.DAY_OF_WEEK);
        System.out.println("Maximum number of days in a week: " + max);

        max = calendar.getMaximum(Calendar.WEEK_OF_YEAR);
        System.out.println("Maximum number of weeks in a year: " + max);
    }
}
```

**Output:**

```
Maximum number of days in a week: 7
Maximum number of weeks in a year: 53
```

**Example 5:**

```java
// Program to demonstrate add() method
// of Calendar class

import java.util.*;
public class Calendar5 {
    public static void main(String[] args)
    {
        // creating calendar object
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -15);
        System.out.println("15 days ago: " + calendar.getTime());
        calendar.add(Calendar.MONTH, 4);
        System.out.println("4 months later: " + calendar.getTime());
        calendar.add(Calendar.YEAR, 2);
        System.out.println("2 years later: " + calendar.getTime());
    }
}
```

**Output:**

```
15 days ago: Mon Aug 13 11:10:57 UTC 2018
4 months later: Thu Dec 13 11:10:57 UTC 2018
2 years later: Sun Dec 13 11:10:57 UTC 2020
```

---

### Locale Class

**What is it?**

- Represents a specific geographical, political, or cultural region.
- Comes from java.util.Locale.

**Why do we need it?**

- Used in internationalization (i18n) – for formatting messages, dates, currencies, etc. based on region/language.

**How it works?**

- You create Locale using language and country codes (e.g. "en", "US").

**Example 1:**

```java
import java.util.Locale;

public class LocaleExample {
    public static void main(String[] args) {
        Locale locale1 = new Locale("en", "US");
        Locale locale2 = new Locale("hi", "IN");

        System.out.println("Language: " + locale1.getDisplayLanguage());
        System.out.println("Country: " + locale2.getDisplayCountry());
    }
}
```

**Example 2:**

```java
import java.util.Locale;

public class LocaleDemo {
   public static void main(String[] args) {

      // create a new array and get all installed locales
      Locale[] locales = Locale.getAvailableLocales();

      // print locales
      System.out.println("Installed locales are:");

      for (int i = 0; i < locales.length; i++) {
         System.out.println(i + ":" + locales[i]);
      }
   }
}
```

**Example 3:**

```java
import java.util.Locale;

public class DefaultLocaleDemo {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        System.out.println("Default Locale: " + defaultLocale);
        System.out.println("Language: " + defaultLocale.getLanguage());
        System.out.println("Country: " + defaultLocale.getCountry());
    }
}
```

**Output:**

```
Default Locale: en_US
Language: en
Country: US
```

**Example 4:**

```java
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormattingDemo {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, defaultLocale);
        String formattedDate = dateFormat.format(new Date());
        System.out.println("Formatted Date: " + formattedDate);
    }
}
```

**Output:**

```
Formatted Date: Wednesday, January 8, 2025
```

**Example 5:**

```java
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormattingDemo {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(defaultLocale);
        double amount = 98765.43;
        String formattedCurrency = currencyFormat.format(amount);
        System.out.println("Formatted Currency: " + formattedCurrency);
    }
}
```

**Output:**

```
98,765.43
```

---

### java.time API

**Introduced in Java 8 – modern way to deal with dates and times (replaces Date, Calendar)**

#### LocalDate

- Represents a date (YYYY-MM-DD) without time or timezone.

**Example 1:**

```java
import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1995, 8, 15);

        System.out.println("Today: " + today);
        System.out.println("Birthday: " + birthday);
    }
}
```

#### LocalTime

- Represents a time (HH:MM:SS) without date or timezone.

**Example 2:**

```java
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalTime fixed = LocalTime.of(10, 30, 45);

        System.out.println("Current Time: " + now);
        System.out.println("Fixed Time: " + fixed);
    }
}
```

**Example 3:**

```java
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimeExample {

   public static void main(String args[]) {
      LocalDateTimeExample java8tester = new LocalDateTimeExample();
      java8tester.testLocalDateTime();
   }

   public void testLocalDateTime() {
      // Get the current date and time
      LocalDateTime currentTime = LocalDateTime.now();
      System.out.println("Current DateTime: " + currentTime);

      LocalDate date1 = currentTime.toLocalDate();
      System.out.println("date1: " + date1);

      Month month = currentTime.getMonth();
      int day = currentTime.getDayOfMonth();
      int seconds = currentTime.getSecond();

      System.out.println("Month: " + month +" day: " + day +" seconds: " + seconds);

      LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
      System.out.println("date2: " + date2);

      //12 december 2014
      LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
      System.out.println("date3: " + date3);

      //22 hour 15 minutes
      LocalTime date4 = LocalTime.of(22, 15);
      System.out.println("date4: " + date4);

      //parse a string
      LocalTime date5 = LocalTime.parse("20:15:30");
      System.out.println("date5: " + date5);
   }
}
```

#### Period

- Represents a period of time in years, months, days.

**Example 4:**

```java
import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2020, 1, 1);
        LocalDate end = LocalDate.now();

        Period period = Period.between(start, end);
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
    }
}
```

#### Duration

- Represents a duration of time in seconds, minutes, etc.
- Works with time-based classes like LocalTime, Instant.

**Example 5:**

```java
import java.time.Duration;
import java.time.LocalTime;

public class DurationExample {
    public static void main(String[] args) {
        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(12, 30);

        Duration duration = Duration.between(start, end);
        System.out.println("Total minutes: " + duration.toMinutes());
        System.out.println("Total seconds: " + duration.getSeconds());
    }
}
```

**Example 6:**

```java
import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.Period;

public class Java8Tester {

   public static void main(String args[]) {
      Java8Tester java8tester = new Java8Tester();
      java8tester.testPeriod();
      java8tester.testDuration();
   }

   public void testPeriod() {
      //Get the current date
      LocalDate date1 = LocalDate.now();
      System.out.println("Current date: " + date1);

      //add 1 month to the current date
      LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
      System.out.println("Next month: " + date2);

      Period period = Period.between(date2, date1);
      System.out.println("Period: " + period);
   }

   public void testDuration() {
      LocalTime time1 = LocalTime.now();
      Duration twoHours = Duration.ofHours(2);

      LocalTime time2 = time1.plus(twoHours);
      Duration duration = Duration.between(time1, time2);

      System.out.println("Duration: " + duration);
   }
}
```

---
