package linearsearch.firstnegativenumber;

import org.junit.Assert;
import org.junit.Test;

public class FirstNegativeNumberTest {

    @Test

    public void firstNegativeNumberTest(){
        int[] arr = {1, -1, 2, 3, 4};
        Assert.assertEquals(1, FirstNegativeNumber.findFirstNegative(arr));
    }
}
