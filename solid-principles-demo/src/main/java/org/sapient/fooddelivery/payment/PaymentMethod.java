package org.sapient.fooddelivery.payment;
// ===============================
//  OCP - OPEN/CLOSED PRINCIPLE
//  Add new payment methods without modifying OrderProcessor.
// ===============================

public interface PaymentMethod {
    boolean pay(double amount);
}
