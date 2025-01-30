package stackandqueue.stockspan;

public class StockSpanMain {
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = StockSpan.calculateSpan(prices);

        System.out.print("Stock Span: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}
