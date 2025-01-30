package hashmapsandhashfunctions.zerosumsubarrays;

import java.util.*;

public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        // List to store the indices of zero sum subarrays
        List<int[]> result = new ArrayList<>();

        // Initialize map with sum 0 at index -1
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum exists in map, we found zero sum subarrays
            if (sumMap.containsKey(sum)) {
                for (int startIdx : sumMap.get(sum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Add current sum to map
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        // Print all found subarrays
        if (result.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Zero sum subarrays found at indices:");
            for (int[] range : result) {
                System.out.println("Start: " + range[0] + ", End: " + range[1]);
            }
        }
    }
}
