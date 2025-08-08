package org.sapient.fooddelivery.payment;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[CreditCard] Paid: " + amount);
        return true;
    }
}
