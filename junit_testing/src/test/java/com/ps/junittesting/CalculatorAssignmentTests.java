package com.ps.junittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorAssignmentTests {
    
    private CalculatorAssignment calculator;

    @BeforeEach
    void setup() {
        calculator = new CalculatorAssignment();
    }

    @Test
    @DisplayName("Should return correct sum of two numbers")
    void shouldReturnSum_whenAddIsCalled() {
        int result = calculator.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    @DisplayName("Should return correct difference when subtract is called")
    void shouldReturnDifference_whenSubtractIsCalled() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    @DisplayName("Should return correct product when multiply is called")
    void shouldReturnProduct_whenMultiplyIsCalled() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    @DisplayName("Should return correct quotient when divide is called with valid input")
    void shouldReturnQuotient_whenDivideIsCalledWithValidInput() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    @DisplayName("Should throw exception when dividing by zero")
    void shouldThrowException_whenDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 10, 100})
    @DisplayName("Should return true for even numbers")
    void shouldReturnTrue_whenNumberIsEven(int number) {
        assertTrue(calculator.isEven(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 9, 101})
    @DisplayName("Should return false for odd numbers")
    void shouldReturnFalse_whenNumberIsOdd(int number) {
        assertFalse(calculator.isEven(number));
    }

    @Test
    @DisplayName("Should return max of two numbers")
    void shouldReturnMax_whenMaxIsCalled() {
        assertEquals(7, calculator.max(5, 7));
        assertEquals(10, calculator.max(10, 3));
    }

    @Nested
    @DisplayName("Grouped tests for divide method")
    class DivideTests {

        @Test
        void shouldDividePositiveNumbersCorrectly() {
            assertEquals(3, calculator.divide(9, 3));
        }

        @Test
        void shouldThrowExceptionForZeroDenominator() {
            assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
        }
    }

}
