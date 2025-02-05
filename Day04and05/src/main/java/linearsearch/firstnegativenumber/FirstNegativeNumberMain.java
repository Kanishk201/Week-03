package linearsearch.firstnegativenumber;

import java.util.Scanner;

public class FirstNegativeNumberMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            System.out.print("enter the number " + (i+1) + " : ");
            arr[i] = sc.nextInt();
        }
        int result = FirstNegativeNumber.findFirstNegative(arr);

        if (result != -1) {
            System.out.println("First negative number is at index : " + result);
        } else {
            System.out.println("No negative number found.");
        }
    }
}
