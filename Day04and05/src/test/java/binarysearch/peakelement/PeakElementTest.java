package binarysearch.peakelement;

import binarysearch.peakelementinarray.PeakElement;
import org.junit.Assert;
import org.junit.Test;

public class PeakElementTest {

    @Test

    public void peakElementTest(){
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        Assert.assertEquals(8, PeakElement.findPeakElement(arr));
    }
}
