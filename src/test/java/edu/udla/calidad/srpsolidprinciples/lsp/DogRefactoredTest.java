package edu.udla.calidad.srpsolidprinciples.lsp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DogRefactoredTest {

    @Test
    void testMakeSound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DogRefactored dog = new DogRefactored();
        dog.makeSound();

        String output = outputStream.toString();
        assertTrue(output.contains("Dog barks."));

        System.setOut(System.out);
    }

    @Test
    void testWalk() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DogRefactored dog = new DogRefactored();
        dog.walk();

        String output = outputStream.toString();
        assertTrue(output.contains("Dog is walking."));

        System.setOut(System.out);
    }

    @Test
    void testSwim() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DogRefactored dog = new DogRefactored();
        dog.swim();

        String output = outputStream.toString();
        assertTrue(output.contains("Dog is swimming."));

        System.setOut(System.out);
    }

    @Test
    void testDogIsWalkable() {
        Walkable walker = new DogRefactored();
        assertDoesNotThrow(walker::walk);
    }

    @Test
    void testDogIsSwimmable() {
        Swimmable swimmer = new DogRefactored();
        assertDoesNotThrow(swimmer::swim);
    }
}
