package org.sapient.fooddelivery.notifier;

public class SmsNotificationService implements SmsNotifier {
    @Override
    public void sendSms(String to, String message) {
        System.out.println("[SMS] To: " + to + " - " + message);
    }
}
