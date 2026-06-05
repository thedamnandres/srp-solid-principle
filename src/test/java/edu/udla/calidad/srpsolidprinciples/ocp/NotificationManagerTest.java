package edu.udla.calidad.srpsolidprinciples.ocp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotificationManagerTest {

    @Test
    void testSendEmailNotification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        NotificationManager manager = new NotificationManager();
        manager.send(new EmailNotification(), "Hello");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending Email: Hello"));

        System.setOut(System.out);
    }

    @Test
    void testSendSMSNotification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        NotificationManager manager = new NotificationManager();
        manager.send(new SMSNotification(), "Hello SMS");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending SMS: Hello SMS"));

        System.setOut(System.out);
    }

    @Test
    void testSendPushNotification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        NotificationManager manager = new NotificationManager();
        manager.send(new PushNotification(), "Hello Push");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending Push Notification: Hello Push"));

        System.setOut(System.out);
    }

    @Test
    void testSendFaxNotification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        NotificationManager manager = new NotificationManager();
        manager.send(new FaxNotification(), "Hello Fax");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending Fax: Hello Fax"));

        System.setOut(System.out);
    }

    @Test
    void testPolymorphismWithCustomNotification() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Notification customNotification = new Notification() {
            @Override
            public void send(String message) {
                System.out.println("Custom: " + message);
            }
        };

        NotificationManager manager = new NotificationManager();
        manager.send(customNotification, "Custom message");

        String output = outputStream.toString();
        assertTrue(output.contains("Custom: Custom message"));

        System.setOut(System.out);
    }
}
