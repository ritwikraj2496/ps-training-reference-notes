package org.sapient.fooddelivery.delivery;

public class BikeDelivery extends DeliveryPartner {
    public BikeDelivery(String name) { super(name); }

    @Override
    public void deliver(String orderId) {
        System.out.println("[BikeDelivery] Delivering order " + orderId + " by " + name);
    }
}