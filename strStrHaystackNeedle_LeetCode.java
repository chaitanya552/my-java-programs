/*
 * Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 */
/* easy method using index of 
 public int strStr(String haystack, String needle) {
 return haystack.indexOf(needle);
 }
 */
public class strStrHaystackNeedle_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "mississippi";
		// "hellomn";

		String needle = "sipp";
		// "lo";
		int len = strStr(haystack, needle);
		System.out.println(len);
	}

	//method 2 using char comparison n without substring 
	public static int strStr(String haystack, String needle) {
		// return haystack.indexOf(needle);
		int m = haystack.length();
		int n = needle.length();
		int val = -1;
		int j = 0;
		int count;
		if (n > m) {
			return -1;
		}
		// when needle is empty return 0
		if (n == 0) {
			return 0;

		}
		for (int i = 0; i < m; i++) {
			// hel|||loink, llo
			count = 0;
			// reset j to 0
			j = 0;
			if (haystack.charAt(i) == needle.charAt(j)) {
				if (m - i < n) {
					// System.out.println("edge case when i is at the end n less than to be searched length");
					return -1;
				}
				// System.out.println("i is"+i+"val: " + val);

				for (int k = i + 1; k < i + n; k++) {
					// System.out.println("working");
					if (haystack.charAt(k) == needle.charAt(j + 1)) {
						count++;
						j++;
					}
				}
				if (count == n - 1) {
					// System.out.println("going");
					val = i;
					return val;
				}

			}
		}
		return -1;
	}
}
// method 3
//using sub string 
/*
public class Solution {
public int strStr(String haystack, String needle) {
    int l1 = haystack.length(), l2 = needle.length();
    if (l1 < l2) {
        return -1;
    } else if (l2 == 0) {
        return 0;
    }
    int threshold = l1 - l2;
    for (int i = 0; i <= threshold; ++i) {
        if (haystack.substring(i,i+l2).equals(needle)) {
            return i;
        }
    }
    return -1;
}
}
*/