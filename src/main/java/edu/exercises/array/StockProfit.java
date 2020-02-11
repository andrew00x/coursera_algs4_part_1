package edu.exercises.array;

public class StockProfit {
    public int bestProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxProfit = 0;
        int profit;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if ((profit = prices[i] - minPrice) > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public int bestProfitManyTransactions(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
