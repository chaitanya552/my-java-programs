import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub

        System.out.println(getRow(13));

    }

    public static List<Integer> getRow(final int rowIndex)
    {
        final List<Integer> result = new ArrayList<>();

        result.add(1);
        if (rowIndex == 0) {
            return result;
        }
        // ncr logic advanced
        int n = rowIndex;
        final int numerator = 1;
        final int denominator = 1;
        int r = 1;
        int res = 1;
        for (int i = 1; i <= (rowIndex - 1); i++) {
            res = (res * n) / r;
            System.out.println("numera***->" + numerator + "*****denom->" + denominator);

            result.add(res);
            n--;
            r++;
            System.out.println("n***->" + n + "*****R->" + r);

        }
        result.add(1);
        return result;
    }

}
