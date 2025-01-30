package hashmapsandhashfunctions.longestconsecutivesequence;

import java.util.*;

class LongestConsecutiveSequenceFinder {
    public int findLongestConsecutiveSequence(int[] arr) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : arr) {
            if (!numSet.contains(num - 1)) { // Start of a sequence
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
