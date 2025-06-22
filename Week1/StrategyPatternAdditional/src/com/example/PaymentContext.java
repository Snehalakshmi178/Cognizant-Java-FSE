package com.example;


public class PaymentContext {
 private PaymentStrategy paymentStrategy;

 public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
     this.paymentStrategy = paymentStrategy;
 }

 public void executePayment(double amount) {
     if (paymentStrategy == null) {
         System.out.println("No payment strategy set. Cannot proceed with payment.");
         return;
     }
     this.paymentStrategy.pay(amount);
 }
}
