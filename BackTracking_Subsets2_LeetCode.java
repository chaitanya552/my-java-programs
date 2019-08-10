import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking_Subsets2_LeetCode
{
    static int count = 1;

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final int[] nums = { 1, 2, 2 };
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(final int[] nums)
    {
        final List<List<Integer>> list = new ArrayList<>();
        final List<Integer> tempList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, tempList, nums, 0);
        return list;
    }

    private static void backtrack(final List<List<Integer>> list, final List<Integer> tempList, final int[] nums, final int start)
    {
        System.out.println("iteration->" + count++);
        System.out.println("backtrack-(nums," + start + ")--> current subset is" + tempList);

        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if ((i > start) && (nums[i] == nums[i - 1])) {
                System.out.println(i + "i value,start" + start);
                continue;
            } // skip duplicates
            tempList.add(nums[i]);
            System.out.println(tempList);

            // System.out.println(tempList);
            backtrack(list, tempList, nums, i + 1);

            tempList.remove(tempList.size() - 1);
        }
    }
}