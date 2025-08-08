package org.sapient.fooddelivery.delivery;
// ===============================
//  LSP - LISKOV SUBSTITUTION PRINCIPLE
//  Any DeliveryPartner can be used without breaking logic.
// ===============================
public abstract class DeliveryPartner {
    protected final String name;

    public DeliveryPartner(String name) { this.name = name; }
    public abstract void deliver(String orderId);
}