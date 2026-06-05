package edu.udla.calidad.srpsolidprinciples.ocp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PushNotificationTest {

    @Test
    void testSend() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PushNotification notification = new PushNotification();
        notification.send("Test push");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending Push Notification: Test push"));

        System.setOut(System.out);
    }
}
