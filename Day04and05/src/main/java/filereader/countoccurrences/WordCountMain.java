package filereader.countoccurences;

public class WordCountMain {
    public static void main(String[] args) {
        String fileName = "file.txt";
        String targetWord = "hello";
        int occurrences = WordCount.countWordOccurrences(fileName, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}
