/*
 * Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
 */
public class BestTimetoBuyStock_LeetCode {

	public static void main(String[] args) {
		//int[] prices= {7,1,5,3,6,4};
		int[] prices= {7,6,4,3,1};
		System.out.println(maxProfit(prices));
		
	}
//O(n2)
	public static int maxProfit(int[] prices) {
		int profitMax=0;
		int profit=0;
		for(int i=0;i< prices.length-1;i++)
		{
			for (int j=i+1;j< prices.length;j++)
			{
				if(prices[j]>prices[i])
				{
					System.out.println(i+","+j);
					profit = prices[j]-prices[i];
				}
				if (profit>profitMax)
				{
					profitMax =profit;
				}
			}
		}
			return profitMax;
    }
	//O(n)
	public static int maxProfit2(int[] prices) {
		int profitMax=0;
		int minPrice= Integer.MAX_VALUE;
		for(int i=0;i< prices.length;i++)
		{
			if(prices[i]<minPrice)
			{
				minPrice=prices[i];
			}
			else if (prices[i]-minPrice> profitMax)
			{
				profitMax=prices[i]- minPrice;
			}
		}
			return profitMax;
    }
}
