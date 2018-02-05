/*
 * https://www.youtube.com/watch?v=PCb1Ca_j6OU&t=4s
 * 
 * 
 * basic logic is 
 * 1.open brackets are less than max
 * 2.close brackets can't be greater than open
 * 3. also open and close brackets can't go more than n
 * for n=3
 * start with (
 * (( ---------------back tracking happens here --> (() --->(()( or  (())  and so on and so forth     
 * (((
 * ((()
 * ((())
 * ((()))[s]
 * uses recursion
 * O(4^n/root(n))
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_LeetCode {

	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	public static void backtrack(List<String> ans, String cur, int open,
			int close, int max) {
		if (open == max && close == max) {
			ans.add(cur);
			return;
		}

		if (open < max) {
			backtrack(ans, cur + "(", open + 1, close, max);

		}
		if (close < open) {
			backtrack(ans, cur + ")", open, close + 1, max);

		}
	}

	public static void main(String[] args) {
System.out.println(generateParenthesis(3));
		
	}
}