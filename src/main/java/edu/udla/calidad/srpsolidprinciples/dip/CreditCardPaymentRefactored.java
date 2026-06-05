package edu.udla.calidad.srpsolidprinciples.dip;

public class CreditCardPaymentRefactored implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}
