/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 * /one way is finding last space
 */
//other is using split n print last ele of array
public class LengthOfLastWord_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int l=lengthOfLastWord("   Hello World  ");
		System.out.println(l);
	}

	public static int lengthOfLastWord(String s) {
		String str = s.trim();
		int len = str.length();
		if (len == 0) {
			return 0;
		}
		int space = -1;
		for (int i = len - 1; i >= 0; i--) {
			if (str.charAt(i) == ' ') {
				space = i;
				break;
			}
		}
		if (space == -1) {
			// no space that means its single word
			return len;
		} else if (space == len) {
			return 0;
		} else {
			int len_of_last_word = len - space - 1;
			return len_of_last_word;
		}
	}
}

// othr way
/*
 * public int lengthOfLastWord(String s) { if(s == null || s.length() == 0)
 * return 0; String[] strs = s.split(" "); if(strs.length == 0) return 0; return
 * strs[strs.length - 1].length(); }
 * 
 * //3rd way using last index of
 * 
 * public int lengthOfLastWord(String s) { s = s.trim(); int lastIndex =
 * s.lastIndexOf(' ') + 1; return s.length() - lastIndex; } }
 */