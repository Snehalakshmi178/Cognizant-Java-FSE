package com.example;


public class StrategyPatternTest {
 public static void main(String[] args) {
     PaymentContext context = new PaymentContext();
     double amountToPay = 125.50;

     System.out.println("--- Scenario 1: Paying with Credit Card ---");
     PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
     context.setPaymentStrategy(creditCardPayment);
     context.executePayment(amountToPay);

     System.out.println("\n--- Scenario 2: Paying with PayPal ---");
     PaymentStrategy payPalPayment = new PayPalPayment("user@example.com", "secure123");
     context.setPaymentStrategy(payPalPayment);
     context.executePayment(75.00); // Different amount for variety

     System.out.println("\n--- Scenario 3: Paying with PayPal (Incorrect credentials) ---");
     PaymentStrategy payPalPaymentFailed = new PayPalPayment("wrong@example.com", "wrongpass");
     context.setPaymentStrategy(payPalPaymentFailed);
     context.executePayment(200.00);

     System.out.println("\n--- Scenario 4: Changing back to Credit Card ---");
     context.setPaymentStrategy(creditCardPayment); // Reusing the existing credit card strategy
     context.executePayment(50.00);
 }
}
