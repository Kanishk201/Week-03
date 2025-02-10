package filereadingcomparisontest;

import largefilereading.LargeFileReading;
import org.junit.Assert;
import org.junit.Test;

public class FileReadingComparisonTest {

    @Test

    public void fileComparisonTest() {
        String[] files = {"file1.pdf", "file2.pdf", "file3.pdf"};
        for(String file : files){
            double[] result = LargeFileReading.compare(file);

            Assert.assertEquals(result[1] < result[0], true);
        }
    }
}
