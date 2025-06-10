package com.threads;

/**
 * @author NaveenWodeyar
 * @date 10-Jun-2025
 */

public class ThreadCounter {

    public static void main(String[] args) {
        // Get the current thread group
        ThreadGroup rootGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parentGroup;
        while ((parentGroup = rootGroup.getParent()) != null) {
            rootGroup = parentGroup;
        }

        // Recursively count active threads in the root thread group and its subgroups
        int totalThreads = getActiveThreadCount(rootGroup);

        System.out.println("Total number of active threads in the program: " + totalThreads);

        // You can also demonstrate creating new threads and re-checking
        System.out.println("\nCreating some new threads to demonstrate...");
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("New Thread 1 finished.");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("New Thread 2 finished.");
        }).start();

        // Give a little time for new threads to start
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        totalThreads = getActiveThreadCount(rootGroup);
        System.out.println("Total number of active threads after creating new threads: " + totalThreads);
    }

    /**
     * Recursively counts the number of active threads within a given ThreadGroup and its subgroups.
     *
     * @param group The ThreadGroup to start counting from.
     * @return The total number of active threads.
     */
    public static int getActiveThreadCount(ThreadGroup group) {
        int activeThreads = group.activeCount();
        Thread[] threads = new Thread[activeThreads * 2]; // Give some buffer
        int enumeratedThreads = group.enumerate(threads, true); // true to recursively enumerate

        int count = 0;
        for (int i = 0; i < enumeratedThreads; i++) {
            if (threads[i] != null && threads[i].isAlive()) {
                count++;
            }
        }

        // Enumerate child thread groups and add their active thread counts
        int activeGroups = group.activeGroupCount();
        ThreadGroup[] groups = new ThreadGroup[activeGroups * 2]; // Give some buffer
        int enumeratedGroups = group.enumerate(groups, true); // true to recursively enumerate

        for (int i = 0; i < enumeratedGroups; i++) {
            if (groups[i] != null) {
                count += getActiveThreadCount(groups[i]); // Recursively count in subgroups
            }
        }
        return count;
    }
}