/**
 * @author NaveenWodeyar
 * @date 18-Jul-2025
 */
package com.backTracking;

public class Subsets {
    public static void generateSubsets(String str, int index, String current) {
        if (index == str.length()) {
            System.out.println(current);
            return;
        }

        // include the character
        generateSubsets(str, index + 1, current + str.charAt(index));

        // exclude the character (backtrack)
        generateSubsets(str, index + 1, current);
    }

    public static void main(String[] args) {
        String str = "AB";
        generateSubsets(str, 0, "");
    }
}
