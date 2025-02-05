package linearsearch.searchwordinsentence;

import java.util.Scanner;

public class SearchSentenceMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of sentences: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] sentences = new String[n];
        System.out.println("Enter the sentences:");
        for (int i = 0; i < n; i++) {
            sentences[i] = scanner.nextLine();
        }

        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();

        String result = LinearSearchSentence.searchWordInSentences(sentences, word);
        System.out.println("Result: " + result);
    }
}
