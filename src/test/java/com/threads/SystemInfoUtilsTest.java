package com.threads;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author NaveenWodeyar
 * @date 11-Jun-2025
 */

public class SystemInfoUtilsTest {

    SystemInfoUtils utils = new SystemInfoUtils();

    @Test
    public void testAvailableProcessors() {
        int processors = utils.getAvailableProcessors();
        assertTrue(processors >= 1, "Processors should be at least 1");
    }

    @Test
    public void testMemoryValues() {
        assertTrue(utils.getTotalMemoryInMB() > 0, "Total memory should be positive");
        assertTrue(utils.getFreeMemoryInMB() >= 0, "Free memory should be non-negative");
        assertTrue(utils.getMaxMemoryInMB() > 0, "Max memory should be positive");
    }

    @Test
    public void testSystemLoadAverage() {
        double load = utils.getSystemLoadAverage();
        assertTrue(load >= -1.0, "Load average should be -1.0 or higher (if unsupported)");
    }

    @Test
    public void testProcessorInfo() {
        String info = utils.getProcessorInfo();
        assertNotNull(info);
        assertFalse(info.isBlank(), "Processor info should not be blank");
    }
}

