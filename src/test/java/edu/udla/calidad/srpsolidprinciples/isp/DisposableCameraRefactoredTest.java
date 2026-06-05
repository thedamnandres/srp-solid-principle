package edu.udla.calidad.srpsolidprinciples.isp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DisposableCameraRefactoredTest {

    @Test
    void testTurnOn() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DisposableCameraRefactored camera = new DisposableCameraRefactored();
        camera.turnOn();

        assertTrue(outputStream.toString().contains("Disposable camera is turning on."));

        System.setOut(System.out);
    }

    @Test
    void testTurnOff() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DisposableCameraRefactored camera = new DisposableCameraRefactored();
        camera.turnOff();

        assertTrue(outputStream.toString().contains("Disposable camera is turning off."));

        System.setOut(System.out);
    }

    @Test
    void testCameraIsSwitchable() {
        DisposableCameraRefactored camera = new DisposableCameraRefactored();
        assertTrue(camera instanceof Switchable);
    }

    @Test
    void testCameraIsNotChargeable() {
        DisposableCameraRefactored camera = new DisposableCameraRefactored();
        assertFalse(camera instanceof Chargeable);
    }
}
