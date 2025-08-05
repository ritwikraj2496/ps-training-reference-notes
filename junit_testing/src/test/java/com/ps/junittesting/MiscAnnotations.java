package com.ps.junittesting;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MiscAnnotations {
    @RepeatedTest(3)
    void testRunsThreeTimes() {
        System.out.println("Running test multiple times");
    }

    @Disabled("Temporarily disabled due to bug")
    @Test
    void thisTestIsDisabled() {
        fail("This test should be skipped.");
    }

    @Tag("slow")
    @Test
    void testThatTakesLongTime() {
        // Marked as slow for selective runs
        assertTrue(true);
    }
}
