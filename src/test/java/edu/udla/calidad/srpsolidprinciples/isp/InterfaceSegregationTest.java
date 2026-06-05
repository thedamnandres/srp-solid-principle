package edu.udla.calidad.srpsolidprinciples.isp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceSegregationTest {

    @Test
    void testPhoneCanBeUsedAsSwitchable() {
        Switchable device = new PhoneRefactored();
        assertDoesNotThrow(device::turnOn);
        assertDoesNotThrow(device::turnOff);
    }

    @Test
    void testPhoneCanBeUsedAsChargeable() {
        Chargeable device = new PhoneRefactored();
        assertDoesNotThrow(device::charge);
    }

    @Test
    void testCameraCanBeUsedAsSwitchable() {
        Switchable device = new DisposableCameraRefactored();
        assertDoesNotThrow(device::turnOn);
        assertDoesNotThrow(device::turnOff);
    }

    @Test
    void testCameraIsNotChargeable() {
        DisposableCameraRefactored camera = new DisposableCameraRefactored();
        assertFalse(camera instanceof Chargeable);
    }

    @Test
    void testLaptopCanBeUsedAsSwitchable() {
        Switchable device = new LaptopRefactored();
        assertDoesNotThrow(device::turnOn);
        assertDoesNotThrow(device::turnOff);
    }

    @Test
    void testLaptopCanBeUsedAsChargeable() {
        Chargeable device = new LaptopRefactored();
        assertDoesNotThrow(device::charge);
    }

    @Test
    void testPolymorphismWithSwitchables() {
        Switchable[] devices = {
            new PhoneRefactored(),
            new DisposableCameraRefactored(),
            new LaptopRefactored()
        };

        for (Switchable device : devices) {
            assertDoesNotThrow(device::turnOn);
            assertDoesNotThrow(device::turnOff);
        }
    }

    @Test
    void testPolymorphismWithChargeables() {
        Chargeable[] devices = {
            new PhoneRefactored(),
            new LaptopRefactored()
        };

        for (Chargeable device : devices) {
            assertDoesNotThrow(device::charge);
        }
    }
}
