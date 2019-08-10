import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * 1
 * 2 5
 * 3 2 1
 * 1 3 2 1
 * Imagine you have a list of numbers like above (Size of first row is 1, and size of each row is size of previous row + 1). You should start from top and pick
 * one number from each row. if you have picked the nth number from a row,
 * then you can ONLY pick nth or nth+1 number from the next row. From all the possible solutions, find the one that has the highest sum of numbers.
 * In the above example the answer is: [1 (1st in row 1), 5 (2nd in row 2), 2 (2nd in row 3), 3 (2nd in row 4)]
 * Implement a method that gets the above structure in a 2-D array (zero padded), and returns the list with the highest sum.
 * The above example will be passed to this method like below:
 * [
 * [1, 0, 0, 0]
 * [2, 5, 0, 0]
 * [3, 2, 1, 0]
 * [1, 3, 2, 1]
 * ]
 * List<Integer> highestSumList(List<List<Integer>> lst) {...}
 */

/*
 * solution ago
 * to store intermediate max sums
 * we are using dp here,
 * if you pick an element from input, it would be coming from previous row's nth or nth-1 element
 * and it comes from whoever is bigger of nth or nth -1 element of previous row
 * and update the sum in dp
 */
public class dpForHighestSumMaxWhileTraversing_teju2
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        // input as a list of lists
        final List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(1, 0, 0, 0));
        list.add(Arrays.asList(2, 5, 0, 0));
        list.add(Arrays.asList(3, 2, 1, 0));
        list.add(Arrays.asList(1, 3, 2, 1));
        System.out.println("resulting elements are" + highestSumList(list));

    }

    private static List<Integer> highestSumList(final List<List<Integer>> list)
    {
        final int numRows = list.size();
        final int numCols = list.size();

        // converting input list to 2d array
        final Integer[][] input = new Integer[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                input[i][j] = list.get(i).get(j);
                System.out.print(input[i][j] + ",");
            }
            System.out.println();
        }
        /*
         * to store intermediate max sums
         * we are using dp here,
         * if you pick an element from input, it would be coming from previous row's nth or nth-1 element
         * and it comes from whoever is bigger of nth or nth -1 element of previous row
         * and update the sum in dp
         */
        final Integer[][] dp = new Integer[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (i == 0) {

                    dp[i][j] = input[i][j];
                }
                else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + input[i][j];
                    }
                    else if (j < numCols) {

                        dp[i][j] = input[i][j] + Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }

                }
            }

        }
        System.out.println();

        final List<Integer> lastRow = new ArrayList<>();

        // maximum of rows helps us back tracking what are the elements involved in making that maximum
        final List<Integer> maximumOfRows = new ArrayList<>();

        for (int j = 0; j < numCols; j++) {

            lastRow.add(dp[numRows - 1][j]);
        }

        System.out.println(lastRow + "last rowwww");

        final int maxSum = Collections.max(lastRow);
        final int index = lastRow.indexOf(maxSum);
        // index where max sum is occured, from here we back track
        int i = numRows - 1;
        int j = index;
        final List<Integer> elementsMakingMaximum = new ArrayList<>();
        // back tracking from highes sum , either it came from nth or nth -1 of previous row, whichever is greater
        // if we subtract we get that element
        while (i > 0) {

            if ((dp[i - 1][j] > dp[i - 1][j - 1]) || (j == 0)) {
                elementsMakingMaximum.add(dp[i][j] - dp[i - 1][j]);
                i--;
            }
            else {
                elementsMakingMaximum.add(dp[i][j] - dp[i - 1][j - 1]);
                i--;
                j--;
            }
        }

        // adding row 1
        elementsMakingMaximum.add(dp[i][j]);

        Collections.reverse(elementsMakingMaximum);

        return elementsMakingMaximum;
    }

}
