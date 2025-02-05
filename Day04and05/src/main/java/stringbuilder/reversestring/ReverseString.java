package stringbuilder.reversestring;

import java.util.Scanner;

public class ReverseString {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return sb.reverse().toString();
    }
}