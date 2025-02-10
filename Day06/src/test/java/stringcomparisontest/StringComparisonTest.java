package stringcomparisontest;

import org.junit.Assert;
import org.junit.Test;
import stringperformancecomparison.StringConcatenatePerformance;
public class StringComparisonTest {

    @Test

    public void stringTest() {
        int[] sizes = {1000, 10000};
        for(int size : sizes){
            double[] result = StringConcatenatePerformance.compare(size);

            Assert.assertEquals((result[1] < result[0]) && (result[1] < result[2]), true);
        }
    }
}
