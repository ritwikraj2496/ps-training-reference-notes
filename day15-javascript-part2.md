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
- It represents all elements (<p>, <div>, <form>, etc.) as objects that can be accessed and modified using JavaScript.

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
let secondMsg = document.querySelector("#para");
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

1. Create a <p> with id myPara.

- Change its text using getElementById.
- Change its color using querySelector.

2. Create a <div> with HTML content.

- Read the content using .innerText.
- Replace it with new bold text using .innerHTML.

3. Build a button:

- On click, update a <p> to say "You clicked the button!".

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

Forms (<form>), inputs (<input>), and select dropdowns (<select>) can be read and controlled using JavaScript.

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
  console.log("Form submitted with name: ", username.value); //comma in console.log
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