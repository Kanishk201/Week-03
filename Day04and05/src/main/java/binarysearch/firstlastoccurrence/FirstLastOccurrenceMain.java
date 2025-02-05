package binarysearch.firstlastoccurence;

public class FirstLastOccurrenceMain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] result = FirstLastOccurrence.findFirstAndLast(arr, target);
        System.out.println("The first occurrence of element is at index: " + result[0]);
        System.out.println("The last occurrence of element is at index: " + result[1]);
    }
}
