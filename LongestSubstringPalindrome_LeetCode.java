/*
 * usng dynamic programming we can save palindromes of len 1, len 2 and go from there on 
 * results in O(n2)
 * The value of table[i][j] is true, if the substring is palindrome, otherwise false.
 * i and j included in substring .[1][3] of chaitu is hai  
 * To calculate table[i][j], we first check the value of table[i+1][j-1], 
 * if the value is true and str[i] is same as str[j], 
 * then we make table[i][j] true. Otherwise, the value of table[i][j] is made false.
 */

public class LongestSubstringPalindrome_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hondaCIVIC";
		int n = s.length();
		int maxLength = 1;
		int start = 0;
		// lets write te algo
		// first create a 2 dim array and initiliaze it with lengths of 1 and 2
		// to true f its a palin
		boolean val[][] = new boolean[n][n];
		// initializing length of 1's as palindomes
		for (int i = 0; i < n; i++) {
			val[i][i] = true;
		}
		maxLength = 1;
		// now checking lengths of 2
		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				val[i][i + 1] = true;
				maxLength = 2;
				start = i;
			
			}
		}

		// then check for palin of len >=3 .this is done by chcking if middle
		// value is a palindrome
		// and then check if starting and ending character is equal then set
		// that 2 dim array to true
		//k<=n because k can reach max length of full string size i.e n
		for (int k = 3; k <= n; k++) {
			//i <n-k+1 because in string abcde when k=3,i needs to iterate only till c, bcz from c len is 3 to reach e
			//cde
			for (int i = 0; i < n - k + 1; i++) {
				// to find ending j, when i =o and to to test abc, j= i+k=3 but our boolean is [0][2]
				//hence j=i+k-1; val is all inclusive boolean array
				int j = i + k - 1;
				if (val[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
					val[i][j] = true;
					//val[i + 1][j - 1] if this is true then middle is palindrome
					// update the max len when a max palindrome is found and
					// also save the starting index so that
					// we can print the elemnt
					if (k > maxLength) {
						start = i;
						maxLength = k;
					}
				}

			}
		}
		System.out.println("Longest palindrome is:"+ s.substring(start,start+maxLength));

	}

}


//method 2 18 ms
/*
class Solution {
private int maxLength = 0;
private int index = 0;

public String longestPalindrome(String s) {
    for(int i = 0; i< s.length(); i++) {
        extendPalindrome(s, i, i);
        extendPalindrome(s, i, i+1); 
    }

    return s.substring(index, index+maxLength);
}

public void extendPalindrome(String s, int i, int j) {
    while(i>=0 && j <= s.length()-1 && s.charAt(i) == s.charAt(j)) {
        i--;
        j++;
    }
    if(maxLength < j-i-1) {
        maxLength = j-i-1;
        index = i+1;
    } 
}
*/