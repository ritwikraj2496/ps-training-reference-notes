package org.sapient.ordermanagement;
/**
 * Hello world!
 */
import org.sapient.ordermanagement.model.Order;
import org.sapient.ordermanagement.service.OrderService;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Order order = new Order(Arrays.asList(100.0, 250.0, 50.0), true);

        OrderService service = new OrderService();
        double finalAmount = service.calculateFinalAmount(order);

        System.out.println("Final Order Amount: ₹" + finalAmount);
    }
}

// 1. KISS (Keep It Simple, Stupid)
// In applyDiscount() and applyTax() → each method does only one thing, no unnecessary conditions or complex logic.
// No over-complication in calculateFinalAmount() → straight, readable flow.
//
// 2. DRY (Don’t Repeat Yourself)
// calculateSubtotal() method used once — avoids repeating the sum logic in multiple places.
// Constants DISCOUNT_RATE and TAX_RATE used instead of magic numbers all over.
//
// 3. YAGNI (You Aren’t Gonna Need It)
// No currency conversion, coupon expiry check, or advanced analytics in OrderService because the current requirement doesn’t need them.
// These can be added later when there’s a real need.
