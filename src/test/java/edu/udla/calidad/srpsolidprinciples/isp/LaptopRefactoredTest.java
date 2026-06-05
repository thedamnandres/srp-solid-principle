package edu.udla.calidad.srpsolidprinciples.isp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LaptopRefactoredTest {

    @Test
    void testTurnOn() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LaptopRefactored laptop = new LaptopRefactored();
        laptop.turnOn();

        assertTrue(outputStream.toString().contains("Laptop is turning on."));

        System.setOut(System.out);
    }

    @Test
    void testTurnOff() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LaptopRefactored laptop = new LaptopRefactored();
        laptop.turnOff();

        assertTrue(outputStream.toString().contains("Laptop is turning off."));

        System.setOut(System.out);
    }

    @Test
    void testCharge() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LaptopRefactored laptop = new LaptopRefactored();
        laptop.charge();

        assertTrue(outputStream.toString().contains("Laptop is charging."));

        System.setOut(System.out);
    }

    @Test
    void testLaptopIsSwitchable() {
        LaptopRefactored laptop = new LaptopRefactored();
        assertTrue(laptop instanceof Switchable);
    }

    @Test
    void testLaptopIsChargeable() {
        LaptopRefactored laptop = new LaptopRefactored();
        assertTrue(laptop instanceof Chargeable);
    }
}
