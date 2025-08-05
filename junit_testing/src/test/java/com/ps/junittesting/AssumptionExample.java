package com.ps.junittesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumptionExample {
    @Test
    void runOnlyInDevEnvironment() {
        String env = "DEV"; // pretend to read from config or env variable

        assumeTrue("DEV".equals(env), "Test skipped: Not in DEV environment");

        // This part will run only if assumption is true
        assertEquals(2, 1 + 1);
    }

    @Test
    void skipTestInProdEnvironment() {
        String env = "PROD";

        assumeFalse("PROD".equals(env), "Test skipped: Runs only outside PROD");

        // Will be skipped in PROD
        assertTrue(true);
    }
}
