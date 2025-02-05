package binarysearch.searchin2dmatrix;

import org.junit.Assert;
import org.junit.Test;

public class SearchIn2dMatrixTest {

    @Test

    public void searchIn2dMatrixTest(){
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 34;

        Assert.assertEquals(true, SearchMatrix.searchMatrix(matrix, target));
    }
}
