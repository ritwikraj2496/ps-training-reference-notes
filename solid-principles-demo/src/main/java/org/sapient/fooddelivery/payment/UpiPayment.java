package org.sapient.fooddelivery.payment;

public class UpiPayment implements PaymentMethod {
    @Override
    public boolean pay(double amount) {
        System.out.println("[UPI] Paid: " + amount);
        return true;
    }
}
