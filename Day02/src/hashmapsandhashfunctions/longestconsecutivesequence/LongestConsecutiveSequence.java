package hashmapsandhashfunctions.longestconsecutivesequence;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequenceFinder finder = new LongestConsecutiveSequenceFinder();
        int result = finder.findLongestConsecutiveSequence(arr);

        System.out.println("Length of the longest consecutive sequence: " + result);
    }
}
