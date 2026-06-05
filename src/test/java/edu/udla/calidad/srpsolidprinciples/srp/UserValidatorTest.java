package edu.udla.calidad.srpsolidprinciples.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    private UserValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UserValidator();
    }

    @Test
    void testValidEmail() {
        assertTrue(validator.isValidEmail("user@example.com"));
        assertTrue(validator.isValidEmail("test.user@domain.org"));
        assertTrue(validator.isValidEmail("user+tag@gmail.com"));
    }

    @Test
    void testInvalidEmail() {
        assertFalse(validator.isValidEmail("invalid-email"));
        assertFalse(validator.isValidEmail("@domain.com"));
        assertFalse(validator.isValidEmail("user@"));
        assertFalse(validator.isValidEmail(""));
    }

    @Test
    void testValidPassword() {
        assertTrue(validator.isValidPassword("password123"));
        assertTrue(validator.isValidPassword("12345678"));
        assertTrue(validator.isValidPassword("longpassword"));
    }

    @Test
    void testInvalidPassword() {
        assertFalse(validator.isValidPassword("1234567"));
        assertFalse(validator.isValidPassword("short"));
        assertFalse(validator.isValidPassword(""));
    }

    @Test
    void testValidUser() {
        assertTrue(validator.isValidUser("user@example.com", "password123"));
    }

    @Test
    void testInvalidUser() {
        assertFalse(validator.isValidUser("invalid-email", "1234"));
        assertFalse(validator.isValidUser("user@example.com", "1234"));
        assertFalse(validator.isValidUser("invalid-email", "password123"));
    }
}
