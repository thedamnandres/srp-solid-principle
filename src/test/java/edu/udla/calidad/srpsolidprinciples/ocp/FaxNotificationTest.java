package edu.udla.calidad.srpsolidprinciples.ocp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FaxNotificationTest {

    @Test
    void testSend() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FaxNotification notification = new FaxNotification();
        notification.send("Test fax");

        String output = outputStream.toString();
        assertTrue(output.contains("Sending Fax: Test fax"));

        System.setOut(System.out);
    }
}
