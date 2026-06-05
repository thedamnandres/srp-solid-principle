package edu.udla.calidad.srpsolidprinciples.lsp;

public class DogRefactored extends AnimalRefactored implements Walkable, Swimmable {
    @Override
    public void makeSound() {
        System.out.println("Dog barks.");
    }

    @Override
    public void walk() {
        System.out.println("Dog is walking.");
    }

    @Override
    public void swim() {
        System.out.println("Dog is swimming.");
    }
}
