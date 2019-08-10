
import java.util.ArrayList;
import java.util.List;

public class pascalTriangeRecursive
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        System.out.println("generate pascal recrsive");
        final List<List<Integer>> bigList = generatePascalRecursive(6);
        System.out.println(bigList);
        final int r = 4;
        final int c = 2;
        System.out.println("from list recursive ->value is " + bigList.get(r).get(2));
        System.out.println("Pascal by DP");
        System.out.println(pascalDP(6, 5));
        final int ans = pascalRecursive(4, 2);
        System.out.println("one of the values " + ans);

    }

    public static List<List<Integer>> generatePascalRecursive(final int rows)
    {
        final List<Integer> smallList = new ArrayList<>();
        final List<List<Integer>> bigList = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                smallList.add(pascalRecursive(i, j));
                // System.out.print(functionRecursive(i,j)+" ");
            }
            bigList.add(new ArrayList<>(smallList));
            smallList.clear();
            // System.out.println();
        }
        return bigList;
    }

    public static int pascalRecursive(final int row, final int col)
    {
        // TODO Auto-generated method stub

        // edge values
        if ((row == col) || (col == 0)) {
            return 1;
        }
        // middle values are sum of previous row sum
        return pascalRecursive(row - 1, col - 1) + pascalRecursive(row - 1, col);
    }

    public static List<List<Integer>> pascalDP(final int row, final int col)
    {
        // TODO Auto-generated method stub
        // first value
        final List<Integer> smallL = new ArrayList<>();
        final List<List<Integer>> bigL = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= i; j++) {
                if ((j == 0) || (j == i)) {
                    smallL.add(1);
                }
                else {
                    smallL.add(bigL.get(i - 1).get(j - 1) + bigL.get(i - 1).get(j));
                }
                // System.out.print(functionRecursive(i,j)+" ");
            }
            bigL.add(new ArrayList<>(smallL));
            smallL.clear();
            // System.out.println();
        }

        return bigL;
    }

}
