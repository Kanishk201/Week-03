package hashmapsandhashfunctions.pairwithgivensum;

public class PairSumCheck {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, -1, 0, 4, -4};
        int target = 1;
        PairSumFinder finder = new PairSumFinder();
        boolean result = finder.hasPairWithSum(arr, target);

        if (result) {
            System.out.println("A pair with the given sum exists.");
        } else {
            System.out.println("No pair with the given sum found.");
        }
    }
}

