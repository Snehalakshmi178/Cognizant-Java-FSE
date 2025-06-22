package com.example;


public class PayPalPayment implements PaymentStrategy {
 private String emailId;
 private String password; // In a real system, never store/pass passwords like this. Use secure tokens.

 public PayPalPayment(String emailId, String password) {
     this.emailId = emailId;
     this.password = password;
 }

 @Override
 public void pay(double amount) {
     System.out.println("Paying $" + String.format("%.2f", amount) + " using PayPal.");
     System.out.println("PayPal Email: " + emailId);
     // Simulate login and payment processing
     if ("user@example.com".equals(emailId) && "secure123".equals(password)) { // Dummy check
         System.out.println("PayPal login successful. Payment processed.");
     } else {
         System.out.println("PayPal login failed. Payment aborted.");
     }
 }
}
