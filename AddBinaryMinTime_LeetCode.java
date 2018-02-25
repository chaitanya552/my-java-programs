/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

 */
//initially failed bcz inputs are more than int. 207 /294 cases passed
//lets consider only individal places
//4ms
public class AddBinaryMinTime_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a =
		// "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";

		"1";
		String b =
		// "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		"111";
		System.out.println(addBinary(a, b));
	}

	public static String addBinary(String a, String b) {
		int diff = a.length() - b.length();
		StringBuilder sb = new StringBuilder();
		// instead of checking if a is greater or b is greater
		// lets make it certain that first string is of greater or equal length
		// saves time
		if (diff < 0) {
			return addBinary(b, a);
		} else {
			int sum = 0;
			int carry = 0;

			for (int i = b.length() - 1; i >= 0; i--) {
				sum = a.charAt(i + diff) + b.charAt(i) - 96 + carry;

				// rather than appending sum%2 and carry is sum/2 the below
				// method is fast
				if (sum <= 1) {
					sb.append(sum);
					carry = 0;
				} else if (sum == 2) {
					sb.append(0);
					carry = 1;
				} else {
					sb.append(1);
					carry = 1;
				}
			}

			for (int i = diff - 1; i >= 0; i--) {
				sum = a.charAt(i) + carry - 48;

				if (sum <= 1) {
					sb.append(sum);
					carry = 0;
				} else if (sum == 2) {
					sb.append(0);
					carry = 1;
				}
			}

			if (carry == 1) {
				sb.append(1);
				return sb.reverse().toString();
			}

		}
		return sb.reverse().toString();
	}
}

/*
 * same logic but less lines 4 ms
 *  public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
 */
