package fibonaccicomparison;

public class FibonacciComparisonMain {
    public static void main(String[] args) {
        int[] sizes = {10, 30, 50};

        for(int N : sizes){
            FibonacciComparison.comparison(N);
        }
    }
}
