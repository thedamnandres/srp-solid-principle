package edu.udla.calidad.srpsolidprinciples.lsp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LiskovSubstitutionTest {

    @Test
    void testDogCanBeUsedAsAnimal() {
        AnimalRefactored animal = new DogRefactored();
        assertDoesNotThrow(animal::makeSound);
    }

    @Test
    void testFishCanBeUsedAsAnimal() {
        AnimalRefactored animal = new FishRefactored();
        assertDoesNotThrow(animal::makeSound);
    }

    @Test
    void testBirdCanBeUsedAsAnimal() {
        AnimalRefactored animal = new BirdRefactored();
        assertDoesNotThrow(animal::makeSound);
    }

    @Test
    void testDogCanBeUsedAsWalkable() {
        Walkable walker = new DogRefactored();
        assertDoesNotThrow(walker::walk);
    }

    @Test
    void testBirdCanBeUsedAsWalkable() {
        Walkable walker = new BirdRefactored();
        assertDoesNotThrow(walker::walk);
    }

    @Test
    void testDogCanBeUsedAsSwimmable() {
        Swimmable swimmer = new DogRefactored();
        assertDoesNotThrow(swimmer::swim);
    }

    @Test
    void testFishCanBeUsedAsSwimmable() {
        Swimmable swimmer = new FishRefactored();
        assertDoesNotThrow(swimmer::swim);
    }

    @Test
    void testPolymorphismWithWalkers() {
        Walkable[] walkers = {new DogRefactored(), new BirdRefactored()};
        for (Walkable walker : walkers) {
            assertDoesNotThrow(walker::walk);
        }
    }

    @Test
    void testPolymorphismWithSwimmers() {
        Swimmable[] swimmers = {new DogRefactored(), new FishRefactored()};
        for (Swimmable swimmer : swimmers) {
            assertDoesNotThrow(swimmer::swim);
        }
    }
}
