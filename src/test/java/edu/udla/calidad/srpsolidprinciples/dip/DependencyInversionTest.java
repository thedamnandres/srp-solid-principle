package edu.udla.calidad.srpsolidprinciples.dip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DependencyInversionTest {

    @Test
    void testCreditCardCanBeUsedAsPaymentMethod() {
        PaymentMethod payment = new CreditCardPaymentRefactored();
        assertDoesNotThrow(() -> payment.processPayment(100.0));
    }

    @Test
    void testPayPalCanBeUsedAsPaymentMethod() {
        PaymentMethod payment = new PayPalPayment();
        assertDoesNotThrow(() -> payment.processPayment(200.0));
    }

    @Test
    void testCryptoCanBeUsedAsPaymentMethod() {
        PaymentMethod payment = new CryptoPayment();
        assertDoesNotThrow(() -> payment.processPayment(300.0));
    }

    @Test
    void testProcessorWorksWithAnyPaymentMethod() {
        PaymentMethod[] payments = {
            new CreditCardPaymentRefactored(),
            new PayPalPayment(),
            new CryptoPayment()
        };

        for (PaymentMethod payment : payments) {
            PaymentProcessorRefactored processor = new PaymentProcessorRefactored(payment);
            assertDoesNotThrow(() -> processor.makePayment(100.0));
        }
    }

    @Test
    void testPolymorphismWithPaymentMethods() {
        PaymentMethod payment1 = new CreditCardPaymentRefactored();
        PaymentMethod payment2 = new PayPalPayment();
        PaymentMethod payment3 = new CryptoPayment();

        PaymentProcessorRefactored processor1 = new PaymentProcessorRefactored(payment1);
        PaymentProcessorRefactored processor2 = new PaymentProcessorRefactored(payment2);
        PaymentProcessorRefactored processor3 = new PaymentProcessorRefactored(payment3);

        assertDoesNotThrow(() -> processor1.makePayment(100.0));
        assertDoesNotThrow(() -> processor2.makePayment(200.0));
        assertDoesNotThrow(() -> processor3.makePayment(300.0));
    }

    @Test
    void testCustomPaymentMethodCanBeAdded() {
        PaymentMethod customPayment = new PaymentMethod() {
            @Override
            public void processPayment(double amount) {
                System.out.println("Custom payment of $" + amount);
            }
        };

        PaymentProcessorRefactored processor = new PaymentProcessorRefactored(customPayment);
        assertDoesNotThrow(() -> processor.makePayment(50.0));
    }
}
