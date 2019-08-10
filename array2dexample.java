
public class array2dexample
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        int sum = 0;
        System.out.println(sum);
        final int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (final int i : arr[0]) {
            sum += i;
        }
        for (final int i : arr[arr.length - 1]) {
            sum += i;
        }
        System.out.println(sum);

    }

}
