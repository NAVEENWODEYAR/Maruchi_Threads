package com.threads;

import java.util.*;

/**
 * @author NaveenWodeyar
 * @date 05-Jun-2025
 */

public class ThreadStreamComparatorExample {
    public static void main(String[] args) {
        // Create threads with different properties
        Thread t1 = new Thread(() -> {}, "Ammi");
        Thread t2 = new Thread(() -> {}, "Bella");
        Thread t3 = new Thread(() -> {}, "Clara");

        t1.setPriority(5);
        t2.setPriority(3);
        t3.setPriority(7);

        List<Thread> threads = Arrays.asList(t1, t2, t3);

        System.out.println("Original List:");
        threads.forEach(t -> printThread(t));

        System.out.println("\n🔠 Sorted by Name (Streams):");
        threads.stream()
               .sorted(Comparator.comparing(Thread::getName))
               .forEach(ThreadStreamComparatorExample::printThread);

        System.out.println("\n🔢 Sorted by Priority (Streams):");
        threads.stream()
               .sorted(Comparator.comparingInt(Thread::getPriority))
               .forEach(ThreadStreamComparatorExample::printThread);

        System.out.println("\n🆔 Sorted by Thread ID (Streams):");
        threads.stream()
               .sorted(Comparator.comparingLong(Thread::getId))
               .forEach(ThreadStreamComparatorExample::printThread);
    }

    // Utility method for printing thread info
    private static void printThread(Thread t) {
        System.out.println("Name: " + t.getName() +
                           ", Priority: " + t.getPriority() +
                           ", ID: " + t.getId());
    }
}

