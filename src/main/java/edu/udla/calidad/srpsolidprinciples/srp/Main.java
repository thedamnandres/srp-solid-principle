package edu.udla.calidad.srpsolidprinciples.srp;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Código Inicial (Viola SRP) ===");
        UserManager userManager = new UserManager();

        System.out.println("\n--- Intento 1: Usuario válido ---");
        userManager.addUser("example@domain.com", "password123");

        System.out.println("\n--- Intento 2: Usuario inválido ---");
        userManager.addUser("invalid-email", "1234");
    }
}
