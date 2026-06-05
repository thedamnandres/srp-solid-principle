package edu.udla.calidad.srpsolidprinciples.lsp;

public class BirdRefactored extends AnimalRefactored implements Walkable {
    @Override
    public void makeSound() {
        System.out.println("Bird chirps.");
    }

    @Override
    public void walk() {
        System.out.println("Bird is walking.");
    }
}
