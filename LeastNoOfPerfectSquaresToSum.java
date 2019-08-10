import java.util.Arrays;

public class LeastNoOfPerfectSquaresToSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
numSquares(13);
	}
	
	public static int numSquares(int n) {
	    int max = (int) Math.sqrt(n);
	 
	    int[] dp = new int[n+1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	
	    for(int i=1; i<=n; i++){
	        for(int j=1; j<=max; j++){
	        	
	            if(i==j*j){
	                dp[i]=1;
	            }else if(i>j*j){
	            	
	                dp[i]=Math.min(dp[i], dp[i-j*j] + 1);
	            }
	            
	        }
	    }
	    for(int i=0;i<=n;i++)
	    {
	    	System.out.println("dp["+i+"]"+dp[i]);
	    }
	 
	    return dp[n];
	}

}
