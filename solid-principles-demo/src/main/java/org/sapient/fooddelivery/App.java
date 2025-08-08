package org.sapient.fooddelivery;

import org.sapient.fooddelivery.delivery.BikeDelivery;
import org.sapient.fooddelivery.delivery.DeliveryPartner;
import org.sapient.fooddelivery.model.Order;
import org.sapient.fooddelivery.model.OrderItem;
import org.sapient.fooddelivery.notifier.EmailNotificationService;
import org.sapient.fooddelivery.notifier.EmailNotifier;
import org.sapient.fooddelivery.payment.PaymentMethod;
import org.sapient.fooddelivery.payment.UpiPayment;
import org.sapient.fooddelivery.service.OrderProcessor;
import org.sapient.fooddelivery.service.OrderValidator;
import org.sapient.fooddelivery.service.PriceCalculator;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Order order = new Order("FD-101", "alice@example.com",
                Arrays.asList(new OrderItem("Burger", 2, 150.0)));

        OrderValidator validator = new OrderValidator();
        PriceCalculator calculator = new PriceCalculator();
        PaymentMethod payment = new UpiPayment(); // OCP: Swap to CreditCardPayment easily
        DeliveryPartner delivery = new BikeDelivery("Ravi"); // LSP: Swap to DroneDelivery
        EmailNotifier notifier = new EmailNotificationService(); // ISP: Swap notifier type

        OrderProcessor processor = new OrderProcessor(
                validator, calculator, payment, delivery, notifier // DIP: All abstractions
        );

        processor.process(order);
    }
}


// Online Food Delivery Platform
// We’ll model Order Placement in a food delivery app.
//
// SRP – each class has one job.
// OCP – add new payment types without changing core logic.
// LSP – substitute delivery partner types without breaking.
// ISP – small, focused interfaces for device notifications.
// DIP – core logic depends on abstractions, not concrete services.

// SRP – OrderValidator only validates, PriceCalculator only calculates, OrderProcessor only orchestrates.
// OCP – PaymentMethod interface allows adding WalletPayment, CryptoPayment without touching OrderProcessor.
// LSP – Any DeliveryPartner subclass (BikeDelivery, DroneDelivery) can replace another without breaking delivery logic.
// ISP – EmailNotifier and SmsNotifier are separate, so classes only depend on what they actually use.
// DIP – OrderProcessor depends on interfaces (PaymentMethod, DeliveryPartner, EmailNotifier) rather than creating concrete classes inside.
