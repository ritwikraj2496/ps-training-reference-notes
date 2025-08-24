# Databases and MongoDB

## Limitations of RDBMS

1. In relational database we need to define structure and schema of data first and then only we can process the data.

2. Relational database systems provides consistency and integrity of data by enforcing ACID properties (Atomicity, Consistency, Isolation and Durability ). However in most of the other cases these properties are significant performance overhead and can make your database response very slow.

3. Most of the applications store their data in JSON format and RDBMS don’t provide you a better way of performing operations such as create, insert, update, delete etc on this data.

## What is NoSQL Database?

1. Not Only SQL (NoSQL) or non relational databases provides a mechanism for storage and retrieval of data other than tabular relations model used in relational databases. 

2. NoSQL database doesn't use tables for storing data. It is generally used to store big data and real-time web applications.

## Why NoSQL Database?

- NoSQL databases were created in response to the limitations of traditional relational database technology.

- When compared against relational databases, NoSQL databases are more scalable and provide superior performance, and their data model addresses several shortcomings of the relational model.

- Relational databases (SQL) are good for structured, tabular data, but modern apps (social media, IoT, e-commerce) handle huge, flexible, and unstructured data (JSON, images, logs). NoSQL is faster, scalable, flexible schema.

- The advantages of NoSQL include being able to handle:
  - Large volumes of structured, semi-structured, and unstructured data
  - Agile sprints, quick iteration, and frequent code pushes
  - Object-oriented programming that is easy to use and flexible
  - Efficient, scale-out architecture instead of expensive, monolithic architecture

## When to use NoSQL Database?

- When you want to store and retrieve huge amount of data.
- The relationship between the data you store is not that important
- The data is not structured and changing over time
- Constraints and Joins support is not required at database level
- The data is growing continuously and you need to scale the database regular to handle the data.

## Where to use NoSQL Database?

- Data isn't relational (e.g. Documents)
- Too much data to fit in a relational database

## How NoSQL stores data?

Stores data in different models → Documents, Key-Value pairs, Graphs, Columns.

**Example (JSON document in MongoDB):**

```json
{
  "id": 1,
  "name": "Alice",
  "age": 22,
  "skills": ["Java", "MongoDB"]
}
```

## Types of NoSQL Databases

1. Document Store (Focus)

- Stores data as JSON-like documents.
- Flexible, human-readable.
- Example: MongoDB, CouchDB.

2. Key-Value Store

- Simple dictionary-like structure.
- Example: Redis.

3. Graph Database

- Stores nodes & edges (great for social networks).
- Example: Neo4j.

4. Column Store

- Stores data in columns (efficient for analytics).
- Example: Cassandra.

## CAP Theorem vs ACID Properties

### ACID (Traditional Databases like SQL)

**What is ACID?**

- It describes how transactions in databases should behave to keep data safe and correct.

**A – Atomicity**

- All-or-nothing.
- Either the whole transaction happens or nothing happens.

- Example: Money transfer (₹100 from A to B) → Deduct from A and add to B, not just one.

**C – Consistency**

- Data must follow rules.
- After a transaction, the database should still make sense.

- Example: A student’s age cannot suddenly be negative.

**I – Isolation**

- Multiple users doing things at the same time should not interfere.

- Example: Two people booking the same seat online → only one should succeed.

**D – Durability**

- Once saved, it’s permanent (even if server crashes).

**Why ACID?** → Ensures correctness, safety, and trust in banking, ERP, inventory systems.

### CAP Theorem (Distributed / NoSQL Databases)

**What is CAP?**

- It explains the limitations of distributed databases (databases spread across multiple servers).

**C – Consistency**

- All nodes should show the same data at the same time.

- Example: If you update your profile picture, all servers should reflect it immediately.

**A – Availability**

- System should always respond, even if some parts are down.

- Example: If one server fails, others still answer your queries.

**P – Partition Tolerance**

- System should keep working even if communication between servers is broken.

- Example: In case of network issues, the system must not collapse.

**Rule:** You can only guarantee two out of three at any moment → CA, AP, or CP.

### Key Differences

| Feature    | **ACID (SQL)**                         | **CAP (NoSQL)**                                                |
| ---------- | ---------------------------------------- | ---------------------------------------------------------------- |
| Focus      | Transactions (single database)           | Distributed systems (multiple servers)                           |
| Purpose    | Keep data safe & correct                 | Handle scale, speed, failures                                    |
| Guarantees | **All 4 (A, C, I, D)**                   | Only **2 of 3 (C, A, P)**                                        |
| Example DB | MySQL, PostgreSQL, Oracle                | MongoDB, Cassandra, CouchDB                                      |
| Analogy    | Bank transactions (must be 100% correct) | Social media feed (better to be fast, even if slightly outdated) |

### Quick Analogy

ACID → Think of a bank. Every transaction must be 100% correct, even if it’s a bit slower.
Use Cases → Banking, Finance, Inventory, Healthcare (where correctness > speed). 

CAP → Think of Facebook/Instagram. Better to show posts fast, even if some are slightly old (eventual consistency).
Use Cases → Social media, E-commerce catalogs, IoT, Big Data (where scale + availability > strict consistency).

## Why MongoDB? – Use Cases

**Why MongoDB?**

- Schema-less → Flexible documents.
- Scales easily across servers.
- Easy to learn (JSON style).
- Strong developer community.

**Use Cases:**

- E-commerce product catalog.
- User profiles in apps.
- Real-time analytics.
- Content management systems.

## Setup & Creating Collections

### SQL

![sql example](./images/sqlexample.png)

### NoSQL

![mongodb example](./images/mongoexample.png)

### Setup and Creating Collections

Steps:

- Install MongoDB (Community Edition - Compass).
- Start MongoDB service.
- Open Mongo Shell (mongosh or mongo)

```javascript
// Show all databases
show dbs;

// Create/switch database - if the database doesn't exists, above command creates a new database otherwise opens the existing one.
use sapientdb;

// Create a collection
db.createCollection("students");

// Check collections - won't show until there is atleast one document inserted
show collections;
```

## CRUD Operations

```javascript
// Create/Insert

// In MongoDB you need not to create collection before you insert document in it. 
// With a single command you can insert a document in the collection and the MongoDB creates that collection on the fly.

// Syntax: 
// db.collection.insertOne({key:value, key:value})
db.students.insertOne({name:"Ritwik", company:"Sapient", age:29, course: "Java"});

// db.collection.insertMany({key:value,key:value})
db.students.insertMany([
  { name: "Bob", company:"Sapient", age: 25, course: "Python" },
  { name: "Charlie", company:"Sapient", age: 23, course: "MongoDB" }
]);

// We can also create collection before we actually insert data in it. This method provides you the options that you can set while creating a collection.

// Syntax: db.createCollection(name, options)
// name is the collection name
// options is an optional field that we can use to specify certain parameters such as size, max number of documents etc. in the collection.

db.createCollection("employees");

// Note: MongoDB stores data records as BSON documents. BSON is a binary representation of JSON documents.

// Read (Find)
// Syntax: db.collection.find(query,projection)
db.students.find();                  // All
db.students.find({ name: "Alice" }); // Filter

// findOne()
// to select only one document, we can use the findOne() method.
db.students.findOne()

// Update
// Syntax: 
// db.collection_name.updateOne(<filter>,<update>)
db.students.updateOne(
  { name: "Alice" },
  { $set: { age: 23 } }
);

// Insert if not found
// If you would like to insert the document if it is not found, you can use the upsert option.

db.students.updateOne( 
  { title: "Post Title 5" }, 
  {
    $set: 
      {
        title: "Post Title 5",
        body: "Body of post.",
        category: "Event",
        likes: 5,
        tags: ["news", "events"],
        date: Date()
      }
  }, 
  { upsert: true }
)

// db.collection_name.updateMany(<filter>,<update>)
db.posts.updateMany({}, { $inc: { likes: 1 } })


// Delete - delete documents by using the methods deleteOne() or deleteMany()
// Syntax: 
db.students.deleteOne({ name: "Charlie" });
db.posts.deleteMany({ category: "Technology" })

// Delete/Drop a database
db.dropDatabase()
db.collection_name.drop()
```

## Query Operators

**Comparison Operators**

The following operators can be used in queries to compare values:

```javascript
$eq: Values are equal
$ne: Values are not equal
$gt: Value is greater than another value
$gte: Value is greater than or equal to another value
$lt: Value is less than another value
$lte: Value is less than or equal to another value
$in: Value is matched within an array
```

**Logical Operators**

The following operators can logically compare multiple queries.

```javascript
$and: Returns documents where both queries match
$or: Returns documents where either query matches
$nor: Returns documents where both queries fail to match
$not: Returns documents where the query does not match
```

**Evaluation Operators**

The following operators assist in evaluating documents.

```javascript
$regex: Allows the use of regular expressions when evaluating field values
$text: Performs a text search
$where: Uses a JavaScript expression to match documents
```

## MongoDB Update Operators

**Fields**

The following operators can be used to update fields:

```javascript
$currentDate: Sets the field value to the current date
$inc: Increments the field value
$rename: Renames the field
$set: Sets the value of a field
$unset: Removes the field from the document
```

**Array**

The following operators assist with updating arrays.

```javascript
$addToSet: Adds distinct elements to an array
$pop: Removes the first or last element of an array
$pull: Removes all elements from an array that match the query
$push: Adds an element to an array
```

## Aggregation Pipelines

- Aggregation operations allow you to group, sort, perform calculations, analyze data, and much more.

- Aggregation pipelines can have one or more "stages". The order of these stages are important. Each stage acts upon the results of the previous stage.

### $group

This aggregation stage groups documents by the unique _id expression provided.

**Note:** Don't confuse this _id expression with the _id ObjectId provided to each document.

```javascript
db.listingsAndReviews.aggregate(
    [ { $group : { _id : "$property_type" } } ]
)
```
- This will return the distinct values from the property_type field.

### $limit

This aggregation stage limits the number of documents passed to the next stage.

```javascript
db.movies.aggregate([ { $limit: 1 } ])
```

- This will return the 1 movie from the collection.

### $project

This aggregation stage passes only the specified fields along to the next aggregation stage.

```javascript
db.restaurants.aggregate([
  {
    $project: {
      "name": 1,
      "cuisine": 1,
      "address": 1
    }
  },
  {
    $limit: 5
  }
])
```

- This will return the documents but only include the specified fields.
- Notice that the _id field is also included. This field is always included unless specifically excluded.
- We use a 1 to include a field and 0 to exclude a field.

### $sort

This aggregation stage groups sorts all documents in the specified sort order.

```javascript
db.listingsAndReviews.aggregate([ 
  { 
    $sort: { "accommodates": -1 } 
  },
  {
    $project: {
      "name": 1,
      "accommodates": 1
    }
  },
  {
    $limit: 5
  }
])
```

- This will return the documents sorted in descending order by the accommodates field.
- The sort order can be chosen by using 1 or -1. 1 is ascending and -1 is descending.

### $match

This aggregation stage behaves like a find. It will filter documents that match the query provided.

**Note:** Using $match early in the pipeline can improve performance since it limits the number of documents the next stages must process.

```javascript
db.listingsAndReviews.aggregate([ 
  { $match : { property_type : "House" } },
  { $limit: 2 },
  { $project: {
    "name": 1,
    "bedrooms": 1,
    "price": 1
  }}
])
```

- This will only return documents that have the property_type of "House".

### $addFields

This aggregation stage adds new fields to documents.

```javascript
db.restaurants.aggregate([
  {
    $addFields: {
      avgGrade: { $avg: "$grades.score" }
    }
  },
  {
    $project: {
      "name": 1,
      "avgGrade": 1
    }
  },
  {
    $limit: 5
  }
])
```

- This will return the documents along with a new field, avgGrade, which will contain the average of each restaurants grades.score.

### $count

This aggregation stage counts the total amount of documents passed from the previous stage.

```javascript
db.restaurants.aggregate([
  {
    $match: { "cuisine": "Chinese" }
  },
  {
    $count: "totalChinese"
  }
])
```

- This will return the number of documents at the $count stage as a field called "totalChinese".

### Example:

```javascript
// Show first 2 students
db.students.find().limit(2);

// Skip first 1 result
db.students.find().skip(1);

// Sort by age ascending
db.students.find().sort({ age: 1 });

// Sort by age descending
db.students.find().sort({ age: -1 });

// Count students per course
db.students.aggregate([
  { $group: { _id: "$course", total: { $count: {} } } }
]);

// Show name and course only
db.students.aggregate([
  { $project: { name: 1, course: 1 } }
]);
```

## Indexing Overview: Single Field & Compound

**What?**

- Index = Shortcut for searching, like an index in a book.

**Why?**

- Makes queries faster.

**Types:**

- Single field → One column/field.
- Compound index → Multiple fields.

```javascript
// Single field
db.students.createIndex({ age: 1 });

// Compound
db.students.createIndex({ course: 1, age: -1 });
```

## Java Integration with MongoDB

**What?**

- MongoDB provides a Java Driver to connect and perform CRUD.

**Steps:**

1. Add MongoDB Driver dependency (Maven/Gradle).
2. Connect using MongoClient.
3. Perform CRUD using MongoCollection.

**Example (Java + MongoDB Driver):**

```java
import com.mongodb.client.*;
import org.bson.Document;

public class MongoDemo {
    public static void main(String[] args) {
        // Connect
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = client.getDatabase("mydb");
        MongoCollection<Document> students = db.getCollection("students");

        // Insert
        Document doc = new Document("name", "Alice")
                            .append("age", 22)
                            .append("course", "Java");
        students.insertOne(doc);

        // Find
        for (Document d : students.find()) {
            System.out.println(d.toJson());
        }
    }
}
```