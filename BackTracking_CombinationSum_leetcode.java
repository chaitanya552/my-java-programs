import java.util.ArrayList;
import java.util.Arrays;
/*
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 * [7],
 * [2,2,3]
 * ]
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 */
import java.util.List;

public class BackTracking_CombinationSum_leetcode
{
    public static void main(final String[] args)
    {
        final int[] nums = { 1, 2, 3, 4 };

        System.out.println(combinationSum(nums, 4));
    }

    public static List<List<Integer>> combinationSum(final int[] nums, final int target)
    {
        final List<List<Integer>> list = new ArrayList<>();
        final List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, tempList, nums, target, 0);
        return list;
    }

    private static void backtrack(final List<List<Integer>> list, final List<Integer> tempList, final int[] nums, final int remain, final int start)
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
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}