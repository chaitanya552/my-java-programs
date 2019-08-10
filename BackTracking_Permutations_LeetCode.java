import java.util.ArrayList;
import java.util.List;

public class BackTracking_Permutations_LeetCode
{
    static int count = 0;

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final int[] nums = { 1, 2, 3 };

        System.out.println(permute(nums));
        System.out.println("abc".substring(0, 0) + "->hello");
        permutation("123", "");
    }

    public static List<List<Integer>> permute(final int[] nums)
    {
        final List<List<Integer>> list = new ArrayList<>();
        final List<Integer> tempList = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, tempList, nums);
        return list;
    }

    private static void backtrack(final List<List<Integer>> list, final List<Integer> tempList, final int[] nums)
    {

        // System.out.println("iteration->" + count++);
        if (tempList.size() == nums.length) {
            // System.out.println("iteration->" + (count - 1));
            list.add(new ArrayList<>(tempList));
            // new object of templist should be created, otherwise whenever u change templist, it will changed at all places in result
            // List( tempList, tempList, tempList, tempList)

        }
        else {
            for (final int num : nums) {

                if (tempList.contains(num)) {
                    continue; // element already exists, skip
                }

                tempList.add(num);
                // System.out.println(i+" i");
                backtrack(list, tempList, nums);

                tempList.remove(tempList.size() - 1);

            }
        }
    }
    // another solution using substring

    public static void permutation(final String str, final String prefix)
    {
        final int n = str.length();
        if (n == 0) { // or prefix = str.length
            System.out.println(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                permutation(str.substring(0, i) + str.substring(i + 1, n), prefix + str.charAt(i));
            }
        }
    }

}