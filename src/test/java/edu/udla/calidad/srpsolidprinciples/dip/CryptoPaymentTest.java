package edu.udla.calidad.srpsolidprinciples.dip;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CryptoPaymentTest {

    @Test
    void testProcessPayment() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CryptoPayment payment = new CryptoPayment();
        payment.processPayment(300.0);

        String output = outputStream.toString();
        assertTrue(output.contains("Processing cryptocurrency payment of $300.0"));

        System.setOut(System.out);
    }

    @Test
    void testImplementsPaymentMethod() {
        CryptoPayment payment = new CryptoPayment();
        assertTrue(payment instanceof PaymentMethod);
    }
}
