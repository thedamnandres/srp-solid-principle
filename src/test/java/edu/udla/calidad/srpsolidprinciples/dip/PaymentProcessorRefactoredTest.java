package edu.udla.calidad.srpsolidprinciples.dip;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PaymentProcessorRefactoredTest {

    @Test
    void testMakePaymentWithCreditCard() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PaymentMethod payment = new CreditCardPaymentRefactored();
        PaymentProcessorRefactored processor = new PaymentProcessorRefactored(payment);
        processor.makePayment(150.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Processing credit card payment of $150.0"));

        System.setOut(System.out);
    }

    @Test
    void testMakePaymentWithPayPal() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PaymentMethod payment = new PayPalPayment();
        PaymentProcessorRefactored processor = new PaymentProcessorRefactored(payment);
        processor.makePayment(250.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Processing PayPal payment of $250.0"));

        System.setOut(System.out);
    }

    @Test
    void testMakePaymentWithCrypto() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PaymentMethod payment = new CryptoPayment();
        PaymentProcessorRefactored processor = new PaymentProcessorRefactored(payment);
        processor.makePayment(500.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Processing cryptocurrency payment of $500.0"));

        System.setOut(System.out);
    }

    @Test
    void testProcessorDependsOnAbstraction() {
        PaymentMethod payment = new CreditCardPaymentRefactored();
        PaymentProcessorRefactored processor = new PaymentProcessorRefactored(payment);
        assertNotNull(processor);
    }
}
