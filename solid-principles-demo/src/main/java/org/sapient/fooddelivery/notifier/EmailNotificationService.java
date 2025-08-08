package org.sapient.fooddelivery.notifier;

public class EmailNotificationService implements EmailNotifier {
    @Override
    public void sendEmail(String to, String message) {
        System.out.println("[Email] To: " + to + " - " + message);
    }
}
