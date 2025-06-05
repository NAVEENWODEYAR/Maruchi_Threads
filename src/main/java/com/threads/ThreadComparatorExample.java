package com.threads;

import java.util.*;

/**
 * @author NaveenWodeyar
 * @date 05-Jun-2025
 */

//Comparator to compare threads by name
class ThreadNameComparator implements Comparator<Thread> {
 public int compare(Thread t1, Thread t2) {
     return t1.getName().compareTo(t2.getName());
 }
}

//Comparator to compare threads by priority
class ThreadPriorityComparator implements Comparator<Thread> {
 public int compare(Thread t1, Thread t2) {
     return Integer.compare(t1.getPriority(), t2.getPriority());
 }
}

public class ThreadComparatorExample {
 public static void main(String[] args) {
     // Create threads with different names and priorities
     Thread t1 = new Thread(() -> {}, "Zebra");
     Thread t2 = new Thread(() -> {}, "Alpha");

     t1.setPriority(3);
     t2.setPriority(7);

     List<Thread> threadList = Arrays.asList(t1, t2);

     System.out.println("Before Sorting:");
     threadList.forEach(t -> System.out.println(t.getName() + " (Priority: " + t.getPriority() + ")"));

     // Sort by name
     System.out.println("\nSorting by Name:");
     threadList.sort(new ThreadNameComparator());
     threadList.forEach(t -> System.out.println(t.getName() + " (Priority: " + t.getPriority() + ")"));

     // Sort by priority
     System.out.println("\nSorting by Priority:");
     threadList.sort(new ThreadPriorityComparator());
     threadList.forEach(t -> System.out.println(t.getName() + " (Priority: " + t.getPriority() + ")"));
 }
}

