package edu.udla.calidad.srpsolidprinciples.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserValidator validator;
    private UserRepository repository;
    private NotificationService notificationService;
    private UserService userService;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
        repository = new UserRepository();
        notificationService = new NotificationService();
        userService = new UserService(validator, repository, notificationService);
    }

    @Test
    void testAddValidUser() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        userService.addUser("user@example.com", "password123");

        String output = outputStream.toString();
        assertTrue(output.contains("Saving user to the database..."));
        assertTrue(output.contains("Email: user@example.com"));
        assertTrue(output.contains("Sending welcome email to user@example.com"));

        System.setOut(System.out);
    }

    @Test
    void testAddInvalidUser() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        userService.addUser("invalid-email", "1234");

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid email or password. User not added."));
        assertFalse(output.contains("Saving user to the database..."));

        System.setOut(System.out);
    }

    @Test
    void testAddUserWithInvalidEmail() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        userService.addUser("bad-email", "password123");

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid email or password. User not added."));
        assertFalse(output.contains("Saving user to the database..."));

        System.setOut(System.out);
    }

    @Test
    void testAddUserWithInvalidPassword() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        userService.addUser("user@example.com", "short");

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid email or password. User not added."));
        assertFalse(output.contains("Saving user to the database..."));

        System.setOut(System.out);
    }
}
