package edu.udla.calidad.srpsolidprinciples.ocp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SMSNotificationTest {

    @Test
    void testSend() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        SMSNotification notification = new SMSNotification();
        notification.send("Test SMS");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending SMS: Test SMS"));

        System.setOut(System.out);
    }
}
