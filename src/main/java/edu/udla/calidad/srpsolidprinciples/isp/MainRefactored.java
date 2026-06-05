package edu.udla.calidad.srpsolidprinciples.isp;

public class MainRefactored {
    public static void main(String[] args) {
        System.out.println("=== Código Refactorizado (Cumple ISP) ===");

        System.out.println("\n--- Dispositivos que se pueden encender/apagar ---");
        Switchable[] switchables = {
            new PhoneRefactored(),
            new DisposableCameraRefactored(),
            new LaptopRefactored()
        };

        for (Switchable device : switchables) {
            device.turnOn();
            device.turnOff();
            System.out.println();
        }

        System.out.println("--- Dispositivos que se pueden cargar ---");
        Chargeable[] chargeables = {
            new PhoneRefactored(),
            new LaptopRefactored()
        };

        for (Chargeable device : chargeables) {
            device.charge();
        }

        System.out.println("\n--- Uso específico de cada dispositivo ---");
        PhoneRefactored phone = new PhoneRefactored();
        phone.turnOn();
        phone.charge();
        phone.turnOff();

        System.out.println();
        DisposableCameraRefactored camera = new DisposableCameraRefactored();
        camera.turnOn();
        camera.turnOff();
    }
}
