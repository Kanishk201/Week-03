package binarysearch.peakelementinarray;

public class PeakElementMain {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        int peakElement = PeakElement.findPeakElement(arr);
        System.out.println("The peak element in the given array is: " + peakElement);
    }
}
