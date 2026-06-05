package edu.udla.calidad.srpsolidprinciples.dip;

public class PaymentProcessorRefactored {
    private final PaymentMethod paymentMethod;

    public PaymentProcessorRefactored(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        paymentMethod.processPayment(amount);
    }
}
