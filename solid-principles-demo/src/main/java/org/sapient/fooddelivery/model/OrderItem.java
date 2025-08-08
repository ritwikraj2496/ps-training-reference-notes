package org.sapient.fooddelivery.model;

public class OrderItem {
    public final String name;
    public final int qty;
    public final double price;

    public OrderItem(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}
