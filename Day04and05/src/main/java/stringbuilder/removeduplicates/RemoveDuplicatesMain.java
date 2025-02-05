package stringbuilder.removeduplicates;
import java.util.Scanner;

public class RemoveDuplicatesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("String without duplicates: " + RemoveDuplicates.removeDuplicates(input));
    }
}
