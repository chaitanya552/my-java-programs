/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

 */
//failed bcz inputs are more than int. 207 /294 cases passed
//lets consider only individal places

public class AddBinary_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a =
		// "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";

		"1010";
		String b =
		// "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		"1011";
		System.out.println(addBinary(a, b));
	}

	public static String addBinary(String a, String b) {
		// convert binary to nums

		// 111 110
		int alen = a.length();
		int blen = b.length();
		int diff = Math.abs(alen - blen);
		// find smaller length string and perform operations
		int commonLength = (alen > blen) ? blen : alen;
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		int carry = 0;
		System.out.println(commonLength);
		// based on common length we choose the sum function
		// 100
		// 11000100
		int diffA;
		int diffB;
		String var;
		if (alen > blen) {
			diffA = diff;
			diffB = 0;
			var = a;
		} else {
			diffA = 0;
			diffB = diff;
			var = b;
		}
		for (int i = commonLength - 1; i >= 0; i--) {
			sum = a.charAt(i + diffA) + b.charAt(i + diffB) - 96+carry;

			System.out.println(sum);
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

		// System.out.println("diff"+diff);
		for (int i = diff - 1; i >= 0; i--) {
			sum = var.charAt(i) + carry - 48;

			// System.out.println(sum);
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
		} else {
			return sb.reverse().toString();
		}

	}

}
