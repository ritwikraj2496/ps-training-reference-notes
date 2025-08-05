package com.ps.junittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;

public class AssertionExamples {
    @Test
    void testAllCommonAssertions() {
        int result = 5 + 3;

        assertEquals(8, result); // checks if values are equal
        assertNotEquals(10, result); // checks values are not equal
        assertTrue(result > 0); // true condition check
        assertFalse(result < 0); // false condition check

        String name = "JUnit";
        assertNotNull(name); // name should not be null
        assertNull(null); // explicitly checking null

        String[] arr1 = { "A", "B" };
        String[] arr2 = { "A", "B" };
        assertArrayEquals(arr1, arr2); // compares array content

        String actual = new String("Ameesha"); // one object with different memory address (heap)
        String expected = new String("Ameesha"); // another object with different memory address (heap)

        // Assertions.assertSame(expected, name); //failing test case
        Assertions.assertEquals(expected, actual);

        String actualName = "Ameesha";
        String expectedName = "Ameesha";

        Assertions.assertSame(expectedName, actualName);
    }
}
