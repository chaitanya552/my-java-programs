/*
 * "Count and Say problem" Write a code to do following: 
n String to print 
0 1 
1 1 1 
2 2 1 
3 1 2 1 1 
... 
Base case: n = 0 print "1" 
for n = 1, look at previous string and write number of times a digit is seen and the digit itself. In this case, digit 1 is seen 1 time in a row... so print "1 1" 
for n = 2, digit 1 is seen two times in a row, so print "2 1" 
for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1" 
for n = 4 you will print "1 1 1 2 2 1" 
 */
public class CountandSay_LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(2));
	}

	public static String countAndSay(int n) {
		String s = "1";
		for (int i = 1; i < n; i++) {
			s = countIdx(s);
		}
		return s;
	}

	public static String countIdx(String s) {
		StringBuilder sb = new StringBuilder();
		char c = s.charAt(0);
		int count = 1;
		for (int i = 1; i < s.length(); i++) {
			// look at previous string and write number of times a digit is seen and the
			// digit itself
			if (s.charAt(i) == c) {
				count++;
			} else {
				sb.append(count);// digit is seen
				sb.append(c);// digit itself
				c = s.charAt(i);
				count = 1;
			}
		}
		// this is for initial loop n mostly for the last condition where there are all
		// 1's or 2's etc
		// count incs in the if part but not appended
		sb.append(count);
		sb.append(c);
		return sb.toString();
	}
}
