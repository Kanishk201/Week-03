package stackandqueue.sortstackrecursively;
import java.util.Stack;

public class SortStackRecursively {
    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Step 1: Remove the top element
            int temp = stack.pop();

            // Step 2: Recursively sort the remaining stack
            sortStack(stack);

            // Step 3: Insert the popped element back in sorted order
            insertSorted(stack, temp);
        }
    }

    // Function to insert an element into a sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: If stack is empty or top element is smaller, push it
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int temp = stack.pop();

        // Recursively insert element at the correct position
        insertSorted(stack, element);

        // Push the removed element back
        stack.push(temp);
    }
}