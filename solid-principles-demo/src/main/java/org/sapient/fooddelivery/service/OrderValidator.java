package org.sapient.fooddelivery.service;
// ===============================
//  SRP - SINGLE RESPONSIBILITY PRINCIPLE
//  Each class has exactly one reason to change.
// ===============================
import org.sapient.fooddelivery.model.Order;

public class OrderValidator {
    public void validate(Order order) {
        if (order.items.isEmpty()) throw new IllegalArgumentException("Order is empty");
        if (!order.customerEmail.contains("@")) throw new IllegalArgumentException("Invalid email");
    }
}
