/*
 * run time complexity is O(n2*n!) CTCI
 * 
 * input is abc
 *  abc
 *  acb
 *  bac 
 *  bca
 *  cab
 *  cba
 */
public class StringPermutations_CTCI {

	// print n! permutation of the characters of the string s (in order)
	public static void main(String[] args) {
		permutation("ABC", "");
	}

	public static void permutation(String str, String prefix) {
		int n = str.length();
		if (n == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutation(str.substring(0, i) + str.substring(i + 1, n),
						prefix + str.charAt(i));
			}
		}

	}
}