public class countDigitRepeataions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 74672877;
		String s = String.valueOf(num);
		// System.out.println(s+);
		System.out.println(countDigitsStr(s));
		System.out.println(countDigits(7107));
	}

	private static int countDigits(int input) {
		int count = 0;
		while (input > 0) {
			int last_digit = input % 10;
			if (last_digit == 7) {
				count++;
			}
			input = input / 10;
		}
		return count;
	}

	private static int countDigitsStr(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '7') {
				count++;
			}

		}
		return count;
	}
}
