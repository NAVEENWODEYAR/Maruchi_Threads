package com.threads;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author NaveenWodeyar
 * @date 11-Jun-2025
 */

public class SystemInfoUtils {

    /**
     * Returns the number of logical processors available to the JVM.
     */
    public int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    /**
     * Returns the total memory in the JVM (in MB).
     */
    public long getTotalMemoryInMB() {
        return Runtime.getRuntime().totalMemory() / (1024 * 1024);
    }

    /**
     * Returns the free memory in the JVM (in MB).
     */
    public long getFreeMemoryInMB() {
        return Runtime.getRuntime().freeMemory() / (1024 * 1024);
    }

    /**
     * Returns the max memory the JVM can use (in MB).
     */
    public long getMaxMemoryInMB() {
        return Runtime.getRuntime().maxMemory() / (1024 * 1024);
    }

    /**
     * Returns the system load average (may not be supported on Windows).
     */
    public double getSystemLoadAverage() {
        OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
        return osBean.getSystemLoadAverage();
    }

    /**
     * Creates a fixed thread pool based on the number of available processors.
     */
    public ExecutorService createOptimizedThreadPool() {
        int cores = getAvailableProcessors();
        return Executors.newFixedThreadPool(cores);
    }

    /**
     * (Workaround) Gets the OS architecture and name, as Java cannot get processor clock speed directly.
     */
    public String getProcessorInfo() {
        return System.getProperty("os.arch") + " on " + System.getProperty("os.name");
    }

    public static void main(String[] args) {
        SystemInfoUtils info = new SystemInfoUtils();

        System.out.println("Available processors: " + info.getAvailableProcessors());
        System.out.println("Total JVM memory (MB): " + info.getTotalMemoryInMB());
        System.out.println("Free JVM memory (MB): " + info.getFreeMemoryInMB());
        System.out.println("Max JVM memory (MB): " + info.getMaxMemoryInMB());
        System.out.println("System load average: " + info.getSystemLoadAverage());
        System.out.println("Processor Info: " + info.getProcessorInfo());

        ExecutorService pool = info.createOptimizedThreadPool();
        pool.shutdown();
    }
}

