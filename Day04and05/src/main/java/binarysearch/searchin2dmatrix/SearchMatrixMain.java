package binarysearch.searchin2dmatrix;

public class SearchMatrixMain {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(SearchMatrix.searchMatrix(matrix, target));
    }
}
