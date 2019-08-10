
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pascalTriangleLists_LeetCode
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final Scanner scan = new Scanner(System.in);
        System.out.println("enter number of rows");
        final int rows = scan.nextInt();
        System.out.println(generate(rows));
    }

    public static List<List<Integer>> generate(final int numRows)
    {

        final List<List<Integer>> ans = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            final List<Integer> mini = new ArrayList<Integer>();
            for (int j = 1; j <= i; j++) {
                if ((j == 1) || (j == i)) {
                    mini.add(1);
                }
                else {
                    mini.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j - 2));
                }

            }
            ans.add((mini));

        }
        return ans;
    }
}
