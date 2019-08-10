import java.util.Arrays;

/*
 * recomputations of same subproblems can be avoided by constructing a temporary array table[] in bottom up manner.
 * Below is Dynamic Programming based solution.
 */
public class MinNumberOfcoins_DP
{

    public static void main(final String[] args)
    {
        final int coins[] = { 9, 6, 3 };
        final int m = coins.length;
        final int target = 15;
        System.out.println("Minimum coins required is " + minCoins(coins, target));
    }

    public static int minCoins(final int[] coins, final int amount)
    {
        final int max = amount + 1;
        final int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (final int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            System.out.println(dp[i]);
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
