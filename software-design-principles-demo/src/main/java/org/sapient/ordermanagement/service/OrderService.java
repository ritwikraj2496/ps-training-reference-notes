package org.sapient.ordermanagement.service;

import org.sapient.ordermanagement.model.Order;

public class OrderService {

    private static final double DISCOUNT_RATE = 0.10;
    private static final double TAX_RATE = 0.18;

    /**
     * Calculate final order amount after discount and tax.
     * Demonstrates KISS, DRY, and YAGNI principles.
     */
    public double calculateFinalAmount(Order order) {
        double total = calculateSubtotal(order); // DRY: single method for subtotal
        if (order.isDiscountEligible()) {
            total = applyDiscount(total); // KISS: clear, one-step discount
        }
        return applyTax(total); // KISS: single responsibility per method
    }

    // --- DRY: This method prevents subtotal calculation code from repeating in multiple places ---
    private double calculateSubtotal(Order order) {
        return order.getItemPrices()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    // --- KISS: Simple method, no over-engineering for discount logic ---
    private double applyDiscount(double amount) {
        return amount - (amount * DISCOUNT_RATE);
    }

    // --- KISS: Tax calculation kept separate and simple ---
    private double applyTax(double amount) {
        return amount + (amount * TAX_RATE);
    }

    /**
     * YAGNI: We don't build features we don't need now.
     * Example: No multi-currency conversion or coupon expiry checks yet,
     * even though they *might* be required in the future.
     * We'll add them when they are actually needed.
     */
}
