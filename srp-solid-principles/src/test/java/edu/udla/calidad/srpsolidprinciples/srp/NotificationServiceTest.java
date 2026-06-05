package edu.udla.calidad.srpsolidprinciples.srp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void testSendWelcomeEmail() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        NotificationService service = new NotificationService();
        service.sendWelcomeEmail("user@example.com");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending welcome email to user@example.com"));

        System.setOut(System.out);
    }
}
