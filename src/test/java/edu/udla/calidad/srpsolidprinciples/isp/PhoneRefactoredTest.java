package edu.udla.calidad.srpsolidprinciples.isp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PhoneRefactoredTest {

    @Test
    void testTurnOn() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PhoneRefactored phone = new PhoneRefactored();
        phone.turnOn();

        assertTrue(outputStream.toString().contains("Phone is turning on."));

        System.setOut(System.out);
    }

    @Test
    void testTurnOff() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PhoneRefactored phone = new PhoneRefactored();
        phone.turnOff();

        assertTrue(outputStream.toString().contains("Phone is turning off."));

        System.setOut(System.out);
    }

    @Test
    void testCharge() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PhoneRefactored phone = new PhoneRefactored();
        phone.charge();

        assertTrue(outputStream.toString().contains("Phone is charging."));

        System.setOut(System.out);
    }

    @Test
    void testPhoneIsSwitchable() {
        PhoneRefactored phone = new PhoneRefactored();
        assertTrue(phone instanceof Switchable);
    }

    @Test
    void testPhoneIsChargeable() {
        PhoneRefactored phone = new PhoneRefactored();
        assertTrue(phone instanceof Chargeable);
    }
}
