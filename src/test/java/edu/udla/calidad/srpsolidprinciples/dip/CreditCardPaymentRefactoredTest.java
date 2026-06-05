package edu.udla.calidad.srpsolidprinciples.dip;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardPaymentRefactoredTest {

    @Test
    void testProcessPayment() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CreditCardPaymentRefactored payment = new CreditCardPaymentRefactored();
        payment.processPayment(100.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Processing credit card payment of $100.0"));

        System.setOut(System.out);
    }

    @Test
    void testImplementsPaymentMethod() {
        CreditCardPaymentRefactored payment = new CreditCardPaymentRefactored();
        assertTrue(payment instanceof PaymentMethod);
    }
}
