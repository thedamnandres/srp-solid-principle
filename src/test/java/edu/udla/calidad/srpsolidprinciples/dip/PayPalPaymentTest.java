package edu.udla.calidad.srpsolidprinciples.dip;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PayPalPaymentTest {

    @Test
    void testProcessPayment() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PayPalPayment payment = new PayPalPayment();
        payment.processPayment(200.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Processing PayPal payment of $200.0"));

        System.setOut(System.out);
    }

    @Test
    void testImplementsPaymentMethod() {
        PayPalPayment payment = new PayPalPayment();
        assertTrue(payment instanceof PaymentMethod);
    }
}
