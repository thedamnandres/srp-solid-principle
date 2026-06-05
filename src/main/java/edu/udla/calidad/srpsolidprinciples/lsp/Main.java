package edu.udla.calidad.srpsolidprinciples.lsp;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Código Inicial (Viola LSP) ===");

        Animal dog = new Dog();
        Animal fish = new Fish();

        System.out.println("\n--- Perro (funciona correctamente) ---");
        dog.makeSound();
        dog.walk();

        System.out.println("\n--- Pez (falla porque no puede caminar) ---");
        fish.makeSound();
        try {
            fish.walk();
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
