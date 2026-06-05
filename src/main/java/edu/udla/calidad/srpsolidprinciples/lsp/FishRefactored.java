package edu.udla.calidad.srpsolidprinciples.lsp;

public class FishRefactored extends AnimalRefactored implements Swimmable {
    @Override
    public void makeSound() {
        System.out.println("Fish makes bubbles.");
    }

    @Override
    public void swim() {
        System.out.println("Fish is swimming.");
    }
}
