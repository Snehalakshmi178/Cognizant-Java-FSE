package com.example;


public class CreditCardPayment implements PaymentStrategy {
 private String cardNumber;
 private String nameOnCard;

 public CreditCardPayment(String cardNumber, String nameOnCard) {
     this.cardNumber = cardNumber;
     this.nameOnCard = nameOnCard;
 }

 @Override
 public void pay(double amount) {
     System.out.println("Paying $" + String.format("%.2f", amount) + " using Credit Card.");
     System.out.println("Card Number: " + cardNumber + ", Name: " + nameOnCard);
     // In a real system, you'd integrate with a payment gateway here.
     System.out.println("Credit Card payment processed successfully.");
 }
}
