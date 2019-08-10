
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers
 * sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 * [1,2,2],
 * [5]
 * ]
 */
import java.util.List;

public class BackTracking_CombinationSum2_leetcode
{
    public static void main(final String[] args)
    {
        final int[] nums = { 2, 5, 2, 1, 2 };

        System.out.println(combinationSum(nums, 5));
    }

    public static HashSet<List<Integer>> combinationSum(final int[] nums, final int target)
    {
        final HashSet<List<Integer>> list = new HashSet<List<Integer>>();
        final List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, tempList, nums, target, 0);
        return list;
    }

    private static void backtrack(final HashSet<List<Integer>> list, final List<Integer> tempList, final int[] nums, final int remain, final int start)
    {
        if (remain < 0) {
            return;
        }
        else if (remain == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1); // i + 1 because we can't reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    /*
     * without hashset
     * public List<List<Integer>> combinationSum2(int[] nums, int target) {
     * List<List<Integer>> list = new ArrayList<>();
     * Arrays.sort(nums);
     * backtrack(list, new ArrayList<>(), nums, target, 0);
     * return list;
     * }
     * private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
     * if(remain < 0) return;
     * else if(remain == 0) list.add(new ArrayList<>(tempList));
     * else{
     * for(int i = start; i < nums.length; i++){
     * if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
     * tempList.add(nums[i]);
     * backtrack(list, tempList, nums, remain - nums[i], i + 1);
     * tempList.remove(tempList.size() - 1);
     * }
     * }
     * }
     */
}