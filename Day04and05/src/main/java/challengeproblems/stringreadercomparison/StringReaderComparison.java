package challengeproblems.stringreadercomparison;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class StringReaderComparison {
    public static void stringReaderComparison() {
        compareStringBuilderAndStringBuffer();
        compareFileReaderAndInputStreamReader("file.txt"); // Provide the actual file path
    }

    private static void compareStringBuilderAndStringBuffer() {
        int iterations = 1_000_000;
        String text = "hello";

        // Measure StringBuilder performance
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " ms");

        // Measure StringBuffer performance
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " ms");
    }

    private static void compareFileReaderAndInputStreamReader(String filePath) {
        try {
            // FileReader
            long startTime = System.nanoTime();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            int wordCountFR = countWords(br);
            fileReader.close();
            long endTime = System.nanoTime();
            System.out.println("FileReader - Word Count: " + wordCountFR + ", Time: " + TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " ms");

            // InputStreamReader
            startTime = System.nanoTime();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
            BufferedReader br2 = new BufferedReader(inputStreamReader);
            int wordCountISR = countWords(br2);
            inputStreamReader.close();
            endTime = System.nanoTime();
            System.out.println("InputStreamReader - Word Count: " + wordCountISR + ", Time: " + TimeUnit.MILLISECONDS.convert(endTime - startTime, TimeUnit.NANOSECONDS) + " ms");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        return wordCount;
    }
}

