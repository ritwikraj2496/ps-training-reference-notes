package org.sapient.fooddelivery.service;

import org.sapient.fooddelivery.delivery.DeliveryPartner;
import org.sapient.fooddelivery.model.Order;
import org.sapient.fooddelivery.notifier.EmailNotifier;
import org.sapient.fooddelivery.payment.PaymentMethod;
// ===============================
//  DIP - DEPENDENCY INVERSION PRINCIPLE
//  OrderProcessor depends on abstractions (PaymentMethod, DeliveryPartner, Notifier)
//  not concrete implementations.
// ===============================
public class OrderProcessor {
    private final OrderValidator validator;
    private final PriceCalculator calculator;
    private final PaymentMethod paymentMethod;
    private final DeliveryPartner deliveryPartner;
    private final EmailNotifier emailNotifier;

    public OrderProcessor(OrderValidator validator,
                          PriceCalculator calculator,
                          PaymentMethod paymentMethod,
                          DeliveryPartner deliveryPartner,
                          EmailNotifier emailNotifier) {
        this.validator = validator;
        this.calculator = calculator;
        this.paymentMethod = paymentMethod;
        this.deliveryPartner = deliveryPartner;
        this.emailNotifier = emailNotifier;
    }

    public void process(Order order) {
        validator.validate(order); // SRP in action
        double total = calculator.calculateTotal(order);

        if (paymentMethod.pay(total)) { // OCP in action
            deliveryPartner.deliver(order.id); // LSP in action
            emailNotifier.sendEmail(order.customerEmail,
                    "Your order " + order.id + " is confirmed. Total: " + total); // ISP in action
        }
    }
}