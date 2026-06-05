package edu.udla.calidad.srpsolidprinciples.lsp;

public class MainRefactored {
    public static void main(String[] args) {
        System.out.println("=== Código Refactorizado (Cumple LSP) ===");

        System.out.println("\n--- Perro (camina y nada) ---");
        DogRefactored dog = new DogRefactored();
        dog.makeSound();
        dog.walk();
        dog.swim();

        System.out.println("\n--- Pez (solo nada, no camina) ---");
        FishRefactored fish = new FishRefactored();
        fish.makeSound();
        fish.swim();

        System.out.println("\n--- Pájaro (camina, no nada) ---");
        BirdRefactored bird = new BirdRefactored();
        bird.makeSound();
        bird.walk();

        System.out.println("\n--- Demostración de polimorfismo ---");
        System.out.println("Animales que caminan:");
        Walkable[] walkers = {new DogRefactored(), new BirdRefactored()};
        for (Walkable w : walkers) {
            w.walk();
        }

        System.out.println("\nAnimales que nadan:");
        Swimmable[] swimmers = {new DogRefactored(), new FishRefactored()};
        for (Swimmable s : swimmers) {
            s.swim();
        }
    }
}
