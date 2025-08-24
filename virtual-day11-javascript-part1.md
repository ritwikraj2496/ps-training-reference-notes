# JavaScript Basics

## script Tag & src Attribute

**What is it?**

- The script tag is used to add JavaScript code to an HTML page.
- The src attribute lets you link an external JavaScript file instead of writing all code inside HTML.

**Why do we need it?**

- Keeps code organized and reusable.
- Separates structure (HTML), styling (CSS), and logic (JS).

**How it works?**

- Inline JS → Written directly inside <script>.
- External JS → Linked with src="file.js".

```javascript
<!DOCTYPE html>
<html>
<head>
  <title>Script Example</title>
</head>
<body>
  <h1>Hello World</h1>

  <!-- Inline Script -->
  <script>
    console.log("Hello from Inline Script!");
  </script>

  <!-- External Script -->
  <script src="app.js"></script>
</body>
</html>
```

## Best Practices: Placing JS in HTML

- Place script tag at the end of <body> so that HTML loads first.
- Avoid mixing JS inside HTML tags → use event listeners.

**Example – Good Placement:**

```javascript
<body>
  <h2>Click Me!</h2>
  <button id="btn">Click</button>

  <script>
    document.getElementById("btn").onclick = function () {
      alert("Button clicked!");
    };
  </script>
</body>
```

## Hiding JS from Old Browsers

- (Older browsers didn’t understand script tag → now almost obsolete)

```javascript
<script type="text/javascript">
//<![CDATA[
  alert("Hello");
//]]>
</script>
```

## Printing in JavaScript

- [Different ways of printing in JavaScript](../ps-training-reference-notes/HTML&CSS&JavaScript/printingInJS.html)

## Variables, Data Types, and Operators

**Variables**

- Used to store data.
- Declared with var, let, or const.

- [Types of Declarations and its Differences](./HTML&CSS&JavaScript/typesOfDeclarationsJS.html)

**Data Types**

- String → "Hello"
- Number → 10, 3.14
- Boolean → true / false
- Object → {key: value}
- Array → [1,2,3]
- Null, Undefined

**Operators**

- Arithmetic: + - * / % **
- Comparison: == === != > <
- Logical: && || !

**Example:**

```javascript
let name = "Ritwik";
let age = 25;
let isTrainer = true;

console.log(name + " is " + age + " years old."); 
console.log(age > 18 && isTrainer); // true
```

## Conditional Statements (if, switch)

**if-else**

```javascript
let age = 20;
if (age >= 18) {
  console.log("You can vote.");
} else {
  console.log("Too young!");
}
```

**switch**

```javascript
let day = "Mon";
switch(day) {
  case "Mon": console.log("Start of week"); break;
  case "Fri": console.log("Weekend soon"); break;
  default: console.log("Normal day");
}
```

## Loops in JS

- [Types of FOR loops in JavaScript](./HTML&CSS&JavaScript/typesOfForLoopJS.html)

## Arrays in JS

- [Creation of Array and Different Types of Array Methods](./HTML&CSS&JavaScript/jsArrayMethods.html)

## Strings in JS

- [Creation of String and Different Types of String Methods](./HTML&CSS&JavaScript/jsStringmethods.html)

## Dates (Date object basics: creation, formatting)

- [Developing Digital Clock and Understanding Date Methods](./HTML&CSS&JavaScript/digitalClock.html)

## Defining, Calling Functions, Function Expressions & Hoisting

- [Difference ways of writing Functions in JavaScript](./HTML&CSS&JavaScript/typesOfFunctionsJS.html)

## Document Object Model (DOM Basics)

- [To Do List application using JS DOM concept](./HTML&CSS&JavaScript/toDoListBasic.html)