package com.ps.junittesting;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaggedTests {
    @Tag("fast")
    @Test
    void quickTest() {
        assertTrue(true);
    }

    @Tag("slow")
    @Test
    void slowRunningTest() {
        assertTrue(true);
    }
}
