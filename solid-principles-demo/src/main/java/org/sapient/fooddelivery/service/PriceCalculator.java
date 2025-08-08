package org.sapient.fooddelivery.service;

import org.sapient.fooddelivery.model.Order;

public class PriceCalculator {
    private final double TAX_RATE = 0.05;

    public double calculateTotal(Order order) {
        double subtotal = order.items.stream()
                .mapToDouble(i -> i.price * i.qty)
                .sum();
        return subtotal + (subtotal * TAX_RATE);
    }
}
