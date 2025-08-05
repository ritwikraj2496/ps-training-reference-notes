package com.ps.junittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionExample {
    @Test
    void shouldThrowArithmeticExceptionWhenDivideByZero() {
        // The test passes only if ArithmeticException is thrown
        assertThrows(ArithmeticException.class, () -> {
            int result = 10 / 0;
        }, "Division by zero should throw ArithmeticException");
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWithMessage() {
        // Testing if exception is thrown with correct message
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Invalid input");
        });

        assertEquals("Invalid input", exception.getMessage()); // Optional: verify message
    }
}
