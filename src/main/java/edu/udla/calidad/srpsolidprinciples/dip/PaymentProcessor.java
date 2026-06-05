package edu.udla.calidad.srpsolidprinciples.dip;

public class PaymentProcessor {
    private CreditCardPayment payment;

    public PaymentProcessor() {
        this.payment = new CreditCardPayment();
    }

    public void makePayment(double amount) {
        payment.processPayment(amount);
    }
}
