/*
 * This program
 * Given an array of integers, return indices of the two numbers such that
 * they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("enter target element");
		int target = scan.nextInt();
		System.out.println("enter no of array elements");
		int len = scan.nextInt();
		System.out.println("enter array elements");
		int[] nums = new int[len];
		for (int i = 0; i < len; i++) {
			nums[i] = scan.nextInt();
		}
		System.out.println(Arrays.toString(nums));
		// all the above is about reading input
		// method is called here
		System.out.println(Arrays.toString(twoSum(nums, target)));

	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			// for each num[i] we check if the compliment is present in o(1)
			// time using hashmap
			// so total time is O(n)
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
