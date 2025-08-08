package org.sapient.fooddelivery.model;
// ===============================
//  MODEL CLASSES
// ===============================
import java.util.List;

public class Order {
    public final String id;
    public final String customerEmail;
    public final List<OrderItem> items;

    public Order(String id, String customerEmail, List<OrderItem> items) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.items = items;
    }
}
