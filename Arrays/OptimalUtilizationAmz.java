package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your
 * task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible.
 * Return a list of ids of selected elements. If no pair is possible, return an empty list.
 * Example 1:
 * Input:
 * a = [[1, 2], [2, 4], [3, 6]]
 * b = [[1, 2]]
 * target = 7
 * Output: [[2, 1]]
 * Explanation:
 * There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 * Example 2:
 * Input:
 * a = [[1, 3], [2, 5], [3, 7], [4, 10]]
 * b = [[1, 2], [2, 3], [3, 4], [4, 5]]
 * target = 10
 * Output: [[2, 4], [3, 2]]
 */

/*
 * Algo
 * Sort arrays by values
 * now two pointer approach
 * i starts a th 0 position
 * j starts from end
 * i+j> target then trim j to level less else i increases to find nearest to target
 * if max so far updates then clear current result
 * when <= target also check in j if there are repeated values, then a while loop will add all these results
 */
public class OptimalUtilizationAmz
{
    public static void main(final String[] args)
    {
        final int[][] a = { { 1, 2 }, { 2, 4 }, { 3, 6 } };
        final int[][] b = { { 1, 2 }, { 2, 2 } };
        // java 8
        final Comparator<int[]> myComp = (o1, o2) -> o1[1] - o2[1];
        // java 7
        /*
         * Comparator<int[]> myComp = new Comparator<int[]>() {
         * @Override
         * public int compare(int[] o1, int[] o2)
         * {
         * return o1[1] - o2[1];
         * }
         * };
         */
        Arrays.sort(a, myComp);
        Arrays.sort(b, myComp);

        final List<int[]> ans = getPairs(a, b, 7);
        for (final int[] e : ans) {
            System.out.println(e[0] + "," + e[1]);
        }

    }

    private static List<int[]> getPairs(final int[][] a, final int[][] b, final int target)
    {

        final List<int[]> result = new ArrayList<>();
        int maxSoFar = Integer.MIN_VALUE;
        final int m = a.length;
        final int n = b.length;
        int i = 0;
        int j = n - 1;
        while ((i < m) && (j >= 0)) {
            final int sum = a[i][1] + b[j][1];
            if (sum > target) {
                j--;
            }
            else {
                if (sum >= maxSoFar) {
                    if (sum > maxSoFar) {
                        maxSoFar = sum;
                        // discard previous result
                        result.clear();
                    }
                    result.add(new int[] { a[i][0], b[j][0] });
                    // what if j repeats then answr needs to be repeated

                    int index = j;
                    // compare [j][1] and [j-1][1] and u will get if there are any repeatations
                    while (((index - 1) >= 0) && (b[index][1] == b[index - 1][1])) {
                        index--;
                        result.add(new int[] { a[i][0], b[index][0] });
                    }
                }
                i++;
            }

        }
        return result;
    }
}
