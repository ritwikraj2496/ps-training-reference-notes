package com.ps.junittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParameterizedExamples {

    // Integer values test
    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 6, 8 })
    void testIsEven(int number) {
        assertTrue(number % 2 == 0); // Checks all are even
    }

    // String values test
    @ParameterizedTest
    @ValueSource(strings = { "hello", "world", "java" })
    void testStringNotEmpty(String input) {
        assertFalse(input.isEmpty()); // Ensures no empty string
    }

    // Enum values test
    enum Status {
        NEW, ACTIVE, CLOSED
    }

    @ParameterizedTest
    @EnumSource(Status.class)
    void testEnumValues(Status status) {
        assertNotNull(status); // All enum values should be non-null
    }

    // Multiple arguments using @MethodSource
    static Stream<Arguments> provideAddCases() {
        return Stream.of( // this makes a stream of data - Stream.of()
                Arguments.of(2, 3, 5),
                Arguments.of(10, 20, 30),
                Arguments.of(-1, 1, 0));
    }

    @ParameterizedTest
    @MethodSource("provideAddCases")
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, a + b); // Testing addition logic - (expected, actual)
    }

    @ParameterizedTest
    @MethodSource("provideAddCases")
    void testAddition1(int a, int b, int expected) {
        assertEquals(expected, CalculatorService.addTwoNumbers(a, b)); // Now using real logic
    }
}