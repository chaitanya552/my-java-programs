import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abcdea"));
	}

	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// Sliding window method O(2n) rather than O(n3) 
			// check if character is already in the set and then add
			// add method gives a boolean true if set doesn't contain value and
			// adds in O(1)
			if (set.add(s.charAt(j))) {
				j++;
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		System.out.println(s.substring(i,j));
		return ans;
	}

}
