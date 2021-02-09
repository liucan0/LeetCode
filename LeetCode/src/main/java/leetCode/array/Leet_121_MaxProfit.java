package leetCode.array;

/**
 * leetcode 121 买卖股票的最佳时机
 *给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 */
public class Leet_121_MaxProfit {

    /**
     * 记录遍历过程中的最小值minPrice以及当前位置值与当前最小值的差值maxProfit(最大收益值),若后续遍历的值小于minPrice
     * 则更新minPrice,若当前值与minPrice之差大于maxProfit,则更新maxProfit
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minPirce = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPirce) {
                //当前值比之前的值都要小，设当前值为最小值
                minPirce = prices[i];
            } else if (prices[i] - minPirce > maxProfit) {
                //如果当前值与最小值只差大于之前的最大收益值，以当前收益值为最大收益值
                maxProfit = prices[i] - minPirce;
            }
        }
        return maxProfit;
    }
}
