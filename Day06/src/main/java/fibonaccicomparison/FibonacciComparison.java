package fibonaccicomparison;

public class FibonacciComparison {
    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    public static int iterativeFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }

    public static double[] comparison(int N){
        double[] output = new double[2];

        long startTime = System.nanoTime();
        int recursiveResult = recursiveFibonacci(N);
        long endTime = System.nanoTime();
        double recursiveTime = endTime - startTime;

        startTime = System.nanoTime();
        int iterativeResult = iterativeFibonacci(N);
        endTime = System.nanoTime();
        double iterativeTime = endTime - startTime;

        output[0] = recursiveTime/100000;
        output[1] = iterativeTime/100000;

        System.out.println("Recursive Fibonacci Time: " + output[0] + " ms");
        System.out.println("Iterative Fibonacci Time: " + output[1] + " ms");

        return output;
    }

}
