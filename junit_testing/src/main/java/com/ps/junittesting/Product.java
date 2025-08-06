package com.ps.junittesting;

// POJO - plain old java object (Java), Model(Spring), Entity(JPA) etc - Encapsulation (Encapsulated class)
public class Product {

    // private data members/variables
    private String name;
    private double price;

    // getters
    public String getName() {
        return name;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // parameteried constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // default constructor
    public Product() {

    }

    // toString
    @Override
    public String toString() { // printing your objects in a string format
        return "Product [name=" + name + ", price=" + price + "]";
    }
}
