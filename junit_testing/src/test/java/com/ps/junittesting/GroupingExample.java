package com.ps.junittesting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupingExample {
    CalculatorService calc = new CalculatorService();

    @Nested
    @DisplayName("Addition Tests")
    class AdditionTests {

        @Test
        @DisplayName("Adding positive numbers")
        void testPositiveAddition() {
            assertEquals(9, calc.addTwoNumbers(4, 5));
        }

        @Test
        @DisplayName("Adding zero")
        void testAdditionWithZero() {
            assertEquals(5, calc.addTwoNumbers(5, 0));
        }
    }

    @Nested
    @DisplayName("Subtraction Tests")
    class SubtractionTests {

        @Test
        @DisplayName("Subtracting smaller from larger")
        void testSubtraction() {
            assertEquals(2, calc.subtractTwoNumbers(5, 3));
        }
    }
}
