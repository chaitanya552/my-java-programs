/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
	 * 
{1,2,3}
{4,8,2}
{1,5,3}
{6,2,9}
*/	
// u can go right or down or diagnally and your aim is to from top left to bottom right
// Ex in a 3*3 matrix find min cost path from 0,0 to 2,2  i.e we create matrix temp of size m+1,n+1
public class MinimumCostPath {

	    public int minCost(int [][]cost,int m,int n){
	        
	        int temp[][] = new int[m+1][n+1];
	        //down values i.e first column
	        int sum = 0;
	        for(int i=0; i <= n; i++){
	            temp[0][i] = sum + cost[0][i];
	            sum = temp[0][i];
	        }
	        sum = 0;
	        //right values i.e top row
	        for(int i=0; i <= m; i++){
	            temp[i][0] = sum + cost[i][0];
	            sum = temp[i][0];
	        }
	        //remaining all
	        for(int i=1; i <= m; i++){
	            for(int j=1; j <= n; j++){
	                temp[i][j] = cost[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
	            }
	        }
	        return temp[m][n];
	    }
	    
	    public int minCostRec(int cost[][], int m, int n){
	    	//u have to go from top to down only so we initialize 0,0
	        return minCostRec(cost, m, n, 0 , 0);
	    }
	    
	    public int minCostRec(int cost[][], int m, int n, int x, int y){
	        if(x > m || y > n){
	            return Integer.MAX_VALUE;
	        }
	        if(x == m && y == n){
	            return cost[m][n];
		}

		int t1 = minCostRec(cost, m, n, x + 1, y);// down
		int t2 = minCostRec(cost, m, n, x + 1, y + 1);// diagnal
	        int t3 = minCostRec(cost, m , n, x, y+1);//right
	        
	        return cost[x][y] + min(t1,t2,t3);
	    }
	    
	    private int min(int a,int b, int c){
	        int l = Math.min(a, b);
	        return Math.min(l, c);
	    }
	    
	    public static void main(String args[]){
	        MinimumCostPath mcp = new MinimumCostPath();
	        int cost[][] = {{1,2,3},{4,5,6},{7,8,9}};
	        //dynamic prog
	        int result = mcp.minCost(cost, 2, 2);
	        //recursion
	        int result1 = mcp.minCostRec(cost, 2, 2);
	        System.out.println("dynamic programming");
	        System.out.println(result);
	        System.out.println("recursive");
	        System.out.println(result1);
	    }

	}