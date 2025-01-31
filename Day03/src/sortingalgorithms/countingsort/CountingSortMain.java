package sortingalgorithms.countingsort;
import java.util.*;

public class CountingSortMain {
    public static void main(String[] args) {
        int[] studentAges = {15, 12, 18, 10, 17, 13, 16, 12, 11, 14, 18, 10};
        System.out.println("Before Sorting: " + Arrays.toString(studentAges));

        CountingSortAges.countingSort(studentAges);

        System.out.println("After Sorting: " + Arrays.toString(studentAges));
    }
}
