package sortingalgorithms.countingsort;
import java.util.*;

public class CountingSortAges {
    public static void countingSort(int[] ages) {
        int minAge = 10, maxAge = 18;
        int range = maxAge - minAge + 1;

        // Step 1: Create count array
        int[] count = new int[range];
        Arrays.fill(count, 0);

        // Step 2: Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 3: Compute cumulative frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 4: Sort the ages into output array
        int[] sortedAges = new int[ages.length];
        for (int i = ages.length - 1; i >= 0; i--) {
            sortedAges[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(sortedAges, 0, ages, 0, ages.length);
    }
}

