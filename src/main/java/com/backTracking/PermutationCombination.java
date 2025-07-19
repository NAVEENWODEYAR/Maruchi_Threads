package com.backTracking;

import java.util.*;

/**
 * @author NaveenWodeyar
 * @date 19-Jul-2025
 */

public class PermutationCombination {

    // Method to generate permutations
    public static void generatePermutations(String input, String result) {
        if (input.length() == 0) {
            System.out.println("Permutation: " + result);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String rest = input.substring(0, i) + input.substring(i + 1);
            generatePermutations(rest, result + ch);
        }
    }

    // Method to generate combinations
    public static void generateCombinations(String input, String result, int index) {
        for (int i = index; i < input.length(); i++) {
            result += input.charAt(i);
            System.out.println("Combination: " + result);
            generateCombinations(input, result, i + 1);
            // Backtrack
            result = result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number = scanner.nextLine();

        System.out.println("\n--- Permutations ---");
        generatePermutations(number, "");

        System.out.println("\n--- Combinations ---");
        generateCombinations(number, "", 0);
    }
}
