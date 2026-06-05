package edu.udla.calidad.srpsolidprinciples.srp;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void testSave() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        UserRepository repository = new UserRepository();
        repository.save("test@example.com", "password123");

        String output = outputStream.toString();
        assertTrue(output.contains("Saving user to the database..."));
        assertTrue(output.contains("Email: test@example.com"));
        assertTrue(output.contains("Password: password123"));

        System.setOut(System.out);
    }
}
