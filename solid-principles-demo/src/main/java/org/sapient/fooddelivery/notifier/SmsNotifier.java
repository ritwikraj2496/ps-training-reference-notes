package org.sapient.fooddelivery.notifier;

public interface SmsNotifier {
    void sendSms(String to, String message);
}
