package stackandqueue.slidingwindowmaximum;

public class SlidingWindowMain {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = SlidingWindowMaximum.maxSlidingWindow(nums, k);

        System.out.print("Sliding Window Maximum: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
