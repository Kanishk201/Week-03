package challengeproblems.linearandbinarysearch;

import java.util.Arrays;

public class SearchAlgorithms {
    public static void searchAlgorithms() {
        int[] nums = {3, 4, -1, 1, 7, 2, 6};
        int target = 7;

        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First Missing Positive Integer: " + missingNumber);


        Arrays.sort(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));


        int targetIndex = binarySearch(nums, target);
        System.out.println("Index of Target (" + target + "): " + targetIndex);
    }

    private static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // Mark as visited
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    // Binary Search to find the target index
    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
