package fibonaccicomparisontest;

import org.junit.Assert;
import org.junit.Test;
import fibonaccicomparison.FibonacciComparison;

public class FibonacciComparisonTest {

    @Test

    public void fibonacciComparisonTest() {
        int[] sizes = {1000, 10000};
        for(int size : sizes){
            double[] result = FibonacciComparison.comparison(size);

            Assert.assertEquals(result[1] < result[0], true);
        }
    }

}
