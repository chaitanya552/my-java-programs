import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class BackTracking_Permutations2_LeetCode
{
    static int count = 0;

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final int[] nums = { 1, 2, 3 };

        System.out.println(permuteUnique(nums));
        System.out.println("abc".substring(0, 0) + "->hello");
        // another method using substring
        final Set<String> result = new LinkedHashSet<>();
        System.out.println(permutation2("123", "", result));
    }

    public static List<List<Integer>> permuteUnique(final int[] nums)
    {
        final List<List<Integer>> list = new ArrayList<>();
        final List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, tempList, nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(final List<List<Integer>> list, final List<Integer> tempList, final int[] nums, final boolean[] used)
    {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || ((i > 0) && (nums[i] == nums[i - 1]) && !used[i - 1])) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    // another solution using substring

    public static Set<String> permutation2(final String str, final String prefix, final Set<String> result)
    {
        final int n = str.length();
        if (n == 0) { // or prefix = str.length
            System.out.println(prefix);
            // System.out.println(result);
            result.add(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                permutation2(str.substring(0, i) + str.substring(i + 1, n), prefix + str.charAt(i), result);
            }
        }
        return result;
    }

}