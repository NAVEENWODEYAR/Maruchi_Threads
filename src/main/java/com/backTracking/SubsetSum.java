package com.backTracking;

import java.util.*;

/**
 * @author NaveenWodeyar
 * @date 18-Jul-2025
 * Find all subsets of a set that sum to a target value.
 */

public class SubsetSum {
    static void findSubsets(int[] nums, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[i] <= target) {
                current.add(nums[i]);
                findSubsets(nums, target - nums[i], i + 1, current, result);
                current.remove(current.size() - 1); // BACKTRACK
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, target, 0, new ArrayList<>(), result);

        System.out.println("Subsets summing to " + target + ": " + result);
    }
}
