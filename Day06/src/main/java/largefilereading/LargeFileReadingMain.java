package largefilereading;

public class LargeFileReadingMain {
    public static void main(String[] args) {
        String[] files = {"file1.pdf", "file2.pdf", "file3.pdf"};
        for (String file : files) {
            LargeFileReading.compare(file);
        }
    }
}
