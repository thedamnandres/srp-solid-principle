package edu.udla.calidad.srpsolidprinciples.ocp;

public class MainRefactored {
    public static void main(String[] args) {
        System.out.println("=== Código Refactorizado (Cumple OCP) ===");

        NotificationManager manager = new NotificationManager();

        System.out.println("\n--- Envío de notificaciones existentes ---");
        manager.send(new EmailNotification(), "Hello via Email!");
        manager.send(new SMSNotification(), "Hello via SMS!");
        manager.send(new PushNotification(), "Hello via Push Notification!");

        System.out.println("\n--- Envío de nueva notificación (Fax) sin modificar código existente ---");
        manager.send(new FaxNotification(), "Hello via Fax!");
    }
}
