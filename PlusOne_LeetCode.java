
/*
 * `* Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
import java.util.Arrays;

public class PlusOne_LeetCode
{

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        // int[] digits = { 9, 9 };
        final int[] digits = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 5, 6, 7, 3 };
        // 2147483647
        System.out.println(Arrays.toString(plusOne(digits)));

    }

    public static int[] plusOne(final int[] digits)
    {

        final int len = digits.length;
        // case where there is single digit and if it is 9 we should output[1,0]

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                break;
            }
            else {
                // the value is 9 so make it zero n proceed to previous digit (
                // loop continues)
                digits[i] = 0;
            }
        }
        // case where there is input as 9 or 9,9
        // output should have 1 extra elemnt and ans [1,0] or[1,0,0]resp
        if (digits[0] == 0) {
            final int[] extended = new int[digits.length + 1];
            extended[0] = 1;

            System.arraycopy(digits, 0, extended, 1, digits.length);
            // arraycopy(Object src, int srcPos, Object dest, int destPos, int
            // length)
            // here length is nmber of elements copied
            // or without copying also we can return int array are initialized to 0 initially
            return extended;
        }
        return digits;
    }

}