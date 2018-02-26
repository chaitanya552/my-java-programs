/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
 */
public class ClimbStairs_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(44));
	}

	public static int climbStairs(int n) {
		// base case
		//M1 using only two variables and concept of DP
		int onestepback=2;
		int twostepback=1;
		int currentstep=0;
		if(n<=2)
		{
			return n;
		}
		else
		{
			
			for(int i=3;i<=n;i++)
			{
				currentstep=onestepback+twostepback;
				twostepback=onestepback;
				onestepback=currentstep;
				
			}
		}
		return currentstep;
	}
}
/*M2 - DP
 * int ans=0;
		if(n<=2)
		{
			return n;
		}
		else
		{
		int[] result = new int[n+1];
		result[1]=1;
		result[2]=2;
		
		for(int i=3;i<=n;i++)
		{
			result[i]=result[i-1]+result[i-2];
			if(i==n)
			{
				ans= result[i];
			}
		}
		}
		return ans;
 */
/*M3 -recursive
 * if (n <= 2) {
 * 
 * return n; } else { return climbStairs(n - 1) + climbStairs(n - 2); // no of
 * ways to reach nth step is = no of ways to rach n-1 step + // no of ways to
 * reach n-2 step }
 * 
 * explanation
 * n=1
1
n=2
1,1
2
n=3 (no of ways of to reach step->2+ no of ways to reach step-> 1)
1,1, 1
2,   1
1,   2
n=4  (no of ways of to reach step->3+ no of ways to reach step-> 2)
1,1,1 1
2,1   1
1,2   1
1,1   2
2     2
 //base case
    if (n<=2)
    {
        return n;
    }
        else {
            return climbStairs(n-1)+climbStairs(n-2);
            //no of ways to reach nth step is = no of ways to rach n-1 step + no of ways to reach n-2 step
        }
        this is time taking so we go with DP
*/
 