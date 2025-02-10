package datastructurescomparison;

public class DataStructuresComparisonMain {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};

        for(int N : sizes){
            DataStructuresSearchComparison.comparison(N);
        }
    }
}
