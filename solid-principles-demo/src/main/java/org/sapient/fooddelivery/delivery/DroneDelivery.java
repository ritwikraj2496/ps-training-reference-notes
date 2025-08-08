package org.sapient.fooddelivery.delivery;

public class DroneDelivery extends DeliveryPartner {
    public DroneDelivery(String name) { super(name); }

    @Override
    public void deliver(String orderId) {
        System.out.println("[DroneDelivery] Flying order " + orderId + " by " + name);
    }
}