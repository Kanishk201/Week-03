package stackandqueue.stockspan;
import java.util.Stack;

public class StockSpan {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and price[stack.top()] <= price[i]
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means all previous prices were smaller
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            // Push current index onto the stack
            stack.push(i);
        }

        return span;
    }
}
