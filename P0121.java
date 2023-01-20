/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * BEST TIME TO BUY AND SELL STOCK
 */

public class P0121 {
    public static int maxProfit(int[] prices) {
        int min = 10001;
        int difference = 0;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) 
                min = prices[i];
            difference = Math.max(difference,prices[i] - min);
        }
        return difference;
    }

    public static void main(String[] args) {
        int[] a = {5,9,2,4,1,2};
        System.out.println(maxProfit(a));
    }
}
