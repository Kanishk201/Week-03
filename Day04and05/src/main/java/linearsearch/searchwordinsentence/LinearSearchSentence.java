package linearsearch.searchwordinsentence;

public class LinearSearchSentence {
    public static String searchWordInSentences(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}
