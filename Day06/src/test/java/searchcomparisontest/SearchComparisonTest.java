package searchcomparisontest;

import org.junit.Assert;
import org.junit.Test;
import searchingalgorithmanalysis.SearchComparison;

public class SearchComparisonTest {

    @Test

    public void linearBinarySearchTest(){
        int[] sizes = {1000, 10000, 1000000};
        for(int size : sizes){
            double[] result = SearchComparison.comparePerformance(size);
            Assert.assertEquals(result[0] > result[1], true);
        }
    }
}
