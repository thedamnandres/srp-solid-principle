package edu.udla.calidad.srpsolidprinciples.lsp;

public class Fish extends Animal {
    @Override
    public void walk() {
        throw new UnsupportedOperationException("Fish can't walk.");
    }
}
