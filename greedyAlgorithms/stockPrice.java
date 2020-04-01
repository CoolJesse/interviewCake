
class stockPrice{

/** Function for finding the maximum possible profit *************************/
	public static int getMaxProfit(int[] prices){

		if(prices.length < 2)
			throw new IllegalArgumentException("Getting a profit requires at least 2 prices.");

		int minPrice = prices[0];
		int maxProfit = prices[1] - prices[0];

		for(int i=1; i < prices.length ; i++){
			int potentialProfit = prices[i] - minPrice;

			maxProfit = Math.max(maxProfit, potentialProfit);

			minPrice = Math.min(minPrice, prices[i]);
		}
		System.out.println("MinPrice: " + minPrice);
		return maxProfit;
	}
/*****************************************************************************/
	public static void main(String[] args){

		int[] test_1 = new int[]{4,5,3,11,12,13,6,7};
		int[] test_2 = new int[]{1,2,3,4,5,6,7,8,9};
		int[] test_3 = new int[]{9,8,7,6,5,4,3,2,1};
		int[] test_4 = new int[]{11,4,5,-1,3,15,4,4,4};

		System.out.println("The max profit is: " + getMaxProfit(test_1));
		System.out.println("The max profit is: " + getMaxProfit(test_2));
		System.out.println("The max profit is: " + getMaxProfit(test_3));
		System.out.println("The max profit is: " + getMaxProfit(test_4));
	}
}
