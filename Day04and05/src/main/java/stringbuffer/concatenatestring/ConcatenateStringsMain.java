package stringbuffer.concatenatestring;

import java.util.Scanner;

public class ConcatenateStringsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }

        System.out.println("Concatenated string: " + ConcatenateStrings.concatenateStrings(strings));

    }
}
