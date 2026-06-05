package edu.udla.calidad.srpsolidprinciples.srp;

public class MainRefactored {
    public static void main(String[] args) {
        System.out.println("=== Código Refactorizado (Cumple SRP) ===");

        UserValidator validator = new UserValidator();
        UserRepository repository = new UserRepository();
        NotificationService notificationService = new NotificationService();
        UserService userService = new UserService(validator, repository, notificationService);

        System.out.println("\n--- Intento 1: Usuario válido ---");
        userService.addUser("example@domain.com", "password123");

        System.out.println("\n--- Intento 2: Usuario inválido ---");
        userService.addUser("invalid-email", "1234");
    }
}
