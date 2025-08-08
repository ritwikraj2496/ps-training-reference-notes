package org.sapient.fooddelivery.notifier;
// ===============================
//  ISP - INTERFACE SEGREGATION PRINCIPLE
//  Customers only depend on notification type they use.
// ===============================
public interface EmailNotifier {
    void sendEmail(String to, String message);
}
