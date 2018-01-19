/*
 * This program
 * Given an array of integers, return indices of the two numbers such that
 * they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice
 * a+b+c= target
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ThreeSum_LeetCode {

	// static List<List<Integer>> ret = new ArrayList<List<Integer>>();

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

		System.out.println(threeSum(nums, target));

	}

	public static List<List<Integer>> threeSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> combinedList = new ArrayList<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int j = 0; j < nums.length; j++) {
			int newTarget = 0;
			newTarget = target - nums[j];
			int firstIndex = j;
			for (int i = firstIndex + 1; i < nums.length; i++) {
				// for each num[i] we check if the compliment is present in o(1)
				// time using hashmap
				// so total time is O(n)and outr loop total will be O(n2)

				int complement = newTarget - nums[i];
				if ((nums[firstIndex] > 0 && nums[i] > 0 && complement > 0)
						|| (nums[firstIndex] < 0 && nums[i] < 0 && complement < 0)) {
					continue;
				}
				if (map.containsKey(complement) && map.get(complement) > i) {
					ArrayList<Integer> initialList = new ArrayList<Integer>();
					initialList.add(nums[firstIndex]);
					initialList.add(nums[i]);
					initialList.add(complement);
					if (!combinedList.contains(initialList)) {
						combinedList.add(initialList);
					}

				}

			}

			// throw new IllegalArgumentException("No three sum solution");
		}
		return combinedList;

	}

}
