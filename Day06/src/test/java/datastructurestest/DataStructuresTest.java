package datastructurestest;

import datastructurescomparison.DataStructuresSearchComparison;
import org.junit.Assert;
import org.junit.Test;

public class DataStructuresTest {

    @Test

    public void dataStructuresTest() {
        int[] sizes = {1000, 10000};
        for(int size : sizes){
            double[] result = DataStructuresSearchComparison.comparison(size);

            Assert.assertEquals((result[1] < result[0]) || (result[1] < result[2]), true);
        }
    }
}
