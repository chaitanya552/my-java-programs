package Arrays;
/*
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
// currentlongest >1
// ba ab ba ad
// bab aba bad
// baba abad
// babad

// dp 5 *5
// 00 11 22 33 44
// aba
// aaabaaa

class LongestPalindromeSubstring_Pmp
{
    static public void main(final String args[])
    {
        System.out.println("Practice makes Perfect!");

        // aa
        // aaabaaa. i j
        final String input = "badadan";
        final int row = input.length();
        final int col = row;
        final boolean[][] dp = new boolean[row][col];

        for (int y = 0; y < row; y++) {
            for (int p = 0; p < col; p++) {
                dp[y][p] = false;
            }
        }

        // single characters

        for (int k = 0; k < row; k++) {
            dp[k][k] = true;
        }
        // two chars
        for (int l = 0; l < (row - 1); l++) {
            if (input.charAt(l) == input.charAt(l + 1)) {
                dp[l][l + 1] = true;
            }
        }

        final int n = 2;
        String maxPal = "";
        for (int j = 2; j < row; j++) {
            for (int i = 0; i < (col - j); i++) {

                // 02

                final int start = i;
                final int end = j + i;
                final int len = ((end - start) + 1) / 2;
                if ((input.charAt(start) == input.charAt(end)) && dp[start + 1][end - 1]) {
                    dp[start][end] = true;
                    final String currentPalindrome = input.substring(start, end + 1);
                    if (currentPalindrome.length() > maxPal.length()) {
                        maxPal = currentPalindrome;
                        System.out.println(maxPal);
                    }

                }

            }
        }

    }

}
