package edu.udla.calidad.srpsolidprinciples.lsp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FishRefactoredTest {

    @Test
    void testMakeSound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FishRefactored fish = new FishRefactored();
        fish.makeSound();

        String output = outputStream.toString();
        assertTrue(output.contains("Fish makes bubbles."));

        System.setOut(System.out);
    }

    @Test
    void testSwim() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FishRefactored fish = new FishRefactored();
        fish.swim();

        String output = outputStream.toString();
        assertTrue(output.contains("Fish is swimming."));

        System.setOut(System.out);
    }

    @Test
    void testFishIsSwimmable() {
        Swimmable swimmer = new FishRefactored();
        assertDoesNotThrow(swimmer::swim);
    }

    @Test
    void testFishIsNotWalkable() {
        FishRefactored fish = new FishRefactored();
        assertFalse(fish instanceof Walkable);
    }
}
