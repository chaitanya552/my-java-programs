/* A child can take either 1 or 2 or 3 steps while he is climbing 
 * In howmany ways can be nth step
 * Algorithm - he can climb nth step in  x ways 
 * x ways = no of ways to climb n-1th step + number of ways to climbs n-2th step + no of ways to climb n-3th step
 *
 *
 *for example consider only he can make 1 step and 2 step 
 *no of ways to climb 4th step is 
 *1->1 , 
 *2-> (1,1);(2)
 *3-> (1,1,1);(1,2);(2,1)
 *
 * 4th step ways = 3rd step ways (1) + 2nd step ways (2)
 *(1,1,1,*1)
 *(2,1,*1)            n-1th step i.e3rd step without stars
 *1,2,*1)
 *--------
 *(1,1,*2)
 *(2,*2)               n-2nd step i.e 2nd step without stars
 */

import java.util.Scanner;

public class GS_StairCaseProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n;
		while ((n=scan.nextInt()) != 0) {
			//int n = scan.nextInt();
			if (n >= 1) {
				System.out.println(fib(n));
			}

		}
	}

	public static int fib(int n) {
		switch(n)
		{
		case 0: return 0;
		case 1: return 1;
		case 2: return 2;
		case 3: return 4;
		default:
			{
				int a=fib(n - 1) + fib(n - 2) + fib(n - 3);
				return a;
			}
		}
		/*if (n <= ) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2) + fib(n - 3);
		}*/

	}
}
