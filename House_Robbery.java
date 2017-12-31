/*
 * You are a professional robber planning to rob houses along a street.
 *  Each house has a certain amount of money stashed, the only constraint
 *   stopping you from robbing each of them is that adjacent houses have security 
 *   system connected and it will automatically contact the police if two adjacent houses
 *    were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class House_Robbery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] house = { 6, 1, 4, 6, 2, 8, 9, 10,13,14 };
		// let as take a dummy house beside first house and money in it be 0

		int[] lookup = new int[house.length + 1];
		lookup[0] = 0;
		lookup[1] = Math.max(house[0], lookup[0]);
		for (int i = 2; i <= house.length; i++) {
			// so we have two options when we go from house 2
			// 1. pick that house and leave adjacent house to it and consider
			// the lookup remaining houses
			// 2. or leave current house and pick lookup of prev houses
			lookup[i] = Math.max(house[i - 1] + lookup[i - 2], lookup[i - 1]);
			//lookup[2] is 2
			//l[3] is 6
			System.out.println(lookup[i]+ "house number is "+ i);
		}
		System.out.println(lookup[house.length]+" max robbery");
	}

}
