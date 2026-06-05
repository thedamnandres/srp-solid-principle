package edu.udla.calidad.srpsolidprinciples.lsp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BirdRefactoredTest {

    @Test
    void testMakeSound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BirdRefactored bird = new BirdRefactored();
        bird.makeSound();

        String output = outputStream.toString();
        assertTrue(output.contains("Bird chirps."));

        System.setOut(System.out);
    }

    @Test
    void testWalk() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BirdRefactored bird = new BirdRefactored();
        bird.walk();

        String output = outputStream.toString();
        assertTrue(output.contains("Bird is walking."));

        System.setOut(System.out);
    }

    @Test
    void testBirdIsWalkable() {
        Walkable walker = new BirdRefactored();
        assertDoesNotThrow(walker::walk);
    }

    @Test
    void testBirdIsNotSwimmable() {
        BirdRefactored bird = new BirdRefactored();
        assertFalse(bird instanceof Swimmable);
    }
}
