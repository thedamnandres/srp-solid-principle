package edu.udla.calidad.srpsolidprinciples.isp;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Código Inicial (Viola ISP) ===");

        Device phone = new Phone();
        Device camera = new DisposableCamera();

        System.out.println("\n--- Teléfono (funciona correctamente) ---");
        phone.turnOn();
        phone.charge();

        System.out.println("\n--- Cámara desechable (falla al cargar) ---");
        camera.turnOn();
        try {
            camera.charge();
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
