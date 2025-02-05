package stringbuilder.reversestring;
import java.util.Scanner;

public class ReverseStringMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("Reversed string: " + ReverseString.reverse(input));
    }
}
