package sortingalgorithms.insertionsort;

import java.util.Arrays;
import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for number of employees
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] ids = new int[n];

        // Taking input for employee IDs
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        // Sorting the employee IDs
        EmployeeIDSort.insertionSort(ids);

        // Displaying result
        System.out.println("Sorted Employee IDs: " + Arrays.toString(ids));

    }
}
