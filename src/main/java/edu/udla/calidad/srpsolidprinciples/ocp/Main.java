package edu.udla.calidad.srpsolidprinciples.ocp;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Código Inicial (Viola OCP) ===");
        NotificationService service = new NotificationService();

        System.out.println("\n--- Envío de notificaciones ---");
        service.sendNotification("Email", "Hello via Email!");
        service.sendNotification("SMS", "Hello via SMS!");
        service.sendNotification("Push", "Hello via Push Notification!");
        service.sendNotification("Fax", "Hello via Fax!");
    }
}
