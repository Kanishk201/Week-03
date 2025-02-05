package binarysearch.firstlastoccurrence;

import binarysearch.firstlastoccurence.FirstLastOccurrence;
import org.junit.Assert;
import org.junit.Test;

public class FirstLastOccurrenceTest {

    @Test

    public void firstLastOccurrenceTest(){
        int[] arr = {1, 2, 3, 3, 3, 4, 5};
        int target = 3;
        Assert.assertEquals(2, FirstLastOccurrence.findFirstOccurrence(arr, target));
        Assert.assertEquals(4, FirstLastOccurrence.findLastOccurrence(arr, target));
    }
}
