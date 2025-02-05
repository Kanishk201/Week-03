package binarysearch.rotationpoint;

import binarysearch.rotationpointinsortedarray.RotationPointBinarySearch;
import org.junit.Assert;
import org.junit.Test;


public class RotationPointTest {

    @Test

    public void rotationPointTest(){
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(4, RotationPointBinarySearch.findRotationPoint(arr));
    }
}
