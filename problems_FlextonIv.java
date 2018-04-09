//Given "abc%20xyz", write code to replace all appearance of "%20" with "c".

/*
 * ============================= ============================= Return the
 * sum of all integers from a random String. Continuous Integers must be
 * considered as one number. If the input String does not have any Integers,
 * return 0. You may ignore decimals, float, and other non-integer numbers
 * 
 * @param str : Input String
 * 
 * 
 * Given the following inputs, we expect the corresponding
 *  output: "1a2b3c" => 6 (1+2+3) 
 * "123ab!45c" => 168 (123+45) 
 * "abcdef" => 0 (no Integers in	 * String) 
 * "0123.4" => 127 (0123+4)
 *  "dFD$#23+++12@#T1234;/.,10" => 1279 (23+12+1234+10) 
 * "12a-10b"=>2 (12-10) 
 * "12a-b10"=>22
 */
public class problems_FlextonIv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// p1
		System.out.println(ReplaceSentence(
				"abc%20xyz %20abd* ***** ******%20***********", "c"));
		// System.out.println(CalSum("1a2b3c"));
		// p2
		// System.out.println(CalSum("123ab!45"));
		// System.out.println(CalSum("abcdef"));
		// System.out.println(CalSum("0123.4"));
		// System.out.println(CalSum("dFD$#23+++12@#T1234;/.,10"));
		// System.out.println(CalSum("200a-10b-a20d"));
		// System.out.println(CalSum("12a-b10"));
		System.out.println(CalSum("-120-12+3c"));

	}

	// p3
	/*
	 * Description: Given a binary tree, write a method to print the tree level
	 * by level. (e.g) Tree: 1 / \ 3 5 / \ \ 2 4 7 / \ \ 9 6 8
	 * 
	 * ==========000 1 35 247 968 }
	 */
	public static String ReplaceSentence(String sentence, String rep) {

		String[] words = sentence.split(" ");

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < words.length; i++) {

			sb.append(words[i].replaceAll("%20", "c"));
			sb.append(" ");

		}

		String answer = sb.toString();
		return answer;
	}

	public static int CalSum(String str) {
		String Str = "1a2b3c";
		char[] chars = str.toCharArray();
		int sum = 0;
		int answer = 0;
		boolean negation = false;

		for (int i = 0; i < chars.length; i++) {

			if (chars[i] >= 48 && chars[i] <= 57) {
				int num = chars[i] - 48;
				num = negation ? num = num * -1 : num;
				sum = sum * 10 + num;
				// edge case for minus
			} else if ((chars[i] == '-') && (Character.isDigit(chars[i + 1]))) {
				answer = answer + sum;
				sum = 0;
				negation = true;
			} else {
				negation = false;
				answer = answer + sum;
				sum = 0;
			}
		}
		// answer + sum bcz if there is no character at the end
		return answer + sum;
	}

}
