package com.backTracking;

/**
 * @author NaveenWodeyar
 * @date 18-Jul-2025
 */

public class BinaryStrings {
    public static void generateBinary(int n, String result) {
        if (n == 0) {
            System.out.println(result);
            return;
        }

        generateBinary(n - 1, result + "0");  // choose 0
        generateBinary(n - 1, result + "1");  // choose 1
    }

    public static void main(String[] args) {
        int n = 3; // change this to generate longer strings
        generateBinary(n, "");
    }
}
