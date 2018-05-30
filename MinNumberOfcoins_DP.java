/* recomputations of same subproblems can be avoided by constructing a temporary array table[] in bottom up manner.
Below is Dynamic Programming based solution.*/
public class MinNumberOfcoins_DP {

	public static void main(String[] args) {
		int coins[] = { 9, 6, 3 };
		int m = coins.length;
		int target = 15;
		System.out.println("Minimum coins required is " + minCoins(coins, m, target));
	}

	// m is size of coins array
	// (number of different coins)
	static int minCoins(int coins[], int m, int target) {
		// table[i] will be storing
		// the minimum number of coins
		// required for i value. So
		// table[target] will have result
		int table[] = new int[target + 1];

		// Base case (If given value V is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= target; i++) {
			table[i] = Integer.MAX_VALUE;
			//System.out.println(table[i]);
		}
			// Compute minimum coins required for all
			// values from 1 to target
			for (int i = 1; i <= target; i++) {
				// Go through all coins smaller than i
				for (int j = 0; j < m; j++)
					if (coins[j] <= i) {
						int sub_res = table[i - coins[j]];
						//System.out.println((sub_res + 1) + "i: " + i);
						if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
							table[i] = sub_res + 1;

					}

			}
			return table[target];
		}

}
