# JavaScript Objects, BOM & DOM

## Creating & Accessing Objects

**What is it?**

An object in JavaScript is a collection of key-value pairs (like a dictionary).

**Why do we need it?**

We use objects to group related data and actions in one place.

**How it works?**

- Keys (properties) store values.
- We can access them using dot notation or [] notation.

**Examples:**

```javascript
// Example 1: Create and Access
let person = { name: "John", age: 25 };
console.log(person.name); // John
console.log(person["age"]); // 25

// Example 2: Update & Add
person.city = "Delhi";
person.age = 26;
console.log(person);
```

## Nested Objects & Arrays

**What is it?**

Objects can have arrays inside them, and arrays can have objects inside them.

**Why do we need it?**

To represent complex data (like users with multiple addresses).

**How it works?**

Access step by step using dot or index.

**Examples:**

```javascript
// Example 1: Object with Array
let student = {
  name: "Asha",
  subjects: ["Math", "Science", "English"],
};
console.log(student.subjects[1]); // Science

// Example 2: Array of Objects
let users = [
  { name: "Sam", age: 20 },
  { name: "Rita", age: 22 },
];
console.log(users[1].name); // Rita
```

## Browser Object Model (BOM)

**What is BOM?**

The Browser Object Model (BOM) is a set of objects provided by the browser that allow JavaScript to interact with the browser itself, not just the webpage (DOM).

- Think of DOM = your webpage’s content (HTML elements).
- BOM = your browser’s environment (window, history, location, etc.).

**Why do we need BOM?**

- To control and interact with the browser features.

- Examples:

  - Redirecting to another page (location.href)
  - Checking browser details (navigator.userAgent)
  - Navigating forward/backward (history.back())
  - Opening new windows (window.open)

- Main BOM Objects
  - window → The main global object (everything lives inside it).
  - navigator → Info about browser & device.
  - location → Info about current URL, can also redirect.
  - history → Browser history navigation.
  - frames → Access multiple frames/iframes.

### Examples:

- **window**

The global object in a browser. All functions, variables, timers, alerts belong to it.

```javascript
// Example 1: Alerts & Prompts
window.alert("Hello from Window!");
let name = window.prompt("Enter your name:");
console.log("You entered:", name);

// Example 2: Timers
let timerId = window.setTimeout(() => {
  console.log("This runs after 2 seconds");
}, 2000);

// Clear timeout
window.clearTimeout(timerId);

// Example 3: location
console.log(window.location.href);
```

- **navigator**

Provides information about the browser and device.

```javascript
// Example 1: Browser details
console.log("Browser Info:", navigator.userAgent);

// Example 2: Online/Offline check
if (navigator.onLine) {
  console.log("You are online!");
} else {
  console.log("You are offline!");
}

// Example 3: Geolocation (if supported)
navigator.geolocation.getCurrentPosition((pos) => {
  console.log("Latitude:", pos.coords.latitude);
  console.log("Longitude:", pos.coords.longitude);
});
```

- **location**

Represents the current URL, and lets us redirect or reload the page.

```javascript
// Example 1: Current URL
console.log("URL:", location.href);

// Example 2: Redirect
// location.href = "https://www.google.com";

// Example 3: Reload
// location.reload();
```

- **history**

Lets us move back and forward through browser history.

```javascript
// Example 1: Back and Forward
// history.back();   // Go back one page
// history.forward(); // Go forward one page

// Example 2: Go n steps
// history.go(-2); // Go back 2 pages
// history.go(1);  // Forward 1 page

// Example 3: History length
console.log("Number of visited pages in session:", history.length);
```

- **frames**

Used to access frames or iframes in a page.

```javascript
<!-- Example 1: Create iframe -->
<iframe id="f1" src="https://example.com" width="300" height="200"></iframe>

<script>
// Access iframe content
let frame = window.frames[0];
console.log("Frame loaded:", frame);
</script>
```

## Document Object Model (DOM)

**What is DOM?**

- The DOM is a tree-like structure created by the browser for every HTML page.
- It represents all elements (p tag, div tag, form tag, etc.) as objects that can be accessed and modified using JavaScript.

Think of it like:

- HTML Page → converted into → DOM Tree → controlled by JavaScript.

**Why do we need DOM?**

- To read content (get text, values, attributes).
- To change content (update text, HTML, styles).
- To add/remove elements dynamically.
- To make pages interactive (form validations, dynamic lists, animations, etc.).

**How it works?**

We use DOM methods and properties to access and change elements.

- getElementById → select by ID.
- querySelector → select by CSS selector.
- .innerText → read/write plain text of element.
- .innerHTML → read/write HTML content (with tags).

### Examples:

- **getElementById**

Finds a single element using its id attribute.

```javascript
<p id="para">Hello World!</p>
<script>
// Example 1: Access element
let p = document.getElementById("para");
console.log(p.innerText); // Hello World!

// Example 2: Change text
p.innerText = "Changed using getElementById!";
</script>
```

- **querySelector**

Selects the first element that matches a CSS selector (id, class, tag, etc.).

```javascript
<p id="myPara">Original Text</p>
<p class="msg">Message 1</p>
<p class="msg">Message 2</p>
<script>
// Example 1: Select by class
let firstMsg = document.querySelector(".msg");
console.log(firstMsg.innerText); // Message 1

// Example 2: Select by tag
let para = document.querySelector("p");
para.style.color = "blue";

//Example 3: Select by id
let secondMsg = document.querySelector("#myPara");
console.log(secondMsg);

//Example 4: Select by tag - applying style to all paragraphs
let para = document.querySelectorAll("p");
para[1].style.color = "blue";

for(let i=0; i<para.length; i++){
    para[i].style.color = "blue";
}
</script>
```

- **.innerText**

Gets or sets only the visible text of an element (ignores HTML tags).

```javascript
<div id="textDiv"><b>Bold Text</b> with normal text</div>
<script>
// Example 1: Read innerText
let div = document.getElementById("textDiv");
console.log(div.innerText); // Bold Text with normal text

// Example 2: Set innerText
div.innerText = "Replaced with plain text (no tags)";


// Example 3:
<div id="htmlDiv">Hello <b>World</b></div>
<p id="btnMsg">Waiting for button click...</p>
<button type="submit" onclick="clickButton()">Submit</button>

let button = document.getElementById("btnMsg");
function clickButton(){
    button.innerText = "you clicked button"
}
</script>
```

- **.innerHTML**

Gets or sets the HTML code inside an element (includes tags).

```javascript
<button onclick="clickButton()">Click Me!</button>

<script>
// Example 1: Read innerHTML
let htmlDiv = document.getElementById("htmlDiv");
console.log(htmlDiv.innerHTML); // Hello <b>World</b>

// Example 2: Set innerHTML
htmlDiv.innerHTML = "New <i>Italic</i> Text";
</script>
```

- **Difference between .innerText vs .innerHTML**

| Feature            | innerText (Plain Text) | innerHTML (With HTML tags)     |
| ------------------ | ---------------------- | ------------------------------ |
| Returns            | Visible text only      | HTML code (with tags)          |
| When setting value | Inserts as plain text  | Inserts as HTML (renders tags) |
| Example            | `"Hello World"`        | `"Hello <b>World</b>"`         |

#### Hands-on Practice

1. Create a p tag with id myPara.

- Change its text using getElementById.
- Change its color using querySelector.

2. Create a div tag with HTML content.

- Read the content using .innerText.
- Replace it with new bold text using .innerHTML.

3. Build a button:

- On click, update a p tag to say "You clicked the button!".

4. Create two paragraphs with class "msg".

- Use querySelector to change only the first one.

## Changing Styles & Attributes

**What is it?**

JavaScript can change the CSS styles and HTML attributes of elements dynamically.

**Why do we need it?**

- To make interactive UIs (theme switch, highlight, hide/show).
- To update attributes like src, href, alt, id, class dynamically.

**How it works?**

- Change style: element.style.property = value
- Change attribute: element.setAttribute(name, value) / element.getAttribute(name)

**Examples:**

```javascript
<p id="p1">Change my style!</p>
<img id="img1" src="https://placehold.co/600x400">

<script>
// Example 1: Changing CSS Style
let para = document.getElementById("p1");
para.style.color = "blue";
para.style.fontSize = "20px";

// Example 2: Changing Attribute
let img = document.getElementById("img1");
img.setAttribute("src", "https://placehold.co/200x200");
img.setAttribute("alt", "New Image");
console.log(img.getAttribute("alt")); // New Image
</script>
```

## Form, Input, Select Element Access via JS

**What is it?**

Forms (form tag), inputs (input tag), and select dropdowns (select tag) can be read and controlled using JavaScript.

**Why do we need it?**

- To collect and process user data (login, search, signup).
- To set default values or read selected options.

**How it works?**

- Access value: element.value
- Access selected option: select.options[select.selectedIndex].value
- Access checkbox/radio: element.checked

**Examples:**

```javascript
<form id="myForm">

  <input type="text" id="username" value="Guest"><br/>

  <input type="checkbox" name="" id="subscribe" checked>Subscribe<br/>

  <label for="">Gender:</label><br />
      <input type="checkbox" name="gender" checked value="Male" />Male<br />
      <input type="checkbox" name="gender" value="Female" />Female<br />
      <input type="checkbox" name="gender" checked value="Others" />Others<br />

  <select id="city">
    <option value="delhi">Delhi</option>
    <option value="mumbai" selected>Mumbai</option>
    <option value="Pune">Pune</option>
  </select><br />

  <button type="submit">Submit</button>
</form>

<script>
// Example 1: Access input value
let user = document.getElementById("username").value;
console.log("User:", user); // Guest

// Example 2: Access selected option
let city = document.getElementById("city");
console.log("Selected:", city.options[city.selectedIndex].value); // mumbai

// Example 3: Access single option - boolean
let sub = document.getElementById("subscribe").checked;
console.log("Subscribed", sub);

// Example 3: Access multiple option
let checkedGenders = document.querySelectorAll(
    'input[name="gender"]:checked'
);

console.log(checkedGenders);

checkedGenders.forEach((gender) => {
    console.log("Checked: ", gender.value);
});
</script>
```

## Form Events (onchange, onsubmit, onfocus, onblur)

**What is it?**

Form elements trigger events when users interact with them.

- onchange → When value changes (dropdown, checkbox, input).
- onsubmit → When form is submitted.
- onfocus → When input gains focus (clicked into).
- onblur → When input loses focus (clicked away).

**Why do we need it?**

- To validate forms before submit.
- To give live feedback while typing.
- To handle user actions immediately.

**How it works?**

Attach events directly in HTML or via JS (addEventListener).

**Examples:**

```javascript
<form id="form1">
  <input type="text" id="name" placeholder="Enter name">
  <select id="lang">
    <option>JavaScript</option>
    <option>Python</option>
    <option>Java</option>
  </select>
  <button type="submit">Submit</button>
</form>

<script>
// Example 1: onchange (dropdown)
document.getElementById("lang").onchange = function() {
  console.log("You selected:", this.value);
};

// Example 2: onfocus & onblur
let nameInput = document.getElementById("name");
nameInput.onfocus = function() {
  this.style.background = "lightyellow";
};
nameInput.onblur = function() {
  this.style.background = "white";
};

// Example 3: onsubmit
document.getElementById("form1").onsubmit = function(e) {
  e.preventDefault(); // prevent reload
  alert("Form submitted with name: " + nameInput.value); //concatenation in alert
  console.log("Form submitted with name: ", nameInput.value); //comma in console.log
};
</script>
```

### Hands-on Practice

1. Create a paragraph with a button → change its font size and color on click.
2. Build a form with name + email + city dropdown.
   - On submit, print values in console instead of reloading page.
3. Highlight an input box with yellow background when it’s focused, and white when it loses focus.
4. Add a select box with multiple options → show an alert whenever user changes the option.

## Validating Form Data with JavaScript

**What is it?**

Form validation means checking user input before sending it to the server.

Examples:

- Ensure required fields are not empty.
- Validate email format.
- Check if passwords match.

**Why do we need it?**

- Prevents invalid or incomplete data from being submitted.
- Saves server load by catching errors early.
- Improves user experience with instant feedback.

**How it works?**

- Access form fields with DOM (getElementById).
- Use conditions (if) to check values.
- Show error messages or block submission using event.preventDefault().

**Examples:**

```javascript
<form id="signup">
  <input type="text" id="username" placeholder="Enter username"><br>
  <input type="email" id="email" placeholder="Enter email"><br>
  <input type="password" id="pass" placeholder="Enter password"><br>
  <button type="submit">Register</button>
</form>

<script>
// Example 1: Required field check
document.getElementById("signup").onsubmit = function(e) {
  e.preventDefault(); // stop reload
  let user = document.getElementById("username").value;
  if (user === "") {
    alert("Username is required!");
  } else {
    alert("Welcome " + user);
  }
};

// Example 2: Email format validation
let email = "user@gmail.com";
console.log(/\S+@\S+\.\S+/.test(email)); // true
</script>
```

## Using .value, .checked, .selectedIndex

**What is it?**

These are properties used to get or set form input values.

- .value → Returns/sets the text value of input or textarea.
- .checked → Returns true/false for checkbox or radio button.
- .selectedIndex → Returns index of selected option in dropdown.

**Why do we need it?**

- To read what the user typed, selected, or checked.
- To control inputs programmatically.

**How it works?**

- input.value → "John"
- checkbox.checked → true / false
- select.options[select.selectedIndex].text → "Delhi"

**Examples:**

```javascript
<form id="myForm">
  <input type="text" id="name" value="Ritwik"><br>
  <input type="checkbox" id="subscribe" checked> Subscribe<br>
  <select id="city">
    <option>Delhi</option>
    <option selected>Mumbai</option>
    <option>Pune</option>
  </select>
</form>

<script>
// Example 1: .value
let name = document.getElementById("name").value;
console.log("Name:", name); // Ritwik

// Example 2: .checked
let sub = document.getElementById("subscribe").checked;
console.log("Subscribed?", sub); // true

// Example 3: .selectedIndex
let city = document.getElementById("city");
let selectedCity = city.options[city.selectedIndex].text;
console.log("City:", selectedCity); // Mumbai
</script>
```

### Hands-on Practice Ideas for Trainees

1. Create a login form with username + password.
   - Validate that both fields are not empty.
   - Show alert "Login successful!" if valid.
2. Create a form with a checkbox "Accept Terms & Conditions".
   - Prevent form submission unless it is checked.
3. Create a dropdown of cities.

- When the form is submitted, show "You selected: <city>".

4. Build a newsletter form with:
   - Text input for email.
   - Checkbox for subscription.
   - Validate email format and check if subscription box is ticked.

## Traversing the DOM

**What is Traversing the DOM?**

- DOM (Document Object Model) represents your HTML as a tree structure.
- Traversing means navigating this tree — moving up (parent), down (children), or sideways (siblings).
- Helps us find and manipulate related elements without always using selectors.

1. **parentNode**

Moves one level up (to the parent of an element).

**Example 1:**

```javascript
<div id="parent">
  <p id="child">Hello</p>
</div>

<script>
  let child = document.getElementById("child");
  console.log(child.parentNode); // <div id="parent">...</div>
</script>
```

**Example 2:**

```javascript
<ul>
  <li id="item">Apple</li>
</ul>

<script>
  let li = document.getElementById("item");
  li.parentNode.style.border = "2px solid red"; // styling the parent <ul>
</script>
```

2. **children**

- Returns all child elements (ignores text nodes).
- Works like an array (but is an HTMLCollection).

**Example 1:**

```javascript
<ul id="fruits">
  <li>Apple</li>
  <li>Banana</li>
  <li>Mango</li>
</ul>

<script>
  let list = document.getElementById("fruits");
  console.log(list.children[0].innerText); // Apple
</script>
```

**Example 2:**

```javascript
<script>
  let list = document.getElementById("fruits");
  for (let child of list.children) {
    child.style.color = "blue";
  }
</script>
```

🔹 3. **nextSibling**

- Moves to the next node at the same level.
- May include text nodes (like spaces).
- Better option: nextElementSibling (skips text nodes).

**Example 1:**

```javascript
<p id="p1">First</p>
<p id="p2">Second</p>

<script>
  let first = document.getElementById("p1");
  console.log(first.nextSibling); // Might show text or <p> depending on spacing
  console.log(first.nextElementSibling.innerText); // "Second"
</script>
```

**Example 2:**

```javascript
<ul>
  <li id="apple">Apple</li>
  <li>Banana</li>
</ul>

<script>
  let apple = document.getElementById("apple");
  apple.nextElementSibling.style.color = "green"; // Banana turns green
</script>
```

## Creating & Removing Elements

**Why?**

- Sometimes we need to add new elements (like new items in a list) or remove old ones (like deleting tasks in a to-do app).
- DOM gives us methods to dynamically build UI.

1. **createElement()**

Creates a new element node.

**Example 1:**

```javascript
<div id="box"></div>

<script>
  let para = document.createElement("p");
  para.innerText = "I am new here!";
  document.getElementById("box").appendChild(para);
</script>
```

**Example 2:**

```javascript
<ul id="list"></ul>

<script>
  let newItem = document.createElement("li");
  newItem.innerText = "Mango";
  document.getElementById("list").appendChild(newItem);
</script>
```

2. **appendChild()**

Adds the newly created element inside a parent.

**Example 1:**

```javascript
<script>
  let div = document.createElement("div"); div.innerText = "Appended Div!";
  document.body.appendChild(div);
</script>
```

**Example 2:**

```javascript
<script>
  let li = document.createElement("li"); li.innerText = "Pineapple";
  document.getElementById("list").appendChild(li);
</script>
```

3. **remove()**

Directly removes an element.

**Example 1:**

```javascript
<p id="removeMe">Delete this</p>

<script>
  let para = document.getElementById("removeMe");
  para.remove(); // gone!
</script>
```

**Example 2:**

```javascript
<ul id="list">
  <li id="one">One</li>
  <li>Two</li>
</ul>

<script>
  let li = document.getElementById("one");
  li.remove(); // removes "One"
</script>
```

4. **removeChild()**

Removes a specific child from parent.

**Example 1:**

```javascript
<ul id="nums">
  <li>1</li>
  <li>2</li>
</ul>

<script>
  let parent = document.getElementById("nums");
  parent.removeChild(parent.children[0]); // removes "1"
</script>
```

**Example 2:**

```javascript
<script>
  let parent = document.getElementById("nums");
  while (parent.firstChild) {
    parent.removeChild(parent.firstChild); // clears the list
  }
</script>
```

## Updating Content & Classes Dynamically

**What is it?**

In JavaScript, you can change content (text, HTML, images) and update CSS classes of elements dynamically after the page has loaded.

**Why do we need it?**

- To make web pages interactive.
- To update information without reloading the page.
- To change look/feel (styles) based on user actions.

**How it works?**

- Use .innerText or .innerHTML to update text/HTML.
- Use .classList methods (add(), remove(), toggle(), contains()) to manipulate classes.

**Example 1: Update text dynamically**

```javascript
<p id="msg">Hello, Trainee!</p>
<button onclick="changeText()">Change Text</button>

<script>
  function changeText() {
    document.getElementById("msg").innerText = "Text updated using JavaScript!";
  }
</script>
```

**Example 2: Toggle a CSS class**

```javascript
<style>
  .highlight { color: red; font-weight: bold; }
</style>

<p id="para">Click button to highlight me</p>
<button onclick="toggleHighlight()">Toggle Highlight</button>

<script>
  function toggleHighlight() {
    document.getElementById("para").classList.toggle("highlight");
  }
</script>
```

## Event Listeners (addEventListener)

**What is it?**

An event listener is a function that waits for a specific event (like click, hover, keypress) to happen on an element and then runs some code.

**Why do we need it?**

- Cleaner and more flexible than inline onclick.
- Multiple listeners can be added to the same element.
- Good for separation of HTML & JS code.

**How it works?**

Syntax:

```javascript
element.addEventListener("eventName", functionToRun);
```

**Example 1: Button Click with Event Listener**

```javascript
<button id="btn">Click Me</button>
<p id="output"></p>

<script>
  document.getElementById("btn").addEventListener("click", function() {
    document.getElementById("output").innerText = "Button was clicked!";
  });
</script>
```

**Example 2: Mouse Over Event**

```javascript
<p id="hoverText">Hover over me!</p>

<script>
  const text = document.getElementById("hoverText");
  text.addEventListener("mouseover", () => {
    text.style.color = "blue";
  });
  text.addEventListener("mouseout", () => {
    text.style.color = "black";
  });
</script>
```

## JS Event Flow (Bubbling vs Capturing)

**What is it?**

- When an event happens on an element inside another element, the event can travel in two ways:
  - Capturing (Trickling Down): From the outermost parent → down to the target.
  - Bubbling (Default in JS): From the target element → up to the parent → up to the root.

**Why do we need it?**

- Helps in handling events at multiple levels (like button inside a div).
- Useful for event delegation (attaching one event handler to a parent to manage many children).

**How it works?**

- Default is bubbling (third parameter false).
- Pass true in addEventListener for capturing.

**Example 1: Bubbling (default)**

```javascript
<div id="parent" style="padding:20px; border:2px solid blue;">
  Parent Div
  <button id="child">Click Me</button>
</div>

<script>
  document.getElementById("parent").addEventListener("click", () => {
    alert("Parent clicked (bubbling)");
  });

  document.getElementById("child").addEventListener("click", () => {
    alert("Child button clicked");
  });
</script>
```

**Note:-** Clicking the button will trigger both alerts (child first, then parent).

**Example 2: Capturing Mode**

```javascript
<div id="outer" style="padding:20px; border:2px solid red;">
  Outer Div
  <div id="inner" style="padding:20px; border:2px solid green;">
    Inner Div
    <button id="btn">Click Me</button>
  </div>
</div>

<script>
  document.getElementById("outer").addEventListener("click", () => {
    alert("Outer Div (Capturing)");
  }, true);  // true = capturing

  document.getElementById("btn").addEventListener("click", () => {
    alert("Button Clicked");
  });
</script>
```

**Note:-** Now the outer div fires first before the button itself.

## Problem Statement: Student Registration & Dashboard App

You need to build a small web app called Student Registration & Dashboard using pure HTML, CSS, and JavaScript.
The app should allow users (students) to fill a registration form, validate inputs, display the data in a list (dashboard), and allow interaction with the displayed data.

**Requirements:**

1. Creating & Accessing Objects + Nested Objects/Arrays

- Store each student’s information as an object (name, email, gender, course).
- Keep all registered students inside an array (list of objects).

2. Form + Input + Select Access

- The form should include:

  - Name (text input)
  - Email (text input)
  - Gender (radio buttons – Male/Female/Other)
  - Course (dropdown select with at least 3 options)

3. Form Events

- Use onfocus to highlight input fields.
- Use onblur to remove highlight.
- Use onchange on dropdown to show a quick preview message of the selected course.
- On onsubmit, validate the form before adding the student to the list.

4. Validating Form Data

- Ensure name is not empty.
- Ensure email contains “@”.
- Ensure one gender is selected.
- Ensure a course is chosen (not default).

5. Using .value, .checked, .selectedIndex

- Fetch input values properly.
- Use .checked for radio buttons.
- Use .selectedIndex or .value for dropdown.

6. DOM Access & Updates

- Use getElementById or querySelector to access form fields.
- Use .innerText or .innerHTML to display success/error messages.

7. Creating & Removing Elements

- When a student is registered, create a new row in a student dashboard table/list dynamically.
- Add a Delete button beside each entry which, when clicked, removes the student from the list.

8. Traversing DOM

- Use .parentNode and .children when handling row deletion or updates.

9. Changing Styles & Attributes

- Highlight error fields in red border.
- Success messages should appear in green text.
- Alternate rows in the dashboard table should have different background colors (dynamic class addition).

10. Updating Content & Classes Dynamically

- Add a "status" column that changes dynamically:
  - Default: “Active”
  - If the student is deleted, mark it as “Removed” (before actually removing from DOM).

11. Event Listeners

- Use addEventListener for button clicks, form submission, and row interactions.

12. JS Event Flow (Bubbling vs Capturing)

- Demonstrate event bubbling by adding a click listener on the table that also detects which student row was clicked.
  (Optional: Show capturing by adding listeners with true flag).

13. Intro to BOM

- Use window.alert() to show a confirmation before deleting a student.
- Display the user’s browser details (navigator.userAgent) in a footer section.
- Provide a button “Visit Course Page” that uses location.href to redirect to an external website (e.g., a course page).

Add a “Back” button that uses history.back().

**Example Hands-on Flow:**

- Student fills the form → JS validates inputs → If valid, creates a student object and pushes it into array.
- Dashboard (table/list) updates dynamically → New student added with Delete button.
- Clicking delete → Confirms with window.alert, updates status → Removes the row.
- Dropdown onchange shows preview → “You selected: Web Development”.
- Different events (focus, blur, submit, bubbling in table) can be observed.
- Footer shows → “You are using Chrome on Windows” (from BOM).

**Solution:**

- [Student Registration & Dashboard Application](./HTML-CSS-JavaScript/studentRegistrationDashboard.html)
