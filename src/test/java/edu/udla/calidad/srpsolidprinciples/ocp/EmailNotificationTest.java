package edu.udla.calidad.srpsolidprinciples.ocp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EmailNotificationTest {

    @Test
    void testSend() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        EmailNotification notification = new EmailNotification();
        notification.send("Test message");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending Email: Test message"));

        System.setOut(System.out);
    }
}
